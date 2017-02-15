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

import com.autodesk.client.model.ObjectFullDetailsDeltas;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;


/**
 * Object Details json response
 */
@ApiModel(description = "Object Details json response")

public class ObjectFullDetails   {
  @JsonProperty("bucketKey")
  private String bucketKey = null;

  @JsonProperty("objectId")
  private String objectId = null;

  @JsonProperty("objectKey")
  private String objectKey = null;

  @JsonProperty("sha1")
  private byte[] sha1 = null;

  @JsonProperty("size")
  private Integer size = null;

  @JsonProperty("contentType")
  private String contentType = null;

  @JsonProperty("location")
  private String location = null;

  @JsonProperty("blockSizes")
  private List<Integer> blockSizes = new ArrayList<Integer>();

  @JsonProperty("deltas")
  private List<ObjectFullDetailsDeltas> deltas = new ArrayList<ObjectFullDetailsDeltas>();

  public ObjectFullDetails bucketKey(String bucketKey) {
    this.bucketKey = bucketKey;
    return this;
  }

   /**
   * Bucket key
   * @return bucketKey
  **/
  @ApiModelProperty(example = "null", value = "Bucket key")
  public String getBucketKey() {
    return bucketKey;
  }

  public void setBucketKey(String bucketKey) {
    this.bucketKey = bucketKey;
  }

  public ObjectFullDetails objectId(String objectId) {
    this.objectId = objectId;
    return this;
  }

   /**
   * Object URN
   * @return objectId
  **/
  @ApiModelProperty(example = "null", value = "Object URN")
  public String getObjectId() {
    return objectId;
  }

  public void setObjectId(String objectId) {
    this.objectId = objectId;
  }

  public ObjectFullDetails objectKey(String objectKey) {
    this.objectKey = objectKey;
    return this;
  }

   /**
   * Object name
   * @return objectKey
  **/
  @ApiModelProperty(example = "null", value = "Object name")
  public String getObjectKey() {
    return objectKey;
  }

  public void setObjectKey(String objectKey) {
    this.objectKey = objectKey;
  }

  public ObjectFullDetails sha1(byte[] sha1) {
    this.sha1 = sha1;
    return this;
  }

   /**
   * Object SHA1
   * @return sha1
  **/
  @ApiModelProperty(example = "null", value = "Object SHA1")
  public byte[] getSha1() {
    return sha1;
  }

  public void setSha1(byte[] sha1) {
    this.sha1 = sha1;
  }

  public ObjectFullDetails size(Integer size) {
    this.size = size;
    return this;
  }

   /**
   * Object size
   * @return size
  **/
  @ApiModelProperty(example = "null", value = "Object size")
  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public ObjectFullDetails contentType(String contentType) {
    this.contentType = contentType;
    return this;
  }

   /**
   * Object content-type
   * @return contentType
  **/
  @ApiModelProperty(example = "null", value = "Object content-type")
  public String getContentType() {
    return contentType;
  }

  public void setContentType(String contentType) {
    this.contentType = contentType;
  }

  public ObjectFullDetails location(String location) {
    this.location = location;
    return this;
  }

   /**
   * URL to download the object
   * @return location
  **/
  @ApiModelProperty(example = "null", value = "URL to download the object")
  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public ObjectFullDetails blockSizes(List<Integer> blockSizes) {
    this.blockSizes = blockSizes;
    return this;
  }

   /**
   * For delta-encoding. Represents whether a signature exists at a specific block size
   * @return blockSizes
  **/
  @ApiModelProperty(example = "null", value = "For delta-encoding. Represents whether a signature exists at a specific block size")
  public List<Integer> getBlockSizes() {
    return blockSizes;
  }

  public void setBlockSizes(List<Integer> blockSizes) {
    this.blockSizes = blockSizes;
  }

  public ObjectFullDetails deltas(List<ObjectFullDetailsDeltas> deltas) {
    this.deltas = deltas;
    return this;
  }

   /**
   * Patch files available for download related to this object
   * @return deltas
  **/
  @ApiModelProperty(example = "null", value = "Patch files available for download related to this object")
  public List<ObjectFullDetailsDeltas> getDeltas() {
    return deltas;
  }

  public void setDeltas(List<ObjectFullDetailsDeltas> deltas) {
    this.deltas = deltas;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ObjectFullDetails objectFullDetails = (ObjectFullDetails) o;
    return Objects.equals(this.bucketKey, objectFullDetails.bucketKey) &&
        Objects.equals(this.objectId, objectFullDetails.objectId) &&
        Objects.equals(this.objectKey, objectFullDetails.objectKey) &&
        Objects.equals(this.sha1, objectFullDetails.sha1) &&
        Objects.equals(this.size, objectFullDetails.size) &&
        Objects.equals(this.contentType, objectFullDetails.contentType) &&
        Objects.equals(this.location, objectFullDetails.location) &&
        Objects.equals(this.blockSizes, objectFullDetails.blockSizes) &&
        Objects.equals(this.deltas, objectFullDetails.deltas);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bucketKey, objectId, objectKey, sha1, size, contentType, location, blockSizes, deltas);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ObjectFullDetails {\n");
    
    sb.append("    bucketKey: ").append(toIndentedString(bucketKey)).append("\n");
    sb.append("    objectId: ").append(toIndentedString(objectId)).append("\n");
    sb.append("    objectKey: ").append(toIndentedString(objectKey)).append("\n");
    sb.append("    sha1: ").append(toIndentedString(sha1)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    contentType: ").append(toIndentedString(contentType)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    blockSizes: ").append(toIndentedString(blockSizes)).append("\n");
    sb.append("    deltas: ").append(toIndentedString(deltas)).append("\n");
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

