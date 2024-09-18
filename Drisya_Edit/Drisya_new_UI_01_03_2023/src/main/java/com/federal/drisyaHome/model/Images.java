package com.federal.drisyaHome.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Images {
    List<ImagesData> data;
    @JsonProperty("data")
    public List<ImagesData> getData() {
        return data;
    }
    @JsonProperty("data")
    public void setData(List<ImagesData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "\"data\":" + data +
                '}';
    }
}
