package com.federal.drisyaHome.dao.reference;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.federal.drisyaHome.Logger;
import com.federal.drisyaHome.model.DrisyaTable;
import com.federal.drisyaHome.model.References;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import static com.federal.drisyaHome.Constants.REFERENCES_WITHOUT_ADLOGIN;

@Repository
public class ReferencesDao {

    @Autowired
    EntityManager entityManager;

    public References getReferences() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("FROM DrisyaTable d WHERE d.section=:section_name And d.id =:id", DrisyaTable.class);
        query.setParameter("section_name", REFERENCES_WITHOUT_ADLOGIN);
        query.setParameter("id", 21);
        List<DrisyaTable> drisyaTable = query.getResultList();
        currentSession.close();
        if (drisyaTable.size() == 0) {
            References references = new References();
            references.setData(new ArrayList<>());
            return references;
        } else {
            String section_data = drisyaTable.get(0).getSectionData();
            ObjectMapper mapper = new ObjectMapper();
            References references = new References();
            try {
                references = mapper.readValue(section_data, References.class);
            } catch (Exception e) {
                Logger.logger.error("Exception Occured on" + e.getStackTrace());
            }
            return references;
        }
    }

    public References setReferences(References references) {
        try{
            DrisyaTable referenceMenu = new DrisyaTable();
            referenceMenu.setId(21);
            referenceMenu.setSection(REFERENCES_WITHOUT_ADLOGIN);
            referenceMenu.setSectionData(references.toString());
            Session currentSession = entityManager.unwrap(Session.class);
            currentSession.clear();
            currentSession.saveOrUpdate(referenceMenu);
            currentSession.close();
            return references;
        }catch (Exception e){
            Logger.logger.error("Exception Occured on" + e.getStackTrace());
        }
        return references;
    }
}


