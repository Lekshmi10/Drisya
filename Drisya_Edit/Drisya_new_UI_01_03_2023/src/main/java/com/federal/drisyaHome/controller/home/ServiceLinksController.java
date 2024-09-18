package com.federal.drisyaHome.controller.home;

import com.federal.drisyaHome.model.ServiceLinks;
import com.federal.drisyaHome.service.home.ServiceLinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/serviceLinks")
public class ServiceLinksController {
    @Autowired
    ServiceLinksService serviceLinksService;

    @GetMapping("/")
    public ServiceLinks getServiceLinks() {
        return serviceLinksService.getServiceLinks();
    }

    @PostMapping("/add")
    public ServiceLinks setServiceLink(@RequestBody ServiceLinks serviceLinks) {
        return serviceLinksService.setServiceLink(serviceLinks);
    }
}
