package com.federal.drisyaHome.model;

import java.util.ArrayList;
import java.util.StringJoiner;

public class LogDataDetails {

    private String[] logData;

    public String[] getLogData() {
        return logData;
    }

    public void setLogData(String[] logData) {
        this.logData = logData;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "{", "}")
                .add("\"logData:\"" + logData)
                .toString();
    }
}
