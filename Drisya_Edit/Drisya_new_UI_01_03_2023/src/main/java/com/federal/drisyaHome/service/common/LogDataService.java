package com.federal.drisyaHome.service.common;

import com.federal.drisyaHome.dao.common.LogDataDao;
import com.federal.drisyaHome.model.LogData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogDataService {
    @Autowired
    LogDataDao logDataDao;

    public List<LogData> fetchLogData() {
        return logDataDao.fetchLogData();
    }

}
