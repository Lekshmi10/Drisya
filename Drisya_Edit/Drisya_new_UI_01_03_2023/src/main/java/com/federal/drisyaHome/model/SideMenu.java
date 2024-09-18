package com.federal.drisyaHome.model;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

public class SideMenu {

    @JsonProperty("data")
    private List<SideMenuData> data;

    public List<SideMenuData> getData() {
        return data;
    }

    public void setData(List<SideMenuData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "\"data\":" + data +
                '}';
    }
}

