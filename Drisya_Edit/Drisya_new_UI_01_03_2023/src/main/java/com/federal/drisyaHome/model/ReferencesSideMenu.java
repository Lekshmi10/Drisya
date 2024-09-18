package com.federal.drisyaHome.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ReferencesSideMenu {
    List<ReferencesSideMenuData> data;
    @JsonProperty("data")
    public List<ReferencesSideMenuData> getData() {
        return data;
    }
    @JsonProperty("data")
    public void setData(List<ReferencesSideMenuData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "\"data\":" + data +
                '}';
    }
}
