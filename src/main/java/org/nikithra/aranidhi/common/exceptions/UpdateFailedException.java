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
public class UpdateFailedException extends Exception {

	
	private static final long serialVersionUID = 1L;

	
	/**
	 *Description of the property message
	 */
	String message = ErrorCodeConstant.UPDATE_FAILED;

	
	/**
	 * Description of the property GetMessaage.
	 */
	public String getMessage() {
		return message;
	}

}
