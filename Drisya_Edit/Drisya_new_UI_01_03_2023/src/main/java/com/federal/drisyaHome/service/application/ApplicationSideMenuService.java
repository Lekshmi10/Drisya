package com.federal.drisyaHome.service.application;

import com.federal.drisyaHome.dao.application.ApplicationSideMenuDao;
import com.federal.drisyaHome.model.ApplicationSideMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ApplicationSideMenuService {
    @Autowired
    ApplicationSideMenuDao applicationSideMenuDao;

    @Transactional
    public ApplicationSideMenu getApplicationSideMenu() {
        return applicationSideMenuDao.getApplicationSideMenu();
    }

    @Transactional
    public ApplicationSideMenu setApplicationSideMenu(ApplicationSideMenu sideMenuData) {
        return applicationSideMenuDao.setApplicationSideMenu(sideMenuData);
    }
}
