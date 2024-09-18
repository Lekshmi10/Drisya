/*
package com.federal.drisyaHome.dao.home;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.federal.drisyaHome.model.BankInfo;
import com.federal.drisyaHome.model.DrisyaTable;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

import static com.federal.drisyaHome.Constants.HOME_BANKINFO;

@Repository
public class BankInfoDao {

    @Autowired
    EntityManager entityManager;


    public BankInfo getBankInfo() {

        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("FROM DrisyaTable d WHERE d.section=:section_name And d.id =:id", DrisyaTable.class);
        query.setParameter("section_name", HOME_BANKINFO);
        query.setParameter("id", 13);
        List<DrisyaTable> drisyaTable = query.getResultList();
        currentSession.close();
        if (drisyaTable.size() == 0) {
            BankInfo bankInfo = new BankInfo();
            bankInfo.setAtms("");
            bankInfo.setBranches("");
            bankInfo.setCdm("");
            bankInfo.setCustomers("");
            return bankInfo;
        } else {
            String bank_info_data = drisyaTable.get(0).getSectionData();
            ObjectMapper mapper = new ObjectMapper();
            BankInfo bankInfo = new BankInfo();
            try {
                bankInfo = mapper.readValue(bank_info_data, BankInfo.class);
            } catch (Exception e) {
                Logger.logger.error("Exception Occured on" + e.getStackTrace());
            }
            return bankInfo;
        }

    }

    public BankInfo setBankInfo(BankInfo bankInfoData) {

        try {
            DrisyaTable bank_info_data = new DrisyaTable();
            bank_info_data.setId(13);
            bank_info_data.setSection(HOME_BANKINFO);
            bank_info_data.setSectionData(bankInfoData.toString());
            Session currentSession = entityManager.unwrap(Session.class);
            currentSession.clear();
            currentSession.saveOrUpdate(bank_info_data);
            currentSession.close();
            return bankInfoData;
        } catch (Exception e) {
            Logger.logger.error("Exception Occured on" + e.getStackTrace());
            return new BankInfo();
        }
    }
}
*/
