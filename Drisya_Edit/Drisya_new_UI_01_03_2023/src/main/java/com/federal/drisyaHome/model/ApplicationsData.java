package com.federal.drisyaHome.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApplicationsData {
    String text;
    String url;
    Boolean flag;
    @JsonProperty("text")
    public String getText() {
        return text;
    }
    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }
    @JsonProperty("flag")
    public Boolean getFlag() {
        return flag;
    }
    @JsonProperty("flag")
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "{" +
                "\"text\":" +"\""+ text + "\"" +
                ", \"url\":" + "\""+ url + "\"" +
                ", \"flag\":" + flag +
                '}';
    }
}
