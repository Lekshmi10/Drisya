/*
package com.federal.drisyaHome.controller.home;

import com.federal.drisyaHome.model.BankInfo;
import com.federal.drisyaHome.model.BankInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/bankInfo")
public class BankInfoController {
    @Autowired
    BankInfoService bankInfoService;

    @GetMapping("/")
    public BankInfo getBankInfo() {
        return bankInfoService.getBankInfo();
    }

    @PostMapping("/add")
    public BankInfo setBankInfo(@RequestBody BankInfo bankInfoData) {
        return bankInfoService.setBankInfo(bankInfoData);
    }
}
*/
