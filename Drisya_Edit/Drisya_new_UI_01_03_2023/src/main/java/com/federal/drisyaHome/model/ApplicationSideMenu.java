package com.federal.drisyaHome.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ApplicationSideMenu {
    List<ApplicationSideMenuData> data;
    @JsonProperty("data")
    public List<ApplicationSideMenuData> getData() {
        return data;
    }
    @JsonProperty("data")
    public void setData(List<ApplicationSideMenuData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "\"data\":" + data +
                '}';
    }
}
