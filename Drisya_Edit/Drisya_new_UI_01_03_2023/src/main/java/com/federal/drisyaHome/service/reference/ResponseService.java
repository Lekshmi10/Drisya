package com.federal.drisyaHome.service.reference;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.federal.drisyaHome.Logger;
import com.federal.drisyaHome.dao.RedisDao;
import com.federal.drisyaHome.dao.common.AlertsDao;
import com.federal.drisyaHome.dao.common.FooterDao;
import com.federal.drisyaHome.dao.common.LogDataDao;
import com.federal.drisyaHome.dao.home.HomeDao;
import com.federal.drisyaHome.dao.reference.ArchivesDao;
import com.federal.drisyaHome.dao.reference.ReferencesDao;
import com.federal.drisyaHome.dao.reference.ReferencesSideMenuDao;
import com.federal.drisyaHome.dao.reference.ReferencesWithADLoginDao;
import com.federal.drisyaHome.model.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.federal.drisyaHome.Constants.*;


@Service
public class ResponseService {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    AlertsDao alertsDao;
    @Autowired
    ReferencesSideMenuDao referencesSideMenuDao;
    @Autowired
    ReferencesDao referencesDao;
    @Autowired
    ReferencesWithADLoginDao referencesWithADLoginDao;
    @Autowired
    ArchivesDao archivesDao;
    @Autowired
    FooterDao footerDao;
    @Autowired
    RedisDao redisDao;
    @Autowired
    HomeDao homeDao;
    @Autowired
    LogDataDao logDataDao;

    public ReferenceTemplate fetchHomePage() {
        List<DrisyaTable> drisyaTable = homeDao.fetchHomepage();
        if (drisyaTable.size() == 0) {

            ArrayList commonList = new ArrayList();
            //reference
            ReferencesSideMenuData referencesSideMenuData = new ReferencesSideMenuData();
            referencesSideMenuData.setText("");
            referencesSideMenuData.setUrl("");
            commonList.add(referencesSideMenuData);
            ReferencesSideMenu referencesSideMenu = new ReferencesSideMenu();
            referencesSideMenu.setData(commonList);
            //ReferencesWithADLogin
            ReferencesWithADLogin referencesWithADLogin = new ReferencesWithADLogin();
            referencesWithADLogin.setData(commonList);
            //References
            References references = new References();
            references.setData(commonList);
            //ArchivesSection
            ArchivesSection archivesSection = new ArchivesSection();
            archivesSection.setSection(commonList);
            ArrayList archivesList = new ArrayList();
            archivesList.add(archivesSection);
            Archives archives = new Archives();
            archives.setArchives(archivesList);
            //Alerts
            AlertsData alertsData = new AlertsData();
            alertsData.setAlert("");
            ArrayList alertsList = new ArrayList();
            alertsList.add(alertsData);
            Alerts alerts = new Alerts();
            alerts.setAlerts(alertsList);
            //Footer
            SectionData sectionData = new SectionData();
            sectionData.setTitle("");
            sectionData.setMenu(commonList);
            ArrayList sectionDataList = new ArrayList();
            sectionDataList.add(sectionData);
            Footer footer = new Footer();
            footer.setSectionData(sectionDataList);

            ReferenceTemplate referenceTemplate = new ReferenceTemplate();
            referenceTemplate.setAlerts(alerts);
            referenceTemplate.setArchives(archives);
            referenceTemplate.setReferences(references);
            referenceTemplate.setReferencesSideMenu(referencesSideMenu);
            referenceTemplate.setReferencesWithADLogin(referencesWithADLogin);
            referenceTemplate.setFooter(footer);
            System.out.println(referenceTemplate);
            return referenceTemplate;
        } else {
            ReferenceTemplate referenceTemplate = new ReferenceTemplate();
            boolean referenceSideMenuFlag = false;
            boolean referenceWithADFlag = false;
            boolean referenceWithoutADFlag = false;
            boolean footerFlag = false;
            boolean alertFlag = false;
            boolean archivesFlag = false;
            for (int i = 0; i < drisyaTable.size(); i++) {
            	if(drisyaTable.get(i).getId()==2) {
            		
            	}else {
                String row_data = drisyaTable.get(i).getSectionData();
                ObjectMapper mapper = new ObjectMapper();
                switch (drisyaTable.get(i).getSection()) {
                    case REFERENCE_SIDEMENU:
                        try {
                            ReferencesSideMenu referencesSideMenu = mapper.readValue(row_data, ReferencesSideMenu.class);
                            referenceTemplate.setReferencesSideMenu(referencesSideMenu);
                            referenceSideMenuFlag = true;
                        } catch (Exception e) {
                            Logger.logger.error("Exception Occured on" + e.getStackTrace());
                        }
                        break;
                    case REFERENCES_WITH_ADLOGIN:
                        try {
                            ReferencesWithADLogin referencesWithADLogin = mapper.readValue(row_data, ReferencesWithADLogin.class);
                            referenceTemplate.setReferencesWithADLogin(referencesWithADLogin);
                            referenceWithADFlag = true;
                        } catch (Exception e) {
                            Logger.logger.error("Exception Occured on" + e.getStackTrace());
                        }
                        break;
                    case REFERENCES_WITHOUT_ADLOGIN:
                        try {
                            References referencesWithoutAd = mapper.readValue(row_data, References.class);
                            referenceTemplate.setReferences(referencesWithoutAd);
                            referenceWithoutADFlag = true;
                        } catch (Exception e) {
                            Logger.logger.error("Exception Occured on" + e.getStackTrace());
                        }
                        break;
                    case REFERENCE_ARCHIVES:
                        try {
                            Archives archives = mapper.readValue(row_data, Archives.class);
                            referenceTemplate.setArchives(archives);
                            archivesFlag = true;
                        } catch (Exception e) {
                            Logger.logger.error("Exception Occured on" + e.getStackTrace());
                        }
                        break;
                    case ALERTS:
                        try {
                            Alerts alerts = mapper.readValue(row_data, Alerts.class);
                            referenceTemplate.setAlerts(alerts);
                            alertFlag = true;
                        } catch (Exception e) {
                            Logger.logger.error("Exception Occured on" + e.getStackTrace());
                        }
                        break;
                    case FOOTER:
                        try {
                            Footer footer = mapper.readValue(row_data, Footer.class);
                            referenceTemplate.setFooter(footer);
                            footerFlag = true;
                        } catch (Exception e) {
                            Logger.logger.error("Exception Occured on" + e.getStackTrace());
                        }
                        break;
                }
            }
            }
            if (!referenceSideMenuFlag) {
                ArrayList commonList = new ArrayList();
                ReferencesSideMenuData referencesSideMenuData = new ReferencesSideMenuData();
                referencesSideMenuData.setText("");
                referencesSideMenuData.setUrl("");
                commonList.add(referencesSideMenuData);
                ReferencesSideMenu referencesSideMenu = new ReferencesSideMenu();
                referencesSideMenu.setData(commonList);
                referenceTemplate.setReferencesSideMenu(referencesSideMenu);
            }
            if (!referenceWithADFlag) {
                ArrayList commonList = new ArrayList();
                ReferencesWithADLogin referencesWithADLogin = new ReferencesWithADLogin();
                ReferencesWithADLoginData referencesWithADLoginData = new ReferencesWithADLoginData();
                referencesWithADLoginData.setText("");
                referencesWithADLoginData.setUrl("");
                commonList.add(referencesWithADLoginData);
                referencesWithADLogin.setData(commonList);
                referenceTemplate.setReferencesWithADLogin(referencesWithADLogin);
            }
            if (!referenceWithoutADFlag) {
                ArrayList commonList = new ArrayList();
                References references = new References();
                ReferencesData referencesData = new ReferencesData();
                referencesData.setText("");
                referencesData.setUrl("");
                commonList.add(referencesData);
                references.setData(commonList);
                referenceTemplate.setReferences(references);
            }
            if (!footerFlag) {
                ArrayList commonList = new ArrayList();
                SectionData sectionData = new SectionData();
                sectionData.setTitle("");
                MenuData menuData = new MenuData();
                menuData.setUrl("");
                menuData.setText("");
                commonList.add(menuData);
                sectionData.setMenu(commonList);
                ArrayList sectionDataList = new ArrayList();
                sectionDataList.add(sectionData);
                Footer footer = new Footer();
                footer.setSectionData(sectionDataList);
                referenceTemplate.setFooter(footer);
            }
            if (!alertFlag) {
                AlertsData alertsData = new AlertsData();
                alertsData.setAlert("");
                ArrayList alertsList = new ArrayList();
                alertsList.add(alertsData);
                Alerts alerts = new Alerts();
                alerts.setAlerts(alertsList);
                referenceTemplate.setAlerts(alerts);
            }
            if (!archivesFlag) {
                ArrayList commonList = new ArrayList();
                ArchivesData archivesData = new ArchivesData();
                ArchivesSection archivesSection = new ArchivesSection();
                archivesData.setUrl("");
                archivesData.setText("");
                commonList.add(archivesData);
                archivesSection.setSection(commonList);
                ArrayList archivesList = new ArrayList();
                archivesList.add(archivesSection);
                Archives archives = new Archives();
                archives.setArchives(archivesList);
                referenceTemplate.setArchives(archives);
            }
            System.out.println(referenceTemplate.toString());
            return referenceTemplate;
        }
    }

    @Transactional
    public String publishReferences(ReferenceTemplate template) throws IOException {

        JSONParser parser = new JSONParser();
        ObjectMapper mapper = new ObjectMapper();
        try {

            /* Alerts */
//            JSONObject alertsJson = (JSONObject) parser.parse(String.valueOf(alertsDao.getNotification()));
//            JSONObject templateAlertsJson = (JSONObject) parser.parse(template.getAlerts().toString());
//            JsonNode alertsJsonNode = mapper.readTree(alertsJson.toString());
//            JsonNode templateAlertsJsonNode = mapper.readTree(templateAlertsJson.toString());
//            if (!alertsJsonNode.equals(templateAlertsJsonNode)) {
//                alertsDao.setNotification(template.getAlerts());
//                logDataDao.saveLogData("Admin", "Admin", "IT", "Reference", "Alerts", templateAlertsJson.toString());
//            }

            /* SideMenu */

            JSONObject sideMenuJson = (JSONObject) parser.parse(String.valueOf(referencesSideMenuDao.getReferencesSideMenu()));
            JSONObject templatesideMenuJson = (JSONObject) parser.parse(template.getReferencesSideMenu().toString());
            JsonNode sideMenuJsonNode = mapper.readTree(sideMenuJson.toString());
            JsonNode templatetemplatesideMenuJsonNode = mapper.readTree(templatesideMenuJson.toString());
            if (!sideMenuJsonNode.equals(templatetemplatesideMenuJsonNode)) {
                referencesSideMenuDao.setReferencesSideMenu(template.getReferencesSideMenu());
                logDataDao.saveLogData("Admin", "Admin", "IT", "Reference", "SideMenu", templatesideMenuJson.toString());
            }


            /* Reference With AD Logins */

            JSONObject referenceWithAdJson = (JSONObject) parser.parse(String.valueOf(referencesWithADLoginDao.getReferencesAD()));
            JSONObject templatereferenceWithAdJson = (JSONObject) parser.parse(template.getReferencesWithADLogin().toString());
            JsonNode referenceWithAdJsonNode = mapper.readTree(referenceWithAdJson.toString());
            JsonNode templatereferenceWithAdJsonNode = mapper.readTree(templatereferenceWithAdJson.toString());
            if (!referenceWithAdJsonNode.equals(templatereferenceWithAdJsonNode)) {
            	Collections.sort(template.getReferencesWithADLogin().getData(),Comparator.comparing(ReferencesWithADLoginData::getText));
            	Collections.reverse(template.getReferencesWithADLogin().getData());
                referencesWithADLoginDao.setReferencesAD(template.getReferencesWithADLogin());
                logDataDao.saveLogData("Admin", "Admin", "IT", "Reference", "With AD Logins", templatereferenceWithAdJson.toString());
            }


            /* Reference Without AD Logins */

            JSONObject referenceWithoutAdJson = (JSONObject) parser.parse(String.valueOf(referencesDao.getReferences()));
            JSONObject templatereferenceWithoutAdJson = (JSONObject) parser.parse(template.getReferences().toString());
            JsonNode referenceWithoutAdJsonNode = mapper.readTree(referenceWithoutAdJson.toString());
            JsonNode templatereferenceWithoutAdJsonNode = mapper.readTree(templatereferenceWithoutAdJson.toString());
            if (!referenceWithoutAdJsonNode.equals(templatereferenceWithoutAdJsonNode)) {
            	Collections.sort(template.getReferences().getData(),Comparator.comparing(ReferencesData::getText));
            	Collections.reverse(template.getReferences().getData());
                referencesDao.setReferences(template.getReferences());
                logDataDao.saveLogData("Admin", "Admin", "IT", "Reference", "Without AD Logins", templatereferenceWithoutAdJson.toString());
            }


            /* Reference archives */

//            JSONObject referenceArchivesJson = (JSONObject) parser.parse(String.valueOf(archivesDao.getArchives()));
//            JSONObject templatereferenceArchivesJson = (JSONObject) parser.parse(template.getArchives().toString());
//            JsonNode referenceArchivesJsonNode = mapper.readTree(referenceArchivesJson.toString());
//            JsonNode templatereferenceArchivesJsonNode = mapper.readTree(templatereferenceArchivesJson.toString());
//            if (!referenceArchivesJsonNode.equals(templatereferenceArchivesJsonNode)) {
//                archivesDao.setArchives(template.getArchives());
//                logDataDao.saveLogData("Admin", "Admin", "IT", "Reference", "Without AD Logins", templatereferenceArchivesJson.toString());
//            }


        } catch (Exception e) {
            Logger.logger.error("Exception Occured on" + e.getStackTrace());
        }
        redisDao.addDataToRedis();
        return "published";

    }
}
