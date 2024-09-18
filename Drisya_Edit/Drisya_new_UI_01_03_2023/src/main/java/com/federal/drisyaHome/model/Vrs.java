package com.federal.drisyaHome.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.StringJoiner;

public class Vrs {
	int flag;
	List<VrsData> data;
    @JsonProperty("data")
    public List<VrsData> getData() {
        return data;
    }
    @JsonProperty("data")
    public void setData(List<VrsData> data) {
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
