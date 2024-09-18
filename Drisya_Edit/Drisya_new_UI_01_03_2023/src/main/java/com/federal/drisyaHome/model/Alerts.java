package com.federal.drisyaHome.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class Alerts {
    List<AlertsData> alerts;
    @JsonProperty("alerts")
    public List<AlertsData> getAlerts() {
        return alerts;
    }
    @JsonProperty("alerts")
    public void setAlerts(List<AlertsData> alerts) {
        this.alerts = alerts;
    }


    @Override
    public String toString() {
        return "{" +
                "\"alerts\":" + alerts +
                '}';
    }
}

