package com.federal.drisyaHome.controller.application;

import com.federal.drisyaHome.model.MoneyTransfer;
import com.federal.drisyaHome.service.application.MoneyTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/moneyTransfer")
public class MoneyTransferController {
    @Autowired
    MoneyTransferService moneyTransferService;

    @GetMapping("/")
    public MoneyTransfer getMoneyTransfer() {
        return moneyTransferService.getMoneyTransfer();
    }

    @PostMapping("/add")
    public MoneyTransfer setMoneyTransfer(@RequestBody MoneyTransfer moneyTransfer) {
        return moneyTransferService.setMoneyTransfer(moneyTransfer);
    }

}
