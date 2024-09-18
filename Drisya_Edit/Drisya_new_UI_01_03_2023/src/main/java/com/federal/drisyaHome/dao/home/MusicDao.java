package com.federal.drisyaHome.dao.home;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.federal.drisyaHome.Logger;
import com.federal.drisyaHome.model.Alerts;
import com.federal.drisyaHome.model.DrisyaTable;
import com.federal.drisyaHome.model.Music;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import static com.federal.drisyaHome.Constants.ALERTS;



    @Repository
    public class MusicDao {

        @Autowired
        EntityManager entityManager;


        public Music getMusic() {
            Session currentSession = entityManager.unwrap(Session.class);
            Query query = currentSession.createQuery("FROM DrisyaTable d WHERE d.section=:section_name And d.id =:id", DrisyaTable.class);
            query.setParameter("section_name", "MUSIC");
            query.setParameter("id", 25);
            List<DrisyaTable> drisyaTable = query.getResultList();
            currentSession.close();
            if (drisyaTable.size() == 0) {
                Music music = new Music();
                music.setAudioText("");
                return music;
            } else {
                String music_data = drisyaTable.get(0).getSectionData();
                ObjectMapper mapper = new ObjectMapper();
                Music music1 = new Music();
                try {
                    music1 = mapper.readValue(music_data, Music.class);
                } catch (Exception e) {
                    Logger.logger.error("Exception Occured on" + e.getStackTrace());
                }
                return music1;
            }

        }

        public Music setMusic(Music music1) {
            try {
                DrisyaTable music_data = new DrisyaTable();
                music_data.setId(25);
                music_data.setSection("MUSIC");
                music_data.setSectionData(music1.toString());
                Session currentSession = entityManager.unwrap(Session.class);
                currentSession.clear();
                currentSession.saveOrUpdate(music_data);
                currentSession.close();
                return music1;
            } catch (Exception e) {
                Logger.logger.error("Exception Occured on" + e.getStackTrace());
                return new Music();
            }
        }

}
