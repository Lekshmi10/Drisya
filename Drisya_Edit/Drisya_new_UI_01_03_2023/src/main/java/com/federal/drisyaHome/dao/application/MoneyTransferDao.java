package com.federal.drisyaHome.dao.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.federal.drisyaHome.Logger;
import com.federal.drisyaHome.model.*;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import static com.federal.drisyaHome.Constants.APPLICATION_MONEY_TRANSFER;

@Repository
public class MoneyTransferDao {

    @Autowired
    EntityManager entityManager;

    public MoneyTransfer getMoneyTransfer() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("FROM DrisyaTable d WHERE d.section=:section_name And d.id =:id", DrisyaTable.class);
        query.setParameter("section_name", APPLICATION_MONEY_TRANSFER);
        query.setParameter("id", 17);
        List<DrisyaTable> drisyaTable = query.getResultList();
        currentSession.close();
        if (drisyaTable.size() == 0) {
            MoneyTransfer moneyTransfer = new MoneyTransfer();
            moneyTransfer.setTitle("Money Transfer");
            moneyTransfer.setData(new ArrayList<>());
            return moneyTransfer;
        } else {
            String section_data = drisyaTable.get(0).getSectionData();
            ObjectMapper mapper = new ObjectMapper();
            MoneyTransfer moneyTransfer = null;
            try {
                moneyTransfer = mapper.readValue(section_data, MoneyTransfer.class);
            } catch (Exception e) {
                Logger.logger.error("Exception Occured on" + e.getStackTrace());
            }
            return moneyTransfer;
        }
    }

    public MoneyTransfer setMoneyTransfer(MoneyTransfer moneyTransfer)  {
        try {
            DrisyaTable applicationMoneyTransfer = new DrisyaTable();
            applicationMoneyTransfer.setId(17);
            applicationMoneyTransfer.setSection(APPLICATION_MONEY_TRANSFER);
            applicationMoneyTransfer.setSectionData(moneyTransfer.toString());
            Session currentSession = entityManager.unwrap(Session.class);
            currentSession.clear();
            currentSession.saveOrUpdate(applicationMoneyTransfer);
            currentSession.close();
            return moneyTransfer;
        } catch (Exception e) {
            Logger.logger.error("Exception Occured on" + e.getStackTrace());
        }
        return moneyTransfer;
    }
}