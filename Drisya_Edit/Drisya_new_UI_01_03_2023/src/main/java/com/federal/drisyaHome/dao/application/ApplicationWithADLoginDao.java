package com.federal.drisyaHome.dao.application;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.federal.drisyaHome.Logger;
import com.federal.drisyaHome.model.*;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import static com.federal.drisyaHome.Constants.APPLICATIONS_WITH_AD_LOGIN;

@Repository
public class ApplicationWithADLoginDao {

    @Autowired
    EntityManager entityManager;

    public ApplicationsWithADLogin getApplications() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("FROM DrisyaTable d WHERE d.section=:section_name And d.id =:id", DrisyaTable.class);
        query.setParameter("section_name", APPLICATIONS_WITH_AD_LOGIN);
        query.setParameter("id", 16);
        List<DrisyaTable> drisyaTable = query.getResultList();
        currentSession.close();
        if (drisyaTable.size() == 0) {
            ApplicationsWithADLogin applicationsWithADLogin = new ApplicationsWithADLogin();
            applicationsWithADLogin.setData(new ArrayList<>());
            return applicationsWithADLogin;
        } else {
            String section_data = drisyaTable.get(0).getSectionData();
            ObjectMapper mapper = new ObjectMapper();
            ApplicationsWithADLogin applicationsWithADLogin = new ApplicationsWithADLogin();
            try {
                applicationsWithADLogin = mapper.readValue(section_data, ApplicationsWithADLogin.class);
            } catch (Exception e) {
                Logger.logger.error("Exception Occured on" + e.getStackTrace());
            }
            return applicationsWithADLogin;
        }
    }

    public ApplicationsWithADLogin setApplication(ApplicationsWithADLogin applicationsWithADLogin) {
        try {
            DrisyaTable applicationsWithAD = new DrisyaTable();
            applicationsWithAD.setId(16);
            applicationsWithAD.setSection(APPLICATIONS_WITH_AD_LOGIN);
            applicationsWithAD.setSectionData(applicationsWithADLogin.toString());
            Session currentSession = entityManager.unwrap(Session.class);
            currentSession.clear();
            currentSession.saveOrUpdate(applicationsWithAD);
            currentSession.close();
            return applicationsWithADLogin;
        } catch (Exception e) {
            Logger.logger.error("Exception Occured on" + e.getStackTrace());
        }
        return applicationsWithADLogin;
    }
}
