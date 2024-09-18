package com.federal.drisyaHome.dao.reference;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.federal.drisyaHome.Logger;
import com.federal.drisyaHome.model.DrisyaTable;
import com.federal.drisyaHome.model.ReferencesSideMenu;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import static com.federal.drisyaHome.Constants.REFERENCE_SIDEMENU;

@Repository
public class ReferencesSideMenuDao {

    @Autowired
    EntityManager entityManager;

    public ReferencesSideMenu getReferencesSideMenu() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("FROM DrisyaTable d WHERE d.section=:section_name And d.id =:id", DrisyaTable.class);
        query.setParameter("section_name", REFERENCE_SIDEMENU);
        query.setParameter("id", 22);
        List<DrisyaTable> drisyaTable = query.getResultList();
        currentSession.close();
        if (drisyaTable.size() == 0) {
            ReferencesSideMenu referencesSideMenu = new ReferencesSideMenu();
            referencesSideMenu.setData(new ArrayList<>());
            return referencesSideMenu;
        } else {
            String section_data = drisyaTable.get(0).getSectionData();
            ObjectMapper mapper = new ObjectMapper();
            ReferencesSideMenu referencesSideMenu = new ReferencesSideMenu();
            try {
                referencesSideMenu = mapper.readValue(section_data, ReferencesSideMenu.class);
            } catch (Exception e) {
                Logger.logger.error("Exception Occured on" + e.getStackTrace());
            }
            return referencesSideMenu;
        }
    }

    public ReferencesSideMenu setReferencesSideMenu(ReferencesSideMenu referencesSideMenu) {
        try{
            DrisyaTable referenceSide = new DrisyaTable();
            referenceSide.setId(22);
            referenceSide.setSection(REFERENCE_SIDEMENU);
            referenceSide.setSectionData(referencesSideMenu.toString());
            Session currentSession = entityManager.unwrap(Session.class);
            currentSession.clear();
            currentSession.saveOrUpdate(referenceSide);
            currentSession.close();
            return referencesSideMenu;
        }catch (Exception e){
            Logger.logger.error("Exception Occured on" + e.getStackTrace());
        }
        return referencesSideMenu;
    }
}
