package com.federal.drisyaHome.service.application;

import com.federal.drisyaHome.dao.application.ExternalLinkDao;
import com.federal.drisyaHome.model.ExternalLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ExternalLinkService {
    @Autowired
    ExternalLinkDao externalLinkDao;


    @Transactional
    public ExternalLink getExternalLink() {
        return externalLinkDao.getExternalLink();

    }
    @Transactional
    public ExternalLink setExternalLink(ExternalLink externalLinkData) {
        return externalLinkDao.setExternalLink(externalLinkData);
    }
}
