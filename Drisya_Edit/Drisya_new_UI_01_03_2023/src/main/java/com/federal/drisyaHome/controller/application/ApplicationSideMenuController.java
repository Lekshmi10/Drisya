package com.federal.drisyaHome.controller.application;

import com.federal.drisyaHome.model.ApplicationSideMenu;
import com.federal.drisyaHome.service.application.ApplicationSideMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/application_sidemenu")
public class ApplicationSideMenuController {
    @Autowired
    ApplicationSideMenuService applicationSideMenuService;

    @GetMapping("/")
    public ApplicationSideMenu getApplicationSideMenu() {
        return applicationSideMenuService.getApplicationSideMenu();
    }

    @PostMapping("/add")
    public ApplicationSideMenu setApplicationSideMenu(@RequestBody ApplicationSideMenu sideMenuData) {
        return applicationSideMenuService.setApplicationSideMenu(sideMenuData);
    }

}
