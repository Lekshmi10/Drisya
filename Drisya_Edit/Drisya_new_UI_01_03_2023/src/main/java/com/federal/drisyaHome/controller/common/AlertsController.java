package com.federal.drisyaHome.controller.common;

import com.federal.drisyaHome.model.Alerts;
import com.federal.drisyaHome.service.common.AlertsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/alerts")
public class AlertsController {
    @Autowired
    AlertsService alertsService;

    @GetMapping("/")
    public Alerts getNotification() {
        return alertsService.getNotification();
    }

    @PostMapping("/add")
    public Alerts setNotification(@RequestBody Alerts alertsData) {
        return alertsService.setNotification(alertsData);
    }
}

