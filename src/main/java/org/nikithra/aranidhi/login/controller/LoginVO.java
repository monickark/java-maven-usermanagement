/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.login.controller;
//Start of user code (user defined imports)

import java.io.Serializable;



// Start of user code (user defined imports)
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

// End of user code

/**
 * Description of LoginVO.
 * 
 * @author NIKITHRA
 */
@Component
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class LoginVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(LoginVO.class);
	/**
	 * Description of the property userId.
	 */
	private String userId = "";

	/**
	 * Description of the property password.
	 */
	private String password = "";
	
	/**
	 * Description of the property ipAddress.
	 */
	private String ipAddress = "";

	// Start of user code (user defined attributes for LoginVO)

	// End of user code

	/**
	 * The constructor.
	 */
	public LoginVO() {
		// Start of user code constructor for LoginVO)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for LoginVO)

	// End of user code
	/**
	 * Returns userId.
	 * @return userId 
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * Sets a value to attribute userId. 
	 * @param newUserId 
	 */
	public void setUserId(String newUserId) {
		this.userId = newUserId;
	}

	/**
	 * Returns password.
	 * @return password 
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Sets a value to attribute password. 
	 * @param newPassword 
	 */
	public void setPassword(String newPassword) {
		this.password = newPassword;
	}
	
	/**
	 * Returns ipAddress.
	 * @return ipAddress 
	 */
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * Sets a value to attribute ipAddress. 
	 * @param newIpAddress 
	 */
	public void setIpAddress(String newIpAddress) {
		this.ipAddress = newIpAddress;
	}

	@Override
	public String toString() {
		return "LoginVO [logger=" + logger + ", userId=" + userId
				+ ", password=" + password + ", ipAddress=" + ipAddress
				+ ", getUserId()=" + getUserId() + ", getPassword()="
				+ getPassword() + ", getIpAddress()=" + getIpAddress()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	

}
