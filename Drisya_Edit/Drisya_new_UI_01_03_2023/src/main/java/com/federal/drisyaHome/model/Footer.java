package com.federal.drisyaHome.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Footer {
    List<SectionData> sectionData;

    @JsonProperty("sectionData")
    public List<SectionData> getSectionData() {
        return sectionData;
    }
    @JsonProperty("sectionData")
    public void setSectionData(List<SectionData> sectionData) {
        this.sectionData = sectionData;
    }

    @Override
    public String toString() {
        return "{" +
                 "\"sectionData\":" + sectionData +
                '}';
    }
}
