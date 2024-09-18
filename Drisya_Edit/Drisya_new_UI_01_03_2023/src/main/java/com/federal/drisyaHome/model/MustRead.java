package com.federal.drisyaHome.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
public class MustRead {
	   String title;
	    List<MustReadData> data;
	    @JsonProperty("title")
	    public String getTitle() {
	        return title;
	    }
	    @JsonProperty("title")
	    public void setTitle(String title) {
	        this.title = title;
	    }
	    @JsonProperty("data")
	    public List<MustReadData> getData() {
	        return data;
	    }
	    @JsonProperty("data")
	    public void setData(List<MustReadData> data) {
	        this.data = data;
	    }


	    @Override
	    public String toString() {
	        return "{" +
	        		"\"title\":" + "\"" +title + "\"" +
	        		",\"data\":" + data +
	                '}';
	    }
}
/*
"\"title\":" + "\"" +title + "\"" +
",\"data\":" + data +
*/