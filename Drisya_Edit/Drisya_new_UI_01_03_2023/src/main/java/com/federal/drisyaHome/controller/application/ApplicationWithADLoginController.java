package com.federal.drisyaHome.controller.application;

import com.federal.drisyaHome.model.ApplicationsWithADLogin;
import com.federal.drisyaHome.service.application.ApplicationWithADLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/applicationsAD")
public class ApplicationWithADLoginController {

    @Autowired
    ApplicationWithADLoginService applicationWithADLoginService;

    @GetMapping("/")
    public ApplicationsWithADLogin getApplications() {
        return applicationWithADLoginService.getApplications();
    }

    @PostMapping("/add")
    public ApplicationsWithADLogin setApplication(@RequestBody ApplicationsWithADLogin applicationData) {
        return applicationWithADLoginService.setApplication(applicationData);
    }
}
