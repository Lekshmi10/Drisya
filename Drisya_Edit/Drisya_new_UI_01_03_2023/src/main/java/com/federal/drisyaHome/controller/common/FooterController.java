package com.federal.drisyaHome.controller.common;

import com.federal.drisyaHome.model.Footer;
import com.federal.drisyaHome.service.common.FooterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/footer")
public class FooterController {
    @Autowired
    FooterService footerService;

    @GetMapping("/")
    public Footer getSection() {
        return footerService.getFooter();

    }
    @PostMapping("/add")
    public Footer setFooter(@RequestBody Footer footerData) {
        return footerService.setFooter(footerData);
    }

}
