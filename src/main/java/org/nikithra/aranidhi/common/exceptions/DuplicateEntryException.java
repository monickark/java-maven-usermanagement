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
public class DuplicateEntryException extends Exception {
	
	/**
	 *Id already Insert to this avoid error use Exception Set Message 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 *Description of the property message
	 */
	String message = ErrorCodeConstant.DUPLICATE_ENTRY;

	/**
	 * Returns message.
	 * @return message 
	 */
	
	public String getMessage() {
		return message;
	}

	
}
