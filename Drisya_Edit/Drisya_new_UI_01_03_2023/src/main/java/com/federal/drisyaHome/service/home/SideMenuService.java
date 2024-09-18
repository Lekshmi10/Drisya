package com.federal.drisyaHome.service.home;

import com.federal.drisyaHome.dao.home.SideMenuDao;
import com.federal.drisyaHome.model.SideMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class SideMenuService {

    @Autowired
    SideMenuDao sideMenuDao;

    @Transactional
    public SideMenu fetchSideMenu() {
        return sideMenuDao.fetchSideMenu();
    }

    @Transactional
    public SideMenu setSideMenu(SideMenu contents) {
        return sideMenuDao.setSideMenu(contents);
    }
}
