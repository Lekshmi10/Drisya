package com.federal.drisyaHome.service.home;

import com.federal.drisyaHome.dao.home.BlurbDao;
import com.federal.drisyaHome.dao.home.MusicDao;
import com.federal.drisyaHome.model.Blurb;
import com.federal.drisyaHome.model.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MusicService {

    @Autowired
    MusicDao musicDao;

    @Transactional
    public Music getMusic(){
        return musicDao.getMusic();

    }

    @Transactional
    public Music setMusic(Music music){

        return musicDao.setMusic(music);
    }


}


