/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.login.controller;

// Start of user code (user defined imports)

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

// End of user code

/**
 * Description of ChangePasswordVO.
 * 
 * @author NIKITHRA
 */
@Component
public class ChangePasswordVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(ChangePasswordVO.class);
	/**
	 * Description of the property userId.
	 */
	private String userId = "";

	/**
	 * Description of the property currentPassword.
	 */
	private String currentPassword = "";

	/**
	 * Description of the property newPassword.
	 */
	private String newPassword = "";

	/**
	 * Description of the property retypeNewPassword.
	 */
	private String retypeNewPassword = "";

	// Start of user code (user defined attributes for ChangePasswordVO)
	
	// End of user code

	/**
	 * The constructor.
	 */
	public ChangePasswordVO() {
		// Start of user code constructor for ChangePasswordVO)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for ChangePasswordVO)
	
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
	 * Returns currentPassword.
	 * @return currentPassword 
	 */
	public String getCurrentPassword() {
		return this.currentPassword;
	}

	/**
	 * Sets a value to attribute currentPassword. 
	 * @param newCurrentPassword 
	 */
	public void setCurrentPassword(String newCurrentPassword) {
		this.currentPassword = newCurrentPassword;
	}

	/**
	 * Returns newPassword.
	 * @return newPassword 
	 */
	public String getNewPassword() {
		return this.newPassword;
	}

	/**
	 * Sets a value to attribute newPassword. 
	 * @param newNewPassword 
	 */
	public void setNewPassword(String newNewPassword) {
		this.newPassword = newNewPassword;
	}

	/**
	 * Returns retypeNewPassword.
	 * @return retypeNewPassword 
	 */
	public String getRetypeNewPassword() {
		return this.retypeNewPassword;
	}

	/**
	 * Sets a value to attribute retypeNewPassword. 
	 * @param newRetypeNewPassword 
	 */
	public void setRetypeNewPassword(String newRetypeNewPassword) {
		this.retypeNewPassword = newRetypeNewPassword;
	}

	@Override
	public String toString() {
		return "ChangePasswordVO [userId=" + userId + ", currentPassword="
				+ currentPassword + ", newPassword=" + newPassword
				+ ", retypeNewPassword=" + retypeNewPassword + ", getUserId()="
				+ getUserId() + ", getCurrentPassword()="
				+ getCurrentPassword() + ", getNewPassword()="
				+ getNewPassword() + ", getRetypeNewPassword()="
				+ getRetypeNewPassword() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	

}
