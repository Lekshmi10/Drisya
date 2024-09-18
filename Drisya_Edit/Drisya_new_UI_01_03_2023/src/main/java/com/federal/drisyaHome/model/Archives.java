package com.federal.drisyaHome.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Archives {
    List<ArchivesSection> archives;
    @JsonProperty("archives")
    public List<ArchivesSection> getArchives() {
        return archives;
    }
    @JsonProperty("archives")
    public void setArchives(List<ArchivesSection> archives) {
        this.archives = archives;
    }

    @Override
    public String toString() {
        return "{" +
                "\"archives\":" + archives +
                '}';
    }
}
