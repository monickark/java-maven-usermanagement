/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.user.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


// Start of user code (user defined imports)

// End of user code

/**
 * Description of UserDetails.
 * 
 * @author NIKITHRA
 */
@Entity
@Table(name="user_details")
public class UserDetails implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Description of the property dbts.
	 */
	private Integer dbts;

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
	 * Description of the property gender.
	 */
	@Column(length=6)
	private String gender = "";

	/**
	 * Description of the property dateOfBirth.
	 */
	private String dateOfBirth = "";

	/**
	 * Description of the property address1.
	 */
	@Column(length = 120)
	private String address1 = "";

	/**
	 * Description of the property address2.
	 */
	@Column(length = 120)
	private String address2 = "";

	/**
	 * Description of the property city.
	 */
	@Column(length = 45)
	private String city = "";

	/**
	 * Description of the property state.
	 */
	@Column(length = 45)
	private String state = "";

	/**
	 * Description of the property country.
	 */
	@Column(length = 45)
	private String country = "";

	/**
	 * Description of the property pincode.
	 */
	@Column(length = 6)
	private String pincode = "";
	
	/**
	 * Description of the property profileGroup.
	 */
	@Column(length = 3)
	private String profileGroup = "";

	/**
	 * Description of the property delFlg.
	 */
	@Column(length = 1)
	private String delFlg = "";
	
	/**
	 * Description of the property remarks.
	 */
	@Column(length = 120)
	private String remarks = "";

	/**
	 * Description of the property rCreTime.
	 */
	private String rCreTime = "";

	/**
	 * Description of the property rModTime.
	 */
	private String rModTime = "";

	/**
	 * Description of the property userDonations.
	 */
	/*@OneToMany(mappedBy = "userDetails",fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@Fetch(FetchMode.SUBSELECT)
    private List<UserDonationsList> userDonations = new ArrayList<>();*/
	// Start of user code (user defined attributes for UserDetails)

	// End of user code

	/**
	 * The constructor.
	 */
	public UserDetails() {
		// Start of user code constructor for UserDetails)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for UserDetails)
	
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
	 * @param newFirstName 
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
	 * Returns address1.
	 * @return address1 
	 */
	public String getAddress1() {
		return this.address1;
	}

	/**
	 * Sets a value to attribute address1. 
	 * @param newAddress1 
	 */
	public void setAddress1(String newAddress1) {
		this.address1 = newAddress1;
	}

	/**
	 * Returns address2.
	 * @return address2 
	 */
	public String getAddress2() {
		return this.address2;
	}

	/**
	 * Sets a value to attribute address2. 
	 * @param newAddress2 
	 */
	public void setAddress2(String newAddress2) {
		this.address2 = newAddress2;
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
	 * Returns state.
	 * @return state 
	 */
	public String getState() {
		return this.state;
	}

	/**
	 * Sets a value to attribute state. 
	 * @param newState 
	 */
	public void setState(String newState) {
		this.state = newState;
	}

	/**
	 * Returns country.
	 * @return country 
	 */
	public String getCountry() {
		return this.country;
	}

	/**
	 * Sets a value to attribute country. 
	 * @param newCountry 
	 */
	public void setCountry(String newCountry) {
		this.country = newCountry;
	}

	/**
	 * Returns pincode.
	 * @return pincode 
	 */
	public String getPincode() {
		return this.pincode;
	}

	/**
	 * Sets a value to attribute pincode. 
	 * @param newPincode 
	 */
	public void setPincode(String newPincode) {
		this.pincode = newPincode;
	}
	
	/**
	 * Returns profileGroup.
	 * @return profileGroup 
	 */
	public String getProfileGroup() {
		return this.profileGroup;
	}

	/**
	 * Sets a value to attribute profileGroup. 
	 * @param newProfileGroup 
	 */
	public void setProfileGroup(String newProfileGroup) {
		this.profileGroup = newProfileGroup;
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
	 * Returns remarks.
	 * @return remarks 
	 */
	public String getRemarks() {
		return this.remarks;
	}

	/**
	 * Sets a value to attribute remarks. 
	 * @param newRemarks 
	 */
	public void setRemarks(String newRemarks) {
		this.remarks = newRemarks;
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
	 * Returns userDonations.
	 * @return userDonations
	 */
	/*public List<UserDonationsList> getUserDonations() {
		return userDonations;
	}*/

	/**
	 * Sets a value to attribute newUserDonations. 
	 * @param newUserDonations 
	 */
	/*public void setUserDonations(List<UserDonationsList> newUserDonations) {
		this.userDonations = newUserDonations;
	}*/
	

	@Override
	public String toString() {
		return "UserDetails [dbts=" + dbts + ", ulaId=" + ulaId
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + ", mobileNo=" + mobileNo
				+ ", gender=" + gender + ", dateOfBirth=" + dateOfBirth
				+ ", address1=" + address1 + ", address2=" + address2
				+ ", city=" + city + ", state=" + state + ", country="
				+ country + ", pincode=" + pincode + ", profileGroup="
				+ profileGroup + ", delFlg=" + delFlg + ", remarks=" + remarks
				+ ", rCreTime=" + rCreTime + ", rModTime=" + rModTime + "]";
	}

}
