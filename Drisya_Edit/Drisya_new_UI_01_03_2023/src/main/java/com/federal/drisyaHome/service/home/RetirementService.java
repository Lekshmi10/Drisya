package com.federal.drisyaHome.service.home;

import com.federal.drisyaHome.dao.home.RetirementDao;
import static com.federal.drisyaHome.Constants.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.federal.drisyaHome.Logger;
import com.federal.drisyaHome.dao.RedisDao;
import com.federal.drisyaHome.dao.home.HomeDao;
import com.federal.drisyaHome.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
public class RetirementService {
	@Autowired
    HomeDao homeDao;
    @Autowired
    RetirementDao retirementDao;


    @Transactional
    public Retirement getRetirements() {
        return retirementDao.getRetirement();
    }

    @Transactional
    public Retirement setRetirements(Retirement retirementData) {
        return retirementDao.setRetirement(retirementData);
    }

    @Transactional
    public void setRetirementsView(String[] pf_split) {
        retirementDao.setRetirementView(pf_split);
    }

    @Transactional
    public Retirement geUploadRetirementView(String newsplit,String nullspace) throws IOException {

        return retirementDao.getRetirementView(newsplit,nullspace);
    }

    public ArrayList<RetirementData> getRetirementView() {
    	ArrayList<RetirementData> retirementList = new ArrayList<RetirementData>();
		 ArrayList<VrsData> vrsList=new ArrayList<VrsData>();
		List<DrisyaTable> drisyaTable = homeDao.fetchHomepage();
		for (int i = 0; i < drisyaTable.size(); i++) {
			
           
			SimpleDateFormat formatter = new SimpleDateFormat();
			Date dt = new Date();
			String row_data = drisyaTable.get(i).getSectionData();
			ObjectMapper mapper = new ObjectMapper();
		//System.out.println("### Item:"+drisyaTable.get(i).getSection());
			/*
			 * if (i == 1) { continue; }
			 */
			switch (drisyaTable.get(i).getSection()) {
			 case HOME_RETIREMENT:
				 String str=drisyaTable.get(i).getSectionData();
				 System.out.println("### Item:"+str);
				  JSONObject obj=new JSONObject(str); JSONArray arr=obj.getJSONArray("data");
				  for(int j=0;j<arr.length();j++) {
				  
				  
				  
					/*
					 * const date_str=retirementData.date; const date_split=date_str.split(" ");
					 * const split_date=new Date(date_split[0]); var
					 * month_diff=Date.now()-split_date.getTime(); var exp_dt=new Date(month_diff);
					 * var year=exp_dt.getUTCFullYear(); var exp=Math.abs(year-1970);
					 */
				  RetirementData retirementData=new RetirementData(); Retirement retirement=new
				  Retirement(); // System.out.println("ONE "+arr.getJSONObject(i));
				  
				  JSONObject data=arr.getJSONObject(j);
				  
				  
				  
					/*
					 * String date=data.getString("date"); String[] date_split=date.split(" "); Date
					 * split_date=new Date(date_split[0]); long
					 * month_diff=dt.getTime()-split_date.getTime(); Date exp_dt=new
					 * Date(month_diff); long year=exp_dt.getYear(); long exp=Math.abs(year-1970);
					 */
				  
				  // String.valueOf(exp)
				  
				  
				  
				  
				  String dateString=data.getString("date"); String[]
				  dateFormat=dateString.split(" "); String datee=dateFormat[0]; LocalDate
				  curDate=LocalDate.now(); LocalDate dob=LocalDate.parse(datee); int
				  dts=Period.between(dob,curDate).getYears(); String str4=String.valueOf(dts);
				  
				  //System.out.println("Date "+str4);
				  retirementData.setName(data.getString("name")); String
				  str1=retirementData.getName();
				  retirementData.setPfNumber(data.getString("pfNumber"));
				  retirementData.setDepartment(data.getString("department"));
				  retirementData.setImage(data.getString("image"));
				  retirementData.setDate(str4);
				  retirementData.setDesignation(data.getString("designation")); RetirementData
				  RetirementData=retirementData; retirementList.add(retirementData);
				  
				  String str2=retirementList.toString(); System.out.println(str2);
				  //retirement.setData(retirementList); 
				  }
				
				  break;
				  
			}
    }
		 return retirementList;	
    }
   
    public ArrayList<VrsData> getVrsView() {
    	ArrayList<RetirementData> retirementList = new ArrayList<RetirementData>();
		 ArrayList<VrsData> vrsList=new ArrayList<VrsData>();
		List<DrisyaTable> drisyaTable = homeDao.fetchHomepage();
		for (int i = 0; i < drisyaTable.size(); i++) {
			
           
			SimpleDateFormat formatter = new SimpleDateFormat();
			Date dt = new Date();
			String row_data = drisyaTable.get(i).getSectionData();
			ObjectMapper mapper = new ObjectMapper();
		//System.out.println("### Item:"+drisyaTable.get(i).getSection());
			/*
			 * if (i == 1) { continue; }
			 */
			switch (drisyaTable.get(i).getSection()) {
			case HOME_VRS:
				 String str2 = drisyaTable.get(i).getSectionData();
				  JSONObject obj1 = new JSONObject(str2);
				  JSONArray arr1 = obj1.getJSONArray("data");
				  for (int j = 0; j < arr1.length(); j++) {
				  
				  
			/*
			 * const date_str=retirementData.date; const date_split=date_str.split(" ");
			 * const split_date=new Date(date_split[0]); var
			 * month_diff=Date.now()-split_date.getTime(); var exp_dt=new Date(month_diff);
			 * var year=exp_dt.getUTCFullYear(); var exp=Math.abs(year-1970);
			 */
				  
				  VrsData vrsData = new VrsData(); 
				  Vrs vrs = new Vrs(); //
				//  System.out.println("ONE "+arr1.getJSONObject(i));
				  
				  JSONObject data = arr1.getJSONObject(j);
				  
				  
			/*
			 * String date=data.getString("date"); String[] date_split=date.split(" "); Date
			 * split_date=new Date(date_split[0]); long
			 * month_diff=dt.getTime()-split_date.getTime(); Date exp_dt=new
			 * Date(month_diff); long year=exp_dt.getYear(); long exp=Math.abs(year-1970);
			 */
				  
				  // String.valueOf(exp)
				  
				  String dateString = data.getString("date"); String[] dateFormat =
				  dateString.split(" "); String datee = dateFormat[0]; LocalDate curDate =
				  LocalDate.now(); LocalDate dob = LocalDate.parse(datee); int dts =
				  Period.between(dob, curDate).getYears(); String str4 = String.valueOf(dts);
				  
				  // System.out.println("Date "+str4); vrsData.setName(data.getString("name"));
				  String str1 = vrsData.getName();
				  vrsData.setPfNumber(data.getString("pfNumber"));
				  vrsData.setDepartment(data.getString("department"));
				  vrsData.setImage(data.getString("image")); vrsData.setDate(str4);
				  vrsData.setDesignation(data.getString("designation")); 
				  VrsData VrsData =vrsData; 
				  vrsList.add(vrsData); }
				
				 break;
				 }
			}
    	return vrsList;
    }
}
