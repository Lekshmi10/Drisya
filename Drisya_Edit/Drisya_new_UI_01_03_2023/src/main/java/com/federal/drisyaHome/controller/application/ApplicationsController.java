package com.federal.drisyaHome.controller.application;


import com.federal.drisyaHome.model.Applications;
import com.federal.drisyaHome.service.application.ApplicationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/application")
public class ApplicationsController {

    @Autowired
    ApplicationsService applicationsService;

    @GetMapping("/")
    public Applications getApplications() {
        return applicationsService.getApplications();
    }

    @PostMapping("/add")
    public Applications setApplication(@RequestBody Applications application) {
        return applicationsService.setApplication(application);
    }

}
