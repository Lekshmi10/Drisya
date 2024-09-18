package com.federal.drisyaHome.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ReferencesWithADLogin {
    List<ReferencesWithADLoginData> data;
    @JsonProperty("data")
    public List<ReferencesWithADLoginData> getData() {
        return data;
    }
    @JsonProperty("data")
    public void setData(List<ReferencesWithADLoginData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "\"data\":" + data +
                '}';
    }
}
