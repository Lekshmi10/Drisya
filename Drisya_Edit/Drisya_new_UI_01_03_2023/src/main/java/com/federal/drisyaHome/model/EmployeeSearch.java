package com.federal.drisyaHome.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeSearch {
    String url;
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
                "\"url\":" +"\""+ url + "\"" +
                '}';
    }


}
