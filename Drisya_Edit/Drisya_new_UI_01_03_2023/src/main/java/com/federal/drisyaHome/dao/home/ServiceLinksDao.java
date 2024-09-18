package com.federal.drisyaHome.dao.home;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.federal.drisyaHome.Logger;
import com.federal.drisyaHome.model.DrisyaTable;
import com.federal.drisyaHome.model.ServiceLinks;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import static com.federal.drisyaHome.Constants.HOME_SERVICE_LINKS;

@Repository
public class ServiceLinksDao {
    @Autowired
    EntityManager entityManager;

    public ServiceLinks getServiceLinks() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("FROM DrisyaTable d WHERE d.section=:section_name And d.id =:id", DrisyaTable.class);
        query.setParameter("section_name", HOME_SERVICE_LINKS);
        query.setParameter("id", 11);
        List<DrisyaTable> drisyaTable = query.getResultList();
        currentSession.close();
        if (drisyaTable.size() == 0) {
            ServiceLinks serviceLinks = new ServiceLinks();
            serviceLinks.setTitle("Service Links");
            serviceLinks.setData(new ArrayList<>());
            return serviceLinks;
        } else {
            String section_data = drisyaTable.get(0).getSectionData();
            ObjectMapper mapper = new ObjectMapper();
            ServiceLinks serviceLinks = new ServiceLinks();
            try {
                serviceLinks = mapper.readValue(section_data, ServiceLinks.class);
            } catch (Exception e) {
                Logger.logger.error("Exception Occured on" + e.getStackTrace());
            }
            return serviceLinks;
        }
    }

    public ServiceLinks setServiceLink(ServiceLinks serviceLinks) {
        try {
            DrisyaTable service_links_data = new DrisyaTable();
            service_links_data.setId(11);
            service_links_data.setSection(HOME_SERVICE_LINKS);
            service_links_data.setSectionData(serviceLinks.toString());
            Session currentSession = entityManager.unwrap(Session.class);
            currentSession.clear();
            currentSession.saveOrUpdate(service_links_data);
            currentSession.close();
            return serviceLinks;
        } catch (Exception e) {
            Logger.logger.error("Exception Occured on" + e.getStackTrace());
            return new ServiceLinks();
        }
    }
}
