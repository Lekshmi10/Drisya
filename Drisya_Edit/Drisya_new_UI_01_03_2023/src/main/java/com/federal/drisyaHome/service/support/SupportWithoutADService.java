package com.federal.drisyaHome.service.support;


import com.federal.drisyaHome.dao.support.SupportWithoutADDao;
import com.federal.drisyaHome.model.SupportWithoutAD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class SupportWithoutADService {
    @Autowired
    SupportWithoutADDao supportWithoutADDao;

    @Transactional
    public SupportWithoutAD getSupport() {
        return supportWithoutADDao.getSupport();
    }

    @Transactional
    public SupportWithoutAD setSupport(SupportWithoutAD support) {
        return supportWithoutADDao.setSupportAD(support);
    }

}
