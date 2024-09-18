package com.federal.drisyaHome.controller.pageControllers;

import com.federal.drisyaHome.model.ResponseModel;
import com.federal.drisyaHome.service.application.ApplicationPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class ApplicationPageController {
    @Autowired
    ApplicationPageService applicationPageService;
    @GetMapping("/applications")
    public ResponseModel fetchApplicationPage(){
        return applicationPageService.fetchApplicationPage();
    }
    @PostMapping("/applicationPublish")
    public String applicationPublish(@RequestBody ResponseModel responseModel) throws IOException {
        return applicationPageService.applicationPublish(responseModel);
    }

}
