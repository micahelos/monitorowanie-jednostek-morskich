
package com.ctm.vessel.tracker.system.model.googlesearch;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "title",
    "totalResults",
    "searchTerms",
    "count",
    "startIndex",
    "inputEncoding",
    "outputEncoding",
    "safe",
    "cx"
})
@Generated("jsonschema2pojo")
public class Request {

    @JsonProperty("title")
    private String title;
    @JsonProperty("totalResults")
    private String totalResults;
    @JsonProperty("searchTerms")
    private String searchTerms;
    @JsonProperty("count")
    private Integer count;
    @JsonProperty("startIndex")
    private Integer startIndex;
    @JsonProperty("inputEncoding")
    private String inputEncoding;
    @JsonProperty("outputEncoding")
    private String outputEncoding;
    @JsonProperty("safe")
    private String safe;
    @JsonProperty("cx")
    private String cx;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("totalResults")
    public String getTotalResults() {
        return totalResults;
    }

    @JsonProperty("totalResults")
    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    @JsonProperty("searchTerms")
    public String getSearchTerms() {
        return searchTerms;
    }

    @JsonProperty("searchTerms")
    public void setSearchTerms(String searchTerms) {
        this.searchTerms = searchTerms;
    }

    @JsonProperty("count")
    public Integer getCount() {
        return count;
    }

    @JsonProperty("count")
    public void setCount(Integer count) {
        this.count = count;
    }

    @JsonProperty("startIndex")
    public Integer getStartIndex() {
        return startIndex;
    }

    @JsonProperty("startIndex")
    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    @JsonProperty("inputEncoding")
    public String getInputEncoding() {
        return inputEncoding;
    }

    @JsonProperty("inputEncoding")
    public void setInputEncoding(String inputEncoding) {
        this.inputEncoding = inputEncoding;
    }

    @JsonProperty("outputEncoding")
    public String getOutputEncoding() {
        return outputEncoding;
    }

    @JsonProperty("outputEncoding")
    public void setOutputEncoding(String outputEncoding) {
        this.outputEncoding = outputEncoding;
    }

    @JsonProperty("safe")
    public String getSafe() {
        return safe;
    }

    @JsonProperty("safe")
    public void setSafe(String safe) {
        this.safe = safe;
    }

    @JsonProperty("cx")
    public String getCx() {
        return cx;
    }

    @JsonProperty("cx")
    public void setCx(String cx) {
        this.cx = cx;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
