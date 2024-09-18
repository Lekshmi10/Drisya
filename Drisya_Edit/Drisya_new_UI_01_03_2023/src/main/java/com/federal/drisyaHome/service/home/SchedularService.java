package com.federal.drisyaHome.service.home;

import com.federal.drisyaHome.model.AnnouncementData;
import com.federal.drisyaHome.model.Announcements;
import com.federal.drisyaHome.model.CircularData;
import com.federal.drisyaHome.model.Circulars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SchedularService {
    @Autowired
    AnnouncementService announcementService;
    @Autowired
    CircularsService circularsService;

//@Scheduled(fixedDelay = 15*60*1000)

    public void setUpdatedAnnouncements() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        Announcements announcementsResponse = restTemplate.getForObject("https://demo8255337.mockable.io/announcements", Announcements.class);
        Announcements data = new Announcements();
        for(int i=0;i<announcementsResponse.getData().size();i++){
            data = new Announcements();
            List<AnnouncementData> list=new ArrayList<>();
            AnnouncementData announcementData=new AnnouncementData();
            announcementData.setUrl(announcementsResponse.getData().get(i).getUrl());
            announcementData.setHeadline(announcementsResponse.getData().get(i).getHeadline());
            //announcementData.setPublishedDate(announcementsResponse.getData().get(i).getPublishedDate());//internally setting at  adding made as system current timing
            announcementData.setAuthor(announcementsResponse.getData().get(i).getAuthor());
            announcementData.setEmployeeId(announcementsResponse.getData().get(i).getEmployeeId());
            announcementData.setDescription(announcementsResponse.getData().get(i).getDescription());
            announcementData.setDepartment(announcementsResponse.getData().get(i).getDepartment());
            announcementData.setId(announcementsResponse.getData().get(i).getId());
            list.add(announcementData);
            data.setData(list);
            announcementService.setAnnouncements(data);
        }
    }
    public void setUpdatedCirculars() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        Circulars circularResponse = restTemplate.getForObject("https://demo8255337.mockable.io/announcements", Circulars.class);
        Circulars data = new Circulars();
        for(int i=0;i<circularResponse.getData().size();i++){
            data = new Circulars();
            List<CircularData> list=new ArrayList<>();
            CircularData circularData=new CircularData();
            circularData.setUrl(circularResponse.getData().get(i).getUrl());
            circularData.setHeadline(circularResponse.getData().get(i).getHeadline());
            //circularData.setPublishedDate(circularResponse.getData().get(i).getPublishedDate());//internally setting at  adding made as system current timing
            circularData.setAuthor(circularResponse.getData().get(i).getAuthor());
            circularData.setEmployeeId(circularResponse.getData().get(i).getEmployeeId());
            circularData.setDescription(circularResponse.getData().get(i).getDescription());
            circularData.setDepartment(circularResponse.getData().get(i).getDepartment());
            circularData.setId(circularResponse.getData().get(i).getId());
            list.add(circularData);
            data.setData(list);
            circularsService.addCirculars(data);
        }
    }
}


