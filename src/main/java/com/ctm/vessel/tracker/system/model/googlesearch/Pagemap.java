
package com.ctm.vessel.tracker.system.model.googlesearch;

import java.util.HashMap;
import java.util.List;
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
    "cse_thumbnail",
    "cse_image",
    "website",
    "metatags"
})
@Generated("jsonschema2pojo")
public class Pagemap {

    @JsonProperty("cse_thumbnail")
    private List<CseThumbnail> cseThumbnail = null;
    @JsonProperty("cse_image")
    private List<CseImage> cseImage = null;
    @JsonProperty("website")
    private List<Website> website = null;
    @JsonProperty("metatags")
    private List<Metatag> metatags = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("cse_thumbnail")
    public List<CseThumbnail> getCseThumbnail() {
        return cseThumbnail;
    }

    @JsonProperty("cse_thumbnail")
    public void setCseThumbnail(List<CseThumbnail> cseThumbnail) {
        this.cseThumbnail = cseThumbnail;
    }

    @JsonProperty("cse_image")
    public List<CseImage> getCseImage() {
        return cseImage;
    }

    @JsonProperty("cse_image")
    public void setCseImage(List<CseImage> cseImage) {
        this.cseImage = cseImage;
    }

    @JsonProperty("website")
    public List<Website> getWebsite() {
        return website;
    }

    @JsonProperty("website")
    public void setWebsite(List<Website> website) {
        this.website = website;
    }

    @JsonProperty("metatags")
    public List<Metatag> getMetatags() {
        return metatags;
    }

    @JsonProperty("metatags")
    public void setMetatags(List<Metatag> metatags) {
        this.metatags = metatags;
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
