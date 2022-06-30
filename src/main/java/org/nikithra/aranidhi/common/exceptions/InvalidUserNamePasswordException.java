package org.nikithra.aranidhi.common.exceptions;

import org.nikithra.aranidhi.common.constants.ErrorCodeConstant;

public class InvalidUserNamePasswordException extends Exception {

	
	private static final long serialVersionUID = 1L;

	/**
	 *Description of the property message
	 */
	String message = ErrorCodeConstant.INVALID_USERNAME_PASSWORD;
	
	
	/**
	 * Returns message.
	 * @return message 
	 */
	@Override
	public String getMessage() {
		return message;
	}

}
