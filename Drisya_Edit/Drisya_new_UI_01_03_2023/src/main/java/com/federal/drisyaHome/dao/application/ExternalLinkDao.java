package com.federal.drisyaHome.dao.application;
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

import static com.federal.drisyaHome.Constants.APPLICATION_EXTERNAL_LINK;

@Repository
public class ExternalLinkDao {

    @Autowired
    EntityManager entityManager;

    public ExternalLink getExternalLink() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("FROM DrisyaTable d WHERE d.section=:section_name And d.id =:id", DrisyaTable.class);
        query.setParameter("section_name", APPLICATION_EXTERNAL_LINK);
        query.setParameter("id", 5);
        List<DrisyaTable> drisyaTable = query.getResultList();
        currentSession.close();
        if (drisyaTable.size() == 0) {
            ExternalLink externalLink = new ExternalLink();
            externalLink.setTitle("External Link");
            externalLink.setData(new ArrayList<>());
            return externalLink;
        } else {
            String section_data = drisyaTable.get(0).getSectionData();
            ObjectMapper mapper = new ObjectMapper();
            ExternalLink externalLink = new ExternalLink();
            try {
                externalLink = mapper.readValue(section_data, ExternalLink.class);
            } catch (Exception e) {
                Logger.logger.error("Exception Occured on" + e.getStackTrace());
            }
            return externalLink;
        }
    }

    public ExternalLink setExternalLink(ExternalLink externalLinkData) {
        try {
            DrisyaTable external_link_Data = new DrisyaTable();
            external_link_Data.setId(5);
            external_link_Data.setSection(APPLICATION_EXTERNAL_LINK);
            external_link_Data.setSectionData(externalLinkData.toString());
            Session currentSession = entityManager.unwrap(Session.class);
            currentSession.clear();
            currentSession.saveOrUpdate(external_link_Data);
            currentSession.close();
            return externalLinkData;
        } catch (Exception e) {
            Logger.logger.error("Exception Occured on" + e.getStackTrace());
            return new ExternalLink();
        }
    }
}