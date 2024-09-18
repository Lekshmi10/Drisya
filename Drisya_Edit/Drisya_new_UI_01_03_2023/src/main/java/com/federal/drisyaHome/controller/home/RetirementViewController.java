package com.federal.drisyaHome.controller.home;

import com.federal.drisyaHome.dao.RedisDao;
import com.federal.drisyaHome.dao.home.RetirementDao;
import com.federal.drisyaHome.model.Retirement;
import com.federal.drisyaHome.service.home.RetirementService;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

@Controller
public class RetirementViewController {
	
	 @Autowired
	    EntityManager entityManager;
	
	 @Autowired
     RedisDao redisDao;
	 
	 @Autowired
     RetirementService retirementService;
	 
	 public String[] pfnum=new String[10];
	 
	 RetirementDao retirementDao=new RetirementDao();
	 //@PostMapping("/uploadRetirement")
	 @RequestMapping(value="/uploadRetirement",method = { RequestMethod.GET, RequestMethod.POST })	
	@ResponseBody
	public Retirement setApplicationRetirementbyPfnum(@RequestParam(value="file", required= false) MultipartFile file, HttpSession session) throws IOException{
	    	String newsplit=new String();
	    	String nullspace=new String();
	    	
	    	 try {
	    			
	    			
	    		 String[] split=new String[100];
	    		 
	    		 String[][] data = null;
	    		 StringBuffer pf_String;
	    		 
	    			ArrayList<String> datalist = new ArrayList<String>();
	    			//String fileext = FilenameUtils.getExtension(filename);
	    			 FileInputStream fis=(FileInputStream) file.getInputStream();
	    			 String filename=file.getOriginalFilename();
	    			 String fileext = FilenameUtils.getExtension(filename);
	    				System.out.println("file is ext  :" + fileext);
	    			 System.out.println(filename);
	    			 Iterator<Row> rowIterator=null;
	    			 int i=0;
	    			 if(fileext.equals("xls")){
	    					HSSFWorkbook workbook = new HSSFWorkbook(fis);
	    					// Get first/desired sheet from the workbook
	    					HSSFSheet sheet = workbook.getSheetAt(0);
	    					 rowIterator = sheet.iterator();
	    					 for(Row row:sheet) {
	    							
	    							int n=sheet.getLastRowNum();
	    							if(i==row.getRowNum()&& i<=n) {
	    								System.out.println(row.getRowNum()+" true"+i);	   
	    								i++;
	    						}else {
	    							System.out.println(row.getRowNum()+" false"+i);
	    							rowIterator=null;
	    						}
	    						}
	    					}else if(fileext.equals("xlsx")){
	    			 	System.out.println("file format is xlsx");
	    						XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    						// Get first/desired sheet from the workbook
	    						XSSFSheet sheet = workbook.getSheetAt(0);
	    						rowIterator = sheet.iterator();
	    						
	    						for(Row row:sheet) {
	    							
	    							int n=sheet.getLastRowNum();
	    							System.out.println(n);
	    							if(i==row.getRowNum()&& i<=n) {
	    								System.out.println(row.getRowNum()+" true"+i);	   
	    								i++;
	    						}else {
	    							System.out.println(row.getRowNum()+" false"+i);
	    							rowIterator=null;
	    						}
	    						}
				/*
				 *  if(sheet.getRow(0)== null) {
				 * System.out.println("null"); }
				 */
	    					}
	    			 
			/*
			 * while (rowIterator.hasNext()) { Row row = rowIterator.next(); Iterator<Cell>
			 * cellIterator = row.cellIterator(); while (cellIterator.hasNext()) { Cell cell
			 * = cellIterator.next();
			 * 
			 * } }
			 */
	    			 
	    			 if(rowIterator==null) {
	    				 nullspace="space";
	    			 }else {
	    			 Row headerRow = rowIterator.next();
	    				 int rw=0;
	    				 int cl=0;
	    				 
	    				 while (rowIterator.hasNext()) {
	    					 System.out.println("next"+rowIterator.hasNext());
	    					 System.out.print("row"+rw);
	    					 rw++;
	    					 int o=0;
	    						datalist.clear();
	    						Row row = rowIterator.next();
	    						//System.out.println("next row:");
	    						//System.out.println("null"+row);
	    						
				
				  for (int cn = 0; cn < row.getLastCellNum(); cn++) { 
					  Cell cell =
				  row.getCell(cn, row.CREATE_NULL_AS_BLANK); //
					 // System.out.println("INVALID DATA"+row.getCell(cn).getStringCellValue());
				  System.out.println("CELL:  "+cn+":"+cell.toString()); }
				 
	    						
	    						// For each row, iterate through all the columns
	    						Iterator<Cell> cellIterator = row.cellIterator();
	    						while (cellIterator.hasNext()) {
	    							
	    							//System.out.println("col"+cl);
	    							 cl++;
	    							Cell cell = cellIterator.next();
	    							if(cell.getCellType()!=cell.CELL_TYPE_NUMERIC) {
	    								newsplit=null;
	    								nullspace="characters";	  
	    								System.out.println("nullspace"+nullspace);
	    					        }else {
	    					        	System.out.println("start");
	    							//System.out.println("CELL TYPE");
	    							// Check the cell type and format accordingly
	    							switch (cell.getCellType()) {
	    							case Cell.CELL_TYPE_NUMERIC:
	    								Double d=cell.getNumericCellValue();
	    								Integer in=d.intValue();
	    								Double pf_double=(cell.getNumericCellValue());
	    								datalist.add(pf_double.toString());
	    								newsplit=newsplit+in.toString()+" ";
	    								System.out.println("datalist"+datalist);
	    								
	    								//System.out.println("pf string"+split.toString());
	    								
	    								break;
	    							}}}
	    						System.out.println("size: " +newsplit);		
	    				 }
	    				 System.out.println("size: " +newsplit);
	    				
	    			 }	
	    	 }catch (Exception e) {
	    		System.err.println(e);
	    	}
	        	System.out.println("*************uploadRetirement*********************************************************************************");
	        
	        	// httpServletResponse.sendRedirect("http://localhost:9098/retirement_view");
	        	
	        	
	              return retirementService.geUploadRetirementView(newsplit,nullspace);
	       
		}
	
	
	    @RequestMapping(value="/uploadVrs",method = { RequestMethod.GET, RequestMethod.POST })	
		@ResponseBody
		public Retirement setApplicationVrsbyPfnum(@RequestParam(value="file", required= false) MultipartFile file, HttpSession session) throws IOException{
		    	String newsplit=new String();
		    	String nullspace=new String();
		    	 try {
		    			
		    			
		    		 String[] split=new String[10];
		    		 
		    		 String[][] data = null;
		    		 StringBuffer pf_String;
		    		 
		    			ArrayList<String> datalist = new ArrayList<String>();
		    			//String fileext = FilenameUtils.getExtension(filename);
		    			 FileInputStream fis=(FileInputStream) file.getInputStream();
		    			 String filename=file.getOriginalFilename();
		    			 String fileext = FilenameUtils.getExtension(filename);
		    				System.out.println("file is ext  :" + fileext);
		    			 System.out.println(filename);
		    			 Iterator<Row> rowIterator=null;
		    			 int i=0;
		    			 if(fileext.equals("xls")){
		    					HSSFWorkbook workbook = new HSSFWorkbook(fis);
		    					// Get first/desired sheet from the workbook
		    					HSSFSheet sheet = workbook.getSheetAt(0);
		    					 rowIterator = sheet.iterator();
		    					 for(Row row:sheet) {
		    							
		    							int n=sheet.getLastRowNum();
		    							if(i==row.getRowNum()&& i<=n) {
		    								System.out.println(row.getRowNum()+" true"+i);	   
		    								i++;
		    						}else {
		    							System.out.println(row.getRowNum()+" false"+i);
		    							rowIterator=null;
		    						}
		    							
		    						}
		    					}else if(fileext.equals("xlsx")){
		    						XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    						// Get first/desired sheet from the workbook
		    						XSSFSheet sheet = workbook.getSheetAt(0);
		    						 rowIterator = sheet.iterator();
		    						 for(Row row:sheet) {
			    							
			    							int n=sheet.getLastRowNum();
			    							if(i==row.getRowNum()&& i<=n) {
			    								System.out.println(row.getRowNum()+" true"+i);	   
			    								i++;
			    						}else {
			    							System.out.println(row.getRowNum()+" false"+i);
			    							rowIterator=null;
			    						}
			    						}
		    					}
		    			 if(rowIterator==null) {
		    				 nullspace="space";
		    			 }else {
		    			 Row headerRow = rowIterator.next();
		    				 int rw=0;
		    				 int cl=0;
		    				 
		    				 while (rowIterator.hasNext()) {
		    					 //System.out.print("row"+rw);
		    					 rw++;
		    					 int o=0;
		    						datalist.clear();
		    						Row row = rowIterator.next();
		    						//System.out.println("next row:");
		    						for (int cn = 0; cn < row.getLastCellNum(); cn++) {
		    							Cell cell = row.getCell(cn, row.CREATE_NULL_AS_BLANK);
		    							// System.out.println("CELL:  "+cn+":"+cell.toString());
		    						}
		    						
		    						// For each row, iterate through all the columns
		    						Iterator<Cell> cellIterator = row.cellIterator();
		    						while (cellIterator.hasNext()) {
		    							
		    							//System.out.println("col"+cl);
		    							 cl++;
		    							Cell cell = cellIterator.next();
		    							if(cell.getCellType()!=cell.CELL_TYPE_NUMERIC) {
		    								newsplit=null;
		    								nullspace="characters";	  
		    								System.out.println("nullspace"+nullspace);
		    					        }else {
		    							// Check the cell type and format accordingly
		    							switch (cell.getCellType()) {
		    							case Cell.CELL_TYPE_NUMERIC:
		    								Double d=cell.getNumericCellValue();
		    								
		    								Integer in=d.intValue();
		    								Double pf_double=(cell.getNumericCellValue());
		    								datalist.add(pf_double.toString());
		    								newsplit=newsplit+in.toString()+" ";
		    								System.out.println("datalist"+datalist);
		    								
		    								//System.out.println("pf string"+split.toString());
		    								
		    								break;
		    							}}}
		    						System.out.println("size: " +newsplit);		
		    				 }
		    				 System.out.println("size: " +newsplit);
		    				
		    			 }
		    	 }catch (Exception e) {
		    		System.err.println(e);
		    	}
		        	System.out.println("*************uploadRetirement*********************************************************************************");
		        
		        	// httpServletResponse.sendRedirect("http://localhost:9098/retirement_view");
		             return retirementService.geUploadRetirementView(newsplit,nullspace);
		       
			}
		
		
		
	
	 
	
}
