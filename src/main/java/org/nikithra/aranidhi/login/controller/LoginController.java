/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.login.controller;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
// Start of user code (user defined imports)

import org.slf4j.LoggerFactory;
import org.nikithra.aranidhi.common.constants.ApplicationConstant;
import org.nikithra.aranidhi.common.constants.ErrorCodeConstant;
import org.nikithra.aranidhi.common.exceptions.DuplicatePasswordException;
import org.nikithra.aranidhi.common.exceptions.InvalidUserIdException;
import org.nikithra.aranidhi.common.exceptions.InvalidUserNamePasswordException;
import org.nikithra.aranidhi.common.exceptions.NoDataFoundException;
import org.nikithra.aranidhi.common.exceptions.PasswordMismatchException;
import org.nikithra.aranidhi.common.exceptions.UpdateFailedException;
import org.nikithra.aranidhi.common.util.ExceptionHandlerMessage;
import org.nikithra.aranidhi.framework.sessCache.SessionCache;
import org.nikithra.aranidhi.framework.sessCache.UserSessionDetails;
import org.nikithra.aranidhi.login.service.ILoginService;

//End of user code

/**
 * Description of LoginController.
 * 
 * @author NIKITHRA
 */
@RestController
@CrossOrigin(origins = {ApplicationConstant.CROSS_ORIGIN, ApplicationConstant.CROSS_ORIGIN1})
@RestControllerAdvice

public class LoginController {
	// Start of user code (user defined attributes for LoginController)
	Logger logger = LoggerFactory.getLogger(LoginController.class.getName());
	
	@Autowired
	private ILoginService loginService;
	// End of user code
    
	/**
	 * Description of the method loginPost.
	 * @throws UpdateFailedException 
	 * @throws InvalidUserNamePasswordException 
	 * @throws InvalidUserIdException 
	 */
	// To show login page
	@RequestMapping(value = "/login/", method = RequestMethod.POST)
	public UserSessionDetails loginPost(LoginVO loginVO, HttpServletRequest request,
			HttpSession session) throws InvalidUserIdException, InvalidUserNamePasswordException,
			UpdateFailedException ,NoDataFoundException{
		
	    // Start of user code for method loginPost
		logger.debug("Validating the username and password to checking the login page");
		UserSessionDetails usersessiondetails=null;
	
	    SessionCache sessionCache = (SessionCache) session
				.getAttribute(ApplicationConstant.SESSION_CACHE_KEY);
	    String ipAddress = request.getHeader("X-FORWARDED-FOR");
	    
	    //1.check the Ipaddress value is null or not
	    //2.Ip address is null to get value
	    //3.to Set a bean value ipaddress
	    logger.debug("IP"+ipAddress);
	    if (ipAddress == null) {
	        ipAddress=request.getRemoteHost();
	        loginVO.setIpAddress(ipAddress);
	    }
	    	
	    //1.Create thhe session
	    //2.
	    //3.else to get the sesion cache value
	    if (sessionCache == null) {
			sessionCache = new SessionCache();
			session.setAttribute(ApplicationConstant.SESSION_CACHE_KEY,
					sessionCache);
		} else {
			sessionCache = (SessionCache) session
					.getAttribute(ApplicationConstant.SESSION_CACHE_KEY);
		}
	    //To check the username and password is Correct or nothing match Database
		usersessiondetails=loginService.validateUser(loginVO,sessionCache);
		logger.debug("Login success, Redirect to Dashboard page");
		logger.debug("User Login Details"+usersessiondetails);
		session.setAttribute("usersessiondetails", usersessiondetails);
		MDC.put("userId", usersessiondetails.getUserId());
		MDC.put("ipAddress", loginVO.getIpAddress());
	    return usersessiondetails;
	    // End of user code
	}
	 
	
	/**
	 * Description of the method logout.
	 * @throws InvalidUserIdException
	 * @throws UpdateFailedException 
	 */
	// Logout function
	@RequestMapping(value = "/logout/", method = RequestMethod.POST)
	public void logout(String userId)throws 
			InvalidUserIdException, UpdateFailedException {
		
		// Start of user code for method logout
		logger.debug("Processing Logout function");
	
		LoginVO loginVO=new LoginVO();
		
		//1.to user id is empty or not.
		// 2.to user id not empty to logout the function or else  throw exception
		if(userId!=null){
			loginVO.setUserId(userId);
			loginService.logout(loginVO);
		}
		MDC.remove("userId");
		MDC.remove("ipAddress");
		logger.debug("Logout completed.");
		// End of user code
	}
	
	
	/**
	 * Description of the method forgotPassword.
	 * @throws NoDataFoundException
	 * @throws UpdateFailedException 
	 */
	// Forgot password function
	@RequestMapping(value = "/forgotPassword/", method = RequestMethod.POST)
	public ExceptionHandlerMessage forgotPassword(String emailId)
			throws NoDataFoundException,InvalidUserIdException,InvalidUserNamePasswordException, 
			UpdateFailedException {
		
		// Start of user code for method forgotPassword
		logger.debug("Process Forgot Password");
		
		//user request to reset the password if user forgot password
		loginService.getDetails(emailId);
		return new ExceptionHandlerMessage(ErrorCodeConstant.MAIL_SENT,ApplicationConstant.SUCCESS);
		// End of user code
	}
	
	
	/**
	 * Description of the method changePassword.
	 * @throws NoDataFoundException
	 * @throws UpdateFailedException 
	 * @throws DuplicatePasswordException 
	 * @throws PasswordMismatchException 
	 */
	// To show change password page
	@RequestMapping(value = "/changePassword/", method = RequestMethod.POST)
	public ExceptionHandlerMessage changePassword(ChangePasswordVO changePasswordVO)
			throws NoDataFoundException,InvalidUserIdException,InvalidUserNamePasswordException, 
			UpdateFailedException, DuplicatePasswordException, PasswordMismatchException {
		logger.debug("changePasswordVO"+changePasswordVO);
		// Start of user code for method changePassword
		logger.debug("Process Change Password request");
		changePasswordVO = loginService.changePassword(changePasswordVO);
		return new ExceptionHandlerMessage(ErrorCodeConstant.PASSWORD_CHANGE_SUCCESS,
				ApplicationConstant.SUCCESS);
		// End of user code
	}
	
	
	// Start of user code (user defined methods for LoginController)
	
	@ExceptionHandler({ UpdateFailedException.class, InvalidUserIdException.class,
		InvalidUserNamePasswordException.class, DuplicatePasswordException.class, 
		PasswordMismatchException.class, NoDataFoundException.class})
	public ExceptionHandlerMessage handleException(Exception ex) {
		logger.error("Exception in Login Controller");
		return new ExceptionHandlerMessage(ex.getMessage(),ApplicationConstant.ERROR);
	}
	// End of user code
	
}
