package com.federal.drisyaHome.service.home;

import com.federal.drisyaHome.dao.home.ServiceLinksDao;
import com.federal.drisyaHome.model.ServiceLinks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ServiceLinksService {
    @Autowired
    ServiceLinksDao serviceLinksDao;

    @Transactional
    public ServiceLinks getServiceLinks() {
        return serviceLinksDao.getServiceLinks();
    }

    @Transactional
    public ServiceLinks setServiceLink(ServiceLinks serviceLinks) {
        return serviceLinksDao.setServiceLink(serviceLinks);
    }
}
