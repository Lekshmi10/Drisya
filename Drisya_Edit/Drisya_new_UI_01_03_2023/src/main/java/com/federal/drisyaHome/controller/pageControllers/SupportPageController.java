package com.federal.drisyaHome.controller.pageControllers;

import com.federal.drisyaHome.model.SupportModel;
import com.federal.drisyaHome.service.support.SupportPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class SupportPageController {
    @Autowired
    SupportPageService supportPageService;

    @GetMapping("/support")
    public SupportModel getSupportPage(){
        return supportPageService.getSupportPage();
    }

    @PostMapping("/publishSupport")
    public String publishSupport(@RequestBody SupportModel supportModel) throws IOException  {
    	System.out.println(supportModel.toString());
        return supportPageService.publishSupport(supportModel);
    }

}
