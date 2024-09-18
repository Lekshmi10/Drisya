package com.federal.drisyaHome.dao.home;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.federal.drisyaHome.Logger;
import com.federal.drisyaHome.model.AnnouncementFiles;
import com.federal.drisyaHome.model.CircularFiles;
import com.federal.drisyaHome.model.Circulars;
import com.federal.drisyaHome.model.DrisyaTable;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import static com.federal.drisyaHome.Constants.HOME_CIRCULARS;

@Repository
public class CircularsDao {

    @Autowired
    private EntityManager entityManager;

    public Circulars fetchCirculars() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("FROM DrisyaTable d WHERE d.section=:section_name And d.id =:id", DrisyaTable.class);
        query.setParameter("section_name", HOME_CIRCULARS);
        query.setParameter("id", 25);
        List<DrisyaTable> drisyaTable = query.getResultList();
        currentSession.close();
        if (drisyaTable.size() == 0) {
            Circulars circulars = new Circulars();
            circulars.setTitle("Circulars");
            circulars.setData(new ArrayList<>());
            return circulars;
        } else {
            String section_data = drisyaTable.get(0).getSectionData();
            ObjectMapper mapper = new ObjectMapper();
            Circulars circulars = new Circulars();
            try {
                circulars = mapper.readValue(section_data, Circulars.class);
            } catch (Exception e) {
                Logger.logger.error("Exception Occured on" + e.getStackTrace());
            }
            return circulars;
        }
    }

    public Circulars setCirculars(Circulars circulars) {
        try {
            DrisyaTable circular_data = new DrisyaTable();
            circular_data.setId(25);
            circular_data.setSection(HOME_CIRCULARS);
            circular_data.setSectionData(circulars.toString());
            Session currentSession = entityManager.unwrap(Session.class);
            currentSession.clear();
            currentSession.saveOrUpdate(circular_data);
            currentSession.close();
            return circulars;
        } catch (Exception e) {
            Logger.logger.error("Exception Occured on" + e.getStackTrace());
            return new Circulars();
        }
    }
    public CircularFiles fetchFile(String circularHeadline) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("FROM CircularFiles as c WHERE c.id=:circularHeadline", CircularFiles.class);
        query.setParameter("circularHeadline",circularHeadline.toUpperCase());
        List<CircularFiles> circularFiles = query.getResultList();
        currentSession.close();
        return circularFiles.get(0);
    }

    public void uploadFile(CircularFiles circularFiles) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.clear();
        currentSession.saveOrUpdate(circularFiles);
        currentSession.close();
    }
    public String deleteFile(String circularHeadline) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.clear();
        CircularFiles circularFiles = (CircularFiles) currentSession.get(CircularFiles.class, circularHeadline.toUpperCase());
        currentSession.delete(circularFiles);
        currentSession.close();
        return "File deleted";
    }
}
