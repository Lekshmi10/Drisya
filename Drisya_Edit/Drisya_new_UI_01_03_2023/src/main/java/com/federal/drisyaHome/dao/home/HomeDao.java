package com.federal.drisyaHome.dao.home;

import com.federal.drisyaHome.model.*;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class HomeDao {

    @Autowired
    EntityManager entityManager;

    public List<DrisyaTable> fetchHomepage() {

        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("FROM DrisyaTable", DrisyaTable.class);
        List<DrisyaTable> drisyaTable = query.getResultList();
        currentSession.close();
        return drisyaTable;
    }
}