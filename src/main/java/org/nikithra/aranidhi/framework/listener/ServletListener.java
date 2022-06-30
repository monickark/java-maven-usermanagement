/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.framework.listener;

//Start of user code (user defined imports)

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

//End of user code

/**
 * Description of ServletListener.
 * 
 * @author NIKITHRA
 */

//@WebListener
public class ServletListener implements ServletContextListener{
	Logger logger = Logger.getLogger(ServletListener.class);
	@Override
	  public void contextInitialized (ServletContextEvent sce) {
	      logger.debug("from ServletContextListener: " +
	                                   " context initialized");
	  }

	  @Override
	  public void contextDestroyed (ServletContextEvent sce) {

	  }
}
