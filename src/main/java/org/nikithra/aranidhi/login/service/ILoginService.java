/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.login.service;

//Start of user code (user defined imports)
import org.nikithra.aranidhi.common.exceptions.DuplicatePasswordException;
import org.nikithra.aranidhi.common.exceptions.InvalidUserIdException;
import org.nikithra.aranidhi.common.exceptions.InvalidUserNamePasswordException;
import org.nikithra.aranidhi.common.exceptions.NoDataFoundException;
import org.nikithra.aranidhi.common.exceptions.PasswordMismatchException;
import org.nikithra.aranidhi.common.exceptions.UpdateFailedException;
import org.nikithra.aranidhi.framework.sessCache.SessionCache;
import org.nikithra.aranidhi.framework.sessCache.UserSessionDetails;
import org.nikithra.aranidhi.login.controller.ChangePasswordVO;
import org.nikithra.aranidhi.login.controller.LoginVO;

// End of user code

/**
 * Description of ILoginService.
 * 
 * @author NIKITHRA
 */
public interface ILoginService {
	// Start of user code (user defined attributes for ILoginService)

	// End of user code
   
     
 	/**
 	 * Description of the method validateUser.
 	 * @param loginVO 
 	 * @param sessionCache 
 	 * @return 
 	 * @throws UpdateFailedException 
 	 * @throws InvalidUserNamePasswordException 
 	 * @throws InvalidUserIdException 
 	 * @throws NoDataFoundException 
 	 */
 	public UserSessionDetails validateUser(LoginVO loginVO,SessionCache sessionCache) throws InvalidUserIdException, InvalidUserNamePasswordException, NoDataFoundException, UpdateFailedException;

 
	

	/**
	 * Description of the method logout.
	 * 
	 * @param userSessionDetails
	 * @throws InvalidUserIdException
	 * @throws UpdateFailedException
	 */
	// To update the logout details
	
	public void logout(LoginVO loginVO)throws InvalidUserIdException, UpdateFailedException;
	
	
	
	
	/**
	 * Description of the method changePasword.
	 * @param changePasswordVO 
	 * @throws UpdateFailedException 
	 * @throws InvalidUserIdException 
	 */
	void updatePassword(ChangePasswordVO changePasswordVO) throws UpdateFailedException, InvalidUserIdException;

	/**
	 * Description of the method changePasword.
	 * @param userId 
	 * @return
	 * @throws InvalidUserIdException 
	 */
	public String getCurrentPassword(String userId) throws InvalidUserIdException;
	
	
	
	
	/**
	 * Description of the method getDetails.
	 * 
	 * @param emailId
	 * @throws InvalidUserIdException
	 * @throws NoDataFoundException
	 * @throws UpdateFailedException
	 */
	void getDetails(String emailId) throws InvalidUserIdException, NoDataFoundException, UpdateFailedException;
	
	

	/**
	 * Description of the method changePassword.
	 * 
	 * @param changePasswordVO
	 * @return 
	 * @throws UpdateFailedException 
	 * @throws InvalidUserIdException 
	 * @throws DuplicatePasswordException 
	 * @throws PasswordMismatchException 
	 */
	// To change the password
	
	public ChangePasswordVO changePassword(ChangePasswordVO changePasswordVO) 
			throws UpdateFailedException, InvalidUserIdException, DuplicatePasswordException, 
			PasswordMismatchException ;

	// Start of user code (user defined methods for ILoginService)

	// End of user code

}
