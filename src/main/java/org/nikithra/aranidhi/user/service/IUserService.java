/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.user.service;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.web.multipart.MultipartFile;

//Start of user code (user defined imports)
import org.nikithra.aranidhi.common.exceptions.DeleteFailedException;
import org.nikithra.aranidhi.common.exceptions.DuplicateEntryException;
import org.nikithra.aranidhi.common.exceptions.NoDataFoundException;
import org.nikithra.aranidhi.common.exceptions.UpdateFailedException;
import org.nikithra.aranidhi.login.controller.LoginVO;
import org.nikithra.aranidhi.user.controller.UserDetailsListVO;
import org.nikithra.aranidhi.user.controller.UserDetailsVO;
// End of user code
import org.nikithra.aranidhi.user.dao.FileMaster;

/**
 * Description of IUserService.
 * 
 * @author NIKITHRA
 */
public interface IUserService {
	// Start of user code (user defined attributes for IUserService)

	// End of user code
	
	/**
	 * Description of the method getNextULAID.
	 * @return 
	 * @throws UpdateFailedException 
	 */
	public String getNextULAID() throws UpdateFailedException;

	/**
	 * Description of the method insertUserDetails.
	 * @param userDetailsVO
	 * @param loginVO
	 * @throws DuplicateEntryException 
	 * @throws UpdateFailedException 
	 */
	public void insertUserDetails(UserDetailsVO userDetailsVO,LoginVO loginVO) throws DuplicateEntryException;


	 /**
     * Description of the method handleFileUpload.
     * @param fileUpload
     * @param ulaId
     * @throws DuplicateEntryException
     * @throws IOException
     */
	 public void handleFileUpload(MultipartFile fileUpload, String ulaId) throws DuplicateEntryException, IOException;
	 
	 /**
	 * Description of the method handleFileDownload.
	 * @param ulaId
	 * @throws NoDataFoundException
	 */
	 public FileMaster handleFileDownload(String ulaId) throws NoDataFoundException;
	 
	 /**
	 * Description of the method handleFileUpdate.
	 * @param fileUpload
	 * @param ulaId
	 * @throws IOException
	 * @throws DuplicateEntryException
	 * 
	 */
	 public String handleFileUpdate(MultipartFile fileUpload, String ulaId) throws IOException, 
	 	DuplicateEntryException;

     /**
      * Description of the method userUpdateProfile.
      * @throws InvalidUserIdException
      * @throws UpdateFailedException
     * @throws NoDataFoundException 
      */
     public void updateUserProfile(UserDetailsVO userDetailsVO) throws UpdateFailedException, NoDataFoundException;

	   /**
      * Description of the method deleteUserProfile.
      * @param userDetailsVO 
      * @throws NoDataFoundException 
      * @throws HibernateException 
      * @throws DeleteFailedException 
      */
      public void deleteUserProfile(UserDetailsVO userDetailsVO) throws NoDataFoundException, HibernateException, DeleteFailedException;
      
      
      /**
       * Description of the method fetchUserDetails.
       * @param ulaId 
       * @return 
       * @throws NoDataFoundException 
       * @throws IOException 
       */
      public UserDetailsVO fetchUserDetails(UserDetailsVO userDetailsVO) throws NoDataFoundException, IOException;

      
      /**
       * Description of the method selectUserDetailsList.
       * @return 
       * @throws NoDataFoundException 
       */
      public List<UserDetailsListVO> selectUserDetailsList() throws NoDataFoundException;

}
