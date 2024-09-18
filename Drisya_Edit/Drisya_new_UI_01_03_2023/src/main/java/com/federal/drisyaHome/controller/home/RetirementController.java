package com.federal.drisyaHome.controller.home;

import com.federal.drisyaHome.model.Retirement;
import com.federal.drisyaHome.service.home.RetirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/retirement")
public class RetirementController {
    @Autowired
    RetirementService retirementService;

    @GetMapping("/")
    public Retirement getRetirements()  {
        return retirementService.getRetirements();
    }

    @PostMapping("/add")
    public Retirement setRetirement(@RequestBody Retirement retirementData)  {
        return retirementService.setRetirements(retirementData);
    }

}
