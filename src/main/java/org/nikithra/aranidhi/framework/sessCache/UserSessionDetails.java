/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.framework.sessCache;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of UserSessionDetails.
 * 
 * @author NIKITHRA
 */
@Component
public class UserSessionDetails {
	/**
	 * Description of the property userId.
	 */
	private String userId = "";

	/**
	 * Description of the property userName.
	 */
	private String userName = "";
	
	/**
	 * Description of the property profileGroup.
	 */
	private String profileGroup = "";

	/**
	 * Description of the property emailId.
	 */
	private String emailId = "";
	
	/**
	 * The constructor.
	 */
	public UserSessionDetails() {
		// Start of user code constructor for UserSessionDetails
		super();
		// End of user code
	}
	
	/**
	 * The Parameterized constructor.
	 */
	
	public UserSessionDetails(String userId, String userName,
			String profileGroup, String emailId) {
		// Start of user code constructor for UserSessionDetails
		this.userId = userId;
		this.userName = userName;
		this.profileGroup = profileGroup;
		this.emailId = emailId;
		// End of user code
	}
	// Start of user code (user defined attributes for UserSessionDetails)
	
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

	@Override
	public String toString() {
		return "UserSessionDetails [userId=" + userId + ", userName="
				+ userName + ", profileGroup=" + profileGroup + ", emailId="
				+ emailId + "]";
	}

	
}
