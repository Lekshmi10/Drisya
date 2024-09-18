package com.federal.drisyaHome.service.home;

import com.federal.drisyaHome.dao.home.MiscellaneousDao;
import com.federal.drisyaHome.model.Miscellaneous;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MiscellaneousService {

    @Autowired
    MiscellaneousDao miscellaneousDao;


    @Transactional
    public Miscellaneous getMiscellaneous() {
        return miscellaneousDao.getMiscellaneous();
    }

    @Transactional
    public Miscellaneous setMiscellaneous(Miscellaneous adsData) {
        return miscellaneousDao.setMiscellaneous(adsData);
    }
}
