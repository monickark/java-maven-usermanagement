/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.nikithra.aranidhi.common.constants.ApplicationConstant;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
// Start of user code (user defined imports)

//End of user code

/**
 * Description of AboutUsController.
 * 
 * @author NIKITHRA
 */
@RestController
@CrossOrigin(origins = {ApplicationConstant.CROSS_ORIGIN, ApplicationConstant.CROSS_ORIGIN1})
public class AboutUsController {
    // Start of user code (user defined attributes for AboutUsController)
    Logger logger = Logger.getLogger(AboutUsController.class.getName());
   
    // End of user code

    /**
     * Description of the method aboutUsGet.
     */
    // Page render method to show aboutUs page
    
    @RequestMapping(value = "/aboutUs/", method = RequestMethod.GET)
    public void aboutUsGet( HttpServletRequest request) {
        // Start of user code for method aboutUsGet
        logger.debug("Opening AboutUs page");
        // End of user code
    }


    // Start of user code (user defined methods for AboutUsController)

    // End of user code

}
