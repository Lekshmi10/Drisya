package com.federal.drisyaHome.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.StringJoiner;

public class MiscellaneousData {

    String content;
    String image;
    String url;
    String color;


    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    @JsonProperty("content")
    public void setContent(String content) {
        this.content = content;
    }

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

    @JsonProperty("color")
    public String getColor() {
        return color;
    }

    @JsonProperty("color")
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ",  "{", "}")
                .add("\"content\":\"" + content + "\"")
                .add("\"image\":\"" + image + "\"")
                .add("\"url\":\"" + url + "\"")
                .add("\"color\":\"" + color + "\"")
                .toString();
    }
}
