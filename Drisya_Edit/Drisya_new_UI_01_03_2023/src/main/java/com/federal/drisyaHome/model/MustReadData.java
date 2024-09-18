package com.federal.drisyaHome.model;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MustReadData {
	 String text;
	    String url;
	    @JsonProperty("text")
	    public String getText() {
	        return text;
	    }
	    @JsonProperty("text")
	    public void setText(String text) {
	        this.text = text;
	    }
	    @JsonProperty("url")
	    public String getUrl() {
	        return url;
	    }
	    @JsonProperty("url")
	    public void setUrl(String url) {
	        this.url = url;
	    }

	    @Override
	    public String toString() {
	        return "{" +
	                "\"text\":" +"\""+ text + "\"" +
	                ", \"url\":" +"\""+ url + "\"" +
	                '}';
	    }
}
