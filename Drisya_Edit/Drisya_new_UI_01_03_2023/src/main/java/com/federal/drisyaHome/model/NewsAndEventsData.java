package com.federal.drisyaHome.model;

import javax.persistence.Lob;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewsAndEventsData {
	  @Lob
    String image;
    String date;
    String location;
    String time;
    String title;
    String text;
    @JsonProperty("image")
    public String getImage() {
        return image;
    }
    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }
    @JsonProperty("date")
    public String getDate() {
        return date;
    }
    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }
    @JsonProperty("location")
    public String getLocation() {
        return location;
    }
    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }
    @JsonProperty("time")
    public String getTime() {
        return time;
    }
    @JsonProperty("time")
    public void setTime(String time) {
        this.time = time;
    }
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }
    @JsonProperty("text")
    public String getText() {
        return text;
    }
    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "{" +
                "\"image\":" +"\""+ image + "\"" +
                ", \"date\":" +"\""+ date + "\"" +
                ", \"location\":" +"\""+ location + "\"" +
                ", \"time\":" +"\""+ time + "\"" +
                ", \"title\":" +"\""+ title + "\"" +
                ", \"text\":" +"\""+ text + "\"" +
                '}';
    }
}
