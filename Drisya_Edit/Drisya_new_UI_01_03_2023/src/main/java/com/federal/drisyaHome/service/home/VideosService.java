package com.federal.drisyaHome.service.home;

import com.federal.drisyaHome.dao.home.VideosDao;
import com.federal.drisyaHome.model.Videos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class VideosService {

    @Autowired
    VideosDao videosDao;

    @Transactional
    public Videos getVideoAds() {
        return videosDao.getVideoAds();
    }

    @Transactional
    public Videos setVideoAds(Videos adsData) {
        return videosDao.setVideoAds(adsData);
    }

}
