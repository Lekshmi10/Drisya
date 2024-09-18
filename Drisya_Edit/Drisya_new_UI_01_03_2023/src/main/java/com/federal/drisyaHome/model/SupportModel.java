package com.federal.drisyaHome.model;

public class SupportModel {
    SupportWithAD supportWithAD;
    SupportWithoutAD supportWithoutAD;
    Footer footer;
    Alerts alerts;
    SupportSideMenu supportSideMenu;

    public SupportWithAD getSupportWithAD() {
        return supportWithAD;
    }

    public void setSupportWithAD(SupportWithAD supportWithAD) {
        this.supportWithAD = supportWithAD;
    }

    public SupportWithoutAD getSupportWithoutAD() {
        return supportWithoutAD;
    }

    public void setSupportWithoutAD(SupportWithoutAD supportWithoutAD) {
        this.supportWithoutAD = supportWithoutAD;
    }

    public Footer getFooter() {
        return footer;
    }

    public void setFooter(Footer footer) {
        this.footer = footer;
    }

    public Alerts getAlerts() {
        return alerts;
    }

    public void setAlerts(Alerts alerts) {
        this.alerts = alerts;
    }

    public SupportSideMenu getSupportSideMenu() {
        return supportSideMenu;
    }

    public void setSupportSideMenu(SupportSideMenu supportSideMenu) {
        this.supportSideMenu = supportSideMenu;
    }
}
