package com.federal.drisyaHome.service.home;
//import com.federal.drisyaHome.JsonConfig;
import com.federal.drisyaHome.dao.home.MustReadDao;
import com.federal.drisyaHome.model.MustRead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
public class MustReadService {

	 @Autowired
	    MustReadDao mustReadDao;
	  /*  @Autowired
	    JsonConfig jsonConfig; */


	    @Transactional
	    public MustRead getMustReadContents() {
	        return mustReadDao.getMustReadContents();
	    }

	    @Transactional
	    public MustRead setMustReadContents(MustRead mustReadData) {
	        return mustReadDao.setMustReadContents(mustReadData);
	    }
	  
}
