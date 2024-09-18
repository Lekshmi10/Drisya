package com.federal.drisyaHome.service.support;

import com.fasterxml.jackson.databind.JsonNode;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.federal.drisyaHome.Logger;
import com.federal.drisyaHome.dao.RedisDao;
import com.federal.drisyaHome.dao.common.AlertsDao;
import com.federal.drisyaHome.dao.common.FooterDao;
import com.federal.drisyaHome.dao.common.LogDataDao;
import com.federal.drisyaHome.dao.home.HomeDao;
import com.federal.drisyaHome.dao.support.SupportSideMenuDao;
import com.federal.drisyaHome.dao.support.SupportWithADDao;
import com.federal.drisyaHome.dao.support.SupportWithoutADDao;
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
import static com.federal.drisyaHome.Constants.FOOTER;
import static com.federal.drisyaHome.Constants.SUPPORT_SIDEMENU;


@Service
public class SupportPageService {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    SupportWithADDao supportWithADDao;
    @Autowired
    SupportWithoutADDao supportWithoutADDao;
    @Autowired
    AlertsDao alertsDao;
    @Autowired
    FooterDao footerDao;
    @Autowired
    HomeDao homeDao;
    @Autowired
    RedisDao redisDao;
    @Autowired
    LogDataDao logDataDao;
    @Autowired
    SupportSideMenuDao supportSideMenuDao;

    public SupportModel getSupportPage() {

        List<DrisyaTable> drisyaTable = homeDao.fetchHomepage();

        if (drisyaTable.size() == 0) {

            ArrayList commonStructure = new ArrayList();


            AlertsData alertsData = new AlertsData();
            alertsData.setAlert("");
            ArrayList alertsList = new ArrayList();
            alertsList.add(alertsData);
            Alerts alerts = new Alerts();
            alerts.setAlerts(alertsList);

            SupportWithADData supportWithAdData = new SupportWithADData();
            supportWithAdData.setText("");
            supportWithAdData.setUrl("");

            commonStructure.add(supportWithAdData);
            SupportWithAD supportWithAd = new SupportWithAD();
            supportWithAd.setData(commonStructure);

            SupportWithoutAD supportWithoutAD = new SupportWithoutAD();
            supportWithoutAD.setData(commonStructure);

            SupportSideMenu supportSideMenu=new SupportSideMenu();
            supportSideMenu.setData(commonStructure);

            SectionData sectionData = new SectionData();
            sectionData.setTitle("");
            sectionData.setMenu(commonStructure);
            ArrayList sectionDataList = new ArrayList();
            sectionDataList.add(sectionData);
            Footer footer = new Footer();
            footer.setSectionData(sectionDataList);

            SupportModel supportModel = new SupportModel();
            supportModel.setAlerts(alerts);
            supportModel.setSupportWithAD(supportWithAd);
            supportModel.setSupportWithoutAD(supportWithoutAD);
            supportModel.setFooter(footer);
            supportModel.setSupportSideMenu(supportSideMenu);
            return supportModel;
        } else {

            SupportModel supportModel = new SupportModel();
            boolean withAdFlag = false;
            boolean withoutAdFlag = false;
            boolean alertsFlag = false;
            boolean footerFlag = false;
            boolean sideMenuFlag = false;
            try {
                for (int i = 0; i < drisyaTable.size(); i++) {
                	if(drisyaTable.get(i).getId()==2) {
                		
                	}else {
                    String row_data = drisyaTable.get(i).getSectionData();
                    ObjectMapper mapper = new ObjectMapper();
                    switch (drisyaTable.get(i).getSection()) {
                        case SUPPORT_WITH_AD_LOGIN:
                            SupportWithAD supportWithAD = mapper.readValue(row_data, SupportWithAD.class);
                            supportModel.setSupportWithAD(supportWithAD);
                            withAdFlag = true;
                            break;
                        case SUPPORT_WITHOUT_AD_LOGIN:
                            SupportWithoutAD supportWithoutAD = mapper.readValue(row_data, SupportWithoutAD.class);
                            supportModel.setSupportWithoutAD(supportWithoutAD);
                            withoutAdFlag = true;
                            break;
                        case ALERTS:
                            Alerts alerts = mapper.readValue(row_data, Alerts.class);
                            supportModel.setAlerts(alerts);
                            alertsFlag = true;
                            break;
                        case FOOTER:
                            Footer footer = mapper.readValue(row_data, Footer.class);
                            supportModel.setFooter(footer);
                            footerFlag = true;
                            break;
                        case SUPPORT_SIDEMENU:
                            SupportSideMenu supportSideMenu = mapper.readValue(row_data, SupportSideMenu.class);
                            supportModel.setSupportSideMenu(supportSideMenu);
                            sideMenuFlag = true;
                            break;
                    }
                }
                }
            } catch (Exception e) {
                Logger.logger.error("Exception Occured on" + e.getStackTrace());
            }
            if (!withAdFlag) {
                ArrayList commonStructure = new ArrayList();
                SupportWithADData supportWithAdData = new SupportWithADData();
                supportWithAdData.setText("");
                supportWithAdData.setUrl("");
                commonStructure.add(supportWithAdData);
                SupportWithAD supportWithAd = new SupportWithAD();
                supportWithAd.setData(commonStructure);
                supportModel.setSupportWithAD(supportWithAd);
            }
            if (!withoutAdFlag) {
                ArrayList commonStructure = new ArrayList();
                SupportWithoutAD supportWithoutAD = new SupportWithoutAD();
                SupportWithoutADData supportWithoutADData = new SupportWithoutADData();
                supportWithoutADData.setText("");
                supportWithoutADData.setUrl("");
                commonStructure.add(supportWithoutADData);
                supportWithoutAD.setData(commonStructure);
                supportModel.setSupportWithoutAD(supportWithoutAD);
            }
            if (!sideMenuFlag) {
                ArrayList commonStructure = new ArrayList();
                SupportSideMenu supportSideMenu = new SupportSideMenu();
                SupportSideMenuData supportSideMenuData = new SupportSideMenuData();
                supportSideMenuData.setText("");
                supportSideMenuData.setUrl("");
                commonStructure.add(supportSideMenuData);
                supportSideMenu.setData(commonStructure);
                supportModel.setSupportSideMenu(supportSideMenu);
            }
            if (!alertsFlag) {
                AlertsData alertsData = new AlertsData();
                alertsData.setAlert("");
                ArrayList alertsList = new ArrayList();
                alertsList.add(alertsData);
                Alerts alerts = new Alerts();
                alerts.setAlerts(alertsList);
                supportModel.setAlerts(alerts);
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
                supportModel.setFooter(footer);
            }
            return supportModel;
        }

    }



    @Transactional
    public String publishSupport(SupportModel template) throws IOException {


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
//                logDataDao.saveLogData("Admin", "Admin", "IT", "Support", "Alerts", alertsJson.toString());
//            }

            /* Without AD Login */
            JSONObject withoutAdLoginJson = (JSONObject) parser.parse(String.valueOf(supportWithoutADDao.getSupport()));
            JSONObject templatewithoutAdLoginJson = (JSONObject) parser.parse(template.getSupportWithoutAD().toString());
            JsonNode withoutAdLoginJsonNode = mapper.readTree(withoutAdLoginJson.toString());
            JsonNode templatewithoutAdLoginJsonNode = mapper.readTree(templatewithoutAdLoginJson.toString());
            if (!withoutAdLoginJsonNode.equals(templatewithoutAdLoginJsonNode)) {
            	//sorting
            	Collections.sort(template.getSupportWithoutAD().getData(),Comparator.comparing(SupportWithoutADData::getText));
            	Collections.reverse(template.getSupportWithoutAD().getData());
                supportWithoutADDao.setSupportAD(template.getSupportWithoutAD());
                logDataDao.saveLogData("Admin", "Admin", "IT", "Support", "Without AD Login", withoutAdLoginJson.toString());
            }

            /* With AD Login */
            JSONObject withtAdLoginJson = (JSONObject) parser.parse(String.valueOf(supportWithADDao.getSupportWithAD()));
            JSONObject templatewithAdLoginJson = (JSONObject) parser.parse(template.getSupportWithAD().toString());
            JsonNode withAdLoginJsonNode = mapper.readTree(withtAdLoginJson.toString());
            JsonNode templatewithAdLoginJsonNode = mapper.readTree(templatewithAdLoginJson.toString());
            if (!withAdLoginJsonNode.equals(templatewithAdLoginJsonNode)) {
            	//sorting
            	Collections.sort(template.getSupportWithAD().getData(),Comparator.comparing(SupportWithADData::getText));
            	Collections.reverse(template.getSupportWithAD().getData());
                supportWithADDao.setSupportWithAD(template.getSupportWithAD());
                logDataDao.saveLogData("Admin", "Admin", "IT", "Support", "With AD Login", withtAdLoginJson.toString());
            }
            /* SideMenu */
            JSONObject sideMenuJson = (JSONObject) parser.parse(String.valueOf(supportSideMenuDao.getSupportSideMenu()));
            JSONObject templatesideMenuJson = (JSONObject) parser.parse(template.getSupportSideMenu().toString());
            JsonNode sideMenuJsonNode = mapper.readTree(sideMenuJson.toString());
            JsonNode templatesideMenuJsonNode = mapper.readTree(templatesideMenuJson.toString());
            if (!sideMenuJsonNode.equals(templatesideMenuJsonNode)) {
                supportSideMenuDao.setSupportSideMenu(template.getSupportSideMenu());
                logDataDao.saveLogData("Admin", "Admin", "IT", "Support", "SideMenu", sideMenuJson.toString());
            }

        } catch (Exception e) {
            Logger.logger.error("Exception Occured on" + e.getStackTrace());
        }
        redisDao.addDataToRedis();
        return "published";
    }
}
