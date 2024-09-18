package com.federal.drisyaHome.dao.home;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.federal.drisyaHome.Logger;
import com.federal.drisyaHome.model.DrisyaTable;
import com.federal.drisyaHome.model.EmployeeSearch;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

import static com.federal.drisyaHome.Constants.HOME_EMPLOYEE_SEARCH;

@Repository
public class EmployeeSearchDao {

    @Autowired
    EntityManager entityManager;

    public EmployeeSearch employeeSearch() {

        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("FROM DrisyaTable d WHERE d.section=:section_name And d.id =:id", DrisyaTable.class);
        query.setParameter("section_name",HOME_EMPLOYEE_SEARCH);
        query.setParameter("id",4);
        List<DrisyaTable> drisyaTable = query.getResultList();
        currentSession.close();
        if (drisyaTable.size() == 0){
            EmployeeSearch employeeSearch = new EmployeeSearch();
            employeeSearch.setUrl("");
            return employeeSearch;
        }
        else {
            String section_data = drisyaTable.get(0).getSectionData();
            ObjectMapper mapper = new ObjectMapper();
            EmployeeSearch employeeSearch = new EmployeeSearch();
            try {
                employeeSearch = mapper.readValue(section_data, EmployeeSearch.class);
            } catch (Exception e) {
                Logger.logger.error("Exception Occured on" + e.getStackTrace());
            }
            return employeeSearch;
        }

    }

    public EmployeeSearch setEmployeeSearchUrl(EmployeeSearch employeeSearch) {
    	 try{
         	System.out.println("inside setEmployeeSearch "+employeeSearch.toString());
             DrisyaTable search_data = new DrisyaTable();
             search_data.setId(4);
             search_data.setSection(HOME_EMPLOYEE_SEARCH);
             search_data.setSectionData(employeeSearch.toString());
             Session currentSession = entityManager.unwrap(Session.class);
             currentSession.clear();
             currentSession.saveOrUpdate(search_data);
             EmployeeSearch s=this.employeeSearch();
             System.out.print("from print "+s);
             System.out.print(employeeSearch.getUrl());
             currentSession.close();
             return employeeSearch;
         }catch (Exception e){
             Logger.logger.error("Exception Occured on" + e.getStackTrace());
             return new EmployeeSearch();
         }
    }
}
