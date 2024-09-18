package com.federal.drisyaHome.dao.home;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.federal.drisyaHome.Logger;
import com.federal.drisyaHome.model.DrisyaTable;
import com.federal.drisyaHome.model.SideMenu;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import static com.federal.drisyaHome.Constants.HOME_SIDEMENU;


@Repository
public class SideMenuDao {
    @Autowired
    EntityManager entityManager;

    public SideMenu setSideMenu(SideMenu contents) {
        try {
            DrisyaTable side_menu = new DrisyaTable();
            side_menu.setId(1);
            side_menu.setSection(HOME_SIDEMENU);
            side_menu.setSectionData(contents.toString());
            Session currentSession = entityManager.unwrap(Session.class);
            currentSession.clear();
            currentSession.saveOrUpdate(side_menu);
            currentSession.close();
            return contents;
        } catch (Exception e) {
            Logger.logger.error("Exception Occured on" + e.getStackTrace());
            return new SideMenu();
        }
    }

    public SideMenu fetchSideMenu() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("FROM DrisyaTable d WHERE d.section=:section_name And d.id =:id", DrisyaTable.class);
        query.setParameter("section_name", HOME_SIDEMENU);
        query.setParameter("id", 1);
        List<DrisyaTable> drisyaTable = query.getResultList();
        currentSession.close();
        if (drisyaTable.size() == 0) {

            SideMenu sideMenu = new SideMenu();
            sideMenu.setData(new ArrayList<>());
            return sideMenu;
        } else {
            String section_data = drisyaTable.get(0).getSectionData();
            ObjectMapper mapper = new ObjectMapper();
            SideMenu sideMenu = new SideMenu();
            try {
                sideMenu = mapper.readValue(section_data, SideMenu.class);
            } catch (Exception e) {
                Logger.logger.error("Exception Occured on" + e.getStackTrace());
            }
            return sideMenu;
        }
    }
}
