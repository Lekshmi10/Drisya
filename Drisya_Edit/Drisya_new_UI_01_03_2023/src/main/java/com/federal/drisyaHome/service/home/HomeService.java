package com.federal.drisyaHome.service.home;

import com.fasterxml.jackson.databind.JsonNode;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.federal.drisyaHome.Logger;
import com.federal.drisyaHome.dao.RedisDao;
import com.federal.drisyaHome.dao.common.LogDataDao;
//import com.federal.drisyaHome.dao.home.BankInfoDao;
import com.federal.drisyaHome.dao.common.AlertsDao;
import com.federal.drisyaHome.dao.common.FooterDao;
import com.federal.drisyaHome.dao.home.*;
import com.federal.drisyaHome.model.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import static com.federal.drisyaHome.Constants.*;


@Service
public class HomeService {
    @Autowired
    SideMenuDao sideMenuDao;
    @Autowired
    AnnouncementDao announcementDao;
    @Autowired
    BlurbDao blurbDao;
    @Autowired
    AlertsDao alertsDao;
    @Autowired
    VideosDao videosDao;
    @Autowired
    ServiceLinksDao serviceLinksDao;
    @Autowired
    NewsAndEventsDao newsAndEventsDao;
    @Autowired
    MiscellaneousDao miscellaneousDao;
    @Autowired
    FooterDao footerDao;
    @Autowired
    ImagesDao imagesDao;
    @Autowired
    RetirementDaoPublish retirementDaoPublish;
//    @Autowired
//    BankInfoDao bankInfoDao;
    @Autowired
    RetirementDao retirementDao;
    @Autowired
    MustReadDao mustreadDao;
    @Autowired
    EmployeeSearchDao employeeSearchDao;
    @Autowired
    CircularsDao circularsDao;
    @Autowired
    RedisDao redisDao;
    @Autowired
    HomeDao homeDao;
    @Autowired
    LogDataDao logDataDao;
    @Autowired
    MusicDao musicDao;

    public HomeTemplate fetchHomepage() throws IOException {
        List<DrisyaTable> drisyaTable = homeDao.fetchHomepage();

        if (drisyaTable.size() == 0) {

            // This arrayList is used for Initiallising array containing text,url
            ArrayList commonList = new ArrayList();

            //The common arraylist is initiallised using sidemenuData class
            SideMenuData sideMenuData = new SideMenuData();
            sideMenuData.setText("");
            sideMenuData.setURL("");
            commonList.add(sideMenuData);

            //SideMenu Initiallisation
            SideMenu sideMenu = new SideMenu();
            sideMenu.setData(commonList);

            //ServiceLinks Initiallisation
            ArrayList serviceLinksList = new ArrayList();
            for (int i =0; i <= 6; i++) {
                serviceLinksList.add(sideMenuData);
            }
            ServiceLinks serviceLinks = new ServiceLinks();
            serviceLinks.setTitle("");
            serviceLinks.setData(serviceLinksList);


            //Footer Initiallisation
            SectionData sectionData = new SectionData();
            sectionData.setTitle("");
            sectionData.setMenu(commonList);
            ArrayList sectionDataList = new ArrayList();
            sectionDataList.add(sectionData);
            Footer footer = new Footer();
            footer.setSectionData(sectionDataList);

            //Announcements Initiallisation
            AnnouncementData announcementData = new AnnouncementData();
            announcementData.setHeadline("");
            announcementData.setDescription("");
            announcementData.setAuthor("");
            announcementData.setEmployeeId("");
            announcementData.setDepartment("");
            announcementData.setUrl("");
            announcementData.setPublishedDate("");
            announcementData.setId("");
       
            
            // This arrayList is used for initiallising Announcements and Circulars.Because both having common structure
            ArrayList announceCircularList = new ArrayList();
            announceCircularList.add(announcementData);
            Announcements announcements = new Announcements();
            announcements.setTitle("Announcements");
            announcements.setData(announceCircularList);

            //Circulars Initiallisation
            Circulars circulars = new Circulars();
            circulars.setTitle("Circulars");
            circulars.setData(announceCircularList);
            
            //EmployeeSearch Initiallisation
            EmployeeSearch employeeSearch = new EmployeeSearch();
            employeeSearch.setUrl("");


            //Images Initiallisation
            ImagesData imagesData = new ImagesData();
            imagesData.setUrl("");
            imagesData.setImage("");
            ArrayList imageList=new ArrayList();
            imageList.add(imagesData);
            Images images = new Images();
            images.setData(imageList);


            //Videos Initiallisation
            VideosData videosData = new VideosData();
            videosData.setTitle("");
            videosData.setThumbnail("");
            videosData.setUrl("");
            ArrayList videosList=new ArrayList();
            videosList.add(videosData);
            Videos videos = new Videos();
            videos.setData(videosList);


            //Blurb Initiallisation
            BlurbData blurbData = new BlurbData();
            blurbData.setUrl("");
            blurbData.setThumbnail("");
            ArrayList blurbList=new ArrayList();
            blurbList.add(blurbData);
            Blurb blurb = new Blurb();
            blurb.setData(blurbList);


            //Retirement Initiallisation
            RetirementData retirementData = new RetirementData();
            retirementData.setDepartment("");
            retirementData.setPfNumber("");
            retirementData.setImage("");
            retirementData.setName("");
          //  retirementData.setUrl("");
            ArrayList retirementList=new ArrayList();
            retirementList.add(retirementData);
            Retirement retirement = new Retirement();
            retirement.setData(retirementList);

            ArrayList mustreadList=new ArrayList();
           
            MustReadData mustreadData=new MustReadData();
            mustreadData.setText("");
            mustreadData.setUrl("");
            mustreadList.add(mustreadData);
            
            MustRead mustRead=new MustRead();
            mustRead.setTitle("Must Read");
            mustRead.setData(mustreadList);
            //System.out.println(mustRead.toString());
           

            
            //BankInfo Initiallisation
            BankInfo bankInfo = new BankInfo();
            bankInfo.setAtms("");
            bankInfo.setCdm("");
            bankInfo.setBranches("");
            bankInfo.setCustomers("");


            //Miscellaneous Initiallisation
            MiscellaneousData miscellaneousData = new MiscellaneousData();
            miscellaneousData.setColor("");
            miscellaneousData.setContent("");
            miscellaneousData.setImage("");
            miscellaneousData.setUrl("");
            ArrayList miscellaneousList = new ArrayList();
            miscellaneousList.add(miscellaneousData);
            Miscellaneous miscellaneous = new Miscellaneous();
            miscellaneous.setData(miscellaneousList);


            // NewsAndEvents
            NewsAndEventsData newsAndEventsData = new NewsAndEventsData();
            newsAndEventsData.setDate("");
            newsAndEventsData.setImage("");
            newsAndEventsData.setLocation("");
            newsAndEventsData.setText("");
            newsAndEventsData.setTime("");
            newsAndEventsData.setTitle("");
            ArrayList newsList = new ArrayList();
            newsList.add(newsAndEventsData);
            NewsAndEvents newsAndEvents = new NewsAndEvents();
            newsAndEvents.setTitle("News And Events");
            newsAndEvents.setData(newsList);


            //Alerts Initiallisation
            AlertsData alertsData = new AlertsData();
            alertsData.setAlert("");
            ArrayList alertsList = new ArrayList();
            alertsList.add(alertsData);
            Alerts alerts = new Alerts();
            alerts.setAlerts(alertsList);
            Music music=new Music();
            music.setAudioText("");

            HomeTemplate homeTemplate = new HomeTemplate();

            homeTemplate.setSideMenu(sideMenu);
            homeTemplate.setAlerts(alerts);
            homeTemplate.setEmployeeSearch(employeeSearch);
            homeTemplate.setImages(images);
            homeTemplate.setVideos(videos);
            homeTemplate.setBlurb(blurb);
            homeTemplate.setNewAnnouncements(announcementDao.getAnnouncementsData());
            homeTemplate.setRetirement(retirement);
            homeTemplate.setMustRead(mustRead);
            homeTemplate.setCirculars(circulars);
          //  homeTemplate.setBankInfo(bankInfo);
            homeTemplate.setNewsAndEvents(newsAndEvents);
            homeTemplate.setServiceLinks(serviceLinks);
            homeTemplate.setMiscellaneous(miscellaneous);
            homeTemplate.setFooter(footer);
            homeTemplate.setMusic(music);
            return homeTemplate;
        } else {
            HomeTemplate template = new HomeTemplate();
            try {

                // This arrayList is used for Initiallising array containing text,url
                ArrayList commonList = new ArrayList();
                SideMenuData sideMenuData = new SideMenuData();
                sideMenuData.setText("");
                sideMenuData.setURL("");
                commonList.add(sideMenuData);

                AnnouncementData announcementData = new AnnouncementData();
                announcementData.setHeadline("");
                announcementData.setDescription("");
                announcementData.setAuthor("");
                announcementData.setEmployeeId("");
                announcementData.setDepartment("");
                announcementData.setUrl("");
                announcementData.setPublishedDate("");
                announcementData.setId("");
                // This arrayList is used for initiallising Announcements and Circulars.Because both having common structure
                ArrayList announceCircularList = new ArrayList();
                announceCircularList.add(announcementData);


                Boolean homeSideMenuFlag = false;
                Boolean searchFlag = false;
                Boolean alertsFlag = false;
                Boolean imagesFlag = false;
                Boolean videosFlag = false;
                Boolean blurbFlag = false;
                Boolean announcementsFlag = false;
                Boolean retirementsFlag = false;
                Boolean mustreadFlag = false;
                Boolean circularsFlag = false;
                Boolean bankInfoFlag = false;
                Boolean newsAndEventsFlag = false;
                Boolean serviceLinksFlag = false;
                Boolean miscellaneousFlag = false;
                Boolean footerFlag = false;
                Boolean musicFlag=false;


                for (int i = 0; i < drisyaTable.size(); i++) {
                	
                	
//                	if(drisyaTable.get(i).getId()==2) {
//                		
//                	}else {
                	    String row_data = drisyaTable.get(i).getSectionData();
                        ObjectMapper mapper = new ObjectMapper();
                        switch (drisyaTable.get(i).getSection()) {
                            case HOME_SIDEMENU:
                                SideMenu sideMenu = mapper.readValue(row_data, SideMenu.class);
                                template.setSideMenu(sideMenu);
                                homeSideMenuFlag = true;
                                break;
                            case HOME_ANNOUNCEMENTS:
                                NewAnnouncements announcements = mapper.readValue(row_data, NewAnnouncements.class);
                                template.setNewAnnouncements(announcements);
                            	 break;
                            case HOME_EMPLOYEE_SEARCH:
                                EmployeeSearch employeeSearch = mapper.readValue(row_data, EmployeeSearch.class);
                                template.setEmployeeSearch(employeeSearch);
                                searchFlag = true;
                                break;
                            case HOME_IMAGES:
                                Images images = mapper.readValue(row_data, Images.class);
                                template.setImages(images);
                                imagesFlag = true;
                                break;
                            case HOME_VIDEOS:
                                Videos videos = mapper.readValue(row_data, Videos.class);
                                template.setVideos(videos);
                                videosFlag = true;
                                break;
                            case HOME_BLURBS:
                                Blurb blurbs = mapper.readValue(row_data, Blurb.class);
                                template.setBlurb(blurbs);
                                blurbFlag = true;
                                break;
                            case HOME_RETIREMENT:
                                try {
                                  Retirement retirements = mapper.readValue(row_data, Retirement.class);
                                    template.setRetirement(retirements);
                                } catch (Exception e) {
                                    Logger.logger.error("Exception Occured on" + e.getStackTrace());
                                }
                                break;
                            case HOME_VRS:
                                try {
                                	Vrs vrs = mapper.readValue(row_data, Vrs.class);
                                    template.setVrs(vrs);
                                } catch (Exception e) {
                                    Logger.logger.error("Exception Occured on" + e.getStackTrace());
                                }
                                break;
                            case HOME_MUSTREAD:
                            	MustRead mustRead = mapper.readValue(row_data, MustRead.class);
                                template.setMustRead(mustRead);
                                mustreadFlag = true;
                                break;
                            case HOME_CIRCULARS:
                                Circulars circulars = mapper.readValue(row_data, Circulars.class);
                                template.setCirculars(circulars);
                                circularsFlag = true;
                                break;
                            case HOME_SERVICE_LINKS:

                                ServiceLinks serviceLinks = mapper.readValue(row_data, ServiceLinks.class);
                                template.setServiceLinks(serviceLinks);
                                serviceLinksFlag = true;
                                break;
//                            case HOME_BANKINFO:
//                                BankInfo bankInfo = mapper.readValue(row_data, BankInfo.class);
//                                template.setBankInfo(bankInfo);
//                                bankInfoFlag = true;
//                                break;
                            case HOME_MISCELLANEOUS:

                                Miscellaneous miscellaneous = mapper.readValue(row_data, Miscellaneous.class);
                                template.setMiscellaneous(miscellaneous);
                                miscellaneousFlag = true;
                                break;
                            case HOME_NEWS_AND_EVENTS:
                                NewsAndEvents newsAndEvents = mapper.readValue(row_data, NewsAndEvents.class);
                                template.setNewsAndEvents(newsAndEvents);
                                newsAndEventsFlag = true;
                                break;
                            case ALERTS:
                                Alerts alerts = mapper.readValue(row_data, Alerts.class);
                                template.setAlerts(alerts);
                                alertsFlag = true;
                                break;
                            case FOOTER:

                                Footer footer = mapper.readValue(row_data, Footer.class);
                                template.setFooter(footer);
                                footerFlag = true;
                                break;

                            case MUSIC:
                                Music music = mapper.readValue(row_data, Music.class);
                                template.setMusic(music);
                                musicFlag= true;
                                break;



                        }
                	}
                
            //    }

                if (!homeSideMenuFlag){
                    SideMenu sideMenu = new SideMenu();
                    sideMenu.setData(commonList);
                    template.setSideMenu(sideMenu);
                }
                if (!searchFlag){
                    EmployeeSearch employeeSearch = new EmployeeSearch();
                    employeeSearch.setUrl("");
                    template.setEmployeeSearch(employeeSearch);
                }
                if (!alertsFlag){
                    AlertsData alertsData = new AlertsData();
                    alertsData.setAlert("");
                    ArrayList alertsList = new ArrayList();
                    alertsList.add(alertsData);
                    Alerts alerts = new Alerts();
                    alerts.setAlerts(alertsList);
                    template.setAlerts(alerts);
                }
                if (!imagesFlag){
                    ImagesData imagesData = new ImagesData();
                    imagesData.setUrl("");
                    imagesData.setImage("");
                    ArrayList imageList = new ArrayList();
                    imageList.add(imagesData);
                    Images images = new Images();
                    images.setData(imageList);
                    template.setImages(images);
                }
                if (!videosFlag){
                    VideosData videosData = new VideosData();
                    videosData.setTitle("");
                    videosData.setThumbnail("");
                    videosData.setUrl("");
                    ArrayList videosList = new ArrayList();
                    videosList.add(videosData);
                    Videos videos = new Videos();
                    videos.setData(videosList);
                    template.setVideos(videos);
                }
                if (!blurbFlag){
                    BlurbData blurbData = new BlurbData();
                    blurbData.setUrl("");
                    blurbData.setThumbnail("");
                    ArrayList blurbList=new ArrayList();
                    blurbList.add(blurbData);
                    Blurb blurb = new Blurb();
                    blurb.setData(blurbList);
                    template.setBlurb(blurb);
                }
//                if (!announcementsFlag){
//                    NewAnnouncements announcements = new NewAnnouncements();
//                    announcements.setTitle("Announcements");
//                    announcements.setData(announceCircularList);
//                    template.setNewAnnouncements(announcements);
//                }
				/*
				 * if (!retirementsFlag){ RetirementData retirementData = new RetirementData();
				 * retirementData.setDepartment(""); retirementData.setPfNumber("");
				 * retirementData.setImage(""); retirementData.setName("");
				 * retirementData.setDate(""); retirementData.setDesignation(""); //
				 * retirementData.setUrl(""); ArrayList retirementList = new ArrayList();
				 * retirementList.add(retirementData); Retirement retirement = new Retirement();
				 * retirement.setData(retirementList); template.setRetirement(retirement); }
				 */
                if (!mustreadFlag){
                	
                  	 MustReadData mustreadData=new MustReadData();
                       mustreadData.setText("");
                       mustreadData.setUrl("");
                       List<MustReadData> mustreadList = new ArrayList();
                       mustreadList.add(mustreadData);
                       MustRead mustRead=new MustRead();
                       mustRead.setData(mustreadList);
                       mustRead.setTitle("Must Read");
                       template.setMustRead(mustRead);
                      
                  }
                if (!circularsFlag){
                    Circulars circulars = new Circulars();
                    circulars.setTitle("Circulars");
                    circulars.setData(announceCircularList);
                    template.setCirculars(circulars);
                }
                if (!bankInfoFlag){
                    BankInfo bankInfo = new BankInfo();
                    bankInfo.setAtms("");
                    bankInfo.setCdm("");
                    bankInfo.setBranches("");
                    bankInfo.setCustomers("");
              //      template.setBankInfo(bankInfo);
                }
                if (!newsAndEventsFlag){
                    NewsAndEventsData newsAndEventsData = new NewsAndEventsData();
                    newsAndEventsData.setDate("");
                    newsAndEventsData.setImage("");
                    newsAndEventsData.setLocation("");
                    newsAndEventsData.setText("");
                    newsAndEventsData.setTime("");
                    newsAndEventsData.setTitle("");
                    ArrayList newsList = new ArrayList();
                    newsList.add(newsAndEventsData);
                    NewsAndEvents newsAndEvents = new NewsAndEvents();
                    newsAndEvents.setTitle("News And Events");
                    newsAndEvents.setData(newsList);
                    template.setNewsAndEvents(newsAndEvents);
                }
                if (!serviceLinksFlag){
                    ArrayList serviceLinksList = new ArrayList();
                    for (int j = 0; j <= 6; j++) {
                        serviceLinksList.add(sideMenuData);
                    }
                    ServiceLinks serviceLinks = new ServiceLinks();
                    serviceLinks.setTitle("");
                    serviceLinks.setData(serviceLinksList);
                    template.setServiceLinks(serviceLinks);
                }
                if (!miscellaneousFlag){
                    MiscellaneousData miscellaneousData = new MiscellaneousData();
                    miscellaneousData.setColor("");
                    miscellaneousData.setContent("");
                    miscellaneousData.setImage("");
                    miscellaneousData.setUrl("");
                    ArrayList miscellaneousList = new ArrayList();
                    miscellaneousList.add(miscellaneousData);
                    Miscellaneous miscellaneous = new Miscellaneous();
                    miscellaneous.setData(miscellaneousList);
                    template.setMiscellaneous(miscellaneous);
                }
                if (!footerFlag){
                    SectionData sectionData = new SectionData();
                    sectionData.setTitle("");
                    sectionData.setMenu(commonList);
                    ArrayList sectionDataList = new ArrayList();
                    sectionDataList.add(sectionData);
                    Footer footer = new Footer();
                    footer.setSectionData(sectionDataList);
                    template.setFooter(footer);
                }

                if (!musicFlag){
                    Music musicData = new Music();
                    musicData.setAudioText("");

                    template.setMusic(musicData);
                }


            }
            catch (Exception e){
                Logger.logger.error("Exception Occured on" + e.getStackTrace());
            }
            return template;
        }
    }
    @Transactional
    public String publish(HomeTemplate template) throws IOException  {
        try {
        	System.out.print("template must read"+template.getMustRead());
            JSONParser parser = new JSONParser();
            JSONObject sidemenuJson = (JSONObject) parser.parse(String.valueOf(sideMenuDao.fetchSideMenu()));
            JSONObject templateSideMenuJson = (JSONObject) parser.parse(template.getSideMenu().toString());
            ObjectMapper mapper = new ObjectMapper();
            JsonNode sidemenuJsonNode = mapper.readTree(sidemenuJson.toString());
            JsonNode templateSideMenuJsonNode = mapper.readTree(templateSideMenuJson.toString());
            if (!sidemenuJsonNode.equals(templateSideMenuJsonNode)) {
            	
                sideMenuDao.setSideMenu(template.getSideMenu());
                logDataDao.saveLogData("Admin", "Admin", "IT", "Home", "Side Menu", templateSideMenuJson.toString());
            }

//            JSONArray announcementJson = (JSONArray) parser.parse(String.valueOf(announcementDao.getAnnouncements().getData()));
//            JSONArray templateAnnouncementJson = (JSONArray) parser.parse(template.getAnnouncements().getData().toString());
//            JsonNode announcementJsonNode = mapper.readTree(announcementJson.toString());
//            JsonNode templateAnnouncementJsonNode = mapper.readTree(templateAnnouncementJson.toString());
//            if (!announcementJsonNode.equals(templateAnnouncementJsonNode)) {
//                announcementDao.setAnnouncements(template.getAnnouncements());
//                logDataDao.saveLogData("Admin", "Admin", "IT", "Home", "Circulars", templateAnnouncementJson.toString());
//            }

            JSONObject blurbJson = (JSONObject) parser.parse(String.valueOf(blurbDao.getBlurb()));
            JSONObject templateBlurbJson = (JSONObject) parser.parse(template.getBlurb().toString());
            JsonNode blurbJsonNode = mapper.readTree(blurbJson.toString());
            JsonNode templateBlurbJsonNode = mapper.readTree(templateBlurbJson.toString());
            if (!blurbJsonNode.equals(templateBlurbJsonNode)) {
                blurbDao.setBlurb(template.getBlurb());
                logDataDao.saveLogData("Admin", "Admin", "IT", "Home", "Blurb", templateBlurbJson.toString());
            }
            JSONObject imageJson = (JSONObject) parser.parse(String.valueOf(imagesDao.getImages()));
            JSONObject templateImageJson = (JSONObject) parser.parse(template.getImages().toString());
            JsonNode imageJsonNode = mapper.readTree(imageJson.toString());
            JsonNode templateImageJsonNode = mapper.readTree(templateImageJson.toString());
            if (!imageJsonNode.equals(templateImageJsonNode)) {
                imagesDao.setImage(template.getImages());
                logDataDao.saveLogData("Admin", "Admin", "IT", "Home", "Image Slides", templateImageJson.toString());
            }
            JSONObject newsAndEventsJson = (JSONObject) parser.parse(String.valueOf(newsAndEventsDao.getNewsAndEvents()));
            JSONObject templateNewsAndEventsJson = (JSONObject) parser.parse(template.getNewsAndEvents().toString());
            JsonNode newsAndEventsJsonJsonNode = mapper.readTree(newsAndEventsJson.toString());
            JsonNode templateNewsAndEventsJsonNode = mapper.readTree(templateNewsAndEventsJson.toString());
            if (!newsAndEventsJsonJsonNode.equals(templateNewsAndEventsJsonNode)) {
                newsAndEventsDao.setNewsAndEvents(template.getNewsAndEvents());
                logDataDao.saveLogData("Admin", "Admin", "IT", "Home", "News and Events", templateNewsAndEventsJson.toString());
            }
            //System.out.println("Retirement");
//            JSONArray retirementsJson = (JSONArray) parser.parse(String.valueOf(retirementDao.getRetirement().getData()));
//            JSONArray templateRetirementsJson = (JSONArray) parser.parse(template.getRetirement().getData().toString());
//            JsonNode retirementsJsonNode = mapper.readTree(retirementsJson.toString());
//            JsonNode templateRetirementsJsonNode = mapper.readTree(templateRetirementsJson.toString());
//            if (!retirementsJsonNode.equals(templateRetirementsJsonNode)) {
//                //	System.out.println("from publish method"+template.getRetirement());
//                    retirementDao.setRetirement(template.getRetirement());
//                    logDataDao.saveLogData("Admin", "Admin", "IT", "Home", "Retirements", templateRetirementsJson.toString());
//                }
            //mustread
          /*  JSONObject mustreadJson = (JSONObject) parser.parse(String.valueOf(mustreadDao.getMustReadContents()));
            JSONObject templateMustReadJson = (JSONObject) parser.parse(template.getMustRead().toString());
            
            JsonNode mustreadJsonNode = mapper.readTree(mustreadJson.toString());
            JsonNode templateMustReadJsonNode = mapper.readTree(templateMustReadJson.toString());
            if (!mustreadJsonNode.equals(templateMustReadJsonNode)) {
            	System.out.println("from publish method"+template.getMustRead());
                mustreadDao.setMustReadContents(template.getMustRead());
                System.out.println("after saving publish getdata"+template.getMustRead());
                logDataDao.saveLogData("Admin", "Admin", "IT", "Home", "Must Read",templateMustReadJson.toString());
            }*/
            
            
            JSONObject videosJson = (JSONObject) parser.parse(String.valueOf(videosDao.getVideoAds()));
            JSONObject templateVideosJson = (JSONObject) parser.parse(template.getVideos().toString());
            JsonNode videosJsonNode = mapper.readTree(videosJson.toString());
            JsonNode templateVideosJsonNode = mapper.readTree(templateVideosJson.toString());
            if (!videosJsonNode.equals(templateVideosJsonNode)) {
                videosDao.setVideoAds(template.getVideos());
                logDataDao.saveLogData("Admin", "Admin", "IT", "Home", "Videos", templateVideosJson.toString());
            }
            JSONObject alertsJson = (JSONObject) parser.parse(String.valueOf(alertsDao.getNotification()));
            JSONObject templateAlertsJson = (JSONObject) parser.parse(template.getAlerts().toString());
            System.out.println("template.getAlerts() " + template.getAlerts());
            JsonNode alertsJsonNode = mapper.readTree(alertsJson.toString());
            JsonNode templateAlertsJsonNode = mapper.readTree(templateAlertsJson.toString());
            if (!alertsJsonNode.equals(templateAlertsJsonNode)) {
            	System.out.print("the alert result is "+template.getAlerts());
                alertsDao.setNotification(template.getAlerts());
                logDataDao.saveLogData("Admin", "Admin", "IT", "Home", "Alerts", templateAlertsJson.toString());
            }
          /*  JSONArray serviceLinksJson = (JSONArray) parser.parse(String.valueOf(serviceLinksDao.getServiceLinks().getData()));
            JSONArray templateServiceLinksJson = (JSONArray) parser.parse(template.getServiceLinks().getData().toString());
            JsonNode serviceLinksJsonNode = mapper.readTree(serviceLinksJson.toString());
            JsonNode templateServiceLinksJsonNode = mapper.readTree(templateServiceLinksJson.toString());
            if (!serviceLinksJsonNode.equals(templateServiceLinksJsonNode)) {
                serviceLinksDao.setServiceLink(template.getServiceLinks());
                logDataDao.saveLogData("Admin", "Admin", "IT", "Home", "Service Links", templateServiceLinksJson.toString());
            }*/
        /*    JSONArray miscellaneousJson = (JSONArray) parser.parse(String.valueOf(miscellaneousDao.getMiscellaneous().getData()));
            JSONArray templatemiscellaneousJson = (JSONArray) parser.parse(template.getMiscellaneous().getData().toString());
            JsonNode miscellaneousJsonNode = mapper.readTree(miscellaneousJson.toString());
            JsonNode templatemiscellaneousJsonNode = mapper.readTree(templatemiscellaneousJson.toString());
            if (!miscellaneousJsonNode.equals(templatemiscellaneousJsonNode)) {
                miscellaneousDao.setMiscellaneous(template.getMiscellaneous());
                logDataDao.saveLogData("Admin", "Admin", "IT", "Home", "Miscellaneous", templatemiscellaneousJson.toString());
            }*/
            JSONArray footerJson = (JSONArray) parser.parse(String.valueOf(footerDao.getFooter().getSectionData()));
            JSONArray templateFooterJson = (JSONArray) parser.parse(template.getFooter().getSectionData().toString());
            JsonNode footerJsonNode = mapper.readTree(footerJson.toString());
            JsonNode templateFooterJsonNode = mapper.readTree(templateFooterJson.toString());
            if (!footerJsonNode.equals(templateFooterJson.toString())) {
                footerDao.setFooter(template.getFooter());
                logDataDao.saveLogData("Admin", "Admin", "IT", "Home", "Footer", templateFooterJson.toString());
            }
            JSONObject employeeSearchJson = (JSONObject) parser.parse(String.valueOf(employeeSearchDao.employeeSearch()));
            System.out.println("employeeSearchDao.employeeSearch()" +employeeSearchDao.employeeSearch());
            JSONObject templateEmployeeSearchJson = (JSONObject) parser.parse(template.getEmployeeSearch().toString());
            System.out.println("template.getEmployeeSearch().toString()" +template.getEmployeeSearch().toString());
            JsonNode employeeSearchJsonNode = mapper.readTree(employeeSearchJson.toString());
            JsonNode templateEmployeeSearchJsonNode = mapper.readTree(templateEmployeeSearchJson.toString());
            if (!employeeSearchJsonNode.equals(templateEmployeeSearchJsonNode)) {
            	System.out.println("inside employee");
                employeeSearchDao.setEmployeeSearchUrl(template.getEmployeeSearch());
                logDataDao.saveLogData("Admin", "Admin", "IT", "Home", "Employee Search", templateEmployeeSearchJson.toString());
            }

            JSONObject musicJson = (JSONObject) parser.parse(String.valueOf(musicDao.getMusic()));
            System.out.println("musicDao.getMusic" +musicDao.getMusic());
            JSONObject templateMusicJson = (JSONObject) parser.parse(template.getMusic().toString());
            System.out.println("template.getMusic().toString()" +template.getMusic());
            JsonNode musicJsonNode = mapper.readTree(musicJson.toString());
            JsonNode templateMusicJsonNode = mapper.readTree(templateMusicJson.toString());
            if (!musicJsonNode.equals(templateMusicJsonNode)) {
                System.out.println("inside music");
                musicDao.setMusic(template.getMusic());
                logDataDao.saveLogData("Admin", "Admin", "IT", "Home", "Music", templateMusicJson.toString());
            }
//            JSONObject bankInfoJson = (JSONObject) parser.parse(String.valueOf(bankInfoDao.getBankInfo()));
//            JSONObject templatebankInfoJson = (JSONObject) parser.parse(template.getBankInfo().toString());
//            JsonNode bankInfoJsonNode = mapper.readTree(bankInfoJson.toString());
//            JsonNode templatebankInfoJsonNode = mapper.readTree(templatebankInfoJson.toString());
//            if (!bankInfoJsonNode.equals(templatebankInfoJsonNode)) {
//                bankInfoDao.setBankInfo(template.getBankInfo());
//                logDataDao.saveLogData("Admin", "Admin", "IT", "Home", "Bank Info", templatebankInfoJson.toString());
//            }
//            JSONObject circularJson = (JSONObject) parser.parse(String.valueOf(circularsDao.fetchCirculars()));
//            JSONObject templateCircularJson = (JSONObject) parser.parse(template.getCirculars().toString());
//            JsonNode circularJsonNode = mapper.readTree(circularJson.toString());
//            JsonNode templateCircularJsonNode = mapper.readTree(templateCircularJson.toString());
//            if (!circularJsonNode.equals(templateCircularJsonNode)) {
//                circularsDao.setCirculars(template.getCirculars());
//                logDataDao.saveLogData("Admin", "Admin", "IT", "Home", "Circulars", templateCircularJson.toString());
//            }
            announcementDao.getAnnouncementsData();
        } catch (Exception e) {
            Logger.logger.error("Exception Occured on" + e.getStackTrace());
        }
        redisDao.addDataToRedis();
        return "published";
    }
    
    @Transactional
    public void publishRetirement(String str) throws IOException  {
    	/*  try {
        	JSONParser parser = new JSONParser();
        	ObjectMapper mapper = new ObjectMapper();
        	// retirementDao.setRetirement(str);
        	  //System.out.println("Retirement 3"+template.getRetirement());
        	// JSONArray retirementsJson = (JSONArray) parser.parse(String.valueOf(retirementDao.getRetirement().getData()));
            // JSONArray templateRetirementsJson = (JSONArray) parser.parse(template.getRetirement().getData().toString());
           //  JsonNode retirementsJsonNode = mapper.readTree(retirementsJson.toString());
            // JsonNode templateRetirementsJsonNode = mapper.readTree(templateRetirementsJson.toString());
            if (!retirementsJsonNode.equals(templateRetirementsJsonNode)) {
             	System.out.println("from publish method"+template.getMustRead());
             	System.out.println("from publish method"+template.getRetirement());
             	System.out.println("from publish method"+template.getMustRead());
                 retirementDao.setRetirement(template.getRetirement());
                 System.out.println("Retirement 3"+retirementDao.setRetirement(template.getRetirement()));
                 logDataDao.saveLogData("Admin", "Admin", "IT", "Home", "Retirements", templateRetirementsJson.toString());
             }
             
             
        } catch (Exception e) {
            Logger.logger.error("Exception Occured on" + e.getStackTrace());
        }
        redisDao.addDataToRedis();  */
    	System.out.println("DATA"+retirementDaoPublish.setRetirementSave(str));
        retirementDaoPublish.setRetirementSave(str);
        
    }
    
    @Transactional
    public void publishVrs(String str) throws IOException  {
    	System.out.println("DATA"+retirementDaoPublish.setVrsSave(str));
        retirementDaoPublish.setVrsSave(str);
    }
    
 
}

