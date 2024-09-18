package com.federal.drisyaHome.dao.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.federal.drisyaHome.Logger;
import com.federal.drisyaHome.model.DrisyaTable;
import com.federal.drisyaHome.model.Footer;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import static com.federal.drisyaHome.Constants.FOOTER;

@Repository
public class FooterDao {

    @Autowired
    EntityManager entityManager;


    public Footer setFooter(Footer footerData) {
        try{
            DrisyaTable footer_data = new DrisyaTable();
            footer_data.setId(20);
            footer_data.setSection(FOOTER);
            footer_data.setSectionData(footerData.toString());
            Session currentSession = entityManager.unwrap(Session.class);
            currentSession.clear();
            currentSession.saveOrUpdate(footer_data);
            currentSession.close();
            return footerData;
        }catch (Exception e){
            Logger.logger.error("Exception Occured on" + e.getStackTrace());
            return new Footer();
        }
    }

    public Footer getFooter() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("FROM DrisyaTable d WHERE d.section=:section_name And d.id =:id", DrisyaTable.class);
        query.setParameter("section_name",FOOTER);
        query.setParameter("id",20);
        List<DrisyaTable> drisyaTable = query.getResultList();
        currentSession.close();
        if (drisyaTable.size() == 0){
            Footer footer = new Footer();
            footer.setSectionData(new ArrayList<>());
            return footer;
        }
        else {
            String footer_data = drisyaTable.get(0).getSectionData();
            ObjectMapper mapper = new ObjectMapper();
            Footer footer = new Footer();
            try {
                footer = mapper.readValue(footer_data, Footer.class);
            } catch (Exception e) {
                Logger.logger.error("Exception Occured on" + e.getStackTrace());
            }
            return footer;
        }
    }
}
