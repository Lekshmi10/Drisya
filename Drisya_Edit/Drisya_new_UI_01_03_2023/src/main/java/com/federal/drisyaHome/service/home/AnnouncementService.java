package com.federal.drisyaHome.service.home;

import com.federal.drisyaHome.Logger;
import com.federal.drisyaHome.dao.home.AnnouncementDao;
import com.federal.drisyaHome.model.AnnouncementFiles;
import com.federal.drisyaHome.model.Announcements;
import com.federal.drisyaHome.model.NewAnnouncements;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


@Service
public class AnnouncementService {
    @Autowired
    AnnouncementDao announcementDao;

    @Transactional
    public Announcements getAnnouncements() {
        return announcementDao.getAnnouncements();
    }

    @Transactional
    public Announcements setAnnouncements(Announcements announcement) {
        return announcementDao.setAnnouncements(announcement);
    }


    @Transactional
    public String uploadPdf(MultipartFile file,String announcementHeadline) {
        try {
            AnnouncementFiles announcementFiles = new AnnouncementFiles();
            announcementFiles.setAnnouncementHeadline(announcementHeadline.toUpperCase());
            announcementFiles.setDoc_name(file.getOriginalFilename());
            announcementFiles.setDoc_type(file.getContentType());
            announcementFiles.setPdf(file.getBytes());
            announcementDao.uploadPdf(announcementFiles);
            return "File Uploaded Successfully";
        }catch (Exception e){
            Logger.logger.error("Exception Occured on" + e.getStackTrace());
            return "Something went wrong";
        }

    }

    public ResponseEntity<Resource> fetchPdf(String announcementHeadline) {
        AnnouncementFiles announcementFiles = announcementDao.fetchPdf(announcementHeadline);
        ByteArrayResource resource = new ByteArrayResource(announcementFiles.getPdf());
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename="+announcementFiles.getDoc_name()+".pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(announcementFiles.getPdf().length)
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);
    }
    @Transactional
    public String deleteFile(String announcementHeadLine){
        return announcementDao.deleteFile(announcementHeadLine);
    }
	//@Scheduled(cron="0 0/1 * * * ?")
  @Scheduled(cron="*/30 * * * * * ")
    @Transactional
    public NewAnnouncements getAnnouncementsData() throws IOException{
        return announcementDao.getAnnouncementsData();
    }
 
}
