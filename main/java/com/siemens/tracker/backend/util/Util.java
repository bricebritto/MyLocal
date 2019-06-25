package com.siemens.tracker.backend.util;
import java.util.Date;
/*import java.sql.Date;*/
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class Util{


/**
	 * This method will sort the direction string to spring Sort enum Direction.
	 *
	 * @param direction
	 *            the direction
	 * @return sort direction
	 */
	public Sort.Direction getSortingDirction(String direction) {
		if ("asc".equals(direction)) {
			return Sort.Direction.ASC;
		} else {
			return Sort.Direction.DESC;
		}
	}
	
	public Date formatStringToDate(String convertedDate) {
		
		if(null == convertedDate){
			return null;
		}else{
			
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date parsedDate=null;
			
			try {
				parsedDate = formatter.parse(convertedDate);
				/*java.sql.Date convertedSqlDate = new Date(parsedDate.getTime())*/
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return parsedDate;
		}
		
		
		
	}

}