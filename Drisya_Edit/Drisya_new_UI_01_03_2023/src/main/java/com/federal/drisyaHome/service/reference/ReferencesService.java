package com.federal.drisyaHome.service.reference;

import com.federal.drisyaHome.dao.reference.ReferencesDao;
import com.federal.drisyaHome.model.References;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReferencesService {
    @Autowired
    ReferencesDao referencesDao;

    @Transactional
    public References getReferences() {
        return referencesDao.getReferences();
    }
    @Transactional
    public References setReferences(References reference)  {
        return referencesDao.setReferences(reference);
    }

}
