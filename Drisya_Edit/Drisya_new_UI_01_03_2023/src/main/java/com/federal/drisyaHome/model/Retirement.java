package com.federal.drisyaHome.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.StringJoiner;

public class Retirement {
	int flag;
    List<RetirementData> data;
    @JsonProperty("data")
    public List<RetirementData> getData() {
        return data;
    }
    @JsonProperty("data")
    public void setData(List<RetirementData> data) {
        this.data = data;
    }
    @JsonProperty("flag")
    public int getFlag() {
		return flag;
	}
    @JsonProperty("flag")
	public void setFlag(int flag) {
		this.flag = flag;
	}

    @Override
    public String toString() {
        return new StringJoiner(", ", "{", "}")
                .add("\"data\":" + data)
                .add("\"flag\":" + flag)
                .toString();
    }
	
}
