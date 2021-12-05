
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
    "og:image",
    "apple-itunes-app",
    "og:type",
    "twitter:card",
    "twitter:title",
    "og:site_name",
    "viewport",
    "twitter:description",
    "og:title",
    "og:url",
    "og:description",
    "twitter:image:src"
})
@Generated("jsonschema2pojo")
public class Metatag {

    @JsonProperty("og:image")
    private String ogImage;
    @JsonProperty("apple-itunes-app")
    private String appleItunesApp;
    @JsonProperty("og:type")
    private String ogType;
    @JsonProperty("twitter:card")
    private String twitterCard;
    @JsonProperty("twitter:title")
    private String twitterTitle;
    @JsonProperty("og:site_name")
    private String ogSiteName;
    @JsonProperty("viewport")
    private String viewport;
    @JsonProperty("twitter:description")
    private String twitterDescription;
    @JsonProperty("og:title")
    private String ogTitle;
    @JsonProperty("og:url")
    private String ogUrl;
    @JsonProperty("og:description")
    private String ogDescription;
    @JsonProperty("twitter:image:src")
    private String twitterImageSrc;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("og:image")
    public String getOgImage() {
        return ogImage;
    }

    @JsonProperty("og:image")
    public void setOgImage(String ogImage) {
        this.ogImage = ogImage;
    }

    @JsonProperty("apple-itunes-app")
    public String getAppleItunesApp() {
        return appleItunesApp;
    }

    @JsonProperty("apple-itunes-app")
    public void setAppleItunesApp(String appleItunesApp) {
        this.appleItunesApp = appleItunesApp;
    }

    @JsonProperty("og:type")
    public String getOgType() {
        return ogType;
    }

    @JsonProperty("og:type")
    public void setOgType(String ogType) {
        this.ogType = ogType;
    }

    @JsonProperty("twitter:card")
    public String getTwitterCard() {
        return twitterCard;
    }

    @JsonProperty("twitter:card")
    public void setTwitterCard(String twitterCard) {
        this.twitterCard = twitterCard;
    }

    @JsonProperty("twitter:title")
    public String getTwitterTitle() {
        return twitterTitle;
    }

    @JsonProperty("twitter:title")
    public void setTwitterTitle(String twitterTitle) {
        this.twitterTitle = twitterTitle;
    }

    @JsonProperty("og:site_name")
    public String getOgSiteName() {
        return ogSiteName;
    }

    @JsonProperty("og:site_name")
    public void setOgSiteName(String ogSiteName) {
        this.ogSiteName = ogSiteName;
    }

    @JsonProperty("viewport")
    public String getViewport() {
        return viewport;
    }

    @JsonProperty("viewport")
    public void setViewport(String viewport) {
        this.viewport = viewport;
    }

    @JsonProperty("twitter:description")
    public String getTwitterDescription() {
        return twitterDescription;
    }

    @JsonProperty("twitter:description")
    public void setTwitterDescription(String twitterDescription) {
        this.twitterDescription = twitterDescription;
    }

    @JsonProperty("og:title")
    public String getOgTitle() {
        return ogTitle;
    }

    @JsonProperty("og:title")
    public void setOgTitle(String ogTitle) {
        this.ogTitle = ogTitle;
    }

    @JsonProperty("og:url")
    public String getOgUrl() {
        return ogUrl;
    }

    @JsonProperty("og:url")
    public void setOgUrl(String ogUrl) {
        this.ogUrl = ogUrl;
    }

    @JsonProperty("og:description")
    public String getOgDescription() {
        return ogDescription;
    }

    @JsonProperty("og:description")
    public void setOgDescription(String ogDescription) {
        this.ogDescription = ogDescription;
    }

    @JsonProperty("twitter:image:src")
    public String getTwitterImageSrc() {
        return twitterImageSrc;
    }

    @JsonProperty("twitter:image:src")
    public void setTwitterImageSrc(String twitterImageSrc) {
        this.twitterImageSrc = twitterImageSrc;
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
