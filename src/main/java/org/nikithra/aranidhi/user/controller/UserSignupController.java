/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.user.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.nikithra.aranidhi.common.constants.ApplicationConstant;
import org.nikithra.aranidhi.common.constants.ErrorCodeConstant;
//Start of user code (user defined imports)
import org.nikithra.aranidhi.common.exceptions.DuplicateEntryException;
import org.nikithra.aranidhi.common.exceptions.UpdateFailedException;
import org.nikithra.aranidhi.common.util.ExceptionHandlerMessage;
import org.nikithra.aranidhi.login.controller.LoginVO;
import org.nikithra.aranidhi.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartFile;

// End of user code

/**
 * Description of UserSignupController.
 * 
 * @author NIKITHRA
 */
@RestController
@CrossOrigin(origins = {ApplicationConstant.CROSS_ORIGIN, ApplicationConstant.CROSS_ORIGIN1})
@RestControllerAdvice

public class UserSignupController {
	// Start of user code (user defined attributes for UserSignupController)
	// Logging
	Logger logger = Logger.getLogger(UserSignupController.class.getName());
	
	@Autowired
	private IUserService userService;

	// End of user code

	/**
	 * Description of the method getNextUlaId.
	 * @throws UpdateFailedException 
	 */
	//to show registration page
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String getNextUlaId() throws UpdateFailedException {
		
		// Start of user code for method signupGet
		logger.debug("Opening User Signup page");
		return userService.getNextULAID();
		// End of user code
		
	}

	/**
	 * Description of the method signupPost.
	 * 
	 * @param userSignupVO
	 * @throws DuplicateEntryException 
	 */
	// To register the user
	@RequestMapping(value = "/signup/", method = RequestMethod.POST, consumes = "multipart/form-data")
	@ResponseBody
	public ExceptionHandlerMessage signupPost(@RequestPart(value = "uploadFile", required=false) final MultipartFile photo,
			@RequestPart(value="userdetails", required=true) UserDetailsVO userDetailsVO,
			@RequestPart(value="logindetails", required=true) LoginVO loginVO, HttpServletRequest request)
			throws  DuplicateEntryException {
		
		// Start of user code for method signupPost
	    logger.debug("Submitting User Signup Form");
	    logger.error("Submitting User Signup Form");
	    logger.info("Submitting User Signup Form");
	    
	    userService.insertUserDetails(userDetailsVO,loginVO);
	    try {    
        	//to insert the user  image
	    	if (photo != null) {
	    		userService.handleFileUpload(photo,userDetailsVO.getUlaId());
	    	}
	    	else{
	    		File file=new File( request
						.getSession()
						.getServletContext()
						.getRealPath( "//WEB-INF//images//avatar.png"));
	    		FileInputStream input = new FileInputStream(file);
	    		MultipartFile multipartFile = new MockMultipartFile("file",
	    				file.getName(), "image/png", IOUtils.toByteArray(input));
	    		userService.handleFileUpload(multipartFile,userDetailsVO.getUlaId());
	    	}
	    	
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
	    logger.info("User Successfully registered");
	    return new ExceptionHandlerMessage(ErrorCodeConstant.ADD_SUCCESS_MESS,
	    		ApplicationConstant.SUCCESS);
		// End of user code
	}

	// Exception handler for registration page
	
	@ExceptionHandler({ DuplicateEntryException.class })
	public ExceptionHandlerMessage handleException(Exception ex) {
		logger.error("Exception in User Signup Controller");
		logger.error("Duplicate Email-Id or Mobile Number");
		return new ExceptionHandlerMessage(ex.getMessage(),ApplicationConstant.ERROR);
	}
	// End of user code
		
}
