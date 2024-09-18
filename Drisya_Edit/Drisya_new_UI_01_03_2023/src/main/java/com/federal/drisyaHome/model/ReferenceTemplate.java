package com.federal.drisyaHome.model;


public class ReferenceTemplate {
    Alerts alerts;
    ReferencesSideMenu referencesSideMenu;
    ReferencesWithADLogin referencesWithADLogin;
    References references;
    Archives archives;
    Footer footer;

    public Alerts getAlerts() {
        return alerts;
    }

    public void setAlerts(Alerts alerts) {
        this.alerts = alerts;
    }

    public ReferencesSideMenu getReferencesSideMenu() {
        return referencesSideMenu;
    }

    public void setReferencesSideMenu(ReferencesSideMenu referencesSideMenu) {
        this.referencesSideMenu = referencesSideMenu;
    }

    public ReferencesWithADLogin getReferencesWithADLogin() {
        return referencesWithADLogin;
    }

    public void setReferencesWithADLogin(ReferencesWithADLogin referencesWithADLogin) {
        this.referencesWithADLogin = referencesWithADLogin;
    }

    public References getReferences() {
        return references;
    }

    public void setReferences(References references) {
        this.references = references;
    }

    public Footer getFooter() {
        return footer;
    }

    public void setFooter(Footer footer) {
        this.footer = footer;
    }

    public Archives getArchives() {
        return archives;
    }

    public void setArchives(Archives archives) {
        this.archives = archives;
    }

    @Override
    public String toString() {
        return "ReferenceTemplate{" +
                "alerts=" + alerts +
                ", referencesSideMenu=" + referencesSideMenu +
                ", referencesWithADLogin=" + referencesWithADLogin +
                ", references=" + references +
                ", archives=" + archives +
                ", footer=" + footer +
                '}';
    }
}
