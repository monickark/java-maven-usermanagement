/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.user.controller;

// Start of user code (user defined imports)

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

// End of user code

/**
 * Description of UserDetailsVO.
 * 
 * @author NIKITHRA
 */
@Component
public class UserDetailsVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(UserDetailsVO.class);
	
	/**
	 * Description of the property ulaId.
	 */
	private String ulaId = "";

	/**
	 * Description of the property firstName.
	 */
	private String firstName = "";

	/**
	 * Description of the property lastName.
	 */
	private String lastName = "";

	/**
	 * Description of the property emailId.
	 */
	private String emailId = "";

	/**
	 * Description of the property mobileNo.
	 */
	private String mobileNo = "";

	/**
	 * Description of the property gender.
	 */
	private String gender = "";

	/**
	 * Description of the property dateOfBirth.
	 */
	private String dateOfBirth = "";

	/**
	 * Description of the property photo.
	 */
	private MultipartFile photo;
	
	/**
	 * Description of the property photoname.
	 */
	private String photoname = "";

	/**
	 * Description of the property address1.
	 */
	private String address1 = "";

	/**
	 * Description of the property address2.
	 */
	private String address2 = "";

	/**
	 * Description of the property city.
	 */
	private String city = "";

	/**
	 * Description of the property state.
	 */
	private String state = "";

	/**
	 * Description of the property country.
	 */
	private String country = "";

	/**
	 * Description of the property pincode.
	 */
	private String pincode = "";

	/**
	 * Description of the property remarks.
	 */
	private String remarks = "";
	
	/**
	 * Description of the property remarks.
	 */
	private String profileGroup = "";
	
	// Start of user code (user defined attributes for UserDetailsVO)
	
	// End of user code
	
	/**
	 * Returns ulaId.
	 * 
	 * @return ulaId
	 */
	public String getUlaId() {
		return this.ulaId;
	}

	/**
	 * Sets a value to attribute ulaId.
	 * 
	 * @param newUlaId
	 */
	public void setUlaId(String newUlaId) {
		this.ulaId = newUlaId;
	}

	/**
	 * Returns firstName.
	 * 
	 * @return firstName
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * Sets a value to attribute firstName.
	 * 
	 * @param newFirstName
	 */
	public void setFirstName(String newFirstName) {
		this.firstName = newFirstName;
	}

	/**
	 * Returns lastName.
	 * 
	 * @return lastName
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * Sets a value to attribute lastName.
	 * 
	 * @param newLastName
	 */
	public void setLastName(String newLastName) {
		this.lastName = newLastName;
	}

	/**
	 * Returns emailId.
	 * 
	 * @return emailId
	 */
	public String getEmailId() {
		return this.emailId;
	}

	/**
	 * Sets a value to attribute emailId.
	 * 
	 * @param newEmailId
	 */
	public void setEmailId(String newEmailId) {
		this.emailId = newEmailId;
	}

	/**
	 * Returns mobileNo.
	 * 
	 * @return mobileNo
	 */
	public String getMobileNo() {
		return this.mobileNo;
	}

	/**
	 * Sets a value to attribute mobileNo.
	 * 
	 * @param newMobileNo
	 */
	public void setMobileNo(String newMobileNo) {
		this.mobileNo = newMobileNo;
	}

	/**
	 * Returns gender.
	 * 
	 * @return gender
	 */
	public String getGender() {
		return this.gender;
	}

	/**
	 * Sets a value to attribute gender.
	 * 
	 * @param newGender
	 */
	public void setGender(String newGender) {
		this.gender = newGender;
	}

	/**
	 * Returns dateOfBirth.
	 * 
	 * @return dateOfBirth
	 */
	public String getDateOfBirth() {
		return this.dateOfBirth;
	}

	/**
	 * Sets a value to attribute dateOfBirth.
	 * 
	 * @param newDateOfBirth
	 */
	public void setDateOfBirth(String newDateOfBirth) {
		this.dateOfBirth = newDateOfBirth;
	}

	/**
	 * Returns photo.
	 * 
	 * @return photo
	 */
	public MultipartFile getPhoto() {
		return this.photo;
	}

	/**
	 * Sets a value to attribute photo.
	 * 
	 * @param newPhoto
	 */
	public void setPhoto(MultipartFile newPhoto) {
		this.photo = newPhoto;
	}
	
	/**
	 * Returns photoname.
	 * 
	 * @return photoname
	 */
	public String getPhotoName() {
		return this.photoname;
	}

	/**
	 * Sets a value to attribute photoname.
	 * 
	 * @param newPhotoname
	 */
	public void setPhotoname(String newPhotoname) {
		this.photoname = newPhotoname;
	}

	/**
	 * Returns address1.
	 * 
	 * @return address1
	 */
	public String getAddress1() {
		return this.address1;
	}

	/**
	 * Sets a value to attribute address1.
	 * 
	 * @param newAddress1
	 */
	public void setAddress1(String newAddress1) {
		this.address1 = newAddress1;
	}

	/**
	 * Returns address2.
	 * 
	 * @return address2
	 */
	public String getAddress2() {
		return this.address2;
	}

	/**
	 * Sets a value to attribute address2.
	 * 
	 * @param newAddress2
	 */
	public void setAddress2(String newAddress2) {
		this.address2 = newAddress2;
	}

	/**
	 * Returns city.
	 * 
	 * @return city
	 */
	public String getCity() {
		return this.city;
	}

	/**
	 * Sets a value to attribute city.
	 * 
	 * @param newCity
	 */
	public void setCity(String newCity) {
		this.city = newCity;
	}

	/**
	 * Returns state.
	 * 
	 * @return state
	 */
	public String getState() {
		return this.state;
	}

	/**
	 * Sets a value to attribute state.
	 * 
	 * @param newState
	 */
	public void setState(String newState) {
		this.state = newState;
	}

	/**
	 * Returns country.
	 * 
	 * @return country
	 */
	public String getCountry() {
		return this.country;
	}

	/**
	 * Sets a value to attribute country.
	 * 
	 * @param newCountry
	 */
	public void setCountry(String newCountry) {
		this.country = newCountry;
	}

	/**
	 * Returns pincode.
	 * 
	 * @return pincode
	 */
	public String getPincode() {
		return this.pincode;
	}

	/**
	 * Sets a value to attribute pincode.
	 * 
	 * @param newPincode
	 */
	public void setPincode(String newPincode) {
		this.pincode = newPincode;
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
	 * Returns profileGroup.
	 * @return profileGroup 
	 */
	public String getProfileGroup() {
		return profileGroup;
	}

	/**
	 * Sets a value to attribute profileGroup. 
	 * @param newProfileGroup 
	 */
	public void setProfileGroup(String newProfileGroup) {
		this.profileGroup = newProfileGroup;
	}

@Override
  public String toString() {
    return "UserDetailsVO [logger=" + logger + ", ulaId=" + ulaId + ", firstName=" + firstName
        + ", lastName=" + lastName + ", emailId=" + emailId + ", mobileNo=" + mobileNo
        + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", photo=" + photo
        + ", address1=" + address1 + ", address2=" + address2 + ", city=" + city + ", state="
        + state + ", country=" + country + ", pincode=" + pincode + ", remarks=" + remarks
        + ", getUlaId()=" + getUlaId() + ", getFirstName()=" + getFirstName() + ", getLastName()="
        + getLastName() + ", getEmailId()=" + getEmailId() + ", getMobileNo()=" + getMobileNo()
        + ", getGender()=" + getGender() + ", getDateOfBirth()=" + getDateOfBirth()
        + ", getPhoto()=" + getPhoto() + ", getAddress1()=" + getAddress1() + ", getAddress2()="
        + getAddress2() + ", getCity()=" + getCity() + ", getState()=" + getState()
        + ", getCountry()=" + getCountry() + ", getPincode()=" + getPincode() + ", getRemarks()="
        + getRemarks() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
        + ", toString()=" + super.toString() + "]";
  }

}
