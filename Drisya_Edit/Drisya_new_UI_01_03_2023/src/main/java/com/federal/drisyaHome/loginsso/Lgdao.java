package com.federal.drisyaHome.loginsso;

import java.rmi.RemoteException;
//import java.io.FileInputStream;
//import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.ResultSet;
import java.sql.SQLException;




import java.util.Date;
import java.util.HashMap;   
import java.util.Map;  







import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.federal.drisyaHome.loginsso.LeadGen;
import com.federal.drisyaHome.loginsso.*;



public class Lgdao {

	
  
 


   
   public static String getRemote(String uname) throws RemoteException {
		// webservice for user details
		
		BPMWebServiceSoapProxy pxy =new BPMWebServiceSoapProxy();
		com.federal.drisyaHome.loginsso.BPMData getUserDetails = pxy.getUserDetails(uname);
		
		
		
		String brcode=getUserDetails.getBranchCode();
	//	System.out.println("Branch code= "+brcode);
	 
	   
         return brcode;
       }
  
   public static String getRegionName(String uname) throws RemoteException {
		// webservice for user details
		
		BPMWebServiceSoapProxy pxy =new BPMWebServiceSoapProxy();
		com.federal.drisyaHome.loginsso.BPMData getUserDetails = pxy.getUserDetails(uname);
		
		String region=getUserDetails.getROName();
		
	//	System.out.println("region name= "+region);
	 
	   
         return region;
       }
   public static String getZoneName(String uname) throws RemoteException {
		// webservice for user details
		
		BPMWebServiceSoapProxy pxy =new BPMWebServiceSoapProxy();
		com.federal.drisyaHome.loginsso.BPMData getUserDetails = pxy.getUserDetails(uname);
		
		String zone=getUserDetails.getZoneName();
		
		// System.out.println("zone name= "+zone);
	 
	   
        return zone;
      }
   
   public static LeadGen getLogin(String uname) throws RemoteException {
   
   /**
   ADLoginSoapProxy pxy1 =new ADLoginSoapProxy();
   org.tempuri.UserAttributesResponseUserAttributesResult userAttributes13mtemp = pxy1.userAttributes(uname,pwd);
  
   System.out.println("Branch code= "+userAttributes13mtemp);
   org.apache.axis.message.MessageElement[] type_any16 = userAttributes13mtemp.get_any();
   LeadGen lg=new LeadGen();
   String temp_any16 = null;
   String ret ="";
   String test = "";  
  
   String Name = "";  
   String pf=""; 
  
   
   if(type_any16 != null){
   java.util.List list_any16= java.util.Arrays.asList(type_any16);
   test= list_any16.get(0).toString(); 
   System.out.println(test);
   ret=test.subSequence(23, 30).toString();
   
   if(ret=="SUCCESS"||ret.equals("SUCCESS")){
   Name="Name";
   String eName=extractPayload(test,Name);
   
   pf="EmployeeNumber";
   String epf=extractPayload(test,pf);
  
   BPMWebServiceSoapProxy pxy =new BPMWebServiceSoapProxy();
   org.tempuri.BPMData getUserDetails = pxy.getUserDetails(uname);
	
	String solid=getUserDetails.getSOLId();
	String brName=getUserDetails.getBranchName();
   System.out.println("Solid Login=="+solid);
   
   lg.setBranch(brName);
   lg.setEname(eName);
   lg.setPf(Integer.parseInt(epf));
   lg.setSolid(Integer.parseInt(solid));
   lg.setBool(ret);
   }
   lg.setBool(ret);
   }
    return lg;
    
	  **/
	  
	   SSOUserDetailsSoapProxy sso=new SSOUserDetailsSoapProxy();		  
	   UserDetails obj=sso.allDetails(uname);
    //   System.out.println("Branch Code= "+ obj.getDepartmentNumber());
       System.out.println("validUser" + obj.getValidUser());
       System.out.println((obj.getValidUser()==null));
      // System.out.println(" ** "+(obj.getValidUser().equals(null)));
       String solid="";
       String brName="";
       String pfno="";
       String BrCode="";
	  if(obj.getValidUser()==null){
	 //  BPMWebServiceSoapProxy pxy =new BPMWebServiceSoapProxy();
	 //  org.tempuri.BPMData getUserDetails = pxy.getUserDetails(uname);
	   
	   //String strValidUser=getUserDetails.
		
	  //solid=getUserDetails.getSOLId();
	 //  brName=getUserDetails.getBranchName();
	   pfno=obj.getEmployeeNumber();
	   BrCode=obj.getDepartmentNumber();
	   
	  }else{
		  solid="0";
		   brName=" ";
		   pfno="0";
		   BrCode="OS";
	  }
	  System.out.println("Solid Login=="+solid);
	  System.out.println("brName Login=="+brName);
	
	  LeadGen lg=new LeadGen();
	   //lg.setBranch(brName);
	   lg.setEname(uname);
	   lg.setBcode(BrCode);
	 
	   lg.setPf(Integer.parseInt(pfno));
	   System.out.println("PF from getLogin="+Integer.parseInt(pfno));
	   //lg.setSolid(Integer.parseInt(solid));
	  
	   
	    return lg;
	    
   }
	//Split xml values
   public static String extractPayload(String a,String tag)  
   {  
             if(a=="" || a==null )  
             {  
                 return a;  
             }  
             String beginTag="<"+tag+">",endTag="</"+tag+">";  
             int i,j,l;  
             i=a.indexOf(beginTag);  
             l=beginTag.length();  
             j=a.indexOf(endTag);  
             if(i>=0 && i<j)  
             {  
                            a=a.substring(i+l,j);  
             }  
          //   System.out.println("Returned Result="+a);
             return a;  
   }  


}