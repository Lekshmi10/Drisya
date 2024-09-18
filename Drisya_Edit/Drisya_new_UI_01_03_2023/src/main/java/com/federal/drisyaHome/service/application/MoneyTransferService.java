package com.federal.drisyaHome.service.application;

import com.federal.drisyaHome.dao.application.MoneyTransferDao;
import com.federal.drisyaHome.model.MoneyTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MoneyTransferService {
    @Autowired
    MoneyTransferDao moneyTransferDao;

    @Transactional
    public MoneyTransfer getMoneyTransfer() {
        return moneyTransferDao.getMoneyTransfer();
    }

    @Transactional
    public MoneyTransfer setMoneyTransfer(MoneyTransfer moneyTransfer) {
        return moneyTransferDao.setMoneyTransfer(moneyTransfer);
    }
}
