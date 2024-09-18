package com.federal.drisyaHome.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.StringJoiner;

public class Miscellaneous {


    List<MiscellaneousData> data;

    @JsonProperty("data")
    public List<MiscellaneousData> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<MiscellaneousData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "{", "}")
                .add("\"data\":" + data)
                .toString();
    }
}

