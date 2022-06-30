/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.donation.dao;

//Start of user code (user defined imports)

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

// End of user code

/**
 * Description of DonationDetails.
 * 
 * @author NIKITHRA
 */
@Entity
@Table(name="donation_details")
public class DonationDetails {

	/**
	 * Description of the property dbts.
	 */
	private Integer dbts ;

	/**
	 * Description of the property donationId.
	 */
	@Id
	@Column(length = 8)
	private String donationId = "";

	/**
	 * Description of the property charityId.
	 */
	@Column(length = 8)
	private String charityId = "";

	/**
	 * Description of the property serviceId.
	 */
	@Column(length = 8)
	private String serviceId = "";

	/**
	 * Description of the property ulaId.
	 */
	@Column(nullable=false,length = 8)
	private String ulaId = "";

	/**
	 * Description of the property emailId.
	 */
	@Column(nullable=false, length = 45)
	private String emailId = "";
	
	/**
	 * Description of the property donationAmt.
	 */
	
	private String donationAmt = "";

	/**
	 * Description of the property paymentMode.
	 */
	@Column(length = 7)
	private String paymentMode = "";

	/**
	 * Description of the property paymentDate.
	 */
	@Temporal(TemporalType.DATE)
	private Date paymentDate;

	/**
	 * Description of the property paymentDesc.
	 */
	@Column(length = 120)
	private String paymentDesc = "";

	/**
	 * Description of the property billNo.
	 */
	@Column(length = 8)
	private String billNo = "";

	/**
	 * Description of the property accountType.
	 */
	@Column(length = 3)
	private String accountType = "";

	/**
	 * Description of the property delFlg.
	 */
	@Column(length = 1)
	private String delFlg = "";

	/**
	 * Description of the property rCreTime.
	 */
	private String rCreTime = "";

	/**
	 * Description of the property rModTime.
	 */
	private String rModTime = "";

	/**
	 * Description of the property rCreId.
	 */
	@Column(length = 8)
	private String rCreId = "";

	/**
	 * Description of the property rModId.
	 */
	@Column(length = 8)
	private String rModId = "";
		  
	  
	// Start of user code (user defined attributes for DonationDetails)

	// End of user code

	/**
	 * The constructor.
	 */
	public DonationDetails() {
		// Start of user code constructor for DonationDetails)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for DonationDetails)

	// End of user code
	/**
	 * Returns dbts.
	 * @return dbts 
	 */
	public Integer getDbts() {
		return this.dbts;
	}

	/**
	 * Sets a value to attribute dbts. 
	 * @param newDbts 
	 */
	public void setDbts(Integer newDbts) {
		this.dbts = newDbts;
	}

	/**
	 * Returns donationId.
	 * @return donationId 
	 */
	public String getDonationId() {
		return this.donationId;
	}

	/**
	 * Sets a value to attribute donationId. 
	 * @param newDonationId 
	 */
	public void setDonationId(String newDonationId) {
		this.donationId = newDonationId;
	}

	/**
	 * Returns charityId.
	 * @return charityId 
	 */
	public String getCharityId() {
		return this.charityId;
	}

	/**
	 * Sets a value to attribute charityId. 
	 * @param newCharityId 
	 */
	public void setCharityId(String newCharityId) {
		this.charityId = newCharityId;
	}

	/**
	 * Returns serviceId.
	 * @return serviceId 
	 */
	public String getServiceId() {
		return this.serviceId;
	}

	/**
	 * Sets a value to attribute serviceId. 
	 * @param newServiceId 
	 */
	public void setServiceId(String newServiceId) {
		this.serviceId = newServiceId;
	}

	/**
	 * Returns ulaId.
	 * @return ulaId 
	 */
	public String getUlaId() {
		return this.ulaId;
	}

	/**
	 * Sets a value to attribute ulaId. 
	 * @param newUlaId 
	 */
	public void setUlaId(String newUlaId) {
		this.ulaId = newUlaId;
	}
	
	/**
	 * Returns emailId.
	 * @return emailId 
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * Sets a value to attribute emailId. 
	 * @param newEmailId 
	 */
	public void setEmailId(String newEmailId) {
		this.emailId = newEmailId;
	}

	/**
	 * Returns donationAmt.
	 * @return donationAmt 
	 */
	public String getDonationAmt() {
		return this.donationAmt;
	}

	/**
	 * Sets a value to attribute donationAmt. 
	 * @param newDonationAmt 
	 */
	public void setDonationAmt(String newDonationAmt) {
		this.donationAmt = newDonationAmt;
	}

	/**
	 * Returns paymentMode.
	 * @return paymentMode 
	 */
	public String getPaymentMode() {
		return this.paymentMode;
	}

	/**
	 * Sets a value to attribute paymentMode. 
	 * @param newPaymentMode 
	 */
	public void setPaymentMode(String newPaymentMode) {
		this.paymentMode = newPaymentMode;
	}

	/**
	 * Returns paymentDate.
	 * @return paymentDate 
	 */
	public Date getPaymentDate() {
		return this.paymentDate;
	}

	/**
	 * Sets a value to attribute paymentDate. 
	 * @param newPaymentDate 
	 */
	public void setPaymentDate(Date newPaymentDate) {
		this.paymentDate = newPaymentDate;
	}

	/**
	 * Returns paymentDesc.
	 * @return paymentDesc 
	 */
	public String getPaymentDesc() {
		return this.paymentDesc;
	}

	/**
	 * Sets a value to attribute paymentDesc. 
	 * @param newPaymentDesc 
	 */
	public void setPaymentDesc(String newPaymentDesc) {
		this.paymentDesc = newPaymentDesc;
	}

	/**
	 * Returns billNo.
	 * @return billNo 
	 */
	public String getBillNo() {
		return this.billNo;
	}

	/**
	 * Sets a value to attribute billNo. 
	 * @param newBillNo 
	 */
	public void setBillNo(String newBillNo) {
		this.billNo = newBillNo;
	}

	/**
	 * Returns accountType.
	 * @return accountType 
	 */
	public String getAccountType() {
		return this.accountType;
	}

	/**
	 * Sets a value to attribute accountType. 
	 * @param newAccountType 
	 */
	public void setAccountType(String newAccountType) {
		this.accountType = newAccountType;
	}

	/**
	 * Returns delFlg.
	 * @return delFlg 
	 */
	public String getDelFlg() {
		return this.delFlg;
	}

	/**
	 * Sets a value to attribute delFlg. 
	 * @param newDelFlg 
	 */
	public void setDelFlg(String newDelFlg) {
		this.delFlg = newDelFlg;
	}

	/**
	 * Returns rCreTime.
	 * @return rCreTime 
	 */
	public String getRCreTime() {
		return this.rCreTime;
	}

	/**
	 * Sets a value to attribute rCreTime. 
	 * @param newRCreTime 
	 */
	public void setRCreTime(String newRCreTime) {
		this.rCreTime = newRCreTime;
	}

	/**
	 * Returns rModTime.
	 * @return rModTime 
	 */
	public String getRModTime() {
		return this.rModTime;
	}

	/**
	 * Sets a value to attribute rModTime. 
	 * @param newRModTime 
	 */
	public void setRModTime(String newRModTime) {
		this.rModTime = newRModTime;
	}

	/**
	 * Returns rCreId.
	 * @return rCreId 
	 */
	public String getRCreId() {
		return this.rCreId;
	}

	/**
	 * Sets a value to attribute rCreId. 
	 * @param newRCreId 
	 */
	public void setRCreId(String newRCreId) {
		this.rCreId = newRCreId;
	}

	/**
	 * Returns rModId.
	 * @return rModId 
	 */
	public String getRModId() {
		return this.rModId;
	}

	/**
	 * Sets a value to attribute rModId. 
	 * @param newRModId 
	 */
	public void setRModId(String newRModId) {
		this.rModId = newRModId;
	}

	@Override
	public String toString() {
		return "DonationDetails [dbts=" + dbts + ", donationId=" + donationId
				+ ", charityId=" + charityId + ", serviceId=" + serviceId
				+ ", ulaId=" + ulaId + ", emailId=" + emailId
				+ ", donationAmt=" + donationAmt + ", paymentMode="
				+ paymentMode + ", paymentDate=" + paymentDate
				+ ", paymentDesc=" + paymentDesc + ", billNo=" + billNo
				+ ", accountType=" + accountType + ", delFlg=" + delFlg
				+ ", rCreTime=" + rCreTime + ", rModTime=" + rModTime
				+ ", rCreId=" + rCreId + ", rModId=" + rModId + "]";
	}

	
}
