package com.federal.drisyaHome.dao.support;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.federal.drisyaHome.Logger;
import com.federal.drisyaHome.model.DrisyaTable;
import com.federal.drisyaHome.model.SupportSideMenu;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import static com.federal.drisyaHome.Constants.SUPPORT_SIDEMENU;

@Repository
public class SupportSideMenuDao {
    @Autowired
    EntityManager entityManager;


    public SupportSideMenu getSupportSideMenu() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("FROM DrisyaTable d WHERE d.section=:section_name And d.id =:id", DrisyaTable.class);
        query.setParameter("section_name", SUPPORT_SIDEMENU);
        query.setParameter("id", 8);
        List<DrisyaTable> drisyaTable = query.getResultList();
        currentSession.close();
        if (drisyaTable.size() == 0) {
            SupportSideMenu supportSideMenu = new SupportSideMenu();
            supportSideMenu.setData(new ArrayList<>());
            return supportSideMenu;
        } else {
            String section_data = drisyaTable.get(0).getSectionData();
            ObjectMapper mapper = new ObjectMapper();
            SupportSideMenu supportSideMenu = new SupportSideMenu();
            try {
                supportSideMenu = mapper.readValue(section_data, SupportSideMenu.class);
            } catch (Exception e) {
                Logger.logger.error("Exception Occured on" + e.getStackTrace());
            }
            return supportSideMenu;
        }
    }

    public SupportSideMenu setSupportSideMenu(SupportSideMenu supportSideMenu) {
        try {
            DrisyaTable side_menu = new DrisyaTable();
            side_menu.setId(8);
            side_menu.setSection(SUPPORT_SIDEMENU);
            side_menu.setSectionData(supportSideMenu.toString());
            System.out.println("side_menu" + side_menu);
            Session currentSession = entityManager.unwrap(Session.class);
            currentSession.clear();
            currentSession.saveOrUpdate(side_menu);
            currentSession.close();
            return supportSideMenu;
        } catch (Exception e) {
            Logger.logger.error("Exception Occured on" + e.getStackTrace());
        }
        return supportSideMenu;
    }
}
