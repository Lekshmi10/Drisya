package com.federal.drisyaHome.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SectionData {
    String title;
    List<MenuData> menu;
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }
    @JsonProperty("menu")
    public List<MenuData> getMenu() {
        return menu;
    }
    @JsonProperty("menu")
    public void setMenu(List<MenuData> menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "{"+
                "\"title\":" +"\""+ title + "\"" +
                ", \"menu\":" + menu +
                '}';
    }
}
