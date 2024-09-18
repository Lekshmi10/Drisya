
package com.federal.drisyaHome.dao;

import com.federal.drisyaHome.model.DrisyaTable;
import org.hibernate.Session;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;



@Repository
public class RedisDao {

    @Autowired
    EntityManager entityManager;

    public static final String KEY = "DRISYA_TABLE";
    private RedisTemplate<Integer,DrisyaTable> redisTemplate;
    private HashOperations hashOperations;


    public RedisDao(RedisTemplate<Integer, DrisyaTable> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

    public Map<Integer,DrisyaTable> fetchDrisyaTableDatas() {
        return hashOperations.entries(KEY);
    }

//   public void addDataToRedis() {
//       Session currentSession = entityManager.unwrap(Session.class);
//        Query query = currentSession.createQuery("FROM DrisyaTable", DrisyaTable.class);
//        List<DrisyaTable> drisyaTable = query.getResultList();
//        currentSession.close();
//      //  hashOperations.delete(KEY, 10);
//        for (int i=0;i<drisyaTable.size();i++){	
//            hashOperations.put(KEY,drisyaTable.get(i).getId(),drisyaTable.get(i));
//        }
//    }

    @Value("${filePath}")
    private String filePath;
      
      public void addDataToRedis() throws IOException {
         Session currentSession = entityManager.unwrap(Session.class);
          Query query = currentSession.createQuery("FROM DrisyaTable", DrisyaTable.class);
          List<DrisyaTable> drisyaTable = query.getResultList();
          currentSession.close();

          //Old code
          
//          for (int i=0;i<drisyaTable.size();i++){	
//              hashOperations.put(KEY,drisyaTable.get(i).getId(),drisyaTable.get(i));
//          }
          
          //New code if redis failure writting to file
          System.out.println("inside redis add");
          JSONObject jsonObject=new JSONObject();
          JSONObject jsonTotalObject=new JSONObject();
          JSONArray jsonArray=new JSONArray();
          for (int i=0;i<drisyaTable.size();i++){
              jsonObject=new JSONObject();
              hashOperations.put(KEY,drisyaTable.get(i).getId(),drisyaTable.get(i));
              jsonObject.put("id",drisyaTable.get(i).getId());
              jsonObject.put("section",drisyaTable.get(i).getSection());
              jsonObject.put("sectionData",drisyaTable.get(i).getSectionData());
              jsonArray.add(jsonObject);
          }
          FileWriter file = new FileWriter(filePath);
          file.write(String.valueOf(jsonArray));
          file.close();
      }
    public Map<Integer,DrisyaTable> getRedisData() {
        return hashOperations.entries(KEY);
    }
    
    public void deleteById(int i) {
    	hashOperations.delete(KEY, i);
    	 
    }
}

