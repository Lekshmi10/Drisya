package com.federal.drisyaHome.dao.common;

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

import static com.federal.drisyaHome.Constants.ALERTS;

@Repository
public class AlertsDao {

    @Autowired
    EntityManager entityManager;


    public Alerts getNotification() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("FROM DrisyaTable d WHERE d.section=:section_name And d.id =:id", DrisyaTable.class);
        query.setParameter("section_name", ALERTS);
        query.setParameter("id", 19);
        List<DrisyaTable> drisyaTable = query.getResultList();
        currentSession.close();
        if (drisyaTable.size() == 0) {
            Alerts alerts = new Alerts();
            alerts.setAlerts(new ArrayList<>());
            return alerts;
        } else {
            String alerts_data = drisyaTable.get(0).getSectionData();
            ObjectMapper mapper = new ObjectMapper();
            Alerts alerts = new Alerts();
            try {
                alerts = mapper.readValue(alerts_data, Alerts.class);
            } catch (Exception e) {
                Logger.logger.error("Exception Occured on" + e.getStackTrace());
            }
            return alerts;
        }

    }

    public Alerts setNotification(Alerts alertsData) {
        try {
            DrisyaTable alerts_data = new DrisyaTable();
            alerts_data.setId(19);
            alerts_data.setSection(ALERTS);
            alerts_data.setSectionData(alertsData.toString());
            Session currentSession = entityManager.unwrap(Session.class);
            currentSession.clear();
            currentSession.saveOrUpdate(alerts_data);
            currentSession.close();
            return alertsData;
        } catch (Exception e) {
            Logger.logger.error("Exception Occured on" + e.getStackTrace());
            return new Alerts();
        }
    }
}