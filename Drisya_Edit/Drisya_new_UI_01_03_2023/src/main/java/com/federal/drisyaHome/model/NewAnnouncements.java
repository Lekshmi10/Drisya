package com.federal.drisyaHome.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewAnnouncements {

	
	  String title;
	     List<NewAnnouncementsData> data;
	   
	    public String getTitle() {
	        return title;
	    }
	  
	    public void setTitle(String title) {
	        this.title = title;
	    }
	   
	    public List<NewAnnouncementsData> getData() {
	        return data;
	    }
	  
	    public void setData(List<NewAnnouncementsData> data) {
	        this.data = data;
	    }
	    
	    @Override
	    public String toString() {
	        return "{" +
	                "\"title\":" +"\""+ title+"\"" +
	                ",\"data\":" + data +
	                '}';
	    }
}
