package com.federal.drisyaHome.controller.home;

import com.federal.drisyaHome.model.NewsAndEvents;
import com.federal.drisyaHome.service.home.NewsAndEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/newsAndEvents")
public class NewsAndEventsController {
    @Autowired
    NewsAndEventsService newsAndEventsService;

    @GetMapping("/")
    public NewsAndEvents getNewsAndEvents() {
        return newsAndEventsService.getNewsAndEvents();
    }

    @PostMapping("/add")
    public NewsAndEvents setNewsAndEvents(@RequestBody NewsAndEvents newsAndEvent) {
        return newsAndEventsService.setNewsAndEvents(newsAndEvent);
    }
}
