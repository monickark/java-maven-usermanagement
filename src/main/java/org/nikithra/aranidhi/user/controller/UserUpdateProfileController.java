/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.user.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartFile;
// Start of user code (user defined imports)
import org.nikithra.aranidhi.common.constants.ApplicationConstant;
import org.nikithra.aranidhi.common.exceptions.NoDataFoundException;
import org.nikithra.aranidhi.common.exceptions.UpdateFailedException;
import org.nikithra.aranidhi.common.util.ExceptionHandlerMessage;
import org.nikithra.aranidhi.user.controller.UserDetailsVO;
import org.nikithra.aranidhi.user.dao.FileMaster;
import org.nikithra.aranidhi.user.service.IUserService;
//End of user code

/**
 * Description of UserViewProfileController.
 * 
 * @author NIKITHRA
 */
@RestController
@CrossOrigin(origins = {ApplicationConstant.CROSS_ORIGIN, ApplicationConstant.CROSS_ORIGIN1})
@RestControllerAdvice

public class UserUpdateProfileController {
	// Start of user code (user defined attributes for UserViewProfileController)
	// Logging
	Logger logger = Logger.getLogger(UserUpdateProfileController.class.getName());
	
	@Autowired
	private IUserService userService;

	// End of user code

	/**
	 * Description of the method editProfile.
	 * 
	 * @param userDetailsVO
	 * @throws NoDataFoundException
	 * @return
	 * @throws IOException
	 */
	//To show update Profile  page
	@RequestMapping(value = "/editProfile/", method = RequestMethod.POST)
	public UserDetailsVO editProfile(UserDetailsVO userDetailsVO)
			throws NoDataFoundException, IOException {
		// Start of user code for method updateProfile
		logger.debug("Opening edit Profile");

		if (userDetailsVO.getUlaId() != null) {
			//to view the user Details 
			userDetailsVO = userService.fetchUserDetails(userDetailsVO);
		} else {
			logger.error("Session Expired ,Redirecting to Session Timeout page");
		}
		
		return userDetailsVO;
		// End of user code
	}
	
	/**
	 * Description of the method updateProfile.
	 * 
	 * @param userDetailsVO
	 * @throws NoDataFoundException
	 * @return
	 * @throws IOException
	 */
	//To show update Profile  page
	@RequestMapping(value = "/updateProfile/", method = RequestMethod.POST, consumes = "multipart/form-data")
	public UserDetailsVO updateProfile(@RequestPart(value = "uploadFile", required=false) final MultipartFile photo,
			@RequestPart(value="userdetails", required=true) UserDetailsVO userDetailsVO)
			throws NoDataFoundException,IOException, UpdateFailedException {
		// Start of user code for method updateProfile
		logger.debug("Opening update Profile page");
		
		if (userDetailsVO.getUlaId() != null) {
			//to view the user Details 
			userService.updateUserProfile(userDetailsVO);
		} else {
			logger.error("Session Expired ,Redirecting to Session Timeout page");
		}
		try {
			if (photo != null) {
				userService.handleFileUpdate(photo,
						userDetailsVO.getUlaId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userDetailsVO;
		// End of user code
	}
	
	/**
	 * Description of the method displayImage.
	 * 
	 * @param ulaId
	 * @throws NoDataFoundException
	 * @throws IOException
	 * @return
	 */
	@RequestMapping(value = "/image", method = RequestMethod.POST)
	public Map<String, String> displayImage(String ulaId) throws IOException, NoDataFoundException {
		// Start of user code for method displayImage
		logger.debug("inside the method to retrieve the image");
		FileMaster userDetailsPhoto = null;
		if (ulaId != null) {
			userDetailsPhoto = userService.handleFileDownload(ulaId);
		}
		byte[] photo = userDetailsPhoto.getFile();
		String encodeImage = Base64.getEncoder().encodeToString(photo);
		Map<String, String> jsonMap = new HashMap<>();
		jsonMap.put("content", encodeImage);
		return jsonMap;
	   // End of user code
	}
	
	// Start of user code (user defined methods for UserUpdateProfileController)
	// Exception handler for UserUpdateProfileController page
	@ExceptionHandler({ NoDataFoundException.class,UpdateFailedException.class})
	public ExceptionHandlerMessage handleException(Exception ex) {
		logger.error("Exception in User Update Controller");
		return new ExceptionHandlerMessage(ex.getMessage(),ApplicationConstant.ERROR);
	}
			
	// End of user code
}

