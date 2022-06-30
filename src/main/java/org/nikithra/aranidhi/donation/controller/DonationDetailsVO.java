/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.donation.controller;


import org.springframework.stereotype.Component;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of DonationDetailsVO.
 * 
 * @author NIKITHRA
 */
@Component
public class DonationDetailsVO {
	
	/**
	 * Description of the property donationId.
	 */
	private String donationId = "";

	/**
	 * Description of the property ulaId.
	 */
	private String ulaId;

	/**
	 * Description of the property emailId.
	 */
	private String emailId = "";
	
	/**
	 * Description of the property donationAmt.
	 */
	private String donationAmt = "";

	/**
	 * Description of the property paymentMode.
	 */
	private String paymentMode = "";

	/**
	 * Description of the property paymentDate.
	 */
	private String paymentDate = "";

	/**
	 * Description of the property paymentDesc.
	 */
	private String paymentDesc = "";

	/**
	 * Description of the property accountType.
	 */
	private String accountType = "";

	/**
	 * Description of the property billNo.
	 */
	private String billNo = "";

	// Start of user code (user defined attributes for DonationDetailsVO)

	// End of user code

	/**
	 * The constructor.
	 */
	public DonationDetailsVO() {
		// Start of user code constructor for DonationDetailsVO)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for DonationDetailsVO)

	// End of user code
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
		return this.emailId;
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
	public String getPaymentDate() {
		return this.paymentDate;
	}

	/**
	 * Sets a value to attribute paymentDate. 
	 * @param newPaymentDate 
	 */
	public void setPaymentDate(String newPaymentDate) {
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
	
	@Override
	public String toString() {
		return "DonationDetailsVO [donationId=" + donationId + ", ulaId="
				+ ulaId + ", donationAmt=" + donationAmt + ", paymentMode="
				+ paymentMode + ", paymentDate=" + paymentDate
				+ ", paymentDesc=" + paymentDesc + ", accountType="
				+ accountType + ", billNo=" + billNo + "]";
	}

}
