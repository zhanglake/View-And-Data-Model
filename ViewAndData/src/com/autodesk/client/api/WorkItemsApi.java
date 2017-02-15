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

import com.autodesk.client.model.WorkItemResp;
import com.autodesk.client.model.WorkItem;


import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class WorkItemsApi {
  private ApiClient apiClient;

  public WorkItemsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public WorkItemsApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Creates a new WorkItem.
   * 
   * @param workItem  (required)
   * @return WorkItemResp
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<WorkItemResp> createWorkItem(WorkItem workItem,  Authentication oauth2, Credentials credentials) throws ApiException, Exception {

    Object localVarPostBody = workItem;
    
    // verify the required parameter 'workItem' is set
    if (workItem == null) {
      throw new ApiException(400, "Missing the required parameter 'workItem' when calling createWorkItem");
    }
    
    // create path and map variables
    String localVarPath = "/autocad.io/us-east/v2/WorkItems".replaceAll("\\{format\\}","json");

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

    GenericType<WorkItemResp> localVarReturnType = new GenericType<WorkItemResp>() {};
    return apiClient.invokeAPI(oauth2, credentials, localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarReturnType);
      }
  /**
   * Removes a specific WorkItem.
   * 
   * @param id  (required)
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> deleteWorkItem(String id,  Authentication oauth2, Credentials credentials) throws ApiException, Exception {

    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling deleteWorkItem");
    }
    
    // create path and map variables
    String localVarPath = "/autocad.io/us-east/v2/WorkItems('{id}')".replaceAll("\\{format\\}","json")
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
   * Returns the details of all WorkItems.
   * 
   * @param skip  (optional)
   * @return List<WorkItemResp>
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<List<WorkItemResp>> getAllWorkItems(Integer skip,  Authentication oauth2, Credentials credentials) throws ApiException, Exception {

    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/autocad.io/us-east/v2/WorkItems".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "$skip", skip));

    
    
    final String[] localVarAccepts = {
      "application/vnd.api+json", "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    GenericType<List<WorkItemResp>> localVarReturnType = new GenericType<List<WorkItemResp>>() {};
    return apiClient.invokeAPI(oauth2, credentials, localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarReturnType);
      }
  /**
   * Returns the details of a specific WorkItem.
   * 
   * @param id  (required)
   * @return WorkItemResp
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<WorkItemResp> getWorkItem(String id,  Authentication oauth2, Credentials credentials) throws ApiException, Exception {

    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getWorkItem");
    }
    
    // create path and map variables
    String localVarPath = "/autocad.io/us-east/v2/WorkItems('{id}')".replaceAll("\\{format\\}","json")
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

    GenericType<WorkItemResp> localVarReturnType = new GenericType<WorkItemResp>() {};
    return apiClient.invokeAPI(oauth2, credentials, localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarReturnType);
      }
}