package com.federal.drisyaHome.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ArchivesSection {
    List<ArchivesData> section;
    @JsonProperty("section")
    public List<ArchivesData> getSection() {
        return section;
    }
    @JsonProperty("section")
    public void setSection(List<ArchivesData> section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return "{" +
                "\"section\":" + section +
                '}';
    }
}
