package org.nikithra.aranidhi.donation.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
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
import org.nikithra.aranidhi.common.constants.ApplicationConstant;
import org.nikithra.aranidhi.common.exceptions.NoDataFoundException;
import org.nikithra.aranidhi.common.util.ExceptionHandlerMessage;
import org.nikithra.aranidhi.donation.service.IUserDonationsService;
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

//Start of user code (user defined imports)
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//End of user code

/**
* Description of UserDonationsUserController.
* 
* @author NIKITHRA
*/
@RestController
@CrossOrigin(origins = {ApplicationConstant.CROSS_ORIGIN, ApplicationConstant.CROSS_ORIGIN1})
@RestControllerAdvice

public class UserDonationsUserController {
	// Start of user code (user defined attributes for UserDonationsController)
	Logger logger = Logger.getLogger(UserDonationsUserController.class);

	@Autowired
	private IUserDonationsService userDonationsService;
	
	// End of user code

	/**
	 * Description of the method userDonationsUserGet.
	 * @param userDonationsSearchVO
	 * @return 
	 * @throws ParseException 
	 * @throws NoDataFoundException 
	 */
	// To generate the Report
	@RequestMapping(value = "/viewUserReport/", method = RequestMethod.POST)
    public List<UserDonationsListVO> userDonationsUserGet(UserDonationsSearchVO userDonationsSearchVO) 
			 throws ParseException, NoDataFoundException {
	
		// Start of user code for method userDonationsUserGet
		//user can view the Report
		List<UserDonationsListVO> userDonationListVOs=userDonationsService.
				selectUserDonationsUserList(userDonationsSearchVO);
		return userDonationListVOs;
		// End of user code
	}

	 /**
	  * 
	  * Description of the method printUserReport.
	  * @param userDonationsMasterVO 
	  * @throws IOException 
	  * @throws NoDataFoundException 
	  * @throws ParseException 
	  */
	//To print the Report
	 @SuppressWarnings("deprecation")
	 @RequestMapping(value = "/printUserReport/", method = RequestMethod.POST, consumes="application/json", 
			 	produces = "application/pdf")
	 public ResponseEntity<byte[]> printUserReport(@RequestBody List<UserDonationsListVO> userDonationListVOs,
			 HttpServletRequest request) throws IOException, ParseException, NoDataFoundException {
		
		 // Start of user code for method printUserReport
		String input = request.getSession().getServletContext()
				.getRealPath("//WEB-INF//reports//ReportsUser.jrxml");
		
		JasperReport jasperReport1 = null;
		try {
			if(userDonationListVOs.get(0).getSno()!=0){
				UserDonationsListVO userDonationsListVO=new UserDonationsListVO();
				userDonationListVOs.add(0,userDonationsListVO);
			}
			JRDataSource datasource = new JRBeanCollectionDataSource(
					userDonationListVOs);
			int amt=0;
			for (UserDonationsListVO userDonationsListVO : userDonationListVOs) {
				int i = userDonationListVOs.indexOf(userDonationsListVO);
				if(i!=0){
				userDonationsListVO=userDonationListVOs.get(i);
				int singleamt=Integer.parseInt(userDonationsListVO.getDonationAmt());
				amt=amt+singleamt;
				}
			}
			Map<String, Object> parameterMap = new HashMap<String, Object>();
			parameterMap.put("datasource", datasource);
			logger.debug("Generating Donation Report PDF...");
			String path = request
					.getSession()
					.getServletContext()
					.getRealPath( "//WEB-INF//images//aranidhi.png");
			parameterMap.put("logo", path);
			parameterMap.put(JRParameter.IS_IGNORE_PAGINATION,Boolean.FALSE);
			parameterMap.put("donationAmt", amt);
			JRExporter exporter = new JRPdfExporter();
			
			jasperReport1 = JasperCompileManager.compileReport(input);
			JasperPrint jasperPrint = JasperFillManager.fillReport(
					jasperReport1, parameterMap, datasource);
			exporter.setParameter(JRPdfExporterParameter.JASPER_PRINT,
					jasperPrint);
			String outputPdf = request.getSession().getServletContext()
					.getRealPath("//WEB-INF//reports//ReportsUser.pdf");
			FileOutputStream output = new FileOutputStream(new File(outputPdf));
			exporter.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, output);
		
			exporter.exportReport();
		
			InputStream file1 = new FileInputStream(new File(outputPdf));
		
			byte[] contents = IOUtils.toByteArray(file1);
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.parseMediaType("application/pdf"));
	        String filename = "Donation Details.pdf";
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

	// Start of user code (user defined methods for UserDonationsController)
	// Exception handler for User List page
	@ExceptionHandler({ NoDataFoundException.class })
	public ExceptionHandlerMessage handleException(Exception ex) {
		logger.error("Exception in User Donations for User Controller");
		return new ExceptionHandlerMessage(ex.getMessage(),ApplicationConstant.ERROR);
	}
	// End of user code
}
