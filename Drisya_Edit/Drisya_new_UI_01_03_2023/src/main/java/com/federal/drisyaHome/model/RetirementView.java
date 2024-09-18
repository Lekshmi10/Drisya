package com.federal.drisyaHome.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RetirementView {
	
	List<RetirementViewData> data;
	
    @JsonProperty("data")
	public List<RetirementViewData> getData() {
		return data;
	}

	@JsonProperty("data")
	public void setData(List<RetirementViewData> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "RetirementView [data=" + data + "]";
	}

	
	
	/* @Override
	    public String toString() {
	        return new StringJoiner(", ", "{", "}")
	                .add("\"data\":" + data)
	                .toString();
	    }
	
	*/
	
}
