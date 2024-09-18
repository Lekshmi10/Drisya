package com.federal.drisyaHome.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class References {
    List<ReferencesData> data;
    @JsonProperty("data")
    public List<ReferencesData> getData() {
        return data;
    }
    @JsonProperty("data")
    public void setData(List<ReferencesData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "\"data\":" + data +
                '}';
    }
}
