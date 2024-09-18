package com.federal.drisyaHome.service.application;

import com.federal.drisyaHome.dao.application.ApplicationsDao;
import com.federal.drisyaHome.model.Applications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ApplicationsService {
    @Autowired
    ApplicationsDao applicationsDao;

    @Transactional
    public Applications getApplications() {
        return applicationsDao.getApplications();
    }

    @Transactional
    public Applications setApplication(Applications application) {
        return applicationsDao.setApplication(application);
    }
}
