package com.federal.drisyaHome.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SupportWithAD {
    List<SupportWithADData> data;
    @JsonProperty("data")
    public List<SupportWithADData> getData() {
        return data;
    }
    @JsonProperty("data")
    public void setData(List<SupportWithADData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "\"data\":" + data +
                '}';
    }
}
