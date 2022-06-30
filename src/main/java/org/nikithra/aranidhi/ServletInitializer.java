/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

//Start of user code (user defined imports)

//End of user code


/**
* Description of AranidhiApplication.
* 
* @author NIKITHRA
*/
public class ServletInitializer extends SpringBootServletInitializer {

	
	/**
	 * Description of the method SpringApplicationBuilder.
	 * @param AranidhiApplication
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		// Start of User code for method SpringApplicationBuilder
		return application.sources(AranidhiApplication.class);
		//End of User code for method SpringApplicationBuilder
	}
	
}
