package com.federal.drisyaHome.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.StringJoiner;

public class Videos {
    List<VideosData> data;
    @JsonProperty("data")
    public List<VideosData> getData() {
        return data;
    }
    @JsonProperty("data")
    public void setData(List<VideosData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return new StringJoiner(",",  "{", "}")
                .add("\"data\":" + data)
                .toString();
    }

}
