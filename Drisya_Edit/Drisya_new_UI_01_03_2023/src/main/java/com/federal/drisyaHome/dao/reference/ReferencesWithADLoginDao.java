package com.federal.drisyaHome.dao.reference;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.federal.drisyaHome.Logger;
import com.federal.drisyaHome.model.DrisyaTable;
import com.federal.drisyaHome.model.ReferencesWithADLogin;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import static com.federal.drisyaHome.Constants.REFERENCES_WITH_ADLOGIN;

@Repository
public class ReferencesWithADLoginDao {

    @Autowired
    EntityManager entityManager;

    public ReferencesWithADLogin getReferencesAD() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("FROM DrisyaTable d WHERE d.section=:section_name And d.id =:id", DrisyaTable.class);
        query.setParameter("section_name", REFERENCES_WITH_ADLOGIN);
        query.setParameter("id", 23);
        List<DrisyaTable> drisyaTable = query.getResultList();
        currentSession.close();
        if (drisyaTable.size() == 0) {
            ReferencesWithADLogin referencesWithADLogin = new ReferencesWithADLogin();
            referencesWithADLogin.setData(new ArrayList<>());
            return referencesWithADLogin;
        } else {
            String section_data = drisyaTable.get(0).getSectionData();
            ObjectMapper mapper = new ObjectMapper();
            ReferencesWithADLogin referencesWithADLogin = new ReferencesWithADLogin();
            try {
                referencesWithADLogin = mapper.readValue(section_data, ReferencesWithADLogin.class);
            } catch (Exception e) {
                Logger.logger.error("Exception Occured on" + e.getStackTrace());
            }
            return referencesWithADLogin;
        }
    }

    public ReferencesWithADLogin setReferencesAD(ReferencesWithADLogin referencesWithADLogin) {
        try{
            DrisyaTable referenceWithAD = new DrisyaTable();
            referenceWithAD.setId(23);
            referenceWithAD.setSection(REFERENCES_WITH_ADLOGIN);
            referenceWithAD.setSectionData(referencesWithADLogin.toString());
            Session currentSession = entityManager.unwrap(Session.class);
            currentSession.clear();
            currentSession.saveOrUpdate(referenceWithAD);
            currentSession.close();
            return referencesWithADLogin;
        }catch (Exception e){
            Logger.logger.error("Exception Occured on" + e.getStackTrace());
        }
        return referencesWithADLogin;
    }
}