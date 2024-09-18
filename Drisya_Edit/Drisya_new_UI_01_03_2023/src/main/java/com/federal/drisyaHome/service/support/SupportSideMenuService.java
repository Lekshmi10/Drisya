package com.federal.drisyaHome.service.support;

import com.federal.drisyaHome.dao.support.SupportSideMenuDao;
import com.federal.drisyaHome.model.SupportSideMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SupportSideMenuService {

    @Autowired
    SupportSideMenuDao supportSideMenuDao;

    @Transactional
    public SupportSideMenu getSupportSideMenu() {
        return supportSideMenuDao.getSupportSideMenu();
    }

    @Transactional
    public SupportSideMenu setSupportSideMenu(SupportSideMenu supportSideMenu) {
        return supportSideMenuDao.setSupportSideMenu(supportSideMenu);
    }

}
