package com.federal.drisyaHome.controller.common;

import com.federal.drisyaHome.model.LogData;
import com.federal.drisyaHome.service.common.LogDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LogDataController {
    @Autowired
    LogDataService logDataService;
    @GetMapping("/logData")
    @Transactional
    public List<LogData> fetchLogData(){
        return logDataService.fetchLogData();
    }

}
