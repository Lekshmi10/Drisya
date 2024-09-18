package com.federal.drisyaHome.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SupportWithoutAD {
    List<SupportWithoutADData> data;
    @JsonProperty("data")
    public List<SupportWithoutADData> getData() {
        return data;
    }
    @JsonProperty("data")
    public void setData(List<SupportWithoutADData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "\"data\":" + data +
                '}';
    }
}
