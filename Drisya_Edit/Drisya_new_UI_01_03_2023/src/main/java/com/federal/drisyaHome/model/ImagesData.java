package com.federal.drisyaHome.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Lob;
import java.util.StringJoiner;

public class ImagesData {
    @Lob
    String image;
    String url;
    @JsonProperty("image")
    public String getImage() {
        return image;
    }
    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
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
        return new StringJoiner(", ",  "{", "}")
                .add("\"image\":\"" + image + "\"")
                .add("\"url\":\"" + url + "\"")
                .toString();
    }
}
