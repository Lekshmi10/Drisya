package com.federal.drisyaHome.dao.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.federal.drisyaHome.model.*;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.util.ArrayList;
import java.util.List;

import static com.federal.drisyaHome.Constants.APPLICATIONS_WITHOUT_AD;


@Repository
public class ApplicationsDao {

    @Autowired
    EntityManager entityManager;

    public Applications getApplications() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("FROM DrisyaTable d WHERE d.section=:section_name And d.id =:id", DrisyaTable.class);
        query.setParameter("section_name", APPLICATIONS_WITHOUT_AD);
        query.setParameter("id", 14);
        List<DrisyaTable> drisyaTable = query.getResultList();
        currentSession.close();
        if (drisyaTable.size() == 0) {
            Applications applications = new Applications();
            applications.setData(new ArrayList<>());
            return applications;
        } else {
            String section_data = drisyaTable.get(0).getSectionData();
            ObjectMapper mapper = new ObjectMapper();
            Applications applications = new Applications();
            try {
                applications = mapper.readValue(section_data, Applications.class);
            } catch (Exception e) {
                return new Applications();
            }
            return applications;
        }
    }

    public Applications setApplication(Applications application) {
        try {
            DrisyaTable applicationMenu = new DrisyaTable();
            applicationMenu.setId(14);
            applicationMenu.setSection(APPLICATIONS_WITHOUT_AD);
            applicationMenu.setSectionData(application.toString());
            Session currentSession = entityManager.unwrap(Session.class);
            currentSession.clear();
            currentSession.saveOrUpdate(applicationMenu);
            currentSession.close();
            return application;
        } catch (Exception e) {
            return new Applications();
        }
    }
}