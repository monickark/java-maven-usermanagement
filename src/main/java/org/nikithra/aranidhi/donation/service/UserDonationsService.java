/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.donation.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// Start of user code (user defined imports)

import org.apache.log4j.Logger;
import org.nikithra.aranidhi.common.bussiness.CommonBusiness;
import org.nikithra.aranidhi.common.constants.ApplicationConstant;
import org.nikithra.aranidhi.common.constants.SequenceConstant;
import org.nikithra.aranidhi.common.constants.TempConstant;
import org.nikithra.aranidhi.common.exceptions.NoDataFoundException;
import org.nikithra.aranidhi.common.exceptions.UpdateFailedException;
import org.nikithra.aranidhi.common.util.AlphaSequenceUtil;
import org.nikithra.aranidhi.common.util.DateUtil;
import org.nikithra.aranidhi.donation.controller.DonateCharityDetailsVO;
import org.nikithra.aranidhi.donation.controller.DonationDetailsVO;
import org.nikithra.aranidhi.donation.controller.UserDonationsListVO;
import org.nikithra.aranidhi.donation.controller.UserDonationsSearchVO;
import org.nikithra.aranidhi.donation.dao.DonationDetails;
import org.nikithra.aranidhi.donation.dao.IMakeDonationDAO;
import org.nikithra.aranidhi.donation.dao.IUserDonationsDAO;
import org.nikithra.aranidhi.donation.dao.UserDonationsKey;
import org.nikithra.aranidhi.donation.dao.UserDonationsList;
import org.nikithra.aranidhi.donation.service.IUserDonationsService;
import org.nikithra.aranidhi.framework.seqgen.service.IIdGeneratorService;
import org.nikithra.aranidhi.user.controller.UserDetailsVO;
import org.nikithra.aranidhi.user.dao.IUserDetailsDAO;
import org.nikithra.aranidhi.user.dao.UserDetails;

// End of user code

/**
 * Description of UserDonationsService.
 * 
 * @author NIKITHRA
 */
@Service
@Transactional
public class UserDonationsService implements IUserDonationsService {
	// Start of user code (user defined attributes for UserDonationsService)
	Logger logger = Logger.getLogger(UserDonationsService.class);

	@Autowired
	private IUserDetailsDAO userDetailsDAO;
	@Autowired
	private CommonBusiness commonBusiness;
	@Autowired
	private IUserDonationsDAO userDonationsDAO;
	@Autowired
    DateUtil dateUtil;
	@Autowired
	private IIdGeneratorService simpleIdGenerator;
	@Autowired
	private IMakeDonationDAO makeDonationDAO;
	
	// End of user code

	/**
	 * Description of the method getAllServicesMap.
	 * @return 
	 */
	public Map<String, String> getAllServicesMap() {
		// Start of user code for method getAllServicesMap
		logger.debug("Get All services from service method");
		
		//set a code manually For all service
		Map<String,String> getAllServicesMap=new HashMap<String,String>();
		getAllServicesMap.put("SER0001","Enrich Social Entrepreneurship" );
		getAllServicesMap.put("SER0002","Nurture Upcoming Entrepreneurs" );
		getAllServicesMap.put("SER0003","Software Solutions to Charitable Organizations" );
		getAllServicesMap.put("SER0004","Life support to destitute women and downtrodden people" );
		getAllServicesMap.put("SER0005","Create home for physically & mentally challenged" );
		getAllServicesMap.put("SER0006","Give all possible means of solutions to blind community" );
		getAllServicesMap.put("SER0007","Self-sustainability to transgender" );
		return getAllServicesMap;
		// End of user code
	}
	
	/**
	 * Description of the method getAllCharityMap.
	 * @return 
	 */
	public Map<String, String> getAllCharityMap() {
		// Start of user code for method getAllCharityMap
		logger.debug("Get All Charity from service method");
		
		//set a code manually For all charity
		Map<String,String> getAllCharityMap=new HashMap<String,String>();
		getAllCharityMap.put("CH0001","Nikithra");
		return getAllCharityMap;
		// End of user code
	}

	
	/**
	 * Description of the method makeDonation.
	 * @param donationDetailsVO
	 * @param donateCharityDetailsVO
	 * @return
	 * @throws UpdateFailedException 
	 */
	@Transactional
	public DonationDetailsVO makeDonation(DonationDetailsVO donationDetailsVO,
 			DonateCharityDetailsVO donateCharityDetailsVO) throws UpdateFailedException{
		// Start of user code for method makeDonation
		logger.debug("Inside a Method makeDonation in service");
	  
		DonationDetails donationDetails=formDonationDetails(donationDetailsVO,donateCharityDetailsVO);
		makeDonationDAO.save(donationDetails);
		commonBusiness.changeObject(donationDetailsVO, donationDetails);
		String paymentdate=dateUtil.getDateFormatInString(donationDetails.getPaymentDate());
		donationDetailsVO.setPaymentDate(paymentdate);
		return donationDetailsVO;

		// End of user code
	}
	
	/**
	 * Description of the method formDonationDetails.
	 * 
	 * @param DonationDetails
	 * @throws UpdateFailedException 
	 */
	//create DonationDetails Object For save the DonationDetails flow
	private  DonationDetails formDonationDetails(DonationDetailsVO donationDetailsVO,
			DonateCharityDetailsVO donateCharityDetailsVO) throws UpdateFailedException {
			// Start of user code for method formUserDetails
			DonationDetails donationDetails=new DonationDetails();
			//set a value to DonationDetails Dao
			donationDetails.setUlaId(donationDetailsVO.getUlaId());
			donationDetails.setDonationAmt(donationDetailsVO.getDonationAmt());
			donationDetails.setEmailId(donationDetailsVO.getEmailId());
			donationDetails.setPaymentMode(donationDetailsVO.getPaymentMode());
			donationDetails.setPaymentDesc(donationDetailsVO.getPaymentDesc());
			donationDetails.setAccountType(donationDetailsVO.getAccountType());
		    donationDetails.setDbts(ApplicationConstant.DBTS);
			donationDetails.setDonationId(AlphaSequenceUtil.generateAlphaSequence(
					ApplicationConstant.STRING_DONATION_ID, simpleIdGenerator
					.getNextId(SequenceConstant.DONATION_ID_SEQUENCE,
							1)));
			donationDetails.setBillNo(AlphaSequenceUtil.generateAlphaSequence(
					ApplicationConstant.STRING_BILL_NO, simpleIdGenerator
					.getNextId(SequenceConstant.BILL_NO,
							1)));
			donationDetails.setCharityId(TempConstant.CHARITY_ID);
			donationDetails.setServiceId(donateCharityDetailsVO.getServiceId());
			donationDetails.setDelFlg(ApplicationConstant.DEL_FLG);
			donationDetails.setPaymentDate(dateUtil.getDateFormatByString(
					donationDetailsVO.getPaymentDate()));
			donationDetails.setRCreTime(dateUtil.getCurrentDateWithTime());
			donationDetails.setRCreId(donationDetails.getUlaId());
			donationDetails.setRModTime(dateUtil.getCurrentDateWithTime());
			donationDetails.setRModId(donationDetails.getUlaId());
			return donationDetails;
			// End of user code
	}

	/**
	 * Description of the method selectUserDonationsList.
	 * @param userDonationsSearchVO
	 * @return 
	 * @throws ParseException 
	 */
	public List<UserDonationsListVO> selectUserDonationsList(
			UserDonationsSearchVO userDonationsSearchVO)throws ParseException,NoDataFoundException {
		// Start of user code for method selectUserDonationsList
		UserDonationsKey userdonationkey = new UserDonationsKey();
		commonBusiness.changeObject(userdonationkey, userDonationsSearchVO);
	    
		if(userdonationkey.getFromDate() != null && !userdonationkey.getFromDate().isEmpty() 
				&& userdonationkey.getToDate()!=null && !userdonationkey.getToDate().isEmpty()){
			userdonationkey.setFromDate(dateUtil.getDateFormatInString(userDonationsSearchVO.getFromDate()));
			userdonationkey.setToDate(dateUtil.getDateFormatInString(userDonationsSearchVO.getToDate()));
		}
				
		//user donation List can fetch the database
		List<UserDonationsList> userDonationlists=userDonationsDAO.selectUserDonationsList(
				userdonationkey.getFromDate(), userdonationkey.getToDate(),
				userdonationkey.getUserDetail(),ApplicationConstant.DEL_FLG);
		List<UserDonationsListVO> donationListVOs=null;
		if (userDonationlists == null || userDonationlists.size() == 0) {
			throw new NoDataFoundException();
        }else{
        	donationListVOs=new ArrayList<UserDonationsListVO>();
			for (UserDonationsList userDonationsList : userDonationlists) {
				int i = userDonationlists.indexOf(userDonationsList);
				UserDonationsListVO donationsListVO = new UserDonationsListVO();
				commonBusiness.changeObject(donationsListVO, userDonationsList);
				String charityName=(String)getAllCharityMap().get(userDonationsList.getCharityId());
				donationsListVO.setParticulars(charityName);
				String serviceName=(String)getAllServicesMap().get(userDonationsList.getServiceId());
				donationsListVO.setServiceName(serviceName);
				donationsListVO.setAccountType(userDonationsList.getAccountType());
				donationsListVO.setUserName(userDonationsList.getUserDetails().getFirstName()+
						userDonationsList.getUserDetails().getLastName());
				donationsListVO.setUlaId(userDonationsList.getUserDetails().getUlaId());
				byte[] photo =userDonationsList.getFileMaster().getFile();
				String encodeImage = Base64.getEncoder().encodeToString(photo);
				Map<String, String> jsonMap = new HashMap<>();
				jsonMap.put("content", encodeImage);
				donationsListVO.setUserImage(jsonMap);
				donationsListVO.setSno(i + 1);
				donationListVOs.add(donationsListVO);
			}
        }
		return donationListVOs;
		// End of user code
	}

	/**
	 * Description of the method selectUserDonationsUserList.
	 * @param userDonationsSearchVO
	 * @return 
	 * @throws ParseException 
	 */
	public List<UserDonationsListVO> selectUserDonationsUserList(
			UserDonationsSearchVO userDonationsSearchVO)throws ParseException,NoDataFoundException {
		// Start of user code for method selectUserDonationsUserList
		UserDonationsKey userdonationkey = new UserDonationsKey();
		commonBusiness.changeObject(userdonationkey, userDonationsSearchVO);
		if(userdonationkey.getFromDate() != null && !userdonationkey.getFromDate().isEmpty() 
				&& userdonationkey.getToDate()!=null && !userdonationkey.getToDate().isEmpty()){
			userdonationkey.setFromDate(dateUtil.getDateFormatInString(userDonationsSearchVO.getFromDate()));
			userdonationkey.setToDate(dateUtil.getDateFormatInString(userDonationsSearchVO.getToDate()));
		}
		//user donation List can fetch the database
		List<UserDonationsList> userDonationlists=userDonationsDAO.selectUserDonationsUserList(
				userdonationkey.getFromDate(), userdonationkey.getToDate(),
				userdonationkey.getUserDetail(),ApplicationConstant.DEL_FLG);
		List<UserDonationsListVO> donationListVOs=null;
		if (userDonationlists == null || userDonationlists.size() == 0) {
			throw new NoDataFoundException();
        }else{
        	donationListVOs=new ArrayList<UserDonationsListVO>();
			for (UserDonationsList userDonationsList : userDonationlists) {
				int i = userDonationlists.indexOf(userDonationsList);
				UserDonationsListVO donationsListVO = new UserDonationsListVO();
				commonBusiness.changeObject(donationsListVO, userDonationsList);
				String CharityName=(String)getAllCharityMap().get(userDonationsList.getCharityId());
				donationsListVO.setParticulars(CharityName);
				String serviceName=(String)getAllServicesMap().get(userDonationsList.getServiceId());
				donationsListVO.setServiceName(serviceName);
				donationsListVO.setAccountType(userDonationsList.getAccountType());
				donationsListVO.setUserName(userDonationsList.getUserDetails().getFirstName()+
						userDonationsList.getUserDetails().getLastName());
				donationsListVO.setUlaId(userDonationsList.getUserDetails().getUlaId());
				donationsListVO.setSno(i + 1);
				donationListVOs.add(donationsListVO);
			}
        }
		return donationListVOs;
		// End of user code
	}
	
	/**
	 * Description of the method selectUserDetails.
	 * @param receiptMasterVO 
	 * @throws ParseException 
	 */
	@Override
	public UserDetailsVO selectUserDetails(
			String ulaId) throws ParseException,NoDataFoundException {
        // Start of user code for method selectUserDetails
		
		//user details can fetch the database
		UserDetailsVO userDetailsVO=null;
		UserDetails userDetails=userDetailsDAO.selectUserDetails(ulaId,ApplicationConstant.DEL_FLG);
		if (userDetails == null) {
			throw new NoDataFoundException();
		}else{
			userDetailsVO=new UserDetailsVO();
			commonBusiness.changeObject(userDetailsVO,userDetails);
		}
		return userDetailsVO;
	}

}
