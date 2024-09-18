package com.federal.drisyaHome.dao.home;

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

import static com.federal.drisyaHome.Constants.HOME_VIDEOS;

@Repository
public class VideosDao {

    @Autowired
    EntityManager entityManager;

    public Videos getVideoAds() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("FROM DrisyaTable d WHERE d.section=:section_name And d.id =:id", DrisyaTable.class);
        query.setParameter("section_name",HOME_VIDEOS);
        query.setParameter("id",12);
        List<DrisyaTable> drisyaTable = query.getResultList();
        currentSession.close();
        if (drisyaTable.size() == 0){
            Videos videos = new Videos();
            videos.setData(new ArrayList<>());
            return videos;
        }
        else {
            String section_data = drisyaTable.get(0).getSectionData();
            ObjectMapper mapper = new ObjectMapper();
            Videos videos = new Videos();
            try {
                videos = mapper.readValue(section_data, Videos.class);
            } catch (Exception e) {
                Logger.logger.error("Exception Occured on" + e.getStackTrace());
            }
            return videos;
        }
    }

    public Videos setVideoAds(Videos adsData) {

        try{
            DrisyaTable videos_data = new DrisyaTable();
            videos_data.setId(12);
            videos_data.setSection(HOME_VIDEOS);
            videos_data.setSectionData(adsData.toString());
            Session currentSession = entityManager.unwrap(Session.class);
            currentSession.clear();
            currentSession.saveOrUpdate(videos_data);
            currentSession.close();
            return adsData;
        }catch (Exception e){
            Logger.logger.error("Exception Occured on" + e.getStackTrace());
            return new Videos();
        }
    }
}
