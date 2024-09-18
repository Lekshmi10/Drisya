package com.federal.drisyaHome.dao.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.federal.drisyaHome.Logger;
import com.federal.drisyaHome.model.ApplicationSideMenu;
import com.federal.drisyaHome.model.DrisyaTable;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import static com.federal.drisyaHome.Constants.APPLICATION_SIDEMENU;

@Repository
public class ApplicationSideMenuDao {
    @Autowired
    EntityManager entityManager;

    public ApplicationSideMenu getApplicationSideMenu() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("FROM DrisyaTable d WHERE d.section=:section_name And d.id =:id", DrisyaTable.class);
        query.setParameter("section_name", APPLICATION_SIDEMENU);
        query.setParameter("id", 15);
        List<DrisyaTable> drisyaTable = query.getResultList();
        currentSession.close();
        if (drisyaTable.size() == 0) {
            ApplicationSideMenu applicationSideMenu = new ApplicationSideMenu();
            applicationSideMenu.setData(new ArrayList<>());
            return applicationSideMenu;
        } else {
            String section_data = drisyaTable.get(0).getSectionData();
            ObjectMapper mapper = new ObjectMapper();
            ApplicationSideMenu applicationSideMenu = new ApplicationSideMenu();
            try {
                applicationSideMenu = mapper.readValue(section_data, ApplicationSideMenu.class);
            } catch (Exception e) {
                Logger.logger.error("Exception Occured on" + e.getStackTrace());
            }
            return applicationSideMenu;
        }
    }

    public ApplicationSideMenu setApplicationSideMenu(ApplicationSideMenu sideMenuData) {
        try {
            DrisyaTable side_menu = new DrisyaTable();
            side_menu.setId(15);
            side_menu.setSection(APPLICATION_SIDEMENU);
            side_menu.setSectionData(sideMenuData.toString());
            System.out.println("side_menu" + side_menu);
            Session currentSession = entityManager.unwrap(Session.class);
            currentSession.clear();
            currentSession.saveOrUpdate(side_menu);
            currentSession.close();
            return sideMenuData;
        } catch (Exception e) {
            Logger.logger.error("Exception Occured on" + e.getStackTrace());
        }
        return sideMenuData;
    }
}