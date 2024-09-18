package com.federal.drisyaHome.controller.home;

import com.federal.drisyaHome.Logger;
import com.federal.drisyaHome.model.CircularFiles;
import com.federal.drisyaHome.model.Circulars;
import com.federal.drisyaHome.service.home.CircularsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/circulars")

public class CircularController {
    @Autowired
    CircularsService circularsService;

    @GetMapping("/")
    public Circulars fetchCirculars() {
        return circularsService.getCirculars();
    }

    @PostMapping("/add")
    public Circulars setCirculars(@RequestBody Circulars circulars) {
        circularsService.addCirculars(circulars);
        return circulars;
    }
    @GetMapping("/downloadFile")
    public ResponseEntity<Resource> downloadFile(@RequestParam(name="circularHeadline") String circularHeadline) {

        CircularFiles circularFiles = circularsService.fetchFile(circularHeadline);
        ByteArrayResource resource = new ByteArrayResource(circularFiles.getPdf());
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename="+circularFiles.getDoc_name()+".pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(circularFiles.getPdf().length)
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);
    }

    @PostMapping("/uploadFile")
    public void uploadPdf(@RequestParam("File") MultipartFile file,@RequestParam("circularHeadline")String circularHeadline) {
        try {
            CircularFiles circularFiles = new CircularFiles();
            circularFiles.setCircularHeadline(circularHeadline.toUpperCase());
            circularFiles.setDoc_name(file.getOriginalFilename());
            circularFiles.setDoc_type(file.getContentType());
            circularFiles.setPdf(file.getBytes());
            circularsService.uploadFile(circularFiles);
        } catch (Exception e) {
            Logger.logger.error("Exception Occured on" + e.getStackTrace());
        }
    }
    @GetMapping("/deleteFile")
    public String deleteFile(@RequestParam String circularHeadLine){
        return circularsService.deleteFile(circularHeadLine);
    }

}