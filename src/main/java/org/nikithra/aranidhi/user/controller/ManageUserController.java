/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.user.controller;

//Start of user code (user defined imports)

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.nikithra.aranidhi.common.constants.ApplicationConstant;

import org.nikithra.aranidhi.common.exceptions.NoDataFoundException;
import org.nikithra.aranidhi.common.util.ExceptionHandlerMessage;
import org.nikithra.aranidhi.user.service.IUserService;

// End of user code

/**
 * Description of ManageUserController.
 * 
 * @author NIKITHRA
 */
@RestController
@CrossOrigin(origins = {ApplicationConstant.CROSS_ORIGIN, ApplicationConstant.CROSS_ORIGIN1})
@RestControllerAdvice

public class ManageUserController {
	// Start of user code (user defined attributes for ManageUserController)
	// Logging
	Logger logger = Logger.getLogger(ManageUserController.class.getName());
	
	@Autowired
	private IUserService userService;
	
	// End of user code

	
	/**
	 * Description of the method getUserList.
	 * @param userDetailsListVO 
	 */
	// Page render method to show user list page
	
	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	public List<UserDetailsListVO> getUserList(UserDetailsListVO userDetailsListVO) 
			throws NoDataFoundException {
		
		// Start of user code for method getUserList
		logger.debug("Opening Fetching User Details page");
		
    	//to view the User List Details
		List<UserDetailsListVO> userListVOs=userService.selectUserDetailsList();
     	
        return userListVOs;
        // End of user code
	}
	
	/**
	  * 
	  * Description of the method printList.
	  * @param userDetailsListVOs 
	  * @throws IOException 
	  */
	 @SuppressWarnings("deprecation")
	 @RequestMapping(value = "/printList", method = RequestMethod.POST, consumes="application/json", 
	 	produces = "application/pdf")
	 public ResponseEntity<byte[]> printList(@RequestBody List<UserDetailsListVO> userDetailsListVOs,
			 HttpServletRequest request) throws IOException {
		 
		// Start of user code for method printList
		String input = request.getSession().getServletContext()
				.getRealPath("//WEB-INF//reports//UserList.jrxml");
		JasperReport jasperReport1 = null;
		try {
			
			if(userDetailsListVOs.get(0).getSno()!=0){
				UserDetailsListVO userDetailsListVO1=new UserDetailsListVO();
				userDetailsListVOs.add(0,userDetailsListVO1);
			}
			JRDataSource datasource = new JRBeanCollectionDataSource(
					userDetailsListVOs);
			Map<String, Object> parameterMap = new HashMap<String, Object>();
			parameterMap.put("datasource", datasource);
			logger.debug("Generating User List PDF...");
			String path = request
					.getSession()
					.getServletContext()
					.getRealPath( "//WEB-INF//images//aranidhi.png");
			parameterMap.put("logo", path);
			parameterMap.put("users", userDetailsListVOs.size()-1);
			parameterMap.put(JRParameter.IS_IGNORE_PAGINATION,Boolean.FALSE);
			JRExporter exporter = new JRPdfExporter();
			
			jasperReport1 = JasperCompileManager.compileReport(input);
			JasperPrint jasperPrint = JasperFillManager.fillReport(
					jasperReport1, parameterMap, datasource);
			exporter.setParameter(JRPdfExporterParameter.JASPER_PRINT,
					jasperPrint);
			String outputPdf = request.getSession().getServletContext()
					.getRealPath("//WEB-INF//reports//UserList.pdf");
			FileOutputStream output = new FileOutputStream(new File(outputPdf));
			exporter.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, output);
		
			exporter.exportReport();
		
			InputStream file1 = new FileInputStream(new File(outputPdf));
		
			byte[] contents = IOUtils.toByteArray(file1);
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.parseMediaType("application/pdf"));
	        String filename = "User List.pdf";
			headers.setContentDispositionFormData(filename, filename);
	        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
	        output.close();
			output.flush();
			file1.close();
	        return response;
			
		} catch (JRException e) {
			e.printStackTrace();
		}
		return null;
			
		// End of user code
	}
	
	// Start of user code (user defined methods for ManageUserController)
	// Exception handler for User List page
	
	@ExceptionHandler({ NoDataFoundException.class })
	public ExceptionHandlerMessage handleException(Exception ex) {
		logger.error("Exception in Manage User Controller");
		return new ExceptionHandlerMessage(ex.getMessage(),ApplicationConstant.ERROR);

	}
	// End of user code
}
