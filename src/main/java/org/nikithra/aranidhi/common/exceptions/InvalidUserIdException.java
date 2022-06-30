/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.common.exceptions;

//Start of user code (user defined imports)
import org.nikithra.aranidhi.common.constants.ErrorCodeConstant;
//End of user code


/**
* Description of AranidhiApplication.
* 
* @author NIKITHRA
*/
public class InvalidUserIdException extends Exception {
	
	private static final long serialVersionUID = 1L;

	/**
	 *Description of the property message
	 */
	String message = ErrorCodeConstant.INVALID_USERID;
	
	
	/**
	 * Returns message.
	 * @return message 
	 */
	@Override
	public String getMessage() {
		return message;
	}

}
