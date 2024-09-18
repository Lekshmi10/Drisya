package com.federal.drisyaHome.controller.support;

import com.federal.drisyaHome.model.SupportSideMenu;
import com.federal.drisyaHome.service.support.SupportSideMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supportSideMenu")
public class SupportSideMenuController {
    @Autowired
    SupportSideMenuService supportSideMenuService;

    @GetMapping("/")
    public SupportSideMenu getSupportSideMenu() {
        return supportSideMenuService.getSupportSideMenu();
    }

    @PostMapping("/add")
    public SupportSideMenu setSupportSideMenu(@RequestBody SupportSideMenu supportSideMenu) {
        return supportSideMenuService.setSupportSideMenu(supportSideMenu);
    }
}
