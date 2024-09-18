package com.federal.drisyaHome.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Applications {
    List<ApplicationsData> data;
    @JsonProperty("data")
    public List<ApplicationsData> getData() {
        return data;
    }
    @JsonProperty("data")
    public void setData(List<ApplicationsData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "\"data\":" + data +
                '}';
    }
}
