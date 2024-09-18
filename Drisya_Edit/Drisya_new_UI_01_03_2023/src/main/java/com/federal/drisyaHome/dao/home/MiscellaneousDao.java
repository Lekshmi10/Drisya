package com.federal.drisyaHome.dao.home;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.federal.drisyaHome.model.DrisyaTable;
import com.federal.drisyaHome.model.Miscellaneous;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import static com.federal.drisyaHome.Constants.HOME_MISCELLANEOUS;

@Repository
public class MiscellaneousDao {

    @Autowired
    EntityManager entityManager;


    public Miscellaneous getMiscellaneous() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("FROM DrisyaTable d WHERE d.section=:section_name And d.id =:id", DrisyaTable.class);
        query.setParameter("section_name", HOME_MISCELLANEOUS);
        query.setParameter("id", 7);
        List<DrisyaTable> drisyaTable = query.getResultList();
        currentSession.close();
        if (drisyaTable.size() == 0) {
            Miscellaneous miscellaneous = new Miscellaneous();
            miscellaneous.setData(new ArrayList<>());
            return miscellaneous;
        } else {
            String section_data = drisyaTable.get(0).getSectionData();
            ObjectMapper mapper = new ObjectMapper();
            Miscellaneous miscellaneous = new Miscellaneous();
            try {
                miscellaneous = mapper.readValue(section_data, Miscellaneous.class);
                return miscellaneous;
            } catch (Exception e) {
                return new Miscellaneous();
            }
        }
    }


    public Miscellaneous setMiscellaneous(Miscellaneous miscellaneous) {
        try {
            DrisyaTable miscellaneous_data = new DrisyaTable();
            miscellaneous_data.setId(7);
            miscellaneous_data.setSection(HOME_MISCELLANEOUS);
            miscellaneous_data.setSectionData(miscellaneous.toString());
            Session currentSession = entityManager.unwrap(Session.class);
            currentSession.clear();
            currentSession.saveOrUpdate(miscellaneous_data);
            currentSession.close();
            return miscellaneous;
        } catch (Exception e) {
            return new Miscellaneous();
        }
    }
}