package com.federal.drisyaHome.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AlertsData {
    String alert;
    @JsonProperty("alert")
    public String getAlert() {
        return alert;
    }
    @JsonProperty("alert")
    public void setAlert(String alert) {
        this.alert = alert;
    }

    @Override
    public String toString() {
        return "{" +
                "\"alert\":"+"\"" + alert +"\""+
                '}';
    }

}
