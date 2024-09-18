package com.federal.drisyaHome.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ApplicationsWithADLogin {
    List<ApplicationsWithADLoginData> data;
    @JsonProperty("data")
    public List<ApplicationsWithADLoginData> getData() {
        return data;
    }
    @JsonProperty("data")
    public void setData(List<ApplicationsWithADLoginData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "\"data\":" + data +
                '}';
    }
}
