package com.federal.drisyaHome.controller.home;

import com.federal.drisyaHome.model.SideMenu;
import com.federal.drisyaHome.service.home.SideMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sideMenu")
public class SideMenuController {

    @Autowired
    SideMenuService sideMenuService;

    @GetMapping("/")
    public SideMenu fetchSideMenu(){
        return sideMenuService.fetchSideMenu();
    }
    @PostMapping("/add")
    public SideMenu setSideMenu(@RequestBody SideMenu contents){
        return sideMenuService.setSideMenu(contents);
    }
}
