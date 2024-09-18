package com.federal.drisyaHome.dao.home;
import com.fasterxml.jackson.databind.ObjectMapper;



import com.federal.drisyaHome.Logger;
import com.federal.drisyaHome.controller.home.RetirementViewController;
import com.federal.drisyaHome.dao.RedisDao;
import com.federal.drisyaHome.model.DrisyaTable;
import com.federal.drisyaHome.model.Retirement;
import com.federal.drisyaHome.model.RetirementData;
import com.federal.drisyaHome.model.RetirementView;
import com.federal.drisyaHome.model.RetirementViewData;

import org.hibernate.Session;
import org.json.JSONObject;

import org.json.simple.JSONArray;
//import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.federal.drisyaHome.Constants.*;
import static com.federal.drisyaHome.Constants.HOME_VRS;

@Repository
public class RetirementDao {

    @Autowired
    EntityManager entityManager;


    @Autowired
    RedisDao redisDao;

    // @Autowired
    // RetirementViewController retirementViewController;


    public String[] pfnum= new String[100];
    // RetirementView
    public Retirement getRetirement() {
        System.out.println("retirement 1");
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("FROM DrisyaTable d WHERE d.section=:section_name And d.id =:id", DrisyaTable.class);
        query.setParameter("section_name", HOME_RETIREMENT);
        query.setParameter("id", 10);
        List<DrisyaTable> drisyaTable = query.getResultList();
        System.out.println("retirement 2"+drisyaTable.toString());
        currentSession.close();
        if (drisyaTable.size() == 0) {
            Retirement retirement = new Retirement();

            /*
             *
                 RetirementView retirement = new RetirementView();
             */
            retirement.setData(new ArrayList<>());
            return retirement;
        } else {
            String section_data = drisyaTable.get(0).getSectionData();
            ObjectMapper mapper = new ObjectMapper();
            Retirement retirement = new Retirement();
            // RetirementView retirement = new RetirementView();

            try {
                retirement = mapper.readValue(section_data, Retirement.class);
                // retirement = mapper.readValue(section_data, RetirementView.class);
            } catch (Exception e) {
                Logger.logger.error("Exception Occured on" + e.getStackTrace());
            }
            return retirement;
        }
    }

    public Retirement getVrs() {
        System.out.println("vrs 1");
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("FROM DrisyaTable d WHERE d.section=:section_name And d.id =:id", DrisyaTable.class);
        query.setParameter("section_name", HOME_VRS);
        query.setParameter("id", 27);
        List<DrisyaTable> drisyaTable = query.getResultList();
        System.out.println("vrs 2"+drisyaTable.toString());
        currentSession.close();
        if (drisyaTable.size() == 0) {
            Retirement vrs = new Retirement();

           /*
            *
                RetirementView retirement = new RetirementView();
            */
            vrs.setData(new ArrayList<>());
            return vrs;
        } else {
            String section_data = drisyaTable.get(0).getSectionData();
            ObjectMapper mapper = new ObjectMapper();
            Retirement vrs = new Retirement();
            // RetirementView retirement = new RetirementView();

            try {
                vrs = mapper.readValue(section_data, Retirement.class);
                // retirement = mapper.readValue(section_data, RetirementView.class);
            } catch (Exception e) {
                Logger.logger.error("Exception Occured on" + e.getStackTrace());
            }
            return vrs;
        }
    }

    // RetirementView
    public Retirement setRetirement(Retirement retirement) {
        try {
            DrisyaTable retirement_data = new DrisyaTable();
            retirement_data.setId(10);
            retirement_data.setSection(HOME_RETIREMENT);
            retirement_data.setSectionData(retirement.toString());
            Session currentSession = entityManager.unwrap(Session.class);
            currentSession.clear();
            currentSession.saveOrUpdate(retirement_data);
            currentSession.close();
            return retirement;
        } catch (Exception e) {
            Logger.logger.error("Exception Occured on" + e.getStackTrace());
            return new Retirement();
        }
    }

    public RetirementView setRetirementView(String[] pf_split) {

        pfnum=pf_split;
        List<RetirementViewData> dataList = new ArrayList<>();
        RetirementView retirementView=new RetirementView();
        RetirementViewData retirementViewData=new RetirementViewData();
        try {
            Session currentSession = entityManager.unwrap(Session.class);
            currentSession.clear();
            System.out.println("pf_split"+pf_split.length);

            String query = "select PFNUM,NAME,JOIN_DATE,DESIGNATION,DEPARTTMENT from FAME_VCARDDETAILS where PFNUM=?";

            Query queryexe = currentSession.createSQLQuery(query);
            for(int i=0;i<pf_split.length;i++) {
                queryexe.setParameter(1, pf_split[i]);
                List<Object> result = queryexe.getResultList();


                System.out.println("Retirement view"+result);



                JSONArray jsonArray = new JSONArray();

                for (int j = 0; j < result.size(); j++) {

                    System.out.print("result is"+result.size());
                    jsonArray.add(result.get(j));

                    Object[] obj = (Object[]) jsonArray.get(j);

                    retirementViewData = new RetirementViewData();
                    retirementViewData.setPfnum(obj[0].toString());
                    retirementViewData.setName(obj[1].toString());
                    retirementViewData.setDate(obj[2].toString());
                    retirementViewData.setDesignation(obj[3].toString());
                    retirementViewData.setDeparttment(obj[4].toString());

                    dataList.add(retirementViewData);
                }

                String query1 = "select PFNUM,NAME,JOIN_DATE,DESIGNATION,DEPARTTMENT from FAME_VCARDDETAILS where PFNUM=?";
                retirementView.setData(dataList);

                currentSession.close();
                DrisyaTable announcement_data = new DrisyaTable();
                announcement_data.setId(2);

                Session currentSession1 = entityManager.unwrap(Session.class);
                currentSession1.clear();
                currentSession1.saveOrUpdate(announcement_data);
                currentSession1.close();
                System.out.println("newAnnouncements "+retirementView);
                redisDao.addDataToRedis();

            }
        }catch (Exception e) {
            // TODO: handle exception
        }
        // httpServletResponse.sendRedirect("http://localhost:9098/retirement_view");
        return retirementView;

    }

    public Retirement getRetirementView(String newsplit,String nullspace) throws IOException {
        System.out.println("nullspace"+nullspace);
        Retirement retirement=new Retirement();
        if(nullspace=="space") {
            System.out.println("space");
            Retirement error=new Retirement();
            List<RetirementData> dataList1 = new ArrayList<>();
            RetirementData retirementData1=new RetirementData();
            retirementData1.setPfNumber("null");
            dataList1.add(retirementData1);
            error.setData(dataList1);
            return error;
        }if(nullspace=="characters") {
            System.out.println("characters");
            Retirement errorchar=new Retirement();
            List<RetirementData> dataList1 = new ArrayList<>();
            RetirementData retirementData1=new RetirementData();
            retirementData1.setPfNumber("characters");
            dataList1.add(retirementData1);
            errorchar.setData(dataList1);
            return errorchar;
        }
        else {
            RetirementViewController retirementViewController =new RetirementViewController();
            System.out.println("Retirement view"+newsplit);
            pfnum=newsplit.split(" ");
            System.out.println("Size"+pfnum[0]+" "+pfnum[1]+" "+pfnum.length);
    	/*String pfstring=(String) newsplit.getAttribute("sessionpf");
    	String[] pfnum=retirementViewController.getPfnum();
    	System.out.println("test************"+pfstring);*/
            List<RetirementData> dataList = new ArrayList<>();

            RetirementData retirementData=new RetirementData();
            Session currentSession = entityManager.unwrap(Session.class);
            currentSession.clear();


            String query = "select PFNUM,NAME,JOIN_DATE,DESIGDESC,DEPTDESC from FAME_VCARDDETAILS C,FAME_DESIGNATION F,FAME_DEPARTMENT D where PFNUM=? AND F.DESIGCODE=C.DESIGNATION AND D.DEPTCODE=C.DEPARTTMENT";

            Query queryexe = currentSession.createSQLQuery(query);
            for(int i=0;i<pfnum.length;i++) {
                queryexe.setParameter(1, pfnum[i]);
                List<Object> result = queryexe.getResultList();



                JSONArray jsonArray = new JSONArray();

                for (int j = 0; j < result.size(); j++) {


                    jsonArray.add(result.get(j));

                    Object[] obj = (Object[]) jsonArray.get(j);

                    retirementData = new RetirementData();
                    retirementData.setPfNumber(obj[0].toString());
                    retirementData.setName(obj[1].toString());
                    retirementData.setDate(obj[2].toString());
                    retirementData.setDesignation(obj[3].toString());
                    retirementData.setDepartment(obj[4].toString());

                    dataList.add(retirementData);
                }

                retirement.setData(dataList);

                currentSession.close();
                DrisyaTable announcement_data = new DrisyaTable();
                announcement_data.setId(2);

                Session currentSession1 = entityManager.unwrap(Session.class);
                currentSession1.clear();
                currentSession1.saveOrUpdate(announcement_data);
                currentSession1.close();
                System.out.println("newRetirements "+retirement);
                redisDao.addDataToRedis();

            }
          /*if(nullspace=="space") {
          	List<RetirementData> dataList1 = new ArrayList<>();
          	RetirementData retirementData1=new RetirementData();
          	retirementData1.setPfNumber("null");
          	dataList1.add(retirementData1);
        	  error.setData(dataList1);
        	  return error;
          }*/
            if(pfnum.length!=dataList.size()){
                /*
                 * Model m=null; String str="hello"; m.addAttribute("message", str);
                 */
                return null;
            }
        }
        return retirement;
    }

    
    
}
