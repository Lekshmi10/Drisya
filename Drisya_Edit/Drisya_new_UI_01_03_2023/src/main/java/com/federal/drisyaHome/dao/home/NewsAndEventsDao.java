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

import static com.federal.drisyaHome.Constants.HOME_NEWS_AND_EVENTS;

@Repository
public class NewsAndEventsDao {
    @Autowired
    EntityManager entityManager;


    public NewsAndEvents getNewsAndEvents() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("FROM DrisyaTable d WHERE d.section=:section_name And d.id =:id", DrisyaTable.class);
        query.setParameter("section_name",HOME_NEWS_AND_EVENTS);
        query.setParameter("id",9);
        List<DrisyaTable> drisyaTable = query.getResultList();
        currentSession.close();
        if (drisyaTable.size() == 0){
            NewsAndEvents newsAndEvents = new NewsAndEvents();
            newsAndEvents.setTitle("News And Events");
            newsAndEvents.setData(new ArrayList<>());
            return newsAndEvents;
        }
        else {
            String section_data = drisyaTable.get(0).getSectionData();
            ObjectMapper mapper = new ObjectMapper();
            NewsAndEvents newsAndEvents = new NewsAndEvents();
            try {
                newsAndEvents = mapper.readValue(section_data, NewsAndEvents.class);
            } catch (Exception e) {
                Logger.logger.error("Exception Occured on" + e.getStackTrace());
            }
            return newsAndEvents;
        }
    }

    public NewsAndEvents setNewsAndEvents(NewsAndEvents newsAndEvent) {
        try {
            DrisyaTable newsAndEvent_data = new DrisyaTable();
            newsAndEvent_data.setId(9);
            newsAndEvent_data.setSection(HOME_NEWS_AND_EVENTS);
            newsAndEvent_data.setSectionData(newsAndEvent.toString());
            Session currentSession = entityManager.unwrap(Session.class);
            currentSession.clear();
            currentSession.saveOrUpdate(newsAndEvent_data);
            currentSession.close();
            return newsAndEvent;
        } catch (Exception e) {
            Logger.logger.error("Exception Occured on" + e.getStackTrace());
            return new NewsAndEvents();
        }
    }
}
