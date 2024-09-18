package com.federal.drisyaHome.service.home;

import com.federal.drisyaHome.dao.home.NewsAndEventsDao;
import com.federal.drisyaHome.model.NewsAndEvents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class NewsAndEventsService {
    @Autowired
    NewsAndEventsDao newsAndEventsDao;

    @Transactional
    public NewsAndEvents getNewsAndEvents() {
        return newsAndEventsDao.getNewsAndEvents();
    }

    @Transactional
    public NewsAndEvents setNewsAndEvents(NewsAndEvents newsAndEvent) {
        return newsAndEventsDao.setNewsAndEvents(newsAndEvent);
    }
}
