/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.common.bussiness;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Component;

//Start of user code (user defined imports)

//End of user code

/**
* Description of AranidhiApplication.
* 
* @author NIKITHRA
*/
@Component
public class CommonBusiness {
	
	/**
	 * Description of the method changeObject.
	 * @param destination
	 */
	public void changeObject(Object destination, Object source) {
		// Start of User code for method changeObject
		try {
			BeanUtils.copyProperties(destination, source);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return;
		//End of User code for method changeObject
	}

}
