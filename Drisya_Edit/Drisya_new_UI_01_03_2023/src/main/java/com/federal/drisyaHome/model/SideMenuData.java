package com.federal.drisyaHome.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SideMenuData{
    private String text;
    private String url;

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String value) {
        this.text = value;
    }

    @JsonProperty("url")
    public String getURL() {
        return url;
    }

    @JsonProperty("url")
    public void setURL(String value) {
        this.url = value;
    }

    @Override
    public String toString() {
        return "{" +
                "\"text\":" +"\""+text + "\"" +
                ", \"url\":" +"\""+ url + "\"" +
                '}';
    }
}