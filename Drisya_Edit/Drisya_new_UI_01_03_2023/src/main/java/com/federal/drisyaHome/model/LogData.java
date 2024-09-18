package com.federal.drisyaHome.model;

import javax.persistence.*;
import java.util.StringJoiner;

@Entity(name = "LogData")
@Table(name = "LOG_DATA")
public class LogData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "log_seq")
    @SequenceGenerator(name = "log_seq", sequenceName = "log_seq", allocationSize = 1)
    @Column(name = "ID")
    private int id;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "DESIGNATION")
    private String designation;
    @Column(name = "DEPARTMENT")
    private String department;
    @Column(name = "TIME")
    private String time;
    @Column(name = "PAGE")
    private String page;
    @Column(name = "SECTION")
    private String section;
    @Lob
    @Column(name = "DATA")
    private String data;


    public String getDesignation() {
        return designation;
    }


    public void setDesignation(String value) {
        this.designation = value;
    }

    public String getDepartment() {
        return department;
    }


    public void setDepartment(String value) {
        this.department = value;
    }

    public String getUsername() {
        return username;
    }


    public void setUsername(String value) {
        this.username = value;
    }

    public String getTime() {
        return time;
    }


    public void setTime(String value) {
        this.time = value;
    }

    public String getPage() {
        return page;
    }


    public void setPage(String value) {
        this.page = value;
    }


    public String getData() {
        return data;
    }

    public void setData(String value) {
        this.data = value;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String value) {
        this.section = value;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "{", "}")
                .add("\"designation:\"" + designation + "\"")
                .add("\"department:\"" + department + "\"")
                .add("\"username:\"" + username + "\"")
                .add("\"time:\"" + time + "\"")
                .add("\"page:\"" + page + "\"")
                .add("\"data:\"" + data + "\"")
                .add("\"section:\"" + section + "\"")
                .toString();
    }
}
