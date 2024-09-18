package com.federal.drisyaHome.dao.support;

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

import static com.federal.drisyaHome.Constants.SUPPORT_WITH_AD_LOGIN;


@Repository
public class SupportWithADDao {

    @Autowired
    EntityManager entityManager;

    public SupportWithAD getSupportWithAD() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("FROM DrisyaTable d WHERE d.section=:section_name And d.id =:id", DrisyaTable.class);
        query.setParameter("section_name",SUPPORT_WITH_AD_LOGIN);
        query.setParameter("id",24);
        List<DrisyaTable> drisyaTable = query.getResultList();
        currentSession.close();
        if (drisyaTable.size() == 0){
            SupportWithAD supportWithAD = new SupportWithAD();
            supportWithAD.setData(new ArrayList<>());
            return supportWithAD;
        }
        else {
            String support_with_ad = drisyaTable.get(0).getSectionData();
            ObjectMapper mapper = new ObjectMapper();
            SupportWithAD supportWithAD = new SupportWithAD();
            try {
                supportWithAD = mapper.readValue(support_with_ad, SupportWithAD.class);
            } catch (Exception e) {
                Logger.logger.error("Exception Occured on" + e.getStackTrace());
            }
            return supportWithAD;
        }
    }

    public SupportWithAD setSupportWithAD(SupportWithAD supportWithAD) {
            try{
                DrisyaTable support_with_ad = new DrisyaTable();
                support_with_ad.setId(24);
                support_with_ad.setSection(SUPPORT_WITH_AD_LOGIN);
                support_with_ad.setSectionData(supportWithAD.toString());
                Session currentSession = entityManager.unwrap(Session.class);
                currentSession.clear();
                currentSession.saveOrUpdate(support_with_ad);
                currentSession.close();
                return supportWithAD;
            }catch (Exception e){
                Logger.logger.error("Exception Occured on" + e.getStackTrace());
                return new SupportWithAD();
            }
    }
}
