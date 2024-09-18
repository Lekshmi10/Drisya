package com.federal.drisyaHome.model;


public class ResponseModel {
    Alerts alerts;
    ApplicationSideMenu applicationSideMenu;
    Applications applications;
    ApplicationsWithADLogin applicationsWithADLogin;
    ExternalLink externalLink;
    MoneyTransfer moneyTransfer;
    Footer footer;

    public Alerts getAlerts() {
        return alerts;
    }

    public void setAlerts(Alerts alerts) {
        this.alerts = alerts;
    }

    public ApplicationSideMenu getApplicationSideMenu() {
        return applicationSideMenu;
    }

    public void setApplicationSideMenu(ApplicationSideMenu applicationSideMenu) {
        this.applicationSideMenu = applicationSideMenu;
    }

    public Applications getApplications() {
        return applications;
    }

    public void setApplications(Applications applications) {
        this.applications = applications;
    }

    public ApplicationsWithADLogin getApplicationsWithADLogin() {
        return applicationsWithADLogin;
    }

    public void setApplicationsWithADLogin(ApplicationsWithADLogin applicationsWithADLogin) {
        this.applicationsWithADLogin = applicationsWithADLogin;
    }

    public ExternalLink getExternalLink() {
        return externalLink;
    }

    public void setExternalLink(ExternalLink externalLink) {
        this.externalLink = externalLink;
    }

    public MoneyTransfer getMoneyTransfer() {
        return moneyTransfer;
    }

    public void setMoneyTransfer(MoneyTransfer moneyTransfer) {
        this.moneyTransfer = moneyTransfer;
    }

    public Footer getFooter() {
        return footer;
    }

    public void setFooter(Footer footer) {
        this.footer = footer;
    }
}
