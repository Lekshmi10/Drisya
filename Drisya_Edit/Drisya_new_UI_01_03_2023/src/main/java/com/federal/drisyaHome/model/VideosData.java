package com.federal.drisyaHome.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Lob;
import java.util.StringJoiner;

public class VideosData {
    String title;
    @Lob
    String thumbnail;
    String url;

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

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

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "{", "}")
                .add("\"title\":\"" + title + "\"")
                .add("\"thumbnail\":\"" + thumbnail + "\"")
                .add("\"url\":\"" + url + "\"")
                .toString();
    }
}
