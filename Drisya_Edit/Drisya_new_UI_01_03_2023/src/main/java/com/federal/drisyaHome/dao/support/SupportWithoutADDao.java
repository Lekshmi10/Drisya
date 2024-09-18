package com.federal.drisyaHome.dao.support;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.federal.drisyaHome.Logger;
import com.federal.drisyaHome.model.DrisyaTable;
import com.federal.drisyaHome.model.SupportWithoutAD;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import static com.federal.drisyaHome.Constants.SUPPORT_WITHOUT_AD_LOGIN;


@Repository
public class SupportWithoutADDao {

    @Autowired
    EntityManager entityManager;

    public SupportWithoutAD getSupport() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("FROM DrisyaTable d WHERE d.section=:section_name And d.id =:id", DrisyaTable.class);
        query.setParameter("section_name",SUPPORT_WITHOUT_AD_LOGIN);
        query.setParameter("id",13);
        List<DrisyaTable> drisyaTable = query.getResultList();
        currentSession.close();
        if (drisyaTable.size() == 0){
            SupportWithoutAD supportWithoutAD = new SupportWithoutAD();
            supportWithoutAD.setData(new ArrayList<>());
            return supportWithoutAD;
        }
        else {
            String support_without_ad = drisyaTable.get(0).getSectionData();
            ObjectMapper mapper = new ObjectMapper();
            SupportWithoutAD supportWithoutAD = new SupportWithoutAD();
            try {
                supportWithoutAD = mapper.readValue(support_without_ad, SupportWithoutAD.class);
            } catch (Exception e) {
                Logger.logger.error("Exception Occured on" + e.getStackTrace());
            }
            return supportWithoutAD;
        }
    }

    public SupportWithoutAD setSupportAD(SupportWithoutAD support) {
        try{
            DrisyaTable support_without_ad = new DrisyaTable();
            support_without_ad.setId(13);
            support_without_ad.setSection(SUPPORT_WITHOUT_AD_LOGIN);
            support_without_ad.setSectionData(support.toString());
            Session currentSession = entityManager.unwrap(Session.class);
            currentSession.clear();
            currentSession.saveOrUpdate(support_without_ad);
            currentSession.close();
            return support;
        }catch (Exception e){
            Logger.logger.error("Exception Occured on" + e.getStackTrace());
            return new SupportWithoutAD();
        }
    }
}
