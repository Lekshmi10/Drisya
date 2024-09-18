package com.federal.drisyaHome.model;


import javax.persistence.*;

import org.springframework.data.redis.core.RedisHash;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.Serializable;

@Entity(name = "DrisyaTable")
@Table(name = "DRISYA_TABLE")
@JsonDeserialize(as=DrisyaTable.class)
@RedisHash("DRISYA_TABLE")

public class DrisyaTable implements Serializable {

    @Id
    @Column(name = "ID")
    private int id;
    @Column(name = "SECTION")
    private String section;

    @Lob
    @Column(name = "SECTION_DATA")
    private String sectionData;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSectionData() {
        return sectionData;
    }

    public void setSectionData(String sectionData) {
        this.sectionData = sectionData;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ",\"section\":" +"\""+ section +"\""+
                ",\"sectionData\":" + sectionData +"\""+
                '}';
    }
}
