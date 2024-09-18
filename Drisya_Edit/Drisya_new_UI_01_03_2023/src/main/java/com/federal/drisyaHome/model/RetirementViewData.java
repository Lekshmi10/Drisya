package com.federal.drisyaHome.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Lob;

public class RetirementViewData {

	String pfnum;
	 String name;
	 String date;	 
	    String departtment;
	    String designation;
	    
	    @Lob
	    String image;
	  //  String url;
	    
	    @JsonProperty("pfnum")
		public String getPfnum() {
			return pfnum;
		}
	    
	    @JsonProperty("pfnum")
		public void setPfnum(String pfnum) {
			this.pfnum = pfnum;
		}
	    
	    @JsonProperty("name")
		public String getName() {
			return name;
		}
	    @JsonProperty("name")
		public void setName(String name) {
			this.name = name;
		}
	   
	    @JsonProperty("departtment")
		public String getDeparttment() {
			return departtment;
		}
	    @JsonProperty("departtment")
		public void setDeparttment(String departtment) {
			this.departtment = departtment;
		}
	    @JsonProperty("designation")
		public String getDesignation() {
			return designation;
		}
	    @JsonProperty("designation")
		public void setDesignation(String designation) {
			this.designation = designation;
		}
	    @JsonProperty("join_date")
		public String getDate() {
			return date;
		}
	    @JsonProperty("join_date")
		public void setDate(String string) {
			this.date = string;
		}
	    
		public String getImage() {
			return image;
		}
	    
		public void setImage(String image) {
			this.image = image;
		}

		@Override
		public String toString() {
			return "RetirementViewData [pfnum=" + pfnum + ", name=" + name + ", date=" + date + ", departtment="
					+ departtment + ", designation=" + designation + ", image=" + image + "]";
		}

		
	    
	    
}
