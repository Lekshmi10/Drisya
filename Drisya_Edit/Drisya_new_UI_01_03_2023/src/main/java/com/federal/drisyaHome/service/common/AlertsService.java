package com.federal.drisyaHome.service.common;

import com.federal.drisyaHome.dao.common.AlertsDao;
import com.federal.drisyaHome.model.Alerts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AlertsService {
    @Autowired
    AlertsDao alertsDao;

    @Transactional
    public Alerts getNotification() {
        return alertsDao.getNotification();
    }

    @Transactional
    public Alerts setNotification(Alerts alertsData) {
        return alertsDao.setNotification(alertsData);
    }
}
