package com.federal.drisyaHome.service.home;

import com.federal.drisyaHome.dao.home.EmployeeSearchDao;
import com.federal.drisyaHome.model.EmployeeSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class EmployeeSearchService {
    @Autowired
    EmployeeSearchDao employeeSearchDao;


    @Transactional
    public EmployeeSearch employeeSearch() {
        return employeeSearchDao.employeeSearch();
    }

    @Transactional
    public EmployeeSearch setEmployeeSearchUrl(EmployeeSearch employeeSearch) {
        return employeeSearchDao.setEmployeeSearchUrl(employeeSearch);
    }
}
