package com.federal.drisyaHome.service.support;

import com.federal.drisyaHome.dao.support.SupportWithADDao;
import com.federal.drisyaHome.model.SupportWithAD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class SupportWithADService {
    @Autowired
    SupportWithADDao supportWithADDao;

    @Transactional
    public SupportWithAD getSupportWithAD() {
        return supportWithADDao.getSupportWithAD();
    }

    @Transactional
    public SupportWithAD setSupportWithAD(SupportWithAD supportWithAD) {
        return supportWithADDao.setSupportWithAD(supportWithAD);
    }
}