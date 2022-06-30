/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.donation.controller;

// Start of user code (user defined imports)
import org.nikithra.aranidhi.donation.controller.DonateCharityDetailsVO;
import org.nikithra.aranidhi.donation.controller.DonationDetailsVO;
// End of user code

/**
 * Description of DonationMasterVO.
 * 
 * @author NIKITHRA
 */
public class DonationMasterVO {
	/**
	 * Description of the property donationDetailsVO.
	 */
	private DonationDetailsVO donationDetailsVO = null;

	/**
	 * Description of the property donateCharityDetailsVO.
	 */
	private DonateCharityDetailsVO donateCharityDetailsVO = null;

	// Start of user code (user defined attributes for DonationMasterVO)

	// End of user code

	/**
	 * The constructor.
	 */
	public DonationMasterVO() {
		// Start of user code constructor for DonationMasterVO)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for DonationMasterVO)

	// End of user code
	/**
	 * Returns donationDetailsVO.
	 * @return donationDetailsVO 
	 */
	public DonationDetailsVO getDonationDetailsVO() {
		return this.donationDetailsVO;
	}

	/**
	 * Sets a value to attribute donationDetailsVO. 
	 * @param newDonationDetailsVO 
	 */
	public void setDonationDetailsVO(DonationDetailsVO newDonationDetailsVO) {
		this.donationDetailsVO = newDonationDetailsVO;
	}

	/**
	 * Returns donateCharityDetailsVO.
	 * @return donateCharityDetailsVO 
	 */
	public DonateCharityDetailsVO getDonateCharityDetailsVO() {
		return this.donateCharityDetailsVO;
	}

	/**
	 * Sets a value to attribute donateCharityDetailsVO. 
	 * @param newDonateCharityDetailsVO 
	 */
	public void setDonateCharityDetailsVO(DonateCharityDetailsVO newDonateCharityDetailsVO) {
		this.donateCharityDetailsVO = newDonateCharityDetailsVO;
	}

	@Override
	public String toString() {
		return "DonationMasterVO [donationDetailsVO=" + donationDetailsVO
				+ ", donateCharityDetailsVO=" + donateCharityDetailsVO + "]";
	}

	
}
