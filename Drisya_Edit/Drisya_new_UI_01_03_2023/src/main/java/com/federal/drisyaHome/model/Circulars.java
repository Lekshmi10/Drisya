package com.federal.drisyaHome.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Circulars {
    String title;
    List<CircularData> data;

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }
    @JsonProperty("data")
    public List<CircularData> getData() {
        return data;
    }
    @JsonProperty("data")
    public void setData(List<CircularData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "\"title\":" +"\""+ title+"\"" +
                ",\"data\":" + data +
                '}';
    }

    }

