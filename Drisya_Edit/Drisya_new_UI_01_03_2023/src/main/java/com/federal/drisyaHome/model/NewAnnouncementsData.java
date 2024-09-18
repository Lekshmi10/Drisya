package com.federal.drisyaHome.model;

import java.util.Date;

public class NewAnnouncementsData {

	private String processId;
	private String circular_Id;
	private String dept_Code;
	private String dept_Name;
	private String circular_Title;
	private String entry_Date;
	private String file_Net_Id;

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public String getCircular_Id() {
		return circular_Id;
	}

	public void setCircular_Id(String circular_Id) {
		this.circular_Id = circular_Id;
	}

	public String getDept_Code() {
		return dept_Code;
	}

	public void setDept_Code(String dept_Code) {
		this.dept_Code = dept_Code;
	}

	public String getDept_Name() {
		return dept_Name;
	}

	public void setDept_Name(String dept_Name) {
		this.dept_Name = dept_Name;
	}

	public String getCircular_Title() {
		return circular_Title;
	}

	public void setCircular_Title(String circular_Title) {
		this.circular_Title = circular_Title;
	}

	public String getEntry_Date() {
		return entry_Date;
	}

	public void setEntry_Date(String entry_Date) {
		this.entry_Date = entry_Date;
	}

	public String getFile_Net_Id() {
		return file_Net_Id;
	}

	public void setFile_Net_Id(String file_Net_Id) {
		this.file_Net_Id = file_Net_Id;
	}

	@Override
	public String toString() {
		return "{" + "\"processId\":" + "\"" + processId + "\"" + ",\"circular_Id\":" + "\"" + circular_Id + "\""
				+ ",\"dept_Code\":" + "\"" + dept_Code + "\"" + ",\"dept_Name\":" + "\"" + dept_Name + "\""
				+ ",\"circular_Title\":" + "\"" + circular_Title + "\"" + ",\"entry_Date\":" + "\"" + entry_Date + "\""
				+ ",\"file_Net_Id\":" + "\"" + file_Net_Id + "\"" + '}';
	}

}
