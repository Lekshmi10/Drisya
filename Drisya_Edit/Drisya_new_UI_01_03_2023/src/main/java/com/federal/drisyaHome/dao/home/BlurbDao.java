package com.federal.drisyaHome.dao.home;

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

import static com.federal.drisyaHome.Constants.HOME_BLURBS;

@Repository
public class BlurbDao {


    @Autowired
    EntityManager entityManager;


    public Blurb getBlurb(){
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("FROM DrisyaTable d WHERE d.section=:section_name And d.id =:id", DrisyaTable.class);
        query.setParameter("section_name",HOME_BLURBS);
        query.setParameter("id",3);
        List<DrisyaTable> drisyaTable = query.getResultList();
        currentSession.close();
        if (drisyaTable.size() == 0){
            Blurb blurb = new Blurb();
            blurb.setData(new ArrayList<>());
            return blurb;
        }
        else {
            String section_data = drisyaTable.get(0).getSectionData();
            ObjectMapper mapper = new ObjectMapper();
            Blurb blurbs = new Blurb();
            try {
                blurbs = mapper.readValue(section_data, Blurb.class);
            } catch (Exception e) {
                Logger.logger.error("Exception Occured on" + e.getStackTrace());
            }
            return blurbs;
        }
    }

    public Blurb setBlurb(Blurb datas) {
        try {
            DrisyaTable blurbs_data = new DrisyaTable();
            blurbs_data.setId(3);
            blurbs_data.setSection(HOME_BLURBS);
            blurbs_data.setSectionData(datas.toString());
            Session currentSession = entityManager.unwrap(Session.class);
            currentSession.clear();
            currentSession.saveOrUpdate(blurbs_data);
            currentSession.close();
            return datas;
        } catch (Exception e) {
            Logger.logger.error("Exception Occured on" + e.getStackTrace());
            return new Blurb();
        }
    }
}
