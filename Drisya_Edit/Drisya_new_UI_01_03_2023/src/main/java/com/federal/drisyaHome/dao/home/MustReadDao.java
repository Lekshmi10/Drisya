package com.federal.drisyaHome.dao.home;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.federal.drisyaHome.model.DrisyaTable;
import com.federal.drisyaHome.model.Miscellaneous;
import com.federal.drisyaHome.model.MustRead;
import com.federal.drisyaHome.model.MustReadData;
//import com.federal.drisyaHome.jsonfiles;
import org.hibernate.Session;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MustReadDao {
	  @Autowired
	    EntityManager entityManager;

/*
	    private String getFile_path(jsonfiles JSON) {
	        return JSON.json_file;
	    }
	    String must_read = getFile_path(jsonfiles.MUST_READ);  */
	    
	    public MustRead getMustReadContents() {
	    	System.out.println("Inside Must read DAO*****");
	        Session currentSession = entityManager.unwrap(Session.class);
	        Query query = currentSession.createQuery("FROM DrisyaTable d WHERE d.section=:section_name And d.id =:id", DrisyaTable.class);
	        query.setParameter("section_name","HOME_MUSTREAD");
	        query.setParameter("id",26);
	        List<DrisyaTable> drisyaTable = query.getResultList();
	        currentSession.close();
	        System.out.println("Drisya table size*****"+drisyaTable.size());
	        System.out.println("Drisya table size*****"+drisyaTable.toString());
	        if (drisyaTable.size() == 0){
	            MustRead mustRead = new MustRead();
	            mustRead.setTitle("Must Read");
	            mustRead.setData(new ArrayList<>());
	            System.out.println("If******Mustread object*****"+mustRead);
	            return mustRead;
	        }
	        else {
	            String section_data = drisyaTable.get(0).getSectionData();
	            System.out.println("Else*****section_data"+section_data);
	            ObjectMapper mapper = new ObjectMapper();
	            MustRead mustRead = new MustRead();
	            try {
	                mustRead = mapper.readValue(section_data, MustRead.class);
	                System.out.println("Else*****must read"+mustRead);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	            return mustRead;
	        }
	    }

	    public MustRead setMustReadContents(MustRead mustReadData) {
	        try{
	            DrisyaTable mustread_data = new DrisyaTable();
	            mustread_data.setId(26);
	            mustread_data.setSection("HOME_MUSTREAD");
	            mustread_data.setSectionData(mustReadData.toString());
	            System.out.print("must data "+mustReadData.toString());
	            Session currentSession = entityManager.unwrap(Session.class);
	            currentSession.clear();
	            currentSession.saveOrUpdate(mustread_data);
	            System.out.print("must data saved "+mustread_data.toString());
	            currentSession.close();
	            return mustReadData;
	        }catch (Exception e){
	        	 System.out.print("in catch");
	            e.printStackTrace();
	            return new MustRead();
	        }
	    }
}
