package com.federal.drisyaHome.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Lob;

public class BlurbData {
    @Lob
    String thumbnail;
    String url;
    @JsonProperty("thumbnail")
    public String getThumbnail() {
        return thumbnail;
    }
    @JsonProperty("thumbnail")
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "{" +
                "\"thumbnail\":" + "\""+thumbnail + "\"" +
                ",\"url\":" + "\""+ url + "\"" +
                "}";
    }
}
