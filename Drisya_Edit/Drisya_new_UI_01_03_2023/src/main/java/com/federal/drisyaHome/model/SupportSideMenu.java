package com.federal.drisyaHome.model;

import java.util.List;

public class SupportSideMenu {

    List<SupportSideMenuData> data;


    public List<SupportSideMenuData> getData() {
        return data;
    }

    public void setData(List<SupportSideMenuData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "\"data\":" + data +
                '}';
    }
}
