package com.siemens.tracker.backend.dao;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="recon_details")
public class Recon implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="Sugar_Ticket")
	private Integer sugarTicket; 
	@Column(name="Account_Number")
	private String accountNumber; 
	@Column(name="Recon_Type")
	private String reconType; 
	@Column(name="Recon_prepared_by")
	private String reconPreparedBy; 
	@Column(name="Recon_reviewed_by")
	private String reconReviewedBy;
	@Column(name="Criticality")
	private String criticality;
	@Column(name="Time_Taken")
	private Float timeTaken;
	@Column(name="Review_Comments")
	private String reviewComments;
	@Column(name="Comments_Type")
	private String commentsType;
	@Column(name="Date_of_Review")
	private Date reviewDate;
	@Column(name="Date_of_Sharing")
	private Date sharingDate;
	@Column(name="Tariff")
	private String tariffCategory;
		
	
	/**
	 * @return the sugarTicket
	 */
	public Integer getSugarTicket() {
		return sugarTicket;
	}




	/**
	 * @param sugarTicket the sugarTicket to set
	 */
	public void setSugarTicket(Integer sugarTicket) {
		this.sugarTicket = sugarTicket;
	}




	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}




	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}




	/**
	 * @return the reconType
	 */
	public String getReconType() {
		return reconType;
	}




	/**
	 * @param reconType the reconType to set
	 */
	public void setReconType(String reconType) {
		this.reconType = reconType;
	}




	/**
	 * @return the reconPreparedBy
	 */
	public String getReconPreparedBy() {
		return reconPreparedBy;
	}




	/**
	 * @param reconPreparedBy the reconPreparedBy to set
	 */
	public void setReconPreparedBy(String reconPreparedBy) {
		this.reconPreparedBy = reconPreparedBy;
	}




	/**
	 * @return the reconReviewedBy
	 */
	public String getReconReviewedBy() {
		return reconReviewedBy;
	}




	/**
	 * @param reconReviewedBy the reconReviewedBy to set
	 */
	public void setReconReviewedBy(String reconReviewedBy) {
		this.reconReviewedBy = reconReviewedBy;
	}




	/**
	 * @return the criticality
	 */
	public String getCriticality() {
		return criticality;
	}




	/**
	 * @param criticality the criticality to set
	 */
	public void setCriticality(String criticality) {
		this.criticality = criticality;
	}




	/**
	 * @return the timeTaken
	 */
	public Float getTimeTaken() {
		return timeTaken;
	}




	/**
	 * @param timeTaken the timeTaken to set
	 */
	public void setTimeTaken(Float timeTaken) {
		this.timeTaken = timeTaken;
	}




	/**
	 * @return the reviewComments
	 */
	public String getReviewComments() {
		return reviewComments;
	}




	/**
	 * @param reviewComments the reviewComments to set
	 */
	public void setReviewComments(String reviewComments) {
		this.reviewComments = reviewComments;
	}




	/**
	 * @return the commentsType
	 */
	public String getCommentsType() {
		return commentsType;
	}




	/**
	 * @param commentsType the commentsType to set
	 */
	public void setCommentsType(String commentsType) {
		this.commentsType = commentsType;
	}




	/**
	 * @return the reviewDate
	 */
	public Date getReviewDate() {
		return reviewDate;
	}




	/**
	 * @param reviewDate the reviewDate to set
	 */
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}




	/**
	 * @return the sharingDate
	 */
	public Date getSharingDate() {
		return sharingDate;
	}




	/**
	 * @param sharingDate the sharingDate to set
	 */
	public void setSharingDate(Date sharingDate) {
		this.sharingDate = sharingDate;
	}




	/**
	 * @return the tariffCategory
	 */
	public String getTariffCategory() {
		return tariffCategory;
	}




	/**
	 * @param tariffCategory the tariffCategory to set
	 */
	public void setTariffCategory(String tariffCategory) {
		this.tariffCategory = tariffCategory;
	}




	@Override
	public String toString() {
		return "Recon [Sugar_Ticket=" + sugarTicket + ", Account_Number=" + accountNumber + ", Recon_Type=" + reconType + ", Recon_prepared_by=" + reconPreparedBy
				+ ", Recon_reviewed_by=" + reconReviewedBy +  ", Criticality=" + criticality +  ", TimeTaken=" + timeTaken +  ", ReviewComments=" + reviewComments + 
				", CommentsType=" + commentsType +  ", ReviewDate=" + reviewDate +  ", SharingDate=" + sharingDate +  ", TariffCategory=" + tariffCategory + "]";
	
	
}
	
}