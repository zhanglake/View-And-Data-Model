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


package com.autodesk.client.model;

import java.util.Objects;

import com.autodesk.client.model.Permission;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;


/**
 * Bucket
 */

public class Bucket   {
  @JsonProperty("bucketKey")
  private String bucketKey = null;

  @JsonProperty("bucketOwner")
  private String bucketOwner = null;

  @JsonProperty("createdDate")
  private String createdDate = null;

  @JsonProperty("permissions")
  private List<Permission> permissions = new ArrayList<Permission>();

  @JsonProperty("policyKey")
  private String policyKey = null;

  public Bucket bucketKey(String bucketKey) {
    this.bucketKey = bucketKey;
    return this;
  }

   /**
   * The key of the Bucket
   * @return bucketKey
  **/
  @ApiModelProperty(example = "null", value = "The key of the Bucket")
  public String getBucketKey() {
    return bucketKey;
  }

  public void setBucketKey(String bucketKey) {
    this.bucketKey = bucketKey;
  }

  public Bucket bucketOwner(String bucketOwner) {
    this.bucketOwner = bucketOwner;
    return this;
  }

   /**
   * The owner of the Bucket
   * @return bucketOwner
  **/
  @ApiModelProperty(example = "null", value = "The owner of the Bucket")
  public String getBucketOwner() {
    return bucketOwner;
  }

  public void setBucketOwner(String bucketOwner) {
    this.bucketOwner = bucketOwner;
  }

  public Bucket createdDate(String createdDate) {
    this.createdDate = createdDate;
    return this;
  }

   /**
   * Counts the number of views for the asset
   * @return createdDate
  **/
  @ApiModelProperty(example = "null", value = "Counts the number of views for the asset")
  public String getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }

  public Bucket permissions(List<Permission> permissions) {
    this.permissions = permissions;
    return this;
  }

   /**
   * Get permissions
   * @return permissions
  **/
  @ApiModelProperty(example = "null", value = "")
  public List<Permission> getPermissions() {
    return permissions;
  }

  public void setPermissions(List<Permission> permissions) {
    this.permissions = permissions;
  }

  public Bucket policyKey(String policyKey) {
    this.policyKey = policyKey;
    return this;
  }

   /**
   * The policy key
   * @return policyKey
  **/
  @ApiModelProperty(example = "null", value = "The policy key")
  public String getPolicyKey() {
    return policyKey;
  }

  public void setPolicyKey(String policyKey) {
    this.policyKey = policyKey;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Bucket bucket = (Bucket) o;
    return Objects.equals(this.bucketKey, bucket.bucketKey) &&
        Objects.equals(this.bucketOwner, bucket.bucketOwner) &&
        Objects.equals(this.createdDate, bucket.createdDate) &&
        Objects.equals(this.permissions, bucket.permissions) &&
        Objects.equals(this.policyKey, bucket.policyKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bucketKey, bucketOwner, createdDate, permissions, policyKey);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Bucket {\n");
    
    sb.append("    bucketKey: ").append(toIndentedString(bucketKey)).append("\n");
    sb.append("    bucketOwner: ").append(toIndentedString(bucketOwner)).append("\n");
    sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
    sb.append("    permissions: ").append(toIndentedString(permissions)).append("\n");
    sb.append("    policyKey: ").append(toIndentedString(policyKey)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
