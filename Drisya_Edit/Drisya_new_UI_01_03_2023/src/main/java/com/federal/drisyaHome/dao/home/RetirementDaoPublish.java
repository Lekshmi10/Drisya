package com.federal.drisyaHome.dao.home;


import com.federal.drisyaHome.dao.RedisDao;
import com.federal.drisyaHome.model.DrisyaTable;
import com.federal.drisyaHome.model.Retirement;
import com.federal.drisyaHome.model.RetirementData;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.federal.drisyaHome.Constants.HOME_VRS;
import static com.federal.drisyaHome.Constants.HOME_RETIREMENT;

@Repository
public class RetirementDaoPublish {

	@Autowired
    EntityManager entityManager;
    
    
    @Autowired
    RedisDao redisDao;
    
    public String setRetirementSave(String str) throws IOException {
    	RetirementData retirementData=new RetirementData();
    	Retirement retirement=new Retirement();
    	List<RetirementData> retirementList=new ArrayList<RetirementData>();
    	//System.out.println("TEMPLATE"+str);
    	/*JSONObject obj=new JSONObject(str);
    	JSONArray arr=obj.getJSONArray("data");
    	System.out.println("TEMPLATE ONE"+str);
    	System.out.println("TEMPLATE"+arr+" "+arr.length()+" ");
    	 for(int i=1;i<=arr.length();i++) {
    		// System.out.println("ONE "+arr.getJSONObject(i));
    		 JSONObject data=arr.getJSONObject(i);
    		
    		 retirementData.setName(data.getString("name"));
    		 retirementData.setPfNumber(data.getString("pfNumber"));
    		 retirementData.setDepartment(data.getString("department"));
    		 retirementData.setImage(data.getString("image"));
    		 retirementData.setDate(data.getString("date"));
    		 retirementData.setDesignation(data.getString("designation"));
    		 retirementList.add(retirementData);
    		 retirement.setData(retirementList);
    		 try {*/
                 DrisyaTable retirement_data = new DrisyaTable();
                 retirement_data.setId(10);
                 retirement_data.setSection(HOME_RETIREMENT);
                 retirement_data.setSectionData(str);
                 System.out.println(retirement_data);
                 Session currentSession = entityManager.unwrap(Session.class);
                 currentSession.clear();
                 currentSession.saveOrUpdate(retirement_data);
                 currentSession.close();
                 redisDao.addDataToRedis();
              // redisDao.deleteById(26);
              //  redisDao.deleteById(27);
              // System.out.println("REDIS DATA RETIREMENT PUBLISH "+redisDao.getRedisData()); 
                
               //  return retirement;
           /*  } catch (Exception e) {
            	 System.out.println(e.getMessage());
                // Logger.logger.error("Exception Occured on retirements" + e.getStackTrace()+" "+e.getMessage());
                // return new Retirement();
             }*/
    	// }
    	 
    	// System.out.println(retirement.toString()); 
    	
    	return "hello";
    }
    
    public String setVrsSave(String str) throws IOException {
    	RetirementData retirementData=new RetirementData();
    	Retirement retirement=new Retirement();
    	List<RetirementData> retirementList=new ArrayList<RetirementData>();
    	DrisyaTable retirement_data = new DrisyaTable();
        retirement_data.setId(25);
        retirement_data.setSection(HOME_VRS);
        retirement_data.setSectionData(str);
        System.out.println(retirement_data);
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.clear();
        currentSession.saveOrUpdate(retirement_data);
        currentSession.close();
        redisDao.addDataToRedis();
     // redisDao.deleteById(27);
    //  System.out.println("REDIS DATA RETIREMENT PUBLISH "+redisDao.getRedisData()); 

       return "hello";
    }
       
    
}
