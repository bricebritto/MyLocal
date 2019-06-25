package com.siemens.tracker.backend.service;

/*import java.sql.Date;*/
import java.util.List;
import java.util.Map;
import java.util.Date;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.siemens.tracker.backend.dao.Recon;
import com.siemens.tracker.backend.dao.User;
import com.siemens.tracker.backend.dao.UserRoles;
import com.siemens.tracker.backend.repository.BcoRepository;
import com.siemens.tracker.backend.repository.ReconRepository;
import com.siemens.tracker.backend.repository.UserRepository;
import com.siemens.tracker.backend.repository.UserRolesRepository;

@Service
public class TrackerServiceImpl implements TrackerService{
	
	
	@Resource
	private ReconRepository reconRepository;
	
	@Resource
	private UserRepository userRepository;
	
	@Resource
	private UserRolesRepository userRolesRepository;
	
	@Resource
	private BcoRepository bcoRepository;

	
	public int getReconCount() {
				return reconRepository.getReconCount();
	}
	
	public List<UserRoles> getUserRolesList() {
		return userRolesRepository.getUserRolesList();
	}
	
	public List<User> findByUsernameContaining(String username){
		return userRepository.findByUsernameContaining(username);
		/*return userRepository.findAll().get(1).getName()getClass();*/
	}
	
	public List<User> findByNameContaining(String name){
		return userRepository.findByNameContaining(name);
	}
	
	public String findByOldPassword(String name){
		 return userRepository.findByOldPassword(name);
	}
	
	/*public List<UserRoles> getUserRolesList() {
		return userRolesRepository.getUserRolesList();
	}*/
	
	/*public List<Recon> getReconTypesList(){
		return reconRepository.getReconTypesList();
	}
*/
	public void updatePassword(String name,String newPassword){
		 userRepository.updatePassword(name,newPassword);
	}
	public void insertReconDetails(Integer sugarTicket, String accountNumber, String reconType, String reconPreparedBy,
			String reconReviewedBy,String criticality,Float timeTaken,String reviewComments,String commentsType,Date convertedReviewDate,Date convertedSharingDate,String tariff) {
	
		reconRepository.insertReconDetails(sugarTicket,accountNumber,reconType,reconPreparedBy,reconReviewedBy,criticality,timeTaken,reviewComments,commentsType,convertedReviewDate,convertedSharingDate,tariff);
	}
	
	public void insertBco(String concatenatedId,String contractAccount,String organisationName,Date bcoDate,String meterSerialNumber,String rateCategory,String consumerType){
		
		bcoRepository.insertBco(concatenatedId,contractAccount,organisationName,bcoDate,meterSerialNumber,rateCategory,consumerType);
	}
	
	public Page<Recon> findReconPreparedBy(String users,Date convertedDatepickerFrom,Date convertedDatepickerTo,PageRequest pageRequest){
		return reconRepository.findReconPreparedBy(users, convertedDatepickerFrom, convertedDatepickerTo, pageRequest);
	}
	
	/*public Page<Recon> findReconPreparedBy(String users,PageRequest pageRequest){
		return reconRepository.findReconPreparedBy(users,pageRequest);
		}*/
	/**
	 * Inserts user into database.
	 *
	 * 
	 */
	public void insertUser(String username,String password,String name){
		userRepository.insertUser(username, password, name);
	}
	/**
	 * Inserts user role into database.
	 *
	 * 
	 */
	public void insertUserRole(String username,String role,String name){
		userRolesRepository.insertUserRole(username, role, name);
	}
	
	 public String findTariff(String concatenatedId){
		return bcoRepository.findTariff(concatenatedId);
	 }
}
	
	