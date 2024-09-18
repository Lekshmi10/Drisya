package com.federal.drisyaHome.service.application;

import com.federal.drisyaHome.dao.application.ApplicationWithADLoginDao;
import com.federal.drisyaHome.model.ApplicationsWithADLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ApplicationWithADLoginService {

    @Autowired
    ApplicationWithADLoginDao applicationWithAdLoginDao;

    public ApplicationsWithADLogin getApplications() {
        return applicationWithAdLoginDao.getApplications();
    }

    @Transactional
    public ApplicationsWithADLogin setApplication(ApplicationsWithADLogin applicationData) {
        return applicationWithAdLoginDao.setApplication(applicationData);
    }

}
