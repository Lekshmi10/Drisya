package com.federal.drisyaHome.controller.reference;

import com.federal.drisyaHome.model.ReferencesSideMenu;
import com.federal.drisyaHome.service.reference.ReferencesSideMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/reference_sidemenu")
public class ReferencesSideMenuController {
    @Autowired
    ReferencesSideMenuService referencesSideMenuService;
    @GetMapping("/")
    public ReferencesSideMenu getApplicationSideMenu()  {
        return referencesSideMenuService.getReferencesSideMenu();
    }
    @PostMapping("/add")
    public ReferencesSideMenu setApplicationSideMenu(@RequestBody ReferencesSideMenu sideMenuData) {
        return referencesSideMenuService.setApplicationSideMenu(sideMenuData);
    }

}
