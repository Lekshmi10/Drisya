package com.federal.drisyaHome.model;

import javax.persistence.Lob;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RetirementData {
    String name;
    String pfNumber;
    String department;

    String image;
    String date;
    String designation;

    @JsonProperty("name")
    public String getName() {
        return name;
    }
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }
    @JsonProperty("pfNumber")
    public String getPfNumber() {
        return pfNumber;
    }
    @JsonProperty("pfNumber")
    public void setPfNumber(String pfNumber) {
        this.pfNumber = pfNumber;
    }
    @JsonProperty("department")
    public String getDepartment() {
        return department;
    }
    @JsonProperty("department")
    public void setDepartment(String department) {
        this.department = department;
    }
    @JsonProperty("image")
    public String getImage() {
        return image;
    }
    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }
    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }
    @JsonProperty("designation")
    public String getDesignation() {
        return designation;
    }
    @JsonProperty("designation")
    public void setDesignation(String designation) {
        this.designation = designation;
    }



    @Override
    public String toString() {
        return "{" +
                "\"name\":" +"\""+ name + "\"" +
                ", \"pfNumber\":" +"\""+ pfNumber + "\"" +
                ", \"department\":" +"\""+ department + "\"" +
                ", \"image\":" +"\""+ image + "\"" +", \"date\":" +"\""+ date + "\"" + ", \"designation\":" +"\""+ designation + "\"" +
                '}';
    }
}
