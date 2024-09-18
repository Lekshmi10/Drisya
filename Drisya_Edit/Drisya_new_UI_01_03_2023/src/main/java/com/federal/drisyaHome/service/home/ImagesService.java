package com.federal.drisyaHome.service.home;

import com.federal.drisyaHome.dao.home.ImagesDao;
import com.federal.drisyaHome.model.Images;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ImagesService {
    @Autowired
    ImagesDao imagesDao;

    @Transactional
    public Images getImages() {
        return imagesDao.getImages();
    }

    @Transactional
    public Images setImage(Images image) {
        return imagesDao.setImage(image);
    }

}
