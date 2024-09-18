package com.federal.drisyaHome.controller.home;

import com.federal.drisyaHome.model.Announcements;
import com.federal.drisyaHome.model.NewAnnouncements;
import com.federal.drisyaHome.service.home.AnnouncementService;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/announcements")
public class AnnouncementController {

    @Autowired
    AnnouncementService announcementService;

    @GetMapping("/")
    public Announcements getAnnouncements() {
        return announcementService.getAnnouncements();
    }

    @PostMapping("/add")
    public Announcements setAnnouncements(@RequestBody Announcements announcement) {
        return announcementService.setAnnouncements(announcement);
    }

    @PostMapping("/uploadPdf")
    public String uploadPdf(@RequestParam("File") MultipartFile file, @RequestParam("announcementHeadline") String announcementHeadline) {
        return announcementService.uploadPdf(file, announcementHeadline);


    }

    @GetMapping("/downloadFile")
    public ResponseEntity<Resource> downloadFile(@RequestParam("announcementHeadline") String announcementHeadline) {
        return announcementService.fetchPdf(announcementHeadline);
    }

    @GetMapping("/deleteFile")
    public String deleteFile(@RequestParam String announcementHeadLine){
        return announcementService.deleteFile(announcementHeadLine);
    }
   @GetMapping("/getannouncementData")
    public NewAnnouncements getAnnouncementsData() throws IOException {   	
return announcementService.getAnnouncementsData();
   }

    	    		
    }

