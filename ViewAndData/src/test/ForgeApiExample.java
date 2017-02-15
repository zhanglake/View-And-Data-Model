package test;

import com.autodesk.client.ApiException;
import com.autodesk.client.ApiResponse;
import com.autodesk.client.api.BucketsApi;
import com.autodesk.client.api.HubsApi;
import com.autodesk.client.auth.*;
import com.autodesk.client.model.*;
import java.util.ArrayList;
import java.util.List;

public class ForgeApiExample {

	public static void main(String[] args) {

        try {    
            List<String> scopes = new ArrayList<String>();
            scopes.add("data:read");
            scopes.add("data:write");
            scopes.add("bucket:create");
            scopes.add("bucket:read");

            // Initialize the oauth2TwoLegged object using the client key and client secret you received when creating the app on the Forge Developer portal:
            OAuth2TwoLegged oauth2TwoLegged = new OAuth2TwoLegged("23SqBBVbzPrmlbj5w5eK9UeEtIxsL2nU", "tuombcRnY1yxBCsl", scopes, true);
            Credentials twoLeggedCredentials = oauth2TwoLegged.authenticate();

            // Initialize the relevant clients; in this example, the Hubs and Buckets clients (part of the Data Management API).
            BucketsApi bucketsApi = new BucketsApi();
            HubsApi hubsApi = new HubsApi();

            // Create a new bucket 
            // Use the oauth2TwoLegged and twoLeggedCredentials objects that you retrieved previously.
            PostBucketsPayload payload = new PostBucketsPayload();
            payload.setBucketKey("test_bucket_key");
            payload.setPolicyKey(PostBucketsPayload.PolicyKeyEnum.PERSISTENT);
            ApiResponse<Bucket> createBucketResponse = bucketsApi.createBucket(payload, "", oauth2TwoLegged, twoLeggedCredentials);
            System.out.println(createBucketResponse.getData().getBucketKey());

            // Get the buckets owned by an application.
            // Use the oauth2TwoLegged and twoLeggedCredentials objects that you retrieved previously.
            ApiResponse<Buckets> getBucketsResponse = bucketsApi.getBuckets(null, null, null, oauth2TwoLegged, twoLeggedCredentials);
            for(BucketsItems bucket: getBucketsResponse.getData().getItems()) {
                System.out.println(bucket.getBucketKey());
            }
            
            

            // Get the hubs that are accessible for a member.
            // Use the oauth2ThreeLegged and threeLeggedCredentials objects that you retrieved previously.
            /*ApiResponse<Hubs> getHubsResponse = hubsApi.getHubs(null, null, oauth2ThreeLegged, threeLeggedCredentials);
            for(Hub hub: getHubsResponse.getData().getData()) {
                System.out.println(hub.getId());
            }*/

        } catch (Exception e) {
            System.err.println("Exception when calling Forge APIs");
            e.printStackTrace();
        }
    }
}
