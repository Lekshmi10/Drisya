package com.federal.drisyaHome.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BankInfo {
    String customers;
    String branches;
    String atms;
    String cdm;
    @JsonProperty("customers")
    public String getCustomers() {
        return customers;
    }
    @JsonProperty("customers")
    public void setCustomers(String customers) {
        this.customers = customers;
    }
    @JsonProperty("branches")
    public String getBranches() {
        return branches;
    }
    @JsonProperty("branches")
    public void setBranches(String branches) {
        this.branches = branches;
    }
    @JsonProperty("atms")
    public String getAtms() {
        return atms;
    }
    @JsonProperty("atms")
    public void setAtms(String atms) {
        this.atms = atms;
    }
    @JsonProperty("cdm")
    public String getCdm() {
        return cdm;
    }
    @JsonProperty("cdm")
    public void setCdm(String cdm) {
        this.cdm = cdm;
    }

    @Override
    public String toString() {
        return "{" +
                "\"customers\":" +"\""+ customers + "\"" +
                ", \"branches\":" +"\""+ branches + "\"" +
                ", \"atms\":" +"\""+ atms + "\"" +
                ", \"cdm\":" +"\""+ cdm + "\"" +
                '}';
    }
}
