package com.federal.drisyaHome.service.home;

import com.federal.drisyaHome.dao.home.BlurbDao;
import com.federal.drisyaHome.model.Blurb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BlurbService {
    @Autowired
    BlurbDao blurbDao;

    @Transactional
    public Blurb getBlurb() {
        return blurbDao.getBlurb();
    }

    @Transactional
    public Blurb setBlurb(Blurb datas) {
        return blurbDao.setBlurb(datas);
    }

}
