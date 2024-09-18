package com.federal.drisyaHome.dao.home;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.federal.drisyaHome.Logger;
import com.federal.drisyaHome.model.DrisyaTable;
import com.federal.drisyaHome.model.Images;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import static com.federal.drisyaHome.Constants.HOME_IMAGES;


@Repository
public class ImagesDao {
    @Autowired
    EntityManager entityManager;

    public Images getImages() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("FROM DrisyaTable d WHERE d.section=:section_name And d.id =:id", DrisyaTable.class);
        query.setParameter("section_name",HOME_IMAGES);
        query.setParameter("id",6);
        List<DrisyaTable> drisyaTable = query.getResultList();
        currentSession.close();
        if (drisyaTable.size() == 0){
            Images images = new Images();
            images.setData(new ArrayList<>());
            return images;
        }
        else {
            String section_data = drisyaTable.get(0).getSectionData();
            ObjectMapper mapper = new ObjectMapper();
            Images images = new Images();
            try {
                images = mapper.readValue(section_data, Images.class);
            } catch (Exception e) {
                Logger.logger.error("Exception Occured on" + e.getStackTrace());
            }
            return images;
        }
    }
    public Images setImage(Images image) {
        try {
            DrisyaTable images_data = new DrisyaTable();
            images_data.setId(6);
            images_data.setSection(HOME_IMAGES);
            images_data.setSectionData(image.toString());
            Session currentSession = entityManager.unwrap(Session.class);
            currentSession.clear();
            currentSession.saveOrUpdate(images_data);
            currentSession.close();
            return image;
        } catch (Exception e) {
            Logger.logger.error("Exception Occured on" + e.getStackTrace());
            return new Images();
        }
    }
}
