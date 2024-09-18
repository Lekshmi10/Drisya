package com.federal.drisyaHome.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Blurb {
    List<BlurbData> data;
    @JsonProperty("data")
    public List<BlurbData> getData() {
        return data;
    }
    @JsonProperty("data")
    public void setData(List<BlurbData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "\"data\":" + data +
                '}';
    }
}
