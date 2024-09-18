package com.federal.drisyaHome.loginsso;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LeadGen
{
private int sno;
private String cname;	
private long mobno;
private String email;
private String ename;
private String branch;
private int solid;
private Date dos;
private int pf;
private Date fdate;
private Date tdate;
private String bool;
private String region;
private String zone;
private String bcode;
private String custType;

private String phone;
private String accNo;
private String nriNo;
private String location;
private String partner;




public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getAccNo() {
	return accNo;
}

public void setAccNo(String accNo) {
	this.accNo = accNo;
}

public String getNriNo() {
	return nriNo;
}

public void setNriNo(String nriNo) {
	this.nriNo = nriNo;
}

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

public String getPartner() {
	return partner;
}

public void setPartner(String partner) {
	this.partner = partner;
}

public String getBcode() {
	return bcode;
}

public void setBcode(String bcode) {
	this.bcode = bcode;
}

public String getRegion() {
	return region;
}

public void setRegion(String region) {
	this.region = region;
}

public String getZone() {
	return zone;
}

public void setZone(String zone) {
	this.zone = zone;
}

public String getBool() {
	return bool;
}

public void setBool(String bool) {
	this.bool = bool;
}

public String getCname() {
	return cname;
}

public void setCname(String cname) {
	this.cname = cname;
}

public long getMobno() {
	return mobno;
}

public void setMobno(String number) {


	long mobno=Long.parseLong(number);
	this.mobno = mobno;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getEname() {
	return ename;
}

public void setEname(String ename) {
	this.ename = ename;
}

public String getBranch() {
	return branch;
}

public void setBranch(String branch) {
	this.branch = branch;
}

public int getSolid() {
	return solid;
}

public void setSolid(int solid) {
	this.solid = solid;
}

public Date getdos() {
	return dos;
}

public void setdos(String dos) {
	DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
    java.util.Date fDate=null;
	try {
		  fDate = df.parse(dos);			
	    } catch (ParseException e) {
		       e.printStackTrace();
	      }
		this.dos =fDate;
}


public int getPf() {
	return pf;
}

public void setPf(int pf) {
	this.pf = pf;
}

public int getSno() {
	return sno;
}

public void setSno(int sno) {
	this.sno = sno;
}


public Date getFdate() {
	return fdate;
}

public void setFdate(String fdate) {
	DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
    java.util.Date fDate=null;
	try {
		  fDate = df.parse(fdate);			
	    } catch (ParseException e) {
		       e.printStackTrace();
	      }
		this.dos =fDate;
}

public Date getTdate() {
	return fdate;
}
public void setTdate(String tdate) {
	DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
    java.util.Date tDate=null;
	try {
		  tDate = df.parse(tdate);			
	    } catch (ParseException e) {
		       e.printStackTrace();
	      }
		this.dos =tDate;
}

public String getCustType() {
	return custType;
}

public void setCustType(String custType) {
	this.custType = custType;
}


	
}
