/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.donation.controller;

import org.nikithra.aranidhi.user.controller.UserDetailsVO;
import org.springframework.stereotype.Component;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of ReceiptMasterVO.
 * 
 * @author NIKITHRA
 */
@Component
public class ReceiptMasterVO {
	/**
	 * Description of the property charityDetailsVO.
	 */
	private CharityDetailsVO charityDetailsVO = null;

	/**
	 * Description of the property userDetailsVO.
	 */
	private UserDetailsVO userDetailsVO = null;

	/**
	 * Description of the property donationMasterVO.
	 */
	private DonationMasterVO donationMasterVO = null;


	
	// Start of user code (user defined attributes for ReceiptMasterVO)

	// End of user code

	/**
	 * The constructor.
	 */
	public ReceiptMasterVO() {
		// Start of user code constructor for ReceiptMasterVO)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for ReceiptMasterVO)

	// End of user code
	/**
	 * Returns charityDetailsVO.
	 * @return charityDetailsVO 
	 */
	public CharityDetailsVO getCharityDetailsVO() {
		return this.charityDetailsVO;
	}

	/**
	 * Sets a value to attribute charityDetailsVO. 
	 * @param newCharityDetailsVO 
	 */
	public void setCharityDetailsVO(CharityDetailsVO newCharityDetailsVO) {
		this.charityDetailsVO = newCharityDetailsVO;
	}

	/**
	 * Returns userDetailsVO.
	 * @return userDetailsVO 
	 */
	public UserDetailsVO getUserDetailsVO() {
		return this.userDetailsVO;
	}

	/**
	 * Sets a value to attribute userDetailsVO. 
	 * @param newUserDetailsVO 
	 */
	public void setUserDetailsVO(UserDetailsVO newUserDetailsVO) {
		this.userDetailsVO = newUserDetailsVO;
	}

	/**
	 * Returns donationMasterVO.
	 * @return donationMasterVO 
	 */
	public DonationMasterVO getDonationMasterVO() {
		return this.donationMasterVO;
	}

	/**
	 * Sets a value to attribute donationMasterVO. 
	 * @param newDonationMasterVO 
	 */
	public void setDonationMasterVO(DonationMasterVO newDonationMasterVO) {
		this.donationMasterVO = newDonationMasterVO;
	}

	@Override
	public String toString() {
		return "ReceiptMasterVO [charityDetailsVO=" + charityDetailsVO
				+ ", userDetailsVO=" + userDetailsVO + ", donationMasterVO="
				+ donationMasterVO + "]";
	}

	
}
