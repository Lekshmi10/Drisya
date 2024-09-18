package com.federal.drisyaHome.controller.home;

import com.federal.drisyaHome.model.EmployeeSearch;
import com.federal.drisyaHome.service.home.EmployeeSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
@RestController
@RequestMapping("/employeeSearch")
public class EmployeeSearchController {
    @Autowired
    EmployeeSearchService employeeSearchService;

    @GetMapping("/")
    public EmployeeSearch employeeSearch(){
        return employeeSearchService.employeeSearch();
    }
    @PostMapping("/add")
    public EmployeeSearch setEmployeeSearchUrl(@RequestBody EmployeeSearch employeeSearch) {
        return employeeSearchService.setEmployeeSearchUrl(employeeSearch);
    }
}
