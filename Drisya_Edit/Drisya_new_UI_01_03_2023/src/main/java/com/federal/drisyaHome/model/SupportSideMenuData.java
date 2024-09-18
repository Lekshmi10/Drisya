package com.federal.drisyaHome.model;

public class SupportSideMenuData {

    String text;
    String url;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "{" +
                "\"text\" :" +"\""+ text + "\"" +
                ", \"url\" :" +"\""+ url + "\"" +
                '}';
    }
}
