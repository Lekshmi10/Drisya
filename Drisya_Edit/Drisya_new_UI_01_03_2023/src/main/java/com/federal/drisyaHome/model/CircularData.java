package com.federal.drisyaHome.model;

public class CircularData {

    String headline;
    String description;
    String department;
    String author;
    String employeeId;
    String url;
    String publishedDate;
    String id;

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{" +
                "\"headline\":" +"\""+ headline + "\"" +
                ",\"description\":" +"\""+ description + "\"" +
                ",\"department\":" +"\""+ department + "\"" +
                ",\"author\":" +"\""+ author + "\"" +
                ",\"employeeId\":" +"\""+ employeeId + "\"" +
                ",\"url\":" +"\""+ url + "\"" +
                ",\"publishedDate\":" +"\""+ publishedDate + "\"" +
                ",\"id\":" +"\""+ id + "\"" +
                '}';
    }
}
