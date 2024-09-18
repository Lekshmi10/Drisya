package com.federal.drisyaHome.service.home;

import com.federal.drisyaHome.dao.home.CircularsDao;
import com.federal.drisyaHome.model.CircularFiles;
import com.federal.drisyaHome.model.Circulars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CircularsService {

    @Autowired
    CircularsDao circularsDao;

    @Transactional
    public Circulars getCirculars() {
        return circularsDao.fetchCirculars();
    }

    @Transactional
    public Circulars addCirculars(Circulars circulars) {
        return circularsDao.setCirculars(circulars);
    }


    @Transactional
    public CircularFiles fetchFile(String circularHeadline) {
        return circularsDao.fetchFile(circularHeadline);
    }

    @Transactional
    public void uploadFile(CircularFiles circularFiles) {
        circularsDao.uploadFile(circularFiles);
    }

    @Transactional
    public String deleteFile(String circularHeadLine) {
        return circularsDao.deleteFile(circularHeadLine);
    }
}
