package com.federal.drisyaHome.service.common;

import com.federal.drisyaHome.dao.common.FooterDao;
import com.federal.drisyaHome.model.Footer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class FooterService {
    @Autowired
    FooterDao footerDao;

    @Transactional
    public Footer getFooter() {
        return footerDao.getFooter();
    }

    @Transactional
    public Footer setFooter(Footer footerData) {
        return footerDao.setFooter(footerData);
    }
}
