/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.user.service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

// Start of user code (user defined imports)
import org.nikithra.aranidhi.common.bussiness.CommonBusiness;
import org.nikithra.aranidhi.common.constants.ApplicationConstant;
import org.nikithra.aranidhi.common.constants.SequenceConstant;
import org.nikithra.aranidhi.common.exceptions.DeleteFailedException;
import org.nikithra.aranidhi.common.exceptions.DuplicateEntryException;
import org.nikithra.aranidhi.common.exceptions.NoDataFoundException;
import org.nikithra.aranidhi.common.exceptions.UpdateFailedException;
import org.nikithra.aranidhi.common.util.AlphaSequenceUtil;
import org.nikithra.aranidhi.common.util.DateUtil;
import org.nikithra.aranidhi.framework.seqgen.service.IIdGeneratorService;
import org.nikithra.aranidhi.login.controller.LoginVO;
import org.nikithra.aranidhi.login.dao.ILoginDAO;
import org.nikithra.aranidhi.login.dao.Login;
import org.nikithra.aranidhi.user.controller.UserDetailsListVO;
import org.nikithra.aranidhi.user.controller.UserDetailsVO;
import org.nikithra.aranidhi.user.dao.FileMaster;
import org.nikithra.aranidhi.user.dao.IFileMasterDAO;
import org.nikithra.aranidhi.user.dao.IUserDetailsDAO;
import org.nikithra.aranidhi.user.dao.IUserDetailsListDAO;
import org.nikithra.aranidhi.user.dao.UserDetails;
import org.nikithra.aranidhi.user.dao.UserDetailsList;
// End of user code

/**
 * Description of UserService.
 * 
 * @author NIKITHRA
 */
@Service
public class UserService implements IUserService {
	// Start of user code (user defined attributes for UserService)
	// Logging
	Logger logger = Logger.getLogger(UserService.class.getName());
	@Autowired
	private CommonBusiness commonBusiness;
	@Autowired
	private ILoginDAO loginDAO;
	@Autowired
	private IUserDetailsDAO userDetailsDAO;
	@Autowired
    private IFileMasterDAO fileMasterDao;
	@Autowired
    private IUserDetailsListDAO userDetailsListDAO;
    @Autowired
    DateUtil dateUtil;
    @Autowired
	private IIdGeneratorService simpleIdGenerator;
    
    String getULAId;
    // End of user code

	/**
	 * Description of the method getNextULAID.
	 * 
	 * @return
	 * @throws UpdateFailedException 
	 */
	// Get next ULA id
	public String getNextULAID() throws UpdateFailedException {
		String ulaId = AlphaSequenceUtil.generateAlphaSequence(
				ApplicationConstant.STRING_ULA_ID, simpleIdGenerator
				.getNextId(SequenceConstant.ULA_ID_SEQUENCE,
						1));
		return ulaId;
	}

	/**
	 * Description of the method insertUserDetails.
	 * 
	 * @param userDetailsVO
	 * @param loginVO
	 * @throws DuplicateEntryException
	 * @throws UpdateFailedException 
	 */
	// To Insert User details
	@Transactional
	public void insertUserDetails(UserDetailsVO userDetailsVO,LoginVO loginVO)
			throws DuplicateEntryException {
		// Start of user code for method userSignup
		logger.debug("User Signup Service");
		UserDetails userDetails=formUserDetails(userDetailsVO,loginVO);
		loginVO.setUserId(userDetailsVO.getUlaId());
		getULAId = userDetailsDAO.getNextULAID();
		String existEmailId=userDetailsDAO.existEmailId(userDetails.getEmailId(),ApplicationConstant.DEL_FLG);
		String existContactNo=userDetailsDAO.existContactNo(userDetails.getMobileNo(),ApplicationConstant.DEL_FLG);
		if(!getULAId.equals(userDetails.getUlaId())){
			saveUserDetails(userDetails, existEmailId, existContactNo);
		}
		else{
        	throw new DuplicateEntryException();
        }
		Login login=formLoginObj(userDetailsVO,loginVO);
		if(!getULAId.equals(loginVO.getUserId())){
			insertLoginDetails(login,existEmailId, existContactNo);
		}
		else{
        	throw new DuplicateEntryException();
        }
		// End of user code
	}
	
    /**
     * Description of the method handleFileUpload.
     * @param fileUpload
     * @param ulaId
     * @throws DuplicateEntryException
     * @throws IOException
     */
    // To upload the user image
    @Transactional
    public void handleFileUpload(MultipartFile fileUpload, String ulaId) throws DuplicateEntryException, IOException  {
        // Start of user code for method handleFileUpload
    	logger.debug("Get from db:"+getULAId);
        FileMaster uploadFile=formFileUploadDetails(fileUpload, ulaId);
        if(!getULAId.equals(uploadFile.getUlaId())){
        	uploadFile.setRCreId(uploadFile.getUlaId());
            uploadFile.setRModId(uploadFile.getUlaId());
    		fileMasterDao.save(uploadFile);
		}
        else{
        	throw new DuplicateEntryException();
        }
        
        // End of user code
    }
    
    /**
     * Description of the method formFileUploadDetails.
     * @param fileUpload
     * @param ulaId
     * @throws DuplicateEntryException
     * @throws IOException
     */
    // To form the upload details of user image
    public FileMaster formFileUploadDetails(MultipartFile fileUpload, String ulaId) throws DuplicateEntryException, IOException  {
        // Start of user code for method handleFileUpload
    	
        FileMaster uploadFile=new FileMaster();
        uploadFile.setUlaId(ulaId);
        uploadFile.setDbts(ApplicationConstant.DBTS);
        uploadFile.setFileName(fileUpload.getOriginalFilename());
        uploadFile.setFile(fileUpload.getBytes());
        uploadFile.setContentType(fileUpload.getContentType());
        uploadFile.setFileSize(fileUpload.getSize());
        uploadFile.setDelFlg(ApplicationConstant.DEL_FLG);
        
        String date=dateUtil.getCurrentDateWithTime();
        uploadFile.setRCreTime(date);
        uploadFile.setRModTime(date);
        
        return uploadFile;
        // End of user code
    }
	
    /**
     * Description of the method fetchUserDetails.
     * 
     * @param userDetailsVO
     * @return
     * @throws NoDataFoundException
     * @throws IOException 
     */
    // To select the user details
    
    @Transactional
    public UserDetailsVO fetchUserDetails(UserDetailsVO userDetailsVO)
            throws NoDataFoundException, IOException {
    	
        // Start of user code for method fetchUserDetails
        UserDetails userDetails  = userDetailsDAO.selectUserDetails(userDetailsVO.getUlaId(),ApplicationConstant.DEL_FLG);
        if(userDetails==null){
        	throw new NoDataFoundException();
        }else{
        	userDetailsVO=new UserDetailsVO();
            commonBusiness.changeObject(userDetailsVO, userDetails);
        }
        return userDetailsVO;
        // End of user code
    }

    /**
	 * Description of the method updateUserProfile.
	 * @param userDetailsVO
	 * @throws UpdateFailedException
     * @throws NoDataFoundException 
	 */
	// To update the User Profile
    @Transactional
    public void updateUserProfile(UserDetailsVO userDetailsVO) throws UpdateFailedException, 
    	NoDataFoundException {
		// Start of user code for method updateUserProfile
        
        UserDetails userDetailsExist = userDetailsDAO.selectUserDetails(userDetailsVO.getUlaId(),ApplicationConstant.DEL_FLG);
        if(userDetailsExist==null){
        	throw new NoDataFoundException();
        }else{
	        UserDetails userDetails = new UserDetails();
	        commonBusiness.changeObject(userDetails, userDetailsVO);
	            
	        userDetails.setDbts(userDetailsExist.getDbts()+1);
	        userDetails.setRModTime(dateUtil.getCurrentDateWithTime());
	        userDetails.setProfileGroup(userDetailsExist.getProfileGroup());
	        int changerow=userDetailsDAO.updateProfile(userDetails.getUlaId(), userDetails.getCity(),userDetails.getDateOfBirth(),
	        		userDetails.getEmailId(),userDetails.getFirstName(), userDetails.getGender(),
	        		userDetails.getLastName(), userDetails.getMobileNo(), userDetails.getAddress1(),
	        		userDetails.getAddress2(), userDetails.getCountry(), userDetails.getDbts(),
	        		userDetails.getPincode(), userDetails.getProfileGroup(), userDetails.getRModTime(),
	        		userDetails.getRemarks(),userDetails.getState() , userDetails.getUlaId(),
	        		userDetails.getDelFlg());
	        if (changerow == 0) {
				throw new UpdateFailedException();
			}
		}
    	// End of user code
	}

    /**
     * Description of the method deleteUserProfile.
     * @param userDetailsVO 
     * @throws NoDataFoundException 
     * @throws HibernateException 
     * @throws DeleteFailedException 
     */
    // To delete the user
    @Transactional
    public void deleteUserProfile(UserDetailsVO userDetailsVO) throws NoDataFoundException, HibernateException, DeleteFailedException {
        // Start of user code for method deleteUserProfile

        if (((userDetailsVO.getUlaId() == null) || (userDetailsVO.getUlaId().equals("")))) {
   			throw new NoDataFoundException();
   		}else{
   		   UserDetails userDetailsExist = userDetailsDAO.selectUserDetails(userDetailsVO.getUlaId(),
           		ApplicationConstant.DEL_FLG);
   		   	if(userDetailsExist==null){
   			   throw new DeleteFailedException();
   		   	}else{
   		   	userDetailsExist=formUserDetailsDeletion(userDetailsExist,userDetailsVO);
	        userDetailsDAO.save(userDetailsExist);
   		   	}
   		}      
      
        // End of user code
    }
    
    
    
    /**
     * Description of the method selectUserDetailsList.
     * @return
     * @throws NoDataFoundException 
     */
    
    // To select the list of user details
    @Transactional
    public List<UserDetailsListVO> selectUserDetailsList() throws NoDataFoundException {
        // Start of user code for method selectUserDetailsList
    	
        List<UserDetailsListVO> userDetailsListVOs = null;
        List<UserDetailsList> userDetailsLists = userDetailsListDAO.selectUsersList(ApplicationConstant.DEL_FLG,ApplicationConstant.USER_REGISTER);
        
        if (userDetailsLists == null || userDetailsLists.size() == 0) {
        	throw new NoDataFoundException();
        }   else{
	        	userDetailsListVOs = new ArrayList<UserDetailsListVO>();
		        for (UserDetailsList userDetailsList : userDetailsLists) {
		        	int i = userDetailsLists.indexOf(userDetailsList);
		        	UserDetailsListVO userDetailsListVO = new UserDetailsListVO();
		            commonBusiness.changeObject(userDetailsListVO, userDetailsList);
		            userDetailsListVO.setUserName(userDetailsList.getFirstName()+" "+ userDetailsList.getLastName());
		            userDetailsListVO.setSno(i + 1);
		            userDetailsListVOs.add(userDetailsListVO);
		        }
	     }
        
        return userDetailsListVOs;
     
    }
    
    
    /**
     * Description of the method formUlaId.
     * 
     * @param ulaId
     * @return
     */
    //create Login Object For change password Flow
	/*private  String formUlaId(String UlaId) {
		// Start of user code for method UlaId
		String splStr = UlaId.substring(3, 7);
		// addValue
		int addVal = Integer.parseInt(splStr);		
		addVal = addVal + 1;
		// concat the String and integer value
		String ulaId = ApplicationConstant.STRING_ULA_ID.concat(
				String.format(ApplicationConstant.DIGITS_FORMAT, addVal));

		return ulaId;
			// End of user code
	}*/
	
	 /**
     * Description of the method formUserDetails.
     * 
     * @param UserDetails
     * @return
     */
	//create UserDetails Object For Signup flow
	private  UserDetails formUserDetails(UserDetailsVO userDetailsVO,LoginVO loginVO) {
		// Start of user code for method formUserDetails
		UserDetails userDetails = new UserDetails();
		commonBusiness.changeObject(userDetails,
				userDetailsVO);
		userDetails.setDbts(ApplicationConstant.DBTS);
		userDetails.setProfileGroup(ApplicationConstant.USER_REGISTER);
		userDetails.setDelFlg(ApplicationConstant.DEL_FLG);
        userDetails.setRCreTime(dateUtil.getCurrentDateWithTime());
		userDetails.setRModTime(dateUtil.getCurrentDateWithTime());
	
		return userDetails;
		// End of user code
	}
	
	 /**
     * Description of the method saveUserDetails.
     * 
     * @param UserDetails
     * @return
	 * @throws DuplicateEntryException 
     */
	//create UserDetails Object For Signup flow
	private  void saveUserDetails(UserDetails userDetails,String existEmailId, String existContactNo) throws DuplicateEntryException {
		// Start of user code for method saveUserDetails
		if(existEmailId==null && existContactNo==null){
			userDetailsDAO.save(userDetails);
		}
		else{
			throw new DuplicateEntryException();
		}
	
		// End of user code
	}

	 /**
     * Description of the method formLoginObj.
     * 
     * @param Login
     * @return
     */
	//create UserDetails Object For Signup flow
	private Login formLoginObj(UserDetailsVO userDetailsVO, LoginVO loginVO) {
		// Start of user code for method changePassword
		String date=dateUtil.getCurrentDateWithTime();

		Login login = new Login();
		commonBusiness.changeObject(login, loginVO);
		
		login.setDbts(ApplicationConstant.DBTS);
		login.setEmailId(userDetailsVO.getEmailId());
		login.setUserId(login.getUserId());
		login.setMobileNo(userDetailsVO.getMobileNo());
		login.setTotalNoOfLogin(ApplicationConstant.TOTAL_NO_OF_LOGIN);
		login.setDelFlg(ApplicationConstant.DEL_FLG);
		login.setLastLoginTime(null);
		login.setLastLogoutTime(null);
		login.setIpAddress(null);
		login.setRCreTime(date);
		login.setRModTime(date);
	
		return login;
		// End of user code
	}
	
	 /**
     * Description of the method insertLoginDetails.
     * 
     * @param Login
     * @return
	 * @throws DuplicateEntryException 
     */
	//create UserDetails Object For Signup flow
	private  void insertLoginDetails(Login login,String existEmailId, String existContactNo) throws DuplicateEntryException {
		// Start of user code for method formUserDetails
		if(existEmailId==null && existContactNo==null){
			loginDAO.save(login);
		}
		else{
			throw new DuplicateEntryException();
		}
	
		// End of user code
	}
	
	/**
     * Description of the method formUserDetailsDeletion.
     * 
     * @param UserDetails
     * @return
     */
	//create UserDetails Object For Delete User flow
	private  UserDetails formUserDetailsDeletion(UserDetails userDetailsExist,UserDetailsVO userDetailsVO) {
		
		// Start of user code for method formUserDetailsDeletion
		UserDetails userDetails = new UserDetails();
		commonBusiness.changeObject(userDetails, userDetailsVO);
		
		userDetails.setDbts(userDetailsExist.getDbts()+1);
	    userDetails.setRModTime(dateUtil.getCurrentDateWithTime());
	    userDetails.setDelFlg(ApplicationConstant.USER_DISABLED);
	    userDetails.setProfileGroup(userDetailsExist.getProfileGroup());

		return userDetails;
		// End of user code
	}
	
	/**
     * Description of the method handleFileDownload.
     * @param ulaId
     * @throws NoDataFoundException
     */
    // To download the user image
	@Transactional
	public FileMaster handleFileDownload(String ulaId) throws NoDataFoundException{
		// Start of user code for method handleFileDownload
		FileMaster downloadFile=fileMasterDao.selectImage(ulaId,ApplicationConstant.DEL_FLG);
		if(downloadFile==null){
			throw new NoDataFoundException();
		}
		return downloadFile;
		// End of user code
	}
	
	/**
     * Description of the method handleFileUpdate.
     * @param fileUpload
     * @param ulaId
     * @throws IOException
     * @throws DuplicateEntryException
     * 
     */
    // To update the user image
	@Transactional
	public String handleFileUpdate(MultipartFile fileUpload, String ulaId) throws IOException, DuplicateEntryException    {
		// Start of user code for method handleFileUpdate
		FileMaster uploadFile=new FileMaster();
		uploadFile.setUlaId(ulaId);
		uploadFile.setDbts(ApplicationConstant.DBTS);
		uploadFile.setFileName(fileUpload.getOriginalFilename());
		uploadFile.setFile(fileUpload.getBytes());
		uploadFile.setContentType(fileUpload.getContentType());
		uploadFile.setFileSize(fileUpload.getSize());
		uploadFile.setDelFlg(ApplicationConstant.DEL_FLG);
		uploadFile.setRCreTime(dateUtil.getCurrentDateWithTime());
		uploadFile.setRModTime(dateUtil.getCurrentDateWithTime());
		uploadFile.setRModId(ulaId);	
		FileMaster downloadFile=fileMasterDao.findOne(ulaId);
		if(downloadFile!=null){
			uploadFile.setDbts(downloadFile.getDbts()+1);
			uploadFile.setRCreTime(downloadFile.getRCreTime());
			uploadFile.setRCreId(downloadFile.getRCreId());
		}
		if(downloadFile==null){
			fileMasterDao.save(uploadFile);
			return null;
		}
		fileMasterDao.save(uploadFile);
		return null;
		// End of user code
	}

}