package com.siemens.tracker.web.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
/*import java.sql.Date;*/
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.util.SystemOutLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.siemens.tracker.backend.dao.Recon;
import com.siemens.tracker.backend.dao.User;
import com.siemens.tracker.backend.service.TrackerService;
import com.siemens.tracker.backend.util.Util;
import com.siemens.tracker.datatable.dto.DataTablesRequest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@RestController
public class MainController{
	
	/** The login. */
	private String login ="login";
	
	private String recon ="recon";
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	/* Upload BCO */
 	private static String UPLOADED_FOLDER = "F://temp//";
	
	/** The records total. */
	private String recordsTotal = "recordsTotal";
	/** The records filtered. */
	private String recordsFiltered = "recordsFiltered";
	
	@Autowired
	Util util;
	
	@Resource
	protected TrackerService trackerService;
		 	     

	   	@RequestMapping(value="/recon", method=RequestMethod.POST)
	   /*	@ResponseStatus(value = HttpStatus.OK)*/
	   	@ResponseBody
	   	
			public boolean insertDetails(@RequestParam(value="sugarTicket")Integer sugarTicket,@RequestParam(value="accountNumber")String accountNumber,
				@RequestParam(value="reconType")String reconType,@RequestParam(value="reconPreparedBy")String reconPreparedBy,
				@RequestParam(value="reconReviewedBy")String reconReviewedBy,@RequestParam(value="criticality")String criticality,@RequestParam(value="timeTaken")Float timeTaken,
				@RequestParam(value="reviewComments")String reviewComments,@RequestParam(value="commentsType")String commentsType,@RequestParam(value="reviewDate")String reviewDate,
				@RequestParam(value="sharingDate")String sharingDate)throws IOException {
	   		/*,@RequestParam(value="tariffCategory")String tariffCategory*/
		   	logger.info("Process started");
		   	String tariff = null;
		  int count = trackerService.getReconCount();
			System.out.println("Total Count = " + count);
			System.out.println("Review date is" + reviewDate); 
			
			Date convertedReviewDate = util.formatStringToDate(reviewDate);
			Date convertedSharingDate = util.formatStringToDate(sharingDate);
			System.out.println("After Conversion: " + convertedReviewDate);
			
			if(accountNumber != null){
				  tariff = trackerService.findTariff(accountNumber);
				System.out.println(" tariff for " + accountNumber + " is " + tariff);
			}
			
		 if(count >= 0){
		  trackerService.insertReconDetails(sugarTicket,accountNumber,reconType,reconPreparedBy,reconReviewedBy,
				  criticality,timeTaken,reviewComments,commentsType,convertedReviewDate,convertedSharingDate,tariff);
		  System.out.println("Inserted Successfully");
		  return true;
		  }
		  else{
			  
			  return false;
	   	  }
		 
	  }
	   	
	  @RequestMapping(value="/tariff", method=RequestMethod.POST)
	   		public String getTariff (@RequestParam(value="accountNumber")String accountNumber)throws IOException{
	   	    String tariffCat = trackerService.findTariff(accountNumber);
	   		return tariffCat;  			
	   		}
	   	
	   	
	  
	   	/*public boolean check() {
			logger.info("Process started");
		  List<User> userList = trackerService.getUserList();
			System.out.println("Users are: " + userList);
			return true;
	   }*/ 	
		   		
		   	@RequestMapping(value="/admin", method=RequestMethod.POST)
		   	@ResponseBody  
		   	public Map<String, Object> findReconPreparedBy(@RequestBody final DataTablesRequest dataTablesRequest)
					throws IOException {
	   		
		   
	   		int pageNo = dataTablesRequest.getStart() / dataTablesRequest.getLength();
			int recordLength = dataTablesRequest.getLength();
			String users = dataTablesRequest.getColumns().get(3).getSearch().getValue();
			String datepickerFrom = dataTablesRequest.getColumns().get(9).getSearch().getValue();
			String datepickerTo = dataTablesRequest.getColumns().get(10).getSearch().getValue();
			System.out.println("Selected User:" + users);
			System.out.println("datepickerFrom:" + datepickerFrom);
			System.out.println("datepickerTo:" + datepickerTo);
			String sortingDirections = dataTablesRequest.getOrder().get(0).getDir();
			String sortingcolumn = dataTablesRequest.getColumns()
					.get(Integer.parseInt(dataTablesRequest.getOrder().get(0).getColumn())).getData();
			Sort sort = new Sort(util.getSortingDirction(sortingDirections), sortingcolumn);
	   		PageRequest pageRequest = new PageRequest(pageNo, recordLength, sort);
	   		Map<String, Object> adminReqReport = new HashMap<>();
	   		
	   		Date convertedDatepickerFrom = util.formatStringToDate(datepickerFrom);
		   	System.out.println("convertedDatepickerFrom: " + convertedDatepickerFrom);
		   	Date convertedDatepickerTo = util.formatStringToDate(datepickerTo);
		   
		   	System.out.println("convertedDatepickerTo: " + convertedDatepickerTo);
	   		
		   	Page<Recon> adminReq = trackerService.findReconPreparedBy(users,convertedDatepickerFrom,convertedDatepickerTo,pageRequest);
	   		adminReqReport.put("draw",dataTablesRequest.getDraw());
	   		adminReqReport.put(recordsTotal,adminReq.getTotalElements());
	   		adminReqReport.put(recordsFiltered, adminReq.getTotalElements());
	   		adminReqReport.put("data", adminReq.getContent());
	   		return adminReqReport;	
}
		   	@RequestMapping(value="/addUser", method=RequestMethod.POST)
		   	@ResponseBody
		   	public boolean createUser(@RequestParam(value="username")String username,@RequestParam(value="name")String name,@RequestParam(value="password")String password,@RequestParam(value="role")String role,HttpServletResponse response)
		   					throws IOException{
		   		String usernameUpperCase = username.toUpperCase();
		   		List<User> userAvlCheck = trackerService.findByUsernameContaining(usernameUpperCase);
		   		
		   			if(userAvlCheck.size() == 0){
		   				trackerService.insertUser(usernameUpperCase, password, name);
		   				trackerService.insertUserRole(usernameUpperCase, role, name);
		   				return true;
		   			}else{
		   				System.out.println("User Already Available");
		   				return false;
		   			}
		   			
		   	}
		   	
		   	@RequestMapping(value="/resetPassword", method=RequestMethod.POST)
		   	@ResponseBody
		   	public boolean changePassword(@RequestParam(value="name")String name,@RequestParam(value="oldPassword")String oldPassword,@RequestParam(value="newPassword")String newPassword,HttpServletResponse response)
		   						throws IOException{
		   	/*	String usernameUpperCase = username.toUpperCase();*/
		   		
		   		String checkOldPassword = trackerService.findByOldPassword(name);
		   		System.out.println("Old Password from Db:" + checkOldPassword );
		   		System.out.println("Old Password enetered by user:" + oldPassword);
		   /*		String checkOldPassword = trackerService.findByOldPassword(oldPassword);*/
		   		if(checkOldPassword.equals(oldPassword)){
		   		
		   			List<User> userAvlCheck = trackerService.findByNameContaining(name);
		   		
		   		if(userAvlCheck.size() != 0){
		   			trackerService.updatePassword(name,newPassword);
		   			System.out.println("Change credentials");
		   			return true;
		   		}else{
		   			System.out.println("User unavailable");
		   			return false;
		   		}
		   		}else{
		   			System.out.println("Entered old Password is invalid");
		   			return false;
		   		}
		   	}
		   	
		   	@RequestMapping(value = "/errorPage", method = RequestMethod.GET)
			public ModelAndView accesssDenied(Principal user) {

				ModelAndView model = new ModelAndView();

				if (user != null) {
					model.addObject("msg", "OOPS! You are not allowed to access this page!");
				} else {
					model.addObject("msg",
					"You are not allowed to access this page!");
				}

				model.setViewName("errorPage");
				return model;

			}
		   	
		   	
		   		/*public ModelAndView check(){
		   		ModelAndView mod = new ModelAndView();
		   		System.out.println("BCO FILE upload page");
		   		System.out.println("BCO FILE upload page uploading......");
		   		return mod;
		   		}*/
		
		   	@RequestMapping(value="/BCOupload", method = RequestMethod.POST)
		   	@ResponseBody
		    public boolean bcoFileUpload(@RequestParam("file") MultipartFile file,
		                                   RedirectAttributes redirectAttributes) throws InvalidFormatException {
		   		
		   		System.out.println(":: FILE 2 ::" + file.getOriginalFilename());
		   		
	   		 	List<String> list = new ArrayList<>();
	   		 			        
		       	if (file.isEmpty()) {
		            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
		           // return "redirect:uploadStatus";
		            return false;
		        }
		       	try{
		       		String excelFilePath = file.getOriginalFilename();
		       		FileInputStream inputfile = new FileInputStream(new File("D:\\bco\\" + excelFilePath));
			        XSSFWorkbook workbook = new XSSFWorkbook(inputfile);
		       		/*XSSFWorkbook workbook = StreamingReader.builder().sstCacheSize(100).open(inputfile);*/
		       		//Workbook workbook = WorkbookFactory.create(new File("D:\\bco\\" + excelFilePath));
			        XSSFSheet sheet = workbook.getSheetAt(0);
			        Iterator<Row> rowIterator = sheet.iterator();
			        rowIterator.next();
			        while(rowIterator.hasNext())
			        {
			            Row row = rowIterator.next();
			            //For each row, iterate through each columns
			            
			            if(row.getRowNum()==0 || row.getRowNum()==1){
			            	System.out.println(":: ROW 0 or 1 ::");
			            	continue;
			            }
			           			            
			            
			            Iterator<Cell> cellIterator = row.cellIterator();

			            while(cellIterator.hasNext())
			            {
			                Cell cell = cellIterator.next();
			                //This will change all Cell Types to String
			                cell.setCellType(Cell.CELL_TYPE_STRING);
			                switch(cell.getCellType()) 
			                {
			                    case Cell.CELL_TYPE_BOOLEAN:
			                        System.out.println("boolean===>>>"+cell.getBooleanCellValue() + "\t");
			                        break;
			                    case Cell.CELL_TYPE_NUMERIC:

			                        break;
			                    case Cell.CELL_TYPE_STRING:

			                       list.add(cell.getStringCellValue());

			                       break;
			                }

			            }
			          String ConcatenatedID =row.getCell(0).getStringCellValue();
			          String ContractAccount= row.getCell(1).getStringCellValue();
			          String OrganisationName=row.getCell(2).getStringCellValue();
			          String BCODate=row.getCell(3).getStringCellValue();
			          String MeterSerialNumber=row.getCell(4).getStringCellValue();
			          
			         /* if(row.getRowNum() == 1432){
			        	  
			        	  System.out.println(": MATERIAL BNUBERSER::" + MeterSerialNumber);
			          }*/
			          
			          String RateCategory=row.getCell(5).getStringCellValue();
			          String ConsumerType=row.getCell(6).getStringCellValue();
			       	  Date ConBCODate = util.formatStringToDate(BCODate);
			           			            
			           /* System.out.println("ContractAccount::" + MeterSerialNumber);
			            System.out.println("Length::" + MeterSerialNumber.length());*/
			       	 // System.out.println("Started..");
			            //ex.InsertRowInDB(name,empid,add,mobile);
			           // System.out.println("");
			            trackerService.insertBco(ConcatenatedID, ContractAccount, OrganisationName, ConBCODate, MeterSerialNumber, RateCategory, ConsumerType);

			         }
			        inputfile.close();
			    } 
		        catch (FileNotFoundException e) {
			        e.printStackTrace();
			    } catch (IOException e) {
			        e.printStackTrace();
			    }
		       	
		       	 return true ; 	
		   			   	
		   	}
		  
		
		   	

}
