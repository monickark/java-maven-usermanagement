/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.donation.controller;

import org.nikithra.aranidhi.donation.controller.UserDonationsListVO;
import org.nikithra.aranidhi.donation.controller.UserDonationsSearchVO;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of UserDonationsMasterVO.
 * 
 * @author NIKITHRA
 */
public class UserDonationsMasterVO {
	/**
	 * Description of the property reportsSearchVO.
	 */
	private UserDonationsSearchVO reportsSearchVO = null;

	/**
	 * Description of the property reportsListVO.
	 */
	private UserDonationsListVO reportsListVO = null;

	// Start of user code (user defined attributes for UserDonationsMasterVO)

	// End of user code

	/**
	 * The constructor.
	 */
	public UserDonationsMasterVO() {
		// Start of user code constructor for UserDonationsMasterVO)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for UserDonationsMasterVO)

	// End of user code
	/**
	 * Returns reportsSearchVO.
	 * @return reportsSearchVO 
	 */
	public UserDonationsSearchVO getReportsSearchVO() {
		return this.reportsSearchVO;
	}

	/**
	 * Sets a value to attribute reportsSearchVO. 
	 * @param newReportsSearchVO 
	 */
	public void setReportsSearchVO(UserDonationsSearchVO newReportsSearchVO) {
		this.reportsSearchVO = newReportsSearchVO;
	}

	/**
	 * Returns reportsListVO.
	 * @return reportsListVO 
	 */
	public UserDonationsListVO getReportsListVO() {
		return this.reportsListVO;
	}

	/**
	 * Sets a value to attribute reportsListVO. 
	 * @param newReportsListVO 
	 */
	public void setReportsListVO(UserDonationsListVO newReportsListVO) {
		this.reportsListVO = newReportsListVO;
	}

	@Override
	public String toString() {
		return "UserDonationsMasterVO [reportsSearchVO=" + reportsSearchVO
				+ ", reportsListVO=" + reportsListVO
				+ ", getReportsSearchVO()=" + getReportsSearchVO()
				+ ", getReportsListVO()=" + getReportsListVO()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
