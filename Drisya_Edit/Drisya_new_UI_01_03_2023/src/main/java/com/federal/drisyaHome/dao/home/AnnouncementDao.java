package com.federal.drisyaHome.dao.home;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.federal.drisyaHome.Logger;
import com.federal.drisyaHome.dao.RedisDao;
import com.federal.drisyaHome.model.*;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Parameter;
import javax.persistence.Query;

import java.io.IOException;
import java.util.*;

import static com.federal.drisyaHome.Constants.HOME_ANNOUNCEMENTS;

@Repository
public class AnnouncementDao {

	@Autowired
	EntityManager entityManager;
	@Autowired
	RedisDao redisDao;

	public Announcements getAnnouncements() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query query = currentSession.createQuery("FROM DrisyaTable d WHERE d.section=:section_name And d.id =:id",
				DrisyaTable.class);
		query.setParameter("section_name", HOME_ANNOUNCEMENTS);
		query.setParameter("id", 2);
		List<DrisyaTable> drisyaTable = query.getResultList();
		currentSession.close();
		if (drisyaTable.size() == 0) {
			Announcements announcements = new Announcements();
			announcements.setTitle("Announcements");
			announcements.setData(new ArrayList<>());
			return announcements;
		} else {
			String section_data = drisyaTable.get(0).getSectionData();
			ObjectMapper mapper = new ObjectMapper();
			Announcements announcements = new Announcements();
			try {
				announcements = mapper.readValue(section_data, Announcements.class);
			} catch (Exception e) {
				Logger.logger.error("Exception Occured on" + e.getStackTrace());
			}
			return announcements;
		}
	}

	public Announcements setAnnouncements(Announcements announcement) {
		try {
			DrisyaTable announcement_data = new DrisyaTable();
			announcement_data.setId(2);
			announcement_data.setSection(HOME_ANNOUNCEMENTS);
			announcement_data.setSectionData(announcement.toString());
			Session currentSession = entityManager.unwrap(Session.class);
			currentSession.clear();
			currentSession.saveOrUpdate(announcement_data);
			currentSession.close();
			return announcement;
		} catch (Exception e) {
			Logger.logger.error("Exception Occured on" + e.getStackTrace());
			return new Announcements();
		}
	}

	public void uploadPdf(AnnouncementFiles announcementFiles) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.clear();
		currentSession.saveOrUpdate(announcementFiles);
		currentSession.close();
	}

	public AnnouncementFiles fetchPdf(String announcementHeadline) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query query = currentSession.createQuery("FROM AnnouncementFiles as a WHERE a.id=:announcementHeadline",
				AnnouncementFiles.class);
		query.setParameter("announcementHeadline", announcementHeadline.toUpperCase());
		List<AnnouncementFiles> announcementFiles = query.getResultList();
		currentSession.close();
		return announcementFiles.get(0);
	}

	public String deleteFile(String announcementHeadline) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.clear();
		AnnouncementFiles AnnouncementFiles = (AnnouncementFiles) currentSession.get(AnnouncementFiles.class,
				announcementHeadline.toUpperCase());
		currentSession.delete(AnnouncementFiles);
		currentSession.close();
		return "File deleted";
	}

	public NewAnnouncements getAnnouncementsData() throws IOException {
//		Session currentSession = entityManager.unwrap(Session.class);
//		currentSession.clear();
//		NewAnnouncements newAnnouncements = new NewAnnouncements();
//		NewAnnouncementsData newAnnouncementsData = new NewAnnouncementsData();
//
//
////		String query = "select a.PROCESSID,a.CIRCULAR_ID,a.DEPT_CODE,a.DEPT_NAME,a.CIRCULAR_TITLE,a.entry_date,b.FILE_NET_ID from "
////				+ "misapp.BPM_DRISYA a,MISBPM.BPM_DOCUMENT_STORE b where a.PROCESSID =b.bpd_instance_id and CIRCULAR_ID is not null and a.STATUS='Approved' and entry_date is not null "
////				+ "and b.file_net_id is not null order by entry_date desc";
//
//		//announcements 20 rows
//		String query = "select a.PROCESSID,a.CIRCULAR_ID,a.DEPT_CODE,a.DEPT_NAME,a.CIRCULAR_TITLE,a.entry_date,b.FILE_NET_ID from misapp.BPM_DRISYA a,MISBPM.BPM_DOCUMENT_STORE b where a.PROCESSID =b.bpd_instance_id and CIRCULAR_ID is not null and a.STATUS='Approved' and entry_date is not null and b.file_net_id is not null order by entry_date desc FETCH NEXT 20 ROWS ONLY";
//
//		Query queryexe = currentSession.createSQLQuery(query);
//		List<Object> result = queryexe.getResultList();
//		System.out.println("scheduler is running"+result);
//		if(result.size()!=0) {
//			newAnnouncements.setTitle("Announcements");
//			List<NewAnnouncementsData> dataList = new ArrayList<>();
//
//			JSONArray jsonArray = new JSONArray();
//
//			for (int j = 0; j < result.size(); j++) {
//
//				//System.out.print("result is"+result.size());
//				System.out.print("Schedualer is running");
//				jsonArray.add(result.get(j));
//
//				Object[] obj = (Object[]) jsonArray.get(j);
//
//				newAnnouncementsData = new NewAnnouncementsData();
//				newAnnouncementsData.setProcessId(obj[0].toString());
//				newAnnouncementsData.setCircular_Id(obj[1].toString());
//				newAnnouncementsData.setDept_Code(obj[2].toString());
//				newAnnouncementsData.setDept_Name(obj[3].toString());
//				newAnnouncementsData.setCircular_Title(obj[4].toString());
//				newAnnouncementsData.setEntry_Date(obj[5].toString());
//				newAnnouncementsData.setFile_Net_Id(obj[6].toString());
//				dataList.add(newAnnouncementsData);
//
//			}
//			newAnnouncements.setData(dataList);
//
//			DrisyaTable announcement_data = new DrisyaTable();
//			announcement_data.setId(2);
//			announcement_data.setSection(HOME_ANNOUNCEMENTS);
//			announcement_data.setSectionData(newAnnouncements.toString());
//			Session currentS1 = entityManager.unwrap(Session.class);
//			currentS1.clear();
//			currentS1.saveOrUpdate(announcement_data);
//			currentS1.close();
//			System.out.println("announcement_data "+announcement_data);
//			System.out.println("newAnnouncements "+newAnnouncements);
//
//			redisDao.addDataToRedis();
//			return newAnnouncements;
//		}else {
//			NewAnnouncements newAnnouncement=new NewAnnouncements();
//			System.out.println("Announcements No data *****");
//
//			List<NewAnnouncementsData> newAnnlist=new ArrayList<>();
//			newAnnouncement.setData(newAnnlist);
//			newAnnouncement.setTitle("Announcements");
//			System.out.println(newAnnouncement);
//			redisDao.addDataToRedis();
//			return newAnnouncement;
//		}
//
		return new NewAnnouncements();
	}

}
