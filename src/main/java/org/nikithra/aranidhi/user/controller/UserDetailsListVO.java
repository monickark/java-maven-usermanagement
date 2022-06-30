/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.user.controller;

// Start of user code (user defined imports)

import org.springframework.stereotype.Component;

// End of user code

/**
 * Description of UserDetailsListVO.
 * 
 * @author NIKITHRA
 */
@Component
public class UserDetailsListVO{

	/**
	 * Description of the property ulaId.
	 */
	private String ulaId = "";

	/**
	 * Description of the property userName.
	 */
	private String userName = "";

	/**
	 * Description of the property emailId.
	 */
	private String emailId = "";

	/**
	 * Description of the property mobileNo.
	 */
	private String mobileNo = "";

	/**
	 * Description of the property city.
	 */
	private String city = "";

	/**
	 * Description of the property gender.
	 */
	private String gender = "";

	/**
	 * Description of the property dateOfBirth.
	 */
	private String dateOfBirth = "";
	
	/**
	 * Description of the property sno.
	 */
	private int sno;

	// Start of user code (user defined attributes for UserDetailsListVO)

	// End of user code

	/**
	 * The constructor.
	 */
	public UserDetailsListVO() {
		// Start of user code constructor for UserDetailsListVO)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for UserDetailsListVO)

	// End of user code
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
	 * Returns mobileNo.
	 * @return mobileNo 
	 */
	public String getMobileNo() {
		return this.mobileNo;
	}

	/**
	 * Sets a value to attribute mobileNo. 
	 * @param newMobileNo 
	 */
	public void setMobileNo(String newMobileNo) {
		this.mobileNo = newMobileNo;
	}

	/**
	 * Returns city.
	 * @return city 
	 */
	public String getCity() {
		return this.city;
	}

	/**
	 * Sets a value to attribute city. 
	 * @param newCity 
	 */
	public void setCity(String newCity) {
		this.city = newCity;
	}

	/**
	 * Returns gender.
	 * @return gender 
	 */
	public String getGender() {
		return this.gender;
	}

	/**
	 * Sets a value to attribute gender. 
	 * @param newGender 
	 */
	public void setGender(String newGender) {
		this.gender = newGender;
	}

	/**
	 * Returns dateOfBirth.
	 * @return dateOfBirth 
	 */
	public String getDateOfBirth() {
		return this.dateOfBirth;
	}

	/**
	 * Sets a value to attribute dateOfBirth. 
	 * @param newDateOfBirth 
	 */
	public void setDateOfBirth(String newDateOfBirth) {
		this.dateOfBirth = newDateOfBirth;
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
		return "UserDetailsListVO [ulaId=" + ulaId + ", userName=" + userName
				+ ", emailId=" + emailId + ", mobileNo=" + mobileNo + ", city="
				+ city + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth
				+ ", getUlaId()=" + getUlaId() + ", getUserName()="
				+ getUserName() + ", getEmailId()=" + getEmailId()
				+ ", getMobileNo()=" + getMobileNo() + ", getCity()="
				+ getCity() + ", getGender()=" + getGender()
				+ ", getDateOfBirth()=" + getDateOfBirth() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	

}
