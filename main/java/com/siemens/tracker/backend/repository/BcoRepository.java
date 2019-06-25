package com.siemens.tracker.backend.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.siemens.tracker.backend.dao.Bco;



public interface BcoRepository extends JpaRepository<Bco, String> {
	
	
	/**
	 * Inserts BCO File.
	 *
	 */
	@Modifying
	@Transactional
	@Query(value = "insert into BCO_File (Concatenated_ID,Contract_Account,Organisation_Name,BCO_Date,Meter_Serial_Number,Rate_Category,Consumer_Type)"
			+ "VALUES (:concatenatedId,:contractAccount,:organisationName,:bcoDate,:meterSerialNumber,:rateCategory,:consumerType)", nativeQuery = true)
	
	void insertBco(@Param("concatenatedId") String concatenatedId, @Param("contractAccount") String contractAccount,@Param("organisationName") String organisationName,
			@Param("bcoDate") Date bcoDate,@Param("meterSerialNumber") String meterSerialNumber,@Param("rateCategory") String rateCategory,@Param("consumerType") String consumerType);

	/**
	 * Finds tariff from BCO File.
	 * @return 
	 *
	 */
	@Query("select u.rateCategory from Bco u where u.concatenatedId like %:concatenatedId%")
	public String findTariff(@Param("concatenatedId")String concatenatedId);
		

}