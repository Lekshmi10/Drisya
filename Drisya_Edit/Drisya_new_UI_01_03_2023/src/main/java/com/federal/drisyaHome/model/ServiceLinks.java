package com.federal.drisyaHome.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ServiceLinks {
    String title;
    List<ServiceLinksData> data;
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }
    @JsonProperty("data")
    public List<ServiceLinksData> getData() {
        return data;
    }
    @JsonProperty("data")
    public void setData(List<ServiceLinksData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "\"title\":" +"\""+ title + "\"" +
                ",\"data\":" + data +
                '}';
    }
}
