package com.federal.drisyaHome.dao.common;

import com.federal.drisyaHome.model.DrisyaTable;
import com.federal.drisyaHome.model.LogData;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Repository
public class LogDataDao {


    @Autowired
    EntityManager entityManager;


    public List<LogData> fetchLogData() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("FROM LogData", LogData.class);
        List<LogData> logData = query.getResultList();
        currentSession.close();
        if (logData.size() == 0) {
            return new ArrayList<>();
        } else {
            return logData;
        }
    }

    public void saveLogData(String name, String designation, String department, String page, String section, String data) {
        LogData logData = new LogData();
        logData.setUsername(name);
        logData.setDesignation(designation);
        logData.setDepartment(department);
        Date date = new Date(System.currentTimeMillis());
        logData.setTime(date.toString());
        logData.setPage(page);
        logData.setSection(section);
        logData.setData(data);
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(logData);
        currentSession.close();
    }    
}



