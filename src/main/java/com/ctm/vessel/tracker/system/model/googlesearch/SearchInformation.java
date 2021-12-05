
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
    "searchTime",
    "formattedSearchTime",
    "totalResults",
    "formattedTotalResults"
})
@Generated("jsonschema2pojo")
public class SearchInformation {

    @JsonProperty("searchTime")
    private Double searchTime;
    @JsonProperty("formattedSearchTime")
    private String formattedSearchTime;
    @JsonProperty("totalResults")
    private String totalResults;
    @JsonProperty("formattedTotalResults")
    private String formattedTotalResults;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("searchTime")
    public Double getSearchTime() {
        return searchTime;
    }

    @JsonProperty("searchTime")
    public void setSearchTime(Double searchTime) {
        this.searchTime = searchTime;
    }

    @JsonProperty("formattedSearchTime")
    public String getFormattedSearchTime() {
        return formattedSearchTime;
    }

    @JsonProperty("formattedSearchTime")
    public void setFormattedSearchTime(String formattedSearchTime) {
        this.formattedSearchTime = formattedSearchTime;
    }

    @JsonProperty("totalResults")
    public String getTotalResults() {
        return totalResults;
    }

    @JsonProperty("totalResults")
    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    @JsonProperty("formattedTotalResults")
    public String getFormattedTotalResults() {
        return formattedTotalResults;
    }

    @JsonProperty("formattedTotalResults")
    public void setFormattedTotalResults(String formattedTotalResults) {
        this.formattedTotalResults = formattedTotalResults;
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
