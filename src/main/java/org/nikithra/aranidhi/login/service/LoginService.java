/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.login.service;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//Start of user code (user defined imports)
import org.nikithra.aranidhi.common.bussiness.CommonBusiness;
import org.nikithra.aranidhi.common.constants.ApplicationConstant;
import org.nikithra.aranidhi.common.exceptions.DuplicatePasswordException;
import org.nikithra.aranidhi.common.exceptions.InvalidUserIdException;
import org.nikithra.aranidhi.common.exceptions.InvalidUserNamePasswordException;
import org.nikithra.aranidhi.common.exceptions.NoDataFoundException;
import org.nikithra.aranidhi.common.exceptions.PasswordMismatchException;
import org.nikithra.aranidhi.common.exceptions.UpdateFailedException;
import org.nikithra.aranidhi.common.util.DateUtil;
import org.nikithra.aranidhi.framework.sessCache.SessionCache;
import org.nikithra.aranidhi.framework.sessCache.UserSessionDetails;
import org.nikithra.aranidhi.login.controller.ChangePasswordVO;
import org.nikithra.aranidhi.login.controller.LoginVO;
import org.nikithra.aranidhi.login.dao.ILoginDAO;
import org.nikithra.aranidhi.login.dao.Login;
import org.nikithra.aranidhi.user.dao.IUserDetailsDAO;
import org.nikithra.aranidhi.user.dao.UserDetails;

// End of user code

/**
 * Description of LoginService.
 * 
 * @author NIKITHRA
 */
@Service
@Transactional
public class LoginService implements ILoginService {
	
	// Start of user code (user defined attributes for LoginService)
	Logger logger = Logger.getLogger(LoginService.class);
	
	@Autowired
    private CommonBusiness commonBusiness;
    @Autowired
    private ILoginDAO loginDAO;
    @Autowired
    private IUserDetailsDAO userDetailsDAO;
    @Autowired
    DateUtil dateUtil;
    @Autowired
    private UserSessionDetails userSessionDetails;
	// End of user code
	
	/**
	 * Description of the method validateUser.
	 * 
	 * @param loginVO
	 * @param sessionCache
	 * @throws UpdateFailedException
	 * @throws InvalidUserNamePasswordException
	 * @throws InvalidUserIdException
	 */
	// To Check User credentials or not
	
	public UserSessionDetails validateUser(LoginVO loginVO,SessionCache sessionCache) throws InvalidUserIdException,
			InvalidUserNamePasswordException, UpdateFailedException,NoDataFoundException {
		
		//checking in database whether the userid exist or not
		logger.debug("User Id: " + loginVO.getUserId());
		Login login = loginDAO.validateUserId(loginVO.getUserId(),ApplicationConstant.DEL_FLG);
		
		if (login == null) {
			throw new InvalidUserIdException();
		}
		if (loginVO.getPassword().equals(login.getPassword())) {
			
		} else {
			logger.error("Password Mismatch");
			throw new InvalidUserNamePasswordException();
		}

		login=buildLoginObjForlogin(login);
		int changerow=loginDAO.updateLogin(login.getDbts(),login.getPassword(),login.getLastLoginTime(),
				login.getIpAddress(),login.getLastLogoutTime(),login.getTotalNoOfLogin(),login.getRModTime(),
				login.getUserId(),login.getDelFlg(),login.getMobileNo());
		if (changerow == 0) {
			throw new UpdateFailedException();
		}
		
		commonBusiness.changeObject(userSessionDetails, login);
		userSessionDetails=setUserSessionCache(userSessionDetails,sessionCache);
		// End of user code
		return userSessionDetails;
	}
	
	/**
	 * Description of the method logout.
	 * 
	 * @param userSessionDetails
	 * @throws InvalidUserIdException
	 * @throws UpdateFailedException
	 */
	// To update the logout details
	
	public void logout(LoginVO loginVO)
			throws InvalidUserIdException, UpdateFailedException {
		// Start of user code for method logout
		Login login = new Login();
		commonBusiness.changeObject(login, loginVO);
		login = loginDAO.findOne(login.getUserId());
	    login.setLastLogoutTime(dateUtil.getCurrentDateWithTime());
		login.setDbts(login.getDbts() + 1);
		login.setRModTime(dateUtil.getCurrentDateWithTime());
		int changerow=loginDAO.updateLogin(login.getDbts(),login.getPassword(),login.getLastLoginTime(),
				login.getIpAddress(),login.getLastLogoutTime(),login.getTotalNoOfLogin(),login.getRModTime(),
				login.getUserId(),login.getDelFlg(),login.getMobileNo());
		if (changerow == 0) {
			throw new UpdateFailedException();
		}
		if (loginVO == null) {
			throw new InvalidUserIdException();
		} 
		// End of user code
	}
	
	/**
	 * Description of the method setUserSessionObject.
	 * 
	 * @param userSessionDetails
	 * @throws NoDataFoundException
	 * @throws InvalidUserIdException 
	 */
	// To Create session for User
	
	private UserSessionDetails setUserSessionObject(UserSessionDetails userSessionDetails)
			throws NoDataFoundException, InvalidUserIdException {
		// Start of user code for method setUserSessionObject
		UserDetails userDetails = userDetailsDAO.selectUserDetails(userSessionDetails
				.getUserId(),ApplicationConstant.DEL_FLG);
		if (userDetails == null) {
			throw new NoDataFoundException();
		}
		return new UserSessionDetails(userDetails.getUlaId(),
				userDetails.getFirstName()+" "+userDetails.getLastName(),
				userDetails.getProfileGroup(),userDetails.getEmailId());
		// End of user code
	}
	
	/**
	 * Description of the method getDetails.
	 * 
	 * @param emailId
	 * @throws InvalidUserIdException
	 * @throws NoDataFoundException
	 * @throws UpdateFailedException
	 */
	// To Forgot the password
	
	@Transactional
	public void getDetails(String emailId) throws InvalidUserIdException, NoDataFoundException, UpdateFailedException{
		// Start of user code for method getDetails
		Login login = new Login();
		login.setUserId(emailId);
		login.setDelFlg(ApplicationConstant.DEL_FLG);
		login = loginDAO.validateUserId(login.getUserId(),login.getDelFlg());
		if (login == null) {
			throw new NoDataFoundException();
		}
		
		UserDetails userDetails=new UserDetails();
		userDetails.setUlaId(login.getUserId());
		userDetails.setEmailId(login.getEmailId());
		userDetails=userDetailsDAO.findOne(userDetails.getUlaId());
		String characters = ApplicationConstant.PASSWORD_CHAR;
        String pwd = RandomStringUtils.random( 8, characters );
        sendingMail(userDetails, pwd);
		login.setPassword(pwd);
		login.setDbts(login.getDbts() + 1);
		login.setRModTime(dateUtil.getCurrentDateWithTime());

		int changerow=loginDAO.updateLogin(login.getDbts(),login.getPassword(),login.getLastLoginTime(),
				login.getIpAddress(),login.getLastLogoutTime(),login.getTotalNoOfLogin(),
				login.getRModTime(),login.getUserId(),login.getDelFlg(),login.getMobileNo());
		
		if (changerow == 0) {
			throw new UpdateFailedException();
		}

		// End of user code
	}
	
	
	/**
	 * Description of the method sendingMail.
	 * @param userDetails
	 * @param genPassword
	 * 
	 */
	// To send the mail
	
	private void sendingMail(UserDetails userDetails,String genPassword) {
		// Start of user code for method sendingMail
		String toEmail = userDetails.getEmailId();
		String fromEmail = ApplicationConstant.EMAIL_ID;
		final String username = ApplicationConstant.USER_NAME;
		final String password = ApplicationConstant.PASSWORD;

		logger.debug("Message Send from "+ fromEmail);
		// Get the session object
		Properties properties = new Properties();
		properties.put("mail.smtp.host", ApplicationConstant.SMTP_HOST);
		properties.put("mail.smtp.socketFactory.port", ApplicationConstant.SMTP_PORT);
		properties.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		properties.put("mail.defaultEncoding", ApplicationConstant.DEFAULT_ENCODING);
		properties.put("mail.smtp.auth", ApplicationConstant.SMTP_AUTH);
		properties.put("mail.smtp.port", ApplicationConstant.SMTP_PORT);
		Session session = Session.getInstance(properties,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

		// compose the message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromEmail));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					toEmail));
			message.setSubject(ApplicationConstant.SUBJECT);

			String text = "<h1>Aranidhi</h1> <h3 style='text-transform: capitalize'>Dear "+userDetails.getFirstName()+" "+userDetails.getLastName()+" ,</h3>"
					
					+ "<h4>As per your request password has been sucessfully changed. Use your User id and the following password to login"
					+ "<h3>New Password: "+genPassword+"</h3>"
					+ "<h3>Regards,</h3><h3>Aranidhi Team</h3>"
					+"<strong style='color: #9a1100;'>Note- This is a system-generated unattended mail box, kindly do not reply to this email.</strong>";
			message.setContent(text, "text/html;charset=UTF-8");

			// Send message
			Transport.send(message);
			logger.debug("Message sent successfully to "+toEmail);

		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
		// End of user code

	}
	
	
	/**
	 * Description of the method changePassword.
	 * 
	 * @param changePasswordVO
	 * @throws UpdateFailedException 
	 * @throws InvalidUserIdException 
	 * @throws DuplicatePasswordException 
	 * @throws PasswordMismatchException 
	 */
	// To change the password
	
	public ChangePasswordVO changePassword(ChangePasswordVO changePasswordVO) 
			throws UpdateFailedException, InvalidUserIdException, DuplicatePasswordException, PasswordMismatchException {
		
		// Start of user code for method changePassword
		 String currentPassword=getCurrentPassword(changePasswordVO.getUserId());
		 logger.debug("Current Password"+currentPassword);
		if(changePasswordVO.getCurrentPassword().equals(
				currentPassword)){ 
			if (!changePasswordVO.getCurrentPassword().equals(
					changePasswordVO.getNewPassword())) {
				updatePassword(changePasswordVO);			
			} else {
				logger.error("Current Password is same as old password");
				throw new DuplicatePasswordException();
			}
		} else {
			logger.error("Password not Matched");
			throw new PasswordMismatchException();
		}
		
		// End of user code
		return changePasswordVO;
	}
	
	/**
	 * Description of the method updatePassword.
	 * 
	 * @param changePasswordVO
	 * @throws UpdateFailedException 
	 * @throws InvalidUserIdException 
	 */
	// To update the password
	public  void updatePassword(ChangePasswordVO changePasswordVO) throws UpdateFailedException, 
			InvalidUserIdException {
		// Start of user code for method changePassword

		Login login = loginDAO.validateUserId(changePasswordVO.getUserId(),ApplicationConstant.DEL_FLG);
		if (login == null) {
			throw new InvalidUserIdException();
		}

		login=buildLoginObjForCp(changePasswordVO.getUserId(),changePasswordVO.getNewPassword(),
				login);
		//to change the password
		int changerow=loginDAO.updateLogin(login.getDbts(),login.getPassword(),login.getLastLoginTime(),
				login.getIpAddress(),login.getLastLogoutTime(),login.getTotalNoOfLogin(),
				login.getRModTime(),login.getUserId(),login.getDelFlg(),login.getMobileNo());
		if (changerow == 0) {
			throw new UpdateFailedException();
		}
		
		// End of user code
	}

	/**
	 * Description of the method getCurrentPassword.
	 * 
	 * @param userId
	 * @return
	 * @throws InvalidUserIdException 
	 */
	// To get the current password
	
	public String getCurrentPassword(String userId) throws InvalidUserIdException {
		// Start of user code for method changePasword
		
		// To get the current password
		Login login=loginDAO.validateUserId(userId,ApplicationConstant.DEL_FLG);
		if (login == null) {
			throw new InvalidUserIdException();
		}
		String password=login.getPassword();
		
		return password;
		// End of user code
	}
	/**
     * Description of the method buildLoginObjForCp.
     * 
     * @param Login
     * @return
     */
	//create Login Object For change password Flow
	private  Login buildLoginObjForCp(String userId,String password,Login login) 
			throws UpdateFailedException, InvalidUserIdException {
		// Start of user code for method changePassword
		login.setUserId(userId);
		login.setDelFlg(ApplicationConstant.DEL_FLG);
		login.setPassword(password);
		login.setDbts(login.getDbts() + 1);
		login.setLastLoginTime(login.getLastLoginTime());
		login.setLastLogoutTime(login.getLastLogoutTime());
		login.setTotalNoOfLogin(login.getTotalNoOfLogin());
		login.setIpAddress(login.getIpAddress());
		login.setRModTime(dateUtil.getCurrentDateWithTime());
		return login;
		// End of user code
	}
	
	/**
     * Description of the method buildLoginObjForlogin.
     * 
     * @param Login
     * @return
     */
	//create Login Object For login Flow
	private  Login buildLoginObjForlogin(Login login) throws UpdateFailedException, 
			InvalidUserIdException {
		// Start of user code for method changePassword
		Integer num = Integer.parseInt(login.getTotalNoOfLogin()) + 1;
		login.setTotalNoOfLogin(num.toString());
		login.setDbts(login.getDbts() + 1);
		login.setLastLoginTime(dateUtil.getCurrentDateWithTime());
		login.setRModTime(dateUtil.getCurrentDateWithTime());
		return login;
		// End of user code
	}
	
	/**
     * Description of the method setUserSessionCache.
     * 
     * @param UserSessionDetails
     * @return
     */
	//create Login Object For change password Flow
	private  UserSessionDetails setUserSessionCache(UserSessionDetails userSessionDetails,
			SessionCache sessionCache) throws UpdateFailedException, InvalidUserIdException, 
			NoDataFoundException {
			// Start of user code for method changePassword
		userSessionDetails=setUserSessionObject(userSessionDetails);
		sessionCache.setUserSessionDetails(userSessionDetails);
		if(userSessionDetails==null){
			throw new NoDataFoundException();
		}
			return userSessionDetails;
			// End of user code
	}

}
