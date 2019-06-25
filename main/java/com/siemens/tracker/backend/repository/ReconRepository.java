package com.siemens.tracker.backend.repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.transaction.annotation.Transactional;

import com.siemens.tracker.backend.dao.Recon;
import com.siemens.tracker.backend.dao.User;

	public interface ReconRepository extends JpaRepository<Recon, String> {
	
	/**
	 * Get recon count.
	 *
	 */
	
	@Query( "select count(u) from Recon u " )
	int getReconCount();
	
	/**
	 * Get recon count.
	 *
	 */
	
	/*@Query("select distinct(u.Recon_Type) from Recon u")
	List<Recon> getReconTypesList();*/
	
	/*@NamedQuery(name = "getDistinctReconTypeFromRecon", 
		    query = "select distinct u reconType from Recon u")*/
	
	/**
	 * Inserts recon details.
	 *
	 */
	@Modifying
	@Transactional
	@Query(value = "insert into recon_details (Sugar_Ticket,Account_Number,Recon_Type,Recon_Prepared_By,Recon_Reviewed_By,Criticality,Time_Taken,Review_Comments,Comments_Type,Date_of_Review,Date_of_Sharing,Tariff) "
			+ "VALUES (:sugarTicket,:accountNumber,:reconType,:reconPreparedBy,:reconReviewedBy,:criticality,:timeTaken,:reviewComments,:commentsType,:convertedReviewDate,:convertedSharingDate,:tariff)", nativeQuery = true)
	
	void insertReconDetails(@Param("sugarTicket") Integer sugarTicket, @Param("accountNumber") String accountNumber,@Param("reconType") String reconType,
			@Param("reconPreparedBy") String reconPreparedBy,@Param("reconReviewedBy") String reconReviewedBy,
			@Param("criticality") String criticality,@Param("timeTaken") Float timeTaken,@Param("reviewComments") String reviewComments,@Param("commentsType") String commentsType,
			@Param("convertedReviewDate") Date convertedReviewDate,@Param("convertedSharingDate") Date convertedSharingDate,@Param("tariff") String tariff);
	
/**
* Find ReconPreapredBy details.
*
* @param users
* @param convertedDatepickerFrom
* @param convertedDatepickerTo
* @return the page
*/
@Query("select u from Recon u where u.reconPreparedBy like :users and u.sharingDate between :convertedDatepickerFrom and :convertedDatepickerTo")
/*Page<Recon> findReconPreparedBy(@Param("users") String users,Pageable pageable);*/
public Page<Recon> findReconPreparedBy(@Param("users") String users,@Param("convertedDatepickerFrom") Date convertedDatepickerFrom,@Param("convertedDatepickerTo") Date convertedDatepickerTo,Pageable pageable);

/*public List<Recon> findReconPreparedBy(@Param("users") String users,@Param("convertedDatepickerFrom") Date convertedDatepickerFrom,@Param("convertedDatepickerTo") Date convertedDatepickerTo);*/

}



