/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.user.controller;


import java.io.IOException;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
//Start of user code (user defined imports)
import org.nikithra.aranidhi.common.constants.ApplicationConstant;
import org.nikithra.aranidhi.common.exceptions.DeleteFailedException;
import org.nikithra.aranidhi.common.exceptions.NoDataFoundException;
import org.nikithra.aranidhi.common.util.ExceptionHandlerMessage;
import org.nikithra.aranidhi.user.service.IUserService;
// End of user code

/**
 * Description of DeleteUserController.
 * 
 * @author NIKITHRA
 */
@RestController
@CrossOrigin(origins = {ApplicationConstant.CROSS_ORIGIN, ApplicationConstant.CROSS_ORIGIN1})
@RestControllerAdvice

public class DeleteUserController {

	// Start of user code (user defined attributes for DeleteUserController)
	// Logging
	Logger logger = Logger.getLogger(DeleteUserController.class.getName());
	
	@Autowired
	private IUserService userService;
	// End of user code

	/**
     * Description of the method deleteProfileGet.
     * 
     * @param userDetailsVO
     * @throws NoDataFoundException
     * @return
     * @throws IOException
     */
    //Page render method to show delete profile page
    @RequestMapping(value = "/getdeleteProfile/", method = RequestMethod.POST)
    public UserDetailsVO deleteProfileGet(UserDetailsVO userDetailsVO)
            throws NoDataFoundException, IOException {
        // Start of user code for method deleteProfileGet
        logger.debug("Opening Delete Profile page");
        if (userDetailsVO.getUlaId() != null) {
        	//to view the userDetails
        	userDetailsVO= userService.fetchUserDetails(userDetailsVO);
        } else {
            logger.error("Session Expired ,Redirecting to Session Timeout page");
        }
        
        return userDetailsVO;
        // End of user code
    }

    /**
	 * Description of the method deleteProfile
	 * @param userDetailsVO 
	 * @throws NoDataFoundException 
	 * @throws HibernateException 
	 * @throws DeleteFailedException 
	 * @throws IOException 
	 */
	// To delete the user profile
	@RequestMapping( value = "/deleteProfile/",method = RequestMethod.POST)
	public UserDetailsVO deleteProfile(UserDetailsVO userDetailsVO) 
			throws NoDataFoundException, HibernateException, DeleteFailedException, IOException {
		// Start of user code for method deleteProfilePost
		logger.debug("Process Delete Profile");
		UserDetailsVO userDetailsVOExist = userService.fetchUserDetails(userDetailsVO);
		userDetailsVOExist.setRemarks(userDetailsVO.getRemarks());
		//to Delete the UserProfile
		userService.deleteUserProfile(userDetailsVOExist);
		
		return userDetailsVO;
		// End of user code
    }

	// Start of user code (user defined methods for DeleteUserController)
	// Exception handler for Delete User page
	
	@ExceptionHandler({ NoDataFoundException.class ,DeleteFailedException.class})
	public ExceptionHandlerMessage handleException(Exception ex) {
		logger.error("Exception in Delete User Controller");
		return new ExceptionHandlerMessage(ex.getMessage(),ApplicationConstant.ERROR);
	}
	// End of user code
}
