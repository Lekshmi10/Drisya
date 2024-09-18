package com.federal.drisyaHome.controller.home;

import com.federal.drisyaHome.model.Videos;
import com.federal.drisyaHome.service.home.VideosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/videos")
public class VideosController {
    @Autowired
    VideosService videosService;

    @GetMapping("/")
    public Videos getVideoAds() {
        return videosService.getVideoAds();
    }

    @PostMapping("/add")
    public Videos setVideoAds(@RequestBody Videos adsData) {
        return videosService.setVideoAds(adsData);
    }

}
