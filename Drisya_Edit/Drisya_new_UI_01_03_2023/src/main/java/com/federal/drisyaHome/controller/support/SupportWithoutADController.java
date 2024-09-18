package com.federal.drisyaHome.controller.support;

import com.federal.drisyaHome.model.SupportWithoutAD;
import com.federal.drisyaHome.service.support.SupportWithoutADService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/supportWithoutAD")
public class SupportWithoutADController {
    @Autowired
    SupportWithoutADService supportWithoutADService;

    @GetMapping("/")
    public SupportWithoutAD getSupport() {
        return supportWithoutADService.getSupport();
    }

    @PostMapping("/add")
    public SupportWithoutAD setSupport(@RequestBody SupportWithoutAD support) {
        return supportWithoutADService.setSupport(support);
    }

}
