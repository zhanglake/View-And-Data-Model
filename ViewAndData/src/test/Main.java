package test;

import com.autodesk.client.ApiException;
import com.autodesk.client.ApiResponse;
import com.autodesk.client.api.BucketsApi;
import com.autodesk.client.api.DerivativesApi;
import com.autodesk.client.api.ObjectsApi;
import com.autodesk.client.auth.Credentials;
import com.autodesk.client.auth.OAuth2TwoLegged;
import com.autodesk.client.model.*;
import com.autodesk.client.model.JobPayloadItem.TypeEnum;
import com.autodesk.client.model.JobPayloadItem.ViewsEnum;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bouncycastle.util.encoders.UrlBase64;

public class Main {

	// TODO - insert your CLIENT_ID and CLIENT_SECRET
	private static final String CLIENT_ID = "23SqBBVbzPrmlbj5w5eK9UeEtIxsL2nU";
	private static final String CLIENT_SECRET = "tuombcRnY1yxBCsl";

	// TODO - Choose a bucket key - a unique name to assign to a bucket. It must
	// be globally unique across all applications and
	// regions, otherwise the call will fail. Possible values: -_.a-z0-9
	// (between 3-128 characters in
	// length). Note that you cannot change a bucket key.
	private static final String BUCKET_KEY = "testandostecazzodiapi-arthur123";// my-chosen-bucket-key

	// TODO - Choose a filename - a key for the uploaded object
	private static final String FILE_NAME = "revit.rvt";

	// TODO - specify the full filename and path
	private static final String FILE_PATH = "C:\\Users\\zack.zhang\\Desktop\\revit.rvt";

	// Initialize the relevant clients; in this example, the Buckets and Objects
	// clients, which are part of the Data Management API
	private static final BucketsApi bucketsApi = new BucketsApi();
	private static final ObjectsApi objectsApi = new ObjectsApi();
	private static final DerivativesApi derivativesApi = new DerivativesApi();

	private static OAuth2TwoLegged oauth2TwoLegged;
	private static Credentials twoLeggedCredentials;

	/**
	 * Initialize the 2-legged OAuth 2.0 client, and optionally set specific
	 * scopes.
	 * 
	 * @throws Exception
	 */
	private static void initializeOAuth() throws Exception {

		// You must provide at least one valid scope
		List<String> scopes = new ArrayList<String>();
		scopes.add("data:read");
		scopes.add("data:write");
		scopes.add("bucket:create");
		scopes.add("bucket:read");

		// Set autoRefresh to `true` to automatically refresh the access token
		// when it expires.
		oauth2TwoLegged = new OAuth2TwoLegged(CLIENT_ID, CLIENT_SECRET, scopes,
				true);
		twoLeggedCredentials = oauth2TwoLegged.authenticate();
		// 获取AccessToken
		String accessToken = twoLeggedCredentials.getAccessToken();
		System.out.println("accessToken:" + accessToken);
	}

	/**
	 * Example of how to create a new bucket using Forge SDK. Uses the
	 * oauth2TwoLegged and twoLeggedCredentials objects that you retrieved
	 * previously.
	 * 
	 * @throws com.autodesk.client.ApiException
	 * @throws Exception
	 */
	private static void createBucket() throws ApiException, Exception {
		System.out.println("***** Sending createBucket request");
		PostBucketsPayload payload = new PostBucketsPayload();
		payload.setBucketKey(BUCKET_KEY);
		payload.setPolicyKey(PostBucketsPayload.PolicyKeyEnum.PERSISTENT);
		ApiResponse<Bucket> response = bucketsApi.createBucket(payload, "US",
				oauth2TwoLegged, twoLeggedCredentials);
		System.out.println("***** Response for createBucket: "
				+ response.getData());
	}

	/**
	 * Example of how to upload a file to the bucket. Uses the oauth2TwoLegged
	 * and twoLeggedCredentials objects that you retrieved previously.
	 * 
	 * @throws java.io.FileNotFoundException
	 * @throws com.autodesk.client.ApiException
	 * @throws Exception
	 */
	private static void uploadFile() throws FileNotFoundException,
			ApiException, Exception {
		System.out.println("***** Sending uploadFile request");
		File fileToUpload = new File(FILE_PATH);
		ApiResponse<ObjectDetails> response = objectsApi
				.uploadObject(BUCKET_KEY, FILE_NAME,
						(int) fileToUpload.length(), fileToUpload, null, null,
						oauth2TwoLegged, twoLeggedCredentials);

		System.out.println("***** Response for uploadFile: ");
		ObjectDetails objectDetails = response.getData();
		String objectId = objectDetails.getObjectId();
		String urn = getBASE64(objectId);
		JobPayload job = new JobPayload();
		JobPayloadInput input = new JobPayloadInput(); 
		input.setUrn(urn);
		job.setInput(input);
		job.setOutput(getJobPayloadOutput());
		ApiResponse<Job> jobs = derivativesApi.translate(job, false, oauth2TwoLegged, twoLeggedCredentials);
		urn = jobs.getData().getUrn();
		System.out.println("urn:" + urn);
		System.out.println("Uploaded object Details - Location: "
				+ objectDetails.getLocation() + ", Size:"
				+ objectDetails.getSize());

	}

	public static String getBASE64(String data) {
		try {
			String ENCODING = "UTF-8";
			byte[] b = UrlBase64.encode(data.getBytes(ENCODING));
			return new String(b, ENCODING);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "";
	}

	/**
	 * Example of how to get the buckets owned by an application. Uses the
	 * oauth2TwoLegged and twoLeggedCredentials objects that you retrieved
	 * previously.
	 * 
	 * @throws com.autodesk.client.ApiException
	 * @throws Exception
	 */
	private static void getBuckets() throws ApiException, Exception {
		System.out.println("***** Sending getBuckets request");
		ApiResponse<Buckets> getBucketsResponse = bucketsApi.getBuckets("US",
				null, null, oauth2TwoLegged, twoLeggedCredentials);

		System.out.println("***** Response for getBuckets: ");
		List<BucketsItems> buckets = getBucketsResponse.getData().getItems();
		for (BucketsItems bucket : buckets) {
			System.out.println("bucket key:" + bucket.getBucketKey()
					+ ", createdDate:" + bucket.getCreatedDate());
		}

		ApiResponse<File> files = objectsApi.getObject(BUCKET_KEY, FILE_NAME,
				null, null, null, "*", oauth2TwoLegged, twoLeggedCredentials);
		ApiResponse<ObjectFullDetails> files1 =
		objectsApi.getObjectDetails(BUCKET_KEY, FILE_NAME, null, null,
		oauth2TwoLegged, twoLeggedCredentials);
		File file = new File(files.getData().getPath());
		System.out.println(files);
	}
	
	/**
	 * 获得AutoDesk JOB
	 * @return
	 */
	public static JobPayloadOutput getJobPayloadOutput(){
		JobPayloadOutput output = new JobPayloadOutput();
		List<JobPayloadItem> items = new ArrayList<JobPayloadItem>();
		JobPayloadItem payloadItem = new JobPayloadItem();
		payloadItem.setType(JobPayloadItem.TypeEnum.SVF);
		JobObjOutputPayloadAdvanced advanced = new JobObjOutputPayloadAdvanced();
		advanced.setExportFileStructure(JobObjOutputPayloadAdvanced.ExportFileStructureEnum.MULTIPLE);
		payloadItem.setAdvanced(advanced);
		List<ViewsEnum> views = new ArrayList<JobPayloadItem.ViewsEnum>();
		views.add(JobPayloadItem.ViewsEnum._2D);
		views.add(JobPayloadItem.ViewsEnum._3D);
		payloadItem.setViews(views);
		return output;
	}

	/**
	 * Delete the file uploaded by the application. Uses the oauth2TwoLegged and
	 * twoLeggedCredentials objects that you retrieved previously.
	 * 
	 * @throws com.autodesk.client.ApiException
	 * @throws Exception
	 */
	private static void deleteFile() throws ApiException, Exception {
		System.out.println("***** Sending deleteFile request");
		ApiResponse<Void> response = objectsApi.deleteObject(BUCKET_KEY,
				FILE_NAME, oauth2TwoLegged, twoLeggedCredentials);
		System.out.println("***** Response Code for deleting File: "
				+ response.getStatusCode());
	}

	public static void main(String[] args) throws Exception {

		try {
			initializeOAuth();
		} catch (ApiException e) {
			System.err.println("Error Initializing OAuth client : "
					+ e.getResponseBody());
		}

		/*
		 * try{ createBucket(); } catch (ApiException e){
		 * System.err.println("Error creating bucket : " + e.getResponseBody());
		 * }
		 */

		try {
			uploadFile();
		} catch (ApiException e) {
			System.err.println("Error uploading file : " + e.getResponseBody());
		}

		try {
			getBuckets();
		} catch (ApiException e) {
			System.err
					.println("Error getting buckets : " + e.getResponseBody());
		}

		/*
		 * try{ deleteFile(); } catch (ApiException e){
		 * System.err.println("Error deleting file : " + e.getResponseBody()); }
		 */
	}

}
