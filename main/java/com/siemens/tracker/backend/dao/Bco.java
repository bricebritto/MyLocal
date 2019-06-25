package com.siemens.tracker.backend.dao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BCO_File")
public class Bco implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="Concatenated_ID")
	private String concatenatedId;
	
	@Column(name="Contract_Account")
	private String contractAccount;
	
	@Column(name="Organisation_Name")
	private String organisationName;
	
	@Column(name="BCO_Date")
	private Date bcoDate;
	
	@Column(name="Meter_Serial_Number")
	private String meterSerialNumber;
	
	@Column(name="Rate_Category")
	private String rateCategory;
	
	@Column(name="Consumer_Type")
	private String consumerType;

	/**
	 * @return the concatenated_ID
	 */
	public String getConcatenated_ID() {
		return concatenatedId;
	}

	/**
	 * @param concatenated_ID the concatenated_ID to set
	 */
	public void setConcatenated_ID(String concatenated_ID) {
		concatenatedId = concatenated_ID;
	}

	/**
	 * @return the contract_Account
	 */
	public String getContract_Account() {
		return contractAccount;
	}

	/**
	 * @param contract_Account the contract_Account to set
	 */
	public void setContract_Account(String contract_Account) {
		contractAccount = contract_Account;
	}

	/**
	 * @return the organisation_Name
	 */
	public String getOrganisation_Name() {
		return organisationName;
	}

	/**
	 * @param organisation_Name the organisation_Name to set
	 */
	public void setOrganisation_Name(String organisation_Name) {
		organisationName = organisation_Name;
	}

	/**
	 * @return the bCO_Date
	 */
	public Date getBCO_Date() {
		return bcoDate;
	}

	/**
	 * @param bCO_Date the bCO_Date to set
	 */
	public void setBCO_Date(Date bCO_Date) {
		bcoDate = bCO_Date;
	}

	/**
	 * @return the meter_Serial_Number
	 */
	public String getMeter_Serial_Number() {
		return meterSerialNumber;
	}

	/**
	 * @param meter_Serial_Number the meter_Serial_Number to set
	 */
	public void setMeter_Serial_Number(String meter_Serial_Number) {
		meterSerialNumber = meter_Serial_Number;
	}

	/**
	 * @return the rate_Category
	 */
	public String getRate_Category() {
		return rateCategory;
	}

	/**
	 * @param rate_Category the rate_Category to set
	 */
	public void setRate_Category(String rate_Category) {
		rateCategory = rate_Category;
	}

	/**
	 * @return the consumer_Type
	 */
	public String getConsumer_Type() {
		return consumerType;
	}

	/**
	 * @param consumer_Type the consumer_Type to set
	 */
	public void setConsumer_Type(String consumer_Type) {
		consumerType = consumer_Type;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Bco [Concatenated_ID=" + concatenatedId + ", Contract_Account=" + contractAccount
				+ ", Organisation_Name=" + organisationName + ", BCO_Date=" + bcoDate + ", Meter_Serial_Number="
				+ meterSerialNumber + ", Rate_Category=" + rateCategory + ", Consumer_Type=" + consumerType + "]";
	}
	
	
	
}