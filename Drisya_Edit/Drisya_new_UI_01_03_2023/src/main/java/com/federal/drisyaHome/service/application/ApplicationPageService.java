package com.federal.drisyaHome.service.application;

import com.fasterxml.jackson.databind.JsonNode;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.federal.drisyaHome.Logger;
import com.federal.drisyaHome.dao.RedisDao;
import com.federal.drisyaHome.dao.application.ApplicationSideMenuDao;
import com.federal.drisyaHome.dao.application.ApplicationWithADLoginDao;
import com.federal.drisyaHome.dao.application.ApplicationsDao;
import com.federal.drisyaHome.dao.application.MoneyTransferDao;
import com.federal.drisyaHome.dao.common.AlertsDao;
import com.federal.drisyaHome.dao.common.FooterDao;
import com.federal.drisyaHome.dao.application.ExternalLinkDao;
import com.federal.drisyaHome.dao.common.LogDataDao;
import com.federal.drisyaHome.dao.home.HomeDao;
import com.federal.drisyaHome.model.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.federal.drisyaHome.Constants.*;


@Service
public class ApplicationPageService {
    @Autowired
    ApplicationSideMenuDao applicationSideMenuDao;
    @Autowired
    ExternalLinkDao externalLinkDao;
    @Autowired
    MoneyTransferDao moneyTransferDao;
    @Autowired
    AlertsDao alertsDao;
    @Autowired
    ApplicationWithADLoginDao applicationWithADLoginDao;
    @Autowired
    ApplicationsDao applicationsDao;
    @Autowired
    FooterDao footerDao;
    @Autowired
    HomeDao homeDao;
    @Autowired
    RedisDao redisDao;
    @Autowired
    LogDataDao logDataDao;

    @Transactional
    public ResponseModel fetchApplicationPage() {

        List<DrisyaTable> drisyaTable = homeDao.fetchHomepage();
        if (drisyaTable.size() == 0) {


            //commonStructure initiallisation which will be used by ExternalLink,MoneyTransfer,Footer
            ApplicationSideMenuData applicationSideMenuData = new ApplicationSideMenuData();
            applicationSideMenuData.setText("");
            applicationSideMenuData.setUrl("");
            //This arrayList is used for assigning setData fields containing text,url
            ArrayList commonStructure = new ArrayList();
            commonStructure.add(applicationSideMenuData);


            ApplicationSideMenu applicationSideMenu = new ApplicationSideMenu();
            applicationSideMenu.setData(commonStructure);


            //ExternalLink data initiallisation
            ExternalLink externalLink = new ExternalLink();
            List<ExternalLinkData> dataList=new ArrayList<>();
            ExternalLinkData extData=new ExternalLinkData();
            externalLink.setTitle("External Link");
            extData.setFlag(false);
            extData.setUrl("");
            extData.setText("");
            dataList.add(extData);
            externalLink.setData(dataList);


            //MoneyTransfer data initiallisation
            MoneyTransfer moneyTransfer = new MoneyTransfer();
            moneyTransfer.setTitle("MoneyTransfer");
            moneyTransfer.setData(commonStructure);


            //Footer data initiallisation
            SectionData sectionData = new SectionData();
            sectionData.setTitle("");
            sectionData.setMenu(commonStructure);
            ArrayList sectionDataList = new ArrayList();
            sectionDataList.add(sectionData);
            Footer footer = new Footer();
            footer.setSectionData(sectionDataList);


            //applicationsStructure initiallisation for both With and WithoutAD login Sections
            ApplicationsData applicationsData = new ApplicationsData();
            applicationsData.setText("");
            applicationsData.setUrl("");
            applicationsData.setFlag(false);
            //This arrayList is used for assigning setData  fields containing text,url,flag
            ArrayList applicationsStructure = new ArrayList();
            applicationsStructure.add(applicationsData);


            //Application WithoutAD Login Data Initiallisation
            Applications applications = new Applications();
            applications.setData(applicationsStructure);


            //Application WithAD Login Data Initiallisation
            ApplicationsWithADLogin applicationsWithADLogin = new ApplicationsWithADLogin();
            applicationsWithADLogin.setData(applicationsStructure);


            //Alerts Data Initiallisation
            AlertsData alertsData = new AlertsData();
            alertsData.setAlert("");
            ArrayList alertsList = new ArrayList();
            alertsList.add(alertsData);
            Alerts alerts = new Alerts();
            alerts.setAlerts(alertsList);


            //Return data assignation
            ResponseModel responseModel = new ResponseModel();
            responseModel.setAlerts(alerts);
            responseModel.setApplicationSideMenu(applicationSideMenu);
            responseModel.setApplications(applications);
            responseModel.setApplicationsWithADLogin(applicationsWithADLogin);
            responseModel.setExternalLink(externalLink);
            responseModel.setMoneyTransfer(moneyTransfer);
            responseModel.setFooter(footer);
            return responseModel;
        } else {
            ResponseModel model = new ResponseModel();
            boolean applicationSideMenuFlag = false;
            boolean externalLinkFlag = false;
            boolean applicationWithADFlag = false;
            boolean applicationWithoutADFlag = false;
            boolean alertsFlag = false;
            boolean moneyTransferFlag = false;
            boolean footerFlag = false;
            for (int i = 0; i < drisyaTable.size(); i++) {
            	if(drisyaTable.get(i).getId()==2) {
            		
            	}else {
                String row_data = drisyaTable.get(i).getSectionData();
                ObjectMapper mapper = new ObjectMapper();
                switch (drisyaTable.get(i).getSection()) {
                    case APPLICATION_SIDEMENU:
                        try {
                            ApplicationSideMenu applicationSideMenu = mapper.readValue(row_data, ApplicationSideMenu.class);
                            model.setApplicationSideMenu(applicationSideMenu);
                            applicationSideMenuFlag = true;
                        } catch (Exception e) {
                            Logger.logger.error("Exception Occured on" + e.getStackTrace());
                        }
                        break;
                    case APPLICATION_EXTERNAL_LINK:
                        try {
                            ExternalLink externalLinks = mapper.readValue(row_data, ExternalLink.class);
                            model.setExternalLink(externalLinks);
                            externalLinkFlag = true;
                        } catch (Exception e) {
                            Logger.logger.error("Exception Occured on" + e.getStackTrace());
                        }
                        break;
                    case APPLICATION_MONEY_TRANSFER:
                        try {
                            MoneyTransfer moneyTransfer = mapper.readValue(row_data, MoneyTransfer.class);
                            model.setMoneyTransfer(moneyTransfer);
                            moneyTransferFlag = true;
                        } catch (Exception e) {
                            Logger.logger.error("Exception Occured on" + e.getStackTrace());
                        }
                        break;
                    case APPLICATIONS_WITH_AD_LOGIN:
                        try {
                            ApplicationsWithADLogin applicationsWithADLogin = mapper.readValue(row_data, ApplicationsWithADLogin.class);
                            model.setApplicationsWithADLogin(applicationsWithADLogin);
                            applicationWithADFlag = true;
                        } catch (Exception e) {
                            Logger.logger.error("Exception Occured on" + e.getStackTrace());
                        }
                        break;
                    case APPLICATIONS_WITHOUT_AD:
                        try {
                            Applications applicationsWithoutAd = mapper.readValue(row_data, Applications.class);
                            model.setApplications(applicationsWithoutAd);
                            applicationWithoutADFlag = true;
                        } catch (Exception e) {
                            Logger.logger.error("Exception Occured on" + e.getStackTrace());
                        }
                        break;
                    case ALERTS:
                        try {
                            Alerts alerts = mapper.readValue(row_data, Alerts.class);
                            model.setAlerts(alerts);
                            alertsFlag = true;
                        } catch (Exception e) {
                            Logger.logger.error("Exception Occured on" + e.getStackTrace());
                        }
                        break;
                    case FOOTER:
                        try {
                            Footer footer = mapper.readValue(row_data, Footer.class);
                            model.setFooter(footer);
                            footerFlag = true;
                        } catch (Exception e) {
                            Logger.logger.error("Exception Occured on" + e.getStackTrace());
                        }
                        break;
                }
            }
            }

            if (!applicationSideMenuFlag) {
                ApplicationSideMenuData applicationSideMenuData = new ApplicationSideMenuData();
                applicationSideMenuData.setText("");
                applicationSideMenuData.setUrl("");
                //This arrayList is used for assigning setData fields containing text,url
                ArrayList commonStructure = new ArrayList();
                commonStructure.add(applicationSideMenuData);
                ApplicationSideMenu applicationSideMenu = new ApplicationSideMenu();
                applicationSideMenu.setData(commonStructure);
                model.setApplicationSideMenu(applicationSideMenu);
            }
            if (!applicationWithADFlag) {
                ApplicationsWithADLogin applicationsWithADLogin = new ApplicationsWithADLogin();
                ApplicationsWithADLoginData applicationsWithADLoginData = new ApplicationsWithADLoginData();
                applicationsWithADLoginData.setFlag(false);
                applicationsWithADLoginData.setText("");
                applicationsWithADLoginData.setUrl("");
                ArrayList applicationsStructure = new ArrayList();
                applicationsStructure.add(applicationsWithADLoginData);
                applicationsWithADLogin.setData(applicationsStructure);
                model.setApplicationsWithADLogin(applicationsWithADLogin);
            }
            if (!externalLinkFlag) {
                ExternalLink externalLink = new ExternalLink();
                externalLink.setTitle("External Link");
                ExternalLinkData externalLinkData = new ExternalLinkData();
                externalLinkData.setText("");
                externalLinkData.setUrl("");
                externalLinkData.setFlag(false);
                ArrayList commonStructure = new ArrayList();
                commonStructure.add(externalLinkData);
                externalLink.setData(commonStructure);
                model.setExternalLink(externalLink);
            }
            if (!applicationWithoutADFlag) {
                ApplicationsData applicationsData = new ApplicationsData();
                applicationsData.setText("");
                applicationsData.setUrl("");
                applicationsData.setFlag(false);
                //This arrayList is used for assigning setData  fields containing text,url,flag
                ArrayList applicationsStructure = new ArrayList();
                applicationsStructure.add(applicationsData);
                Applications applications = new Applications();
                applications.setData(applicationsStructure);
                model.setApplications(applications);
            }
            if (!moneyTransferFlag) {
                MoneyTransfer moneyTransfer = new MoneyTransfer();
                moneyTransfer.setTitle("MoneyTransfer");
                MoneyTransferData moneyTransferData = new MoneyTransferData();
                moneyTransferData.setText("");
                moneyTransferData.setUrl("");
                ArrayList commonStructure = new ArrayList();
                commonStructure.add(moneyTransferData);
                moneyTransfer.setData(commonStructure);
                model.setMoneyTransfer(moneyTransfer);
            }
            if (!footerFlag) {
                ArrayList commonStructure = new ArrayList();
                SectionData sectionData = new SectionData();
                sectionData.setTitle("");
                MenuData menuData = new MenuData();
                menuData.setUrl("");
                menuData.setText("");
                commonStructure.add(menuData);
                sectionData.setMenu(commonStructure);
                ArrayList sectionDataList = new ArrayList();
                sectionDataList.add(sectionData);
                Footer footer = new Footer();
                footer.setSectionData(sectionDataList);
                model.setFooter(footer);
            }
            if (!alertsFlag) {
                AlertsData alertsData = new AlertsData();
                alertsData.setAlert("");
                ArrayList alertsList = new ArrayList();
                alertsList.add(alertsData);
                Alerts alerts = new Alerts();
                alerts.setAlerts(alertsList);
                model.setAlerts(alerts);
            }
            return model;
        }

    }

    @Transactional
    public String applicationPublish(ResponseModel template) {
        JSONParser parser = new JSONParser();

        ObjectMapper mapper = new ObjectMapper();

        try {

//            /* Alerts */
//            JSONObject alertsJson = (JSONObject) parser.parse(String.valueOf(alertsDao.getNotification()));
//            JSONObject templateAlertsJson = (JSONObject) parser.parse(template.getAlerts().toString());
//            JsonNode alertsJsonNode = mapper.readTree(alertsJson.toString());
//            JsonNode templateAlertsJsonNode = mapper.readTree(templateAlertsJson.toString());
//            if (!alertsJsonNode.equals(templateAlertsJsonNode)) {
//                alertsDao.setNotification(template.getAlerts());
//                logDataDao.saveLogData("Admin", "Admin", "IT", "Application", "Alerts", templateAlertsJson.toString());
//            }

            /* SideMenu */

            JSONObject applicationSidemenuJson = (JSONObject) parser.parse(String.valueOf(applicationSideMenuDao.getApplicationSideMenu()));
            JSONObject templateApplicationSidemenuJson = (JSONObject) parser.parse(template.getApplicationSideMenu().toString());
            JsonNode sidemenuJsonNode = mapper.readTree(applicationSidemenuJson.toString());
            JsonNode templateSideMenuJsonNode = mapper.readTree(templateApplicationSidemenuJson.toString());
            if (!sidemenuJsonNode.equals(templateSideMenuJsonNode)) {
                applicationSideMenuDao.setApplicationSideMenu(template.getApplicationSideMenu());
                logDataDao.saveLogData("Admin", "Admin", "IT", "Application", "SideMenu", templateApplicationSidemenuJson.toString());
            }


            /* External Links */

            JSONObject externalLinksJson = (JSONObject) parser.parse(String.valueOf(externalLinkDao.getExternalLink()));
            JSONObject templateexternalLinksJson = (JSONObject) parser.parse(template.getExternalLink().toString());
            JsonNode externalLinksJsonNode = mapper.readTree(externalLinksJson.toString());
            JsonNode templateexternalLinksJsonNode = mapper.readTree(templateexternalLinksJson.toString());
            if (!externalLinksJsonNode.equals(templateexternalLinksJsonNode)) {
                externalLinkDao.setExternalLink(template.getExternalLink());
                logDataDao.saveLogData("Admin", "Admin", "IT", "Application", "External Links", templateexternalLinksJson.toString());
            }

            /* Money Transfer*/

            JSONObject moneyTransferJson = (JSONObject) parser.parse(String.valueOf(moneyTransferDao.getMoneyTransfer()));
            JSONObject templateMoneyTransferJson = (JSONObject) parser.parse(template.getMoneyTransfer().toString());
            JsonNode moneyTransferJsonNode = mapper.readTree(moneyTransferJson.toString());
            JsonNode templateMoneyTransferJsonNode = mapper.readTree(templateMoneyTransferJson.toString());
            if (!moneyTransferJsonNode.equals(templateMoneyTransferJsonNode)) {
                moneyTransferDao.setMoneyTransfer(template.getMoneyTransfer());
                logDataDao.saveLogData("Admin", "Admin", "IT", "Application", "Money Transfer", templateMoneyTransferJson.toString());
            }
            /* Application without AD*/

            JSONObject applicationWithoutADJson = (JSONObject) parser.parse(String.valueOf(applicationsDao.getApplications()));
            JSONObject templateApplicationWithoutADJson = (JSONObject) parser.parse(template.getApplications().toString());
            JsonNode applicationWithoutADJsonNode = mapper.readTree(applicationWithoutADJson.toString());
            JsonNode templateApplicationWithoutADJsonNode = mapper.readTree(templateApplicationWithoutADJson.toString());
            if (!applicationWithoutADJsonNode.equals(templateApplicationWithoutADJsonNode)) {
            	//sorting
            	Collections.sort(template.getApplications().getData(),Comparator.comparing(ApplicationsData::getText));
				Collections.reverse(template.getApplications().getData());
                applicationsDao.setApplication(template.getApplications());
                logDataDao.saveLogData("Admin", "Admin", "IT", "Application", "Application without", templateApplicationWithoutADJson.toString());
            }
            /* Application with AD*/

            JSONObject applicationWithADJson = (JSONObject) parser.parse(String.valueOf(applicationWithADLoginDao.getApplications()));
            JSONObject templateApplicationWithADJson = (JSONObject) parser.parse(template.getApplicationsWithADLogin().toString());
            JsonNode applicationWithADJsonNode = mapper.readTree(applicationWithADJson.toString());
            JsonNode templateApplicationWithADJsonNode = mapper.readTree(templateApplicationWithADJson.toString());
            if (!applicationWithADJsonNode.equals(templateApplicationWithADJsonNode)) {
            	//sorting
            	Collections.sort(template.getApplicationsWithADLogin().getData(),Comparator.comparing(ApplicationsWithADLoginData::getText));
            	Collections.reverse(template.getApplicationsWithADLogin().getData());
                applicationWithADLoginDao.setApplication(template.getApplicationsWithADLogin());
                logDataDao.saveLogData("Admin", "Admin", "IT", "Application", "Application with AD", templateApplicationWithADJson.toString());
            }
            redisDao.addDataToRedis();
        } catch (Exception e) {
            Logger.logger.error("Exception Occured on" + e.getStackTrace());
        }
        return "published";
    }
}