package com.federal.drisyaHome.service.reference;

import com.federal.drisyaHome.dao.reference.ReferencesWithADLoginDao;
import com.federal.drisyaHome.model.ReferencesWithADLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ReferencesWithADLoginService {
    @Autowired
    ReferencesWithADLoginDao referencesWithADLoginDao;

    @Transactional
    public ReferencesWithADLogin getReferencesAD() {
        return referencesWithADLoginDao.getReferencesAD();
    }

    @Transactional
    public ReferencesWithADLogin setReferencesAD(ReferencesWithADLogin reference) {
        return referencesWithADLoginDao.setReferencesAD(reference);
    }

}
