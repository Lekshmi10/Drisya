package com.federal.drisyaHome.service.reference;

import com.federal.drisyaHome.dao.reference.ReferencesSideMenuDao;
import com.federal.drisyaHome.model.ReferencesSideMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ReferencesSideMenuService {
    @Autowired
    ReferencesSideMenuDao referencesSideMenuDao;

    @Transactional
    public ReferencesSideMenu getReferencesSideMenu()  {
        return referencesSideMenuDao.getReferencesSideMenu();
    }
    @Transactional
    public ReferencesSideMenu setApplicationSideMenu(ReferencesSideMenu sideMenuData)  {
        return referencesSideMenuDao.setReferencesSideMenu(sideMenuData);
    }

}
