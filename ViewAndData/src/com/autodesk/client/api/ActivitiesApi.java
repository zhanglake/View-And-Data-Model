/*
 * Forge SDK
 * The Forge Platform contains an expanding collection of web service components that can be used with Autodesk cloud-based products or your own technologies. Take advantage of Autodesk’s expertise in design and engineering.
 *
 * OpenAPI spec version: 0.1.0
 * Contact: forge.help@autodesk.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.autodesk.client.api;

import com.sun.jersey.api.client.GenericType;

import com.autodesk.client.ApiException;
import com.autodesk.client.ApiClient;
import com.autodesk.client.Configuration;
import com.autodesk.client.model.*;
import com.autodesk.client.Pair;
import com.autodesk.client.auth.Credentials;
import com.autodesk.client.auth.Authentication;
import com.autodesk.client.ApiResponse;

import java.io.File;

import com.autodesk.client.model.Activity;
import com.autodesk.client.model.ActivityOptional;
import com.autodesk.client.model.ActivityVersion;


import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ActivitiesApi {
  private ApiClient apiClient;

  public ActivitiesApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ActivitiesApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Creates a new Activity.
   * 
   * @param activity  (required)
   * @return Activity
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Activity> createActivity(Activity activity,  Authentication oauth2, Credentials credentials) throws ApiException, Exception {

    Object localVarPostBody = activity;
    
    // verify the required parameter 'activity' is set
    if (activity == null) {
      throw new ApiException(400, "Missing the required parameter 'activity' when calling createActivity");
    }
    
    // create path and map variables
    String localVarPath = "/autocad.io/us-east/v2/Activities".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/vnd.api+json", "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    GenericType<Activity> localVarReturnType = new GenericType<Activity>() {};
    return apiClient.invokeAPI(oauth2, credentials, localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarReturnType);
      }
  /**
   * Removes a specific Activity.
   * 
   * @param id  (required)
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> deleteActivity(String id,  Authentication oauth2, Credentials credentials) throws ApiException, Exception {

    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling deleteActivity");
    }
    
    // create path and map variables
    String localVarPath = "/autocad.io/us-east/v2/Activities('{id}')".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/vnd.api+json", "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);


    return apiClient.invokeAPI(oauth2, credentials, localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, null);
  }
  /**
   * Removes the version history of the specified Activity.
   * 
   * @param id  (required)
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> deleteActivityHistory(String id,  Authentication oauth2, Credentials credentials) throws ApiException, Exception {

    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling deleteActivityHistory");
    }
    
    // create path and map variables
    String localVarPath = "/autocad.io/us-east/v2/Activities('{id}')/Operations.DeleteHistory".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/vnd.api+json", "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);


    return apiClient.invokeAPI(oauth2, credentials, localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, null);
  }
  /**
   * Returns the details of a specific Activity.
   * 
   * @param id  (required)
   * @return Activity
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Activity> getActivity(String id,  Authentication oauth2, Credentials credentials) throws ApiException, Exception {

    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getActivity");
    }
    
    // create path and map variables
    String localVarPath = "/autocad.io/us-east/v2/Activities('{id}')".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/vnd.api+json", "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    GenericType<Activity> localVarReturnType = new GenericType<Activity>() {};
    return apiClient.invokeAPI(oauth2, credentials, localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarReturnType);
      }
  /**
   * Returns all old versions of a specified Activity.
   * 
   * @param id  (required)
   * @return List<Activity>
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<List<Activity>> getActivityVersions(String id,  Authentication oauth2, Credentials credentials) throws ApiException, Exception {

    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getActivityVersions");
    }
    
    // create path and map variables
    String localVarPath = "/autocad.io/us-east/v2/Activities('{id}')/Operations.GetVersions".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/vnd.api+json", "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    GenericType<List<Activity>> localVarReturnType = new GenericType<List<Activity>>() {};
    return apiClient.invokeAPI(oauth2, credentials, localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarReturnType);
      }
  /**
   * Returns the details of all Activities.
   * 
   * @return List<Activity>
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<List<Activity>> getAllActivities( Authentication oauth2, Credentials credentials) throws ApiException, Exception {

    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/autocad.io/us-east/v2/Activities".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/vnd.api+json", "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    GenericType<List<Activity>> localVarReturnType = new GenericType<List<Activity>>() {};
    return apiClient.invokeAPI(oauth2, credentials, localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarReturnType);
      }
  /**
   * Updates an Activity by specifying only the changed attributes.
   * 
   * @param id  (required)
   * @param activity  (required)
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> patchActivity(String id, ActivityOptional activity,  Authentication oauth2, Credentials credentials) throws ApiException, Exception {

    Object localVarPostBody = activity;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling patchActivity");
    }
    
    // verify the required parameter 'activity' is set
    if (activity == null) {
      throw new ApiException(400, "Missing the required parameter 'activity' when calling patchActivity");
    }
    
    // create path and map variables
    String localVarPath = "/autocad.io/us-east/v2/Activities('{id}')".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/vnd.api+json", "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);


    return apiClient.invokeAPI(oauth2, credentials, localVarPath, "PATCH", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, null);
  }
  /**
   * Sets the Activity to the specified version.
   * 
   * @param id  (required)
   * @param activityVersion  (required)
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> setActivityVersion(String id, ActivityVersion activityVersion,  Authentication oauth2, Credentials credentials) throws ApiException, Exception {

    Object localVarPostBody = activityVersion;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling setActivityVersion");
    }
    
    // verify the required parameter 'activityVersion' is set
    if (activityVersion == null) {
      throw new ApiException(400, "Missing the required parameter 'activityVersion' when calling setActivityVersion");
    }
    
    // create path and map variables
    String localVarPath = "/autocad.io/us-east/v2/Activities('{id}')/Operations.SetVersion".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/vnd.api+json", "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);


    return apiClient.invokeAPI(oauth2, credentials, localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, null);
  }
  /**
   * Updates an Activity by redefining the entire Activity object.
   * 
   * @param id  (required)
   * @param activity  (required)
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> updateActivity(String id, Activity activity,  Authentication oauth2, Credentials credentials) throws ApiException, Exception {

    Object localVarPostBody = activity;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling updateActivity");
    }
    
    // verify the required parameter 'activity' is set
    if (activity == null) {
      throw new ApiException(400, "Missing the required parameter 'activity' when calling updateActivity");
    }
    
    // create path and map variables
    String localVarPath = "/autocad.io/us-east/v2/Activities('{id}')".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    final String[] localVarAccepts = {
      "application/vnd.api+json", "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);


    return apiClient.invokeAPI(oauth2, credentials, localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, null);
  }
}
