package com.federal.drisyaHome.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Lob;


public class Music {
    @Lob
    @JsonProperty("audioText")
    public String audioText;

    public String getAudioText() {
        return audioText;
    }

    public void setAudioText(String audioText) {
        this.audioText = audioText;
    }


    @Override
    public String toString() {
        return "{" +
                "\"audioText\":" +"\""+ audioText + "\"" +
                '}';
    }
}
