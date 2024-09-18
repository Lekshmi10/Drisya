package com.federal.drisyaHome.service.reference;

import com.federal.drisyaHome.dao.reference.ArchivesDao;
import com.federal.drisyaHome.model.Archives;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ArchivesService {
    @Autowired
    ArchivesDao archivesDao;

    @Transactional
    public Archives getArchives() {
        return archivesDao.getArchives();
    }

    @Transactional
    public Archives setArchives(Archives archives) {
        return archivesDao.setArchives(archives);
    }

}
