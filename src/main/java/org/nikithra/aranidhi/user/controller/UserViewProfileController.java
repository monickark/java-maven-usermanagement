/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.user.controller;


import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RestControllerAdvice;
// Start of user code (user defined imports)
import org.nikithra.aranidhi.common.exceptions.NoDataFoundException;
import org.nikithra.aranidhi.common.util.ExceptionHandlerMessage;
import org.nikithra.aranidhi.user.controller.UserDetailsVO;
import org.nikithra.aranidhi.user.service.IUserService;
import org.nikithra.aranidhi.common.constants.ApplicationConstant;

//End of user code

/**
 * Description of UserViewProfileController.
 * 
 * @author NIKITHRA
 */
@RestController
@CrossOrigin(origins = {ApplicationConstant.CROSS_ORIGIN, ApplicationConstant.CROSS_ORIGIN1})
@RestControllerAdvice

public class UserViewProfileController {
	// Start of user code (user defined attributes for UserViewProfileController)
	// Logging
	Logger logger = Logger.getLogger(UserViewProfileController.class.getName());
	
	@Autowired
	private IUserService userService;
	
	// End of user code

	/**
	 * Description of the method viewProfileGet.
	 * 
	 * @param userDetailsVO
	 * @throws NoDataFoundException
	 * @return
	 * @throws IOException
	 */
	//Page render method to show view profile page
	
	@RequestMapping(value = "/viewProfile/", method = RequestMethod.POST)
	public UserDetailsVO viewProfileGet(UserDetailsVO userDetailsVO)
			throws NoDataFoundException, IOException {
		
		// Start of user code for method viewProfileGet
		logger.debug("Opening View Profile page");
		if (userDetailsVO.getUlaId() != null) {
			//to view the user Details 
			userDetailsVO = userService.fetchUserDetails(userDetailsVO);
		} else {
			logger.error("Session Expired ,Redirecting to Session Timeout page");
		}
		return userDetailsVO;
		// End of user code
	
	}
	
	// Start of user code (user defined methods for UserUpdateProfileController)
	// Exception handler for User View Profile page

	@ExceptionHandler({ NoDataFoundException.class})
	public ExceptionHandlerMessage handleException(Exception ex) {
		logger.error("Exception in User View Controller");
		return new ExceptionHandlerMessage(ex.getMessage(),ApplicationConstant.ERROR);
	}
	// End of user code
}
