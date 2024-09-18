package com.federal.drisyaHome.controller.application;

import com.federal.drisyaHome.model.ExternalLink;
import com.federal.drisyaHome.service.application.ExternalLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/externalLink")
public class ExternalLinkController {
    @Autowired
    ExternalLinkService externalLinkService;

    @GetMapping("/")
    public ExternalLink getExternalLink() {
        return externalLinkService.getExternalLink();
    }

    @PostMapping("/add")
    public ExternalLink setExternalLink(@RequestBody ExternalLink externalLinkData) {
        return externalLinkService.setExternalLink(externalLinkData);
    }

}
