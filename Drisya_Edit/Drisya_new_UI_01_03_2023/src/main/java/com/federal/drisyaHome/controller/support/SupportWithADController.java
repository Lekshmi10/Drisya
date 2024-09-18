package com.federal.drisyaHome.controller.support;


import com.federal.drisyaHome.model.SupportWithAD;
import com.federal.drisyaHome.service.support.SupportWithADService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/supportAD")
public class SupportWithADController {
    @Autowired
    SupportWithADService supportWithADService;

    @GetMapping("/")
    public SupportWithAD getSupportWithAD() {
        return supportWithADService.getSupportWithAD();
    }

    @PostMapping("/add")
    public SupportWithAD setSupportWithAD(@RequestBody SupportWithAD supportWithAD) {
        return supportWithADService.setSupportWithAD(supportWithAD);
    }
}
