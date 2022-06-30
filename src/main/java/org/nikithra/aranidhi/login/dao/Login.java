/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.login.dao;

// Start of user code (user defined imports)
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

// End of user code

/**
 * Description of Login.
 * 
 * @author NIKITHRA
 */
@Entity
@Table(name="login")
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Login {
	@Transient
	Logger logger = Logger.getLogger(Login.class);
	/**
	 * Description of the property dbts.
	 */
	private int dbts = Integer.valueOf(0);

	/**
	 * Description of the property username.
	 */
	@Id
	@Column(length = 8,nullable=false)
	private String userId = "";

	/**
	 * Description of the property password.
	 */
	@Column(length = 45,nullable=false)
	private String password = "";

	/**
	 * Description of the property lastLoginTime.
	 */
	private String lastLoginTime = "";

	/**
	 * Description of the property IpAddress.
	 */
	@Column(length = 45)
	private String ipAddress = "";

	/**
	 * Description of the property lastLogoutTime.
	 */
	private String lastLogoutTime = "";

	/**
	 * Description of the property totalNoOfLogin.
	 */
	private String totalNoOfLogin = "";

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

	// Start of user code (user defined attributes for Login)
	/**
	 * Description of the property emailId.
	 */
	@Column(length = 45,nullable=false)
	private String emailId = "";
	
	/**
	 * Description of the property mobileNo.
	 */
	@Column(length = 15)
	private String mobileNo = "";
	// End of user code

	/**
	 * The constructor.
	 */
	public Login() {
		// Start of user code constructor for Login)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for Login)

	// End of user code
	/**
	 * Returns dbts.
	 * @return dbts 
	 */
	public int getDbts() {
		return this.dbts;
	}

	/**
	 * Sets a value to attribute dbts. 
	 * @param newDbts 
	 */
	public void setDbts(int newDbts) {
		this.dbts = newDbts;
	}

	/**
	 * Returns userId.
	 * @return userId 
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * Sets a value to attribute userid. 
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
	 * Returns lastLoginTime.
	 * @return lastLoginTime 
	 */
	public String getLastLoginTime() {
		return this.lastLoginTime;
	}

	/**
	 * Sets a value to attribute lastLoginTime. 
	 * @param newLastLoginTime 
	 */
	public void setLastLoginTime(String newLastLoginTime) {
		this.lastLoginTime = newLastLoginTime;
	}

	/**
	 * Returns IpAddress.
	 * @return IpAddress 
	 */
	public String getIpAddress() {
		return this.ipAddress;
	}

	/**
	 * Sets a value to attribute IpAddress. 
	 * @param newIpAddress 
	 */
	public void setIpAddress(String newIpAddress) {
		this.ipAddress = newIpAddress;
	}

	/**
	 * Returns lastLogoutTime.
	 * @return lastLogoutTime 
	 */
	public String getLastLogoutTime() {
		return this.lastLogoutTime;
	}

	/**
	 * Sets a value to attribute lastLogoutTime. 
	 * @param newLastLogoutTime 
	 */
	public void setLastLogoutTime(String newLastLogoutTime) {
		this.lastLogoutTime = newLastLogoutTime;
	}

	/**
	 * Returns totalNoOfLogin.
	 * @return totalNoOfLogin 
	 */
	public String getTotalNoOfLogin() {
		return this.totalNoOfLogin;
	}

	/**
	 * Sets a value to attribute totalNoOfLogin. 
	 * @param newTotalNoOfLogin 
	 */
	public void setTotalNoOfLogin(String newTotalNoOfLogin) {
		this.totalNoOfLogin = newTotalNoOfLogin;
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

}
