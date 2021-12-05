
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
    "kind",
    "title",
    "htmlTitle",
    "link",
    "displayLink",
    "snippet",
    "htmlSnippet",
    "cacheId",
    "formattedUrl",
    "htmlFormattedUrl",
    "pagemap"
})
@Generated("jsonschema2pojo")
public class Item {

    @JsonProperty("kind")
    private String kind;
    @JsonProperty("title")
    private String title;
    @JsonProperty("htmlTitle")
    private String htmlTitle;
    @JsonProperty("link")
    private String link;
    @JsonProperty("displayLink")
    private String displayLink;
    @JsonProperty("snippet")
    private String snippet;
    @JsonProperty("htmlSnippet")
    private String htmlSnippet;
    @JsonProperty("cacheId")
    private String cacheId;
    @JsonProperty("formattedUrl")
    private String formattedUrl;
    @JsonProperty("htmlFormattedUrl")
    private String htmlFormattedUrl;
    @JsonProperty("pagemap")
    private Pagemap pagemap;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("htmlTitle")
    public String getHtmlTitle() {
        return htmlTitle;
    }

    @JsonProperty("htmlTitle")
    public void setHtmlTitle(String htmlTitle) {
        this.htmlTitle = htmlTitle;
    }

    @JsonProperty("link")
    public String getLink() {
        return link;
    }

    @JsonProperty("link")
    public void setLink(String link) {
        this.link = link;
    }

    @JsonProperty("displayLink")
    public String getDisplayLink() {
        return displayLink;
    }

    @JsonProperty("displayLink")
    public void setDisplayLink(String displayLink) {
        this.displayLink = displayLink;
    }

    @JsonProperty("snippet")
    public String getSnippet() {
        return snippet;
    }

    @JsonProperty("snippet")
    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    @JsonProperty("htmlSnippet")
    public String getHtmlSnippet() {
        return htmlSnippet;
    }

    @JsonProperty("htmlSnippet")
    public void setHtmlSnippet(String htmlSnippet) {
        this.htmlSnippet = htmlSnippet;
    }

    @JsonProperty("cacheId")
    public String getCacheId() {
        return cacheId;
    }

    @JsonProperty("cacheId")
    public void setCacheId(String cacheId) {
        this.cacheId = cacheId;
    }

    @JsonProperty("formattedUrl")
    public String getFormattedUrl() {
        return formattedUrl;
    }

    @JsonProperty("formattedUrl")
    public void setFormattedUrl(String formattedUrl) {
        this.formattedUrl = formattedUrl;
    }

    @JsonProperty("htmlFormattedUrl")
    public String getHtmlFormattedUrl() {
        return htmlFormattedUrl;
    }

    @JsonProperty("htmlFormattedUrl")
    public void setHtmlFormattedUrl(String htmlFormattedUrl) {
        this.htmlFormattedUrl = htmlFormattedUrl;
    }

    @JsonProperty("pagemap")
    public Pagemap getPagemap() {
        return pagemap;
    }

    @JsonProperty("pagemap")
    public void setPagemap(Pagemap pagemap) {
        this.pagemap = pagemap;
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
