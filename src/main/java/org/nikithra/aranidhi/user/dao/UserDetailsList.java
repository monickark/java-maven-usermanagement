/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.user.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
// Start of user code (user defined imports)


// End of user code

/**
 * Description of UserDetailsList.
 * 
 * @author NIKITHRA
 */
@Entity
@Table(name="user_details")
public class UserDetailsList {
	/**
	 * Description of the property ulaId.
	 */
	@Id
	@Column(nullable=false,length=8)
	private String ulaId = "";

	/**
	 * Description of the property firstName.
	 */
	@Column(length = 45)
	private String firstName = "";
	
	/**
	 * Description of the property lastName.
	 */
	@Column(length = 45)
	private String lastName = "";

	/**
	 * Description of the property emailId.
	 */
	@Column(nullable=false,length=45)
	private String emailId = "";

	/**
	 * Description of the property mobileNo.
	 */
	@Column(nullable=false,length=15)
	private String mobileNo = "";

	/**
	 * Description of the property city.
	 */
	private String city = "";

	/**
	 * Description of the property gender.
	 */
	@Column(length=6)
	private String gender = "";

	/**
	 * Description of the property dateOfBirth.
	 */
	private String dateOfBirth = "";
	
	/**
	 * Description of the property delFlg.
	 */
	@Column(length = 1)
	private String delFlg = "";

	// Start of user code (user defined attributes for UserDetailsList)

	// End of user code

	/**
	 * The constructor.
	 */
	public UserDetailsList() {
		// Start of user code constructor for UserDetailsList)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for UserDetailsList)

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
	 * Returns firstName.
	 * @return firstName 
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * Sets a value to attribute firstName. 
	 * @param newLastName 
	 */
	public void setFirstName(String newFirstName) {
		this.firstName = newFirstName;
	}

	/**
	 * Returns lastName.
	 * @return lastName 
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * Sets a value to attribute lastName. 
	 * @param newLastName 
	 */
	public void setLastName(String newLastName) {
		this.lastName = newLastName;
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
	
	

}
