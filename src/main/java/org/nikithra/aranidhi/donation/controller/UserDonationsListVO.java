/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.donation.controller;

import java.util.Map;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of UserDonationsListVO.
 * 
 * @author NIKITHRA
 */
public class UserDonationsListVO {
	

	/**
	 * Description of the property userImage.
	 */
	private Map<String, String> userImage;
	
	
	/**
	 * Description of the property ulaId.
	 */
	private String ulaId = "";

	/**
	 * Description of the property userName.
	 */
	private String userName = "";

	/**
	 * Description of the property paymentDate.
	 */
	private String paymentDate = "";

	/**
	 * Description of the property donationAmt.
	 */
	private String donationAmt = "";
	
	/**
	 * Description of the property accountType.
	 */
	private String accountType = "";
	
	/**
	 * Description of the property serviceName.
	 */
	private String serviceName = "";

	/**
	 * Description of the property particulars.
	 */
	private String particulars = "";
	
	/**
	 * Description of the property sno.
	 */
	private int sno;

	// Start of user code (user defined attributes for UserDonationsListVO)

	// End of user code

	/**
	 * The constructor.
	 */
	public UserDonationsListVO() {
		// Start of user code constructor for UserDonationsListVO)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for UserDonationsListVO)

	// End of user code
	/**
	 * Returns userImage.
	 * @return userImage 
	 */
	public Map<String, String> getUserImage() {
		return this.userImage;
	}

	/**
	 * Sets a value to attribute userImage. 
	 * @param newUserImage 
	 */
	public void setUserImage(Map<String, String> newUserImage) {
		this.userImage = newUserImage;
	}

	/**
	 * Returns userName.
	 * @return userName 
	 */
	public String getUserName() {
		return this.userName;
	}

	/**
	 * Sets a value to attribute userName. 
	 * @param newUserName 
	 */
	public void setUserName(String newUserName) {
		this.userName = newUserName;
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
	 * Returns serviceName.
	 * @return serviceName 
	 */
	public String getServiceName() {
		return this.serviceName;
	}

	/**
	 * Sets a value to attribute serviceName. 
	 * @param newServiceName 
	 */
	public void setServiceName(String newServiceName) {
		this.serviceName = newServiceName;
	}

	/**
	 * Returns particulars.
	 * @return particulars 
	 */
	public String getParticulars() {
		return this.particulars;
	}

	/**
	 * Sets a value to attribute particulars. 
	 * @param newParticulars 
	 */
	public void setParticulars(String newParticulars) {
		this.particulars = newParticulars;
	}

	/**
	 * Returns ulaId.
	 * @return ulaId 
	 */
	public String getUlaId() {
		return ulaId;
	}
	
	/**
	 * Sets a value to attribute ulaId. 
	 * @param newulaId
	 */
	public void setUlaId(String newulaId) {
		this.ulaId = newulaId;
	}
	
	/**
	 * Returns sno.
	 * @return sno 
	 */
	public int getSno() {
		return sno;
	}

	/**
	 * Sets a value to attribute sno. 
	 * @param newsno
	 */
	public void setSno(int newsno) {
		this.sno = newsno;
	}

	@Override
	public String toString() {
		return "UserDonationsListVO [userImage=" + userImage + ", ulaId="
				+ ulaId + ", userName=" + userName + ", paymentDate="
				+ paymentDate + ", donationAmt=" + donationAmt
				+ ", accountType=" + accountType + ", serviceName="
				+ serviceName + ", particulars=" + particulars + ", sno=" + sno
				+ ", getUserImage()=" + getUserImage() + ", getUserName()="
				+ getUserName() + ", getPaymentDate()=" + getPaymentDate()
				+ ", getDonationAmt()=" + getDonationAmt()
				+ ", getAccountType()=" + getAccountType()
				+ ", getServiceName()=" + getServiceName()
				+ ", getParticulars()=" + getParticulars() + ", getUlaId()="
				+ getUlaId() + ", getSno()=" + getSno() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}


}
