/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.donation.service;

import java.text.ParseException;

// Start of user code (user defined imports)

import java.util.List;
import java.util.Map;

import org.nikithra.aranidhi.common.exceptions.NoDataFoundException;
import org.nikithra.aranidhi.common.exceptions.UpdateFailedException;
import org.nikithra.aranidhi.donation.controller.DonateCharityDetailsVO;
import org.nikithra.aranidhi.donation.controller.DonationDetailsVO;
import org.nikithra.aranidhi.donation.controller.UserDonationsListVO;
// End of user code
import org.nikithra.aranidhi.donation.controller.UserDonationsSearchVO;
import org.nikithra.aranidhi.user.controller.UserDetailsVO;

/**
 * Description of IUserDonationsService.
 * 
 * @author NIKITHRA
 */
public interface IUserDonationsService {
	// Start of user code (user defined attributes for IUserDonationsService)

	// End of user code

	/**
	 * Description of the method selectUserDonationsList.
	 * @param userDonationsSearchVO
	 * @return 
	 * @throws ParseException 
	 * @throws NoDataFoundException 
	 */
	public List<UserDonationsListVO> selectUserDonationsList(UserDonationsSearchVO userDonationsSearchVO) throws ParseException, NoDataFoundException;

	/**
	 * Description of the method selectUserDonationsUserList.
	 * @param userDonationsSearchVO
	 * @return 
	 * @throws ParseException 
	 * @throws NoDataFoundException 
	 */
	public List<UserDonationsListVO> selectUserDonationsUserList(UserDonationsSearchVO userDonationsSearchVO) throws ParseException, NoDataFoundException;


	/**
	 * Description of the method selectUserDetails.
	 * @param ulaId
	 * @return 
	 * @throws ParseException 
	 * @throws NoDataFoundException 
	 */
	public UserDetailsVO selectUserDetails(String ulaId) throws ParseException, NoDataFoundException;


	/**
	 * Description of the method getAllServicesMap.
	 * @return 
	 */
	public Map<String, String> getAllServicesMap();

	
	/**
	 * Description of the method makeDonation.
	 * @param donationDetailsVO
	 * @param donateCharityDetailsVO
	 * @return 
	 * @throws UpdateFailedException 
	 */
	public DonationDetailsVO makeDonation(DonationDetailsVO donationDetailsVO,
 			DonateCharityDetailsVO donateCharityDetailsVO) throws UpdateFailedException;


	// Start of user code (user defined methods for IUserDonationsService)

	// End of user code

}
