package com.siemens.tracker.backend.service;

/*import java.sql.Date;*/
import java.util.List;
import java.util.Map;
import java.util.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;

import com.siemens.tracker.backend.dao.Recon;
import com.siemens.tracker.backend.dao.User;
import com.siemens.tracker.backend.dao.UserRoles;

public interface TrackerService {
	
	/**
	 * Gets recon count.
	 *
	 * 
	 */
		
	public int getReconCount();

	/**
	 * Gets user list with ROLE USER.
	 *
	 * 
	 */
	
	public List<UserRoles> getUserRolesList();
	
	/**
	 * Checks user available.(with respect to ZID)
	 *
	 * 
	 */
	
	public List<User> findByUsernameContaining(String username);
	
	/**
	 * Checks user available.(with respect to name)
	 *
	 * 
	 */
	public List<User> findByNameContaining(String name);
	
	/**
	 * Checks old password(with respect to name)
	 *
	 * 
	 */
	
	public String findByOldPassword(String name); 
	
	
	/**
	 * Gets recon type list.
	 *
	 * 
	 */
	
/*	public List<Recon> getReconTypesList();*/
	
	
	/**
	 * Inserts recon details into database.
	 *
	 * 
	 */
	
	 public void insertReconDetails(Integer sugarTicket,String accountNumber,String reconType,String reconPreparedBy,String reconReviewedBy,
			  String criticality,Float timeTaken,String reviewComments,String commentsType,Date convertedReviewDate,Date convertedSharingDate,String tariff); 
	 
	 /**
		 * Inserts BCO File into database.
		 *
		 * 
		 */
	 
	public void insertBco(String concatenatedId,String contractAccount,String organisationName,Date bcoDate,String meterSerialNumber,String rateCategory,String consumerType); 
	 

	/**
	 * Get details from database.
	 *
	 * 
	 */
		
	 public Page<Recon> findReconPreparedBy(String users,Date convertedDatepickerFrom,Date convertedDatepickerTo,PageRequest pageRequest);
	  /* public Page<Recon> findReconPreparedBy(String users,PageRequest pageRequest); */  
	 
	 /**
		 * Inserts new user into database.
		 *
		 * 
		 */
	 void insertUser(String username,String password,String name);
	 
	 /**
		 * Inserts new user role into database.
		 *
		 * 
		 */
	 void insertUserRole(String username,String role,String name);
	 
	 /**
		 * Inserts new password into database.
		 *
		 * 
		 */
	 void updatePassword(String name,String newPassword);
	 
	 public String findTariff(String concatenatedId); 
}
