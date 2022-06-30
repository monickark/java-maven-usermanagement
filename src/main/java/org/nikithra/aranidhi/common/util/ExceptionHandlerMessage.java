/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.common.util;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

//Start of user code (user defined imports)

//End of user code

/**
* Description of Message.
* 
* @author NIKITHRA
*/
@Component
public class ExceptionHandlerMessage {
	/**
	 * Description of the property messageCode.
	 */
	/*private String messageCode = "";*/

	/**
	 * Description of the property messageDescription.
	 */
	private String messageDescription = "";

	/**
	 * Description of the property messageType.
	 */
	private String messageType = "";

	
	// Start of user code (user defined attributes for Message)

	// End of user code

	/**
	 * The constructor.
	 */
	public ExceptionHandlerMessage() {
		// Start of user code constructor for ExceptionHandlerMessage
		super();
		// End of user code
	}
	
	/**
	 * The Parameterized constructor.
	 */
	public ExceptionHandlerMessage(String messageDescription, String messageType) {
		// Start of user code constructor for ExceptionHandlerMessage
		this.messageType=messageType;
		this.messageDescription=messageDescription;
		// End of user code
	}

	// Start of user code (user defined methods for Message)

	// End of user code
	/**
	 * Returns messageCode.
	 * @return messageCode 
	 */
	/*public String getMessageCode() {
		return this.messageCode;
	}*/

	/**
	 * Sets a value to attribute messageCode. 
	 * @param newMessageCode 
	 */
	/*public void setMessageCode(String newMessageCode) {
		this.messageCode = newMessageCode;
	}*/

	/**
	 * Returns messageDescription.
	 * @return messageDescription 
	 */
	public String getMessageDescription() {
		return this.messageDescription;
	}

	/**
	 * Sets a value to attribute messageDescription. 
	 * @param newMessageDescription 
	 */
	public void setMessageDescription(String newMessageDescription) {
		this.messageDescription = newMessageDescription;
	}

	/**
	 * Returns messageType.
	 * @return messageType 
	 */
	public String getMessageType() {
		return this.messageType;
	}

	/**
	 * Sets a value to attribute messageType. 
	 * @param newMessageType 
	 */
	public void setMessageType(String newMessageType) {
		this.messageType = newMessageType;
	}

	
}
