package com.federal.drisyaHome.dao.reference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.federal.drisyaHome.Logger;
import com.federal.drisyaHome.model.Archives;
import com.federal.drisyaHome.model.DrisyaTable;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import static com.federal.drisyaHome.Constants.REFERENCE_ARCHIVES;

@Repository
public class ArchivesDao {
    @Autowired
    EntityManager entityManager;

    public Archives getArchives() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("FROM DrisyaTable d WHERE d.section=:section_name And d.id =:id", DrisyaTable.class);
        query.setParameter("section_name", REFERENCE_ARCHIVES);
        query.setParameter("id", 18);
        List<DrisyaTable> drisyaTable = query.getResultList();
        currentSession.close();
        if (drisyaTable.size() == 0) {
            Archives archives = new Archives();
            archives.setArchives(new ArrayList<>());
            return archives;
        } else {
            String section_data = drisyaTable.get(0).getSectionData();
            ObjectMapper mapper = new ObjectMapper();
            Archives archives = new Archives();
            try {
                archives = mapper.readValue(section_data, Archives.class);
            } catch (Exception e) {
                Logger.logger.error("Exception Occured on" + e.getStackTrace());
            }
            return archives;
        }
    }

    public Archives setArchives(Archives archives) {
        try{
            DrisyaTable archivesMenu = new DrisyaTable();
            archivesMenu.setId(18);
            archivesMenu.setSection(REFERENCE_ARCHIVES);
            archivesMenu.setSectionData(archives.toString());
            Session currentSession = entityManager.unwrap(Session.class);
            currentSession.clear();
            currentSession.saveOrUpdate(archivesMenu);
            currentSession.close();
            return archives;
        }catch (Exception e){
            Logger.logger.error("Exception Occured on" + e.getStackTrace());
        }
        return archives;
    }
}