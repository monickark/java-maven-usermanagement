/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.donation.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.*;

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
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
// Start of user code (user defined imports)
import org.nikithra.aranidhi.common.constants.ApplicationConstant;
import org.nikithra.aranidhi.common.constants.ErrorCodeConstant;
import org.nikithra.aranidhi.common.exceptions.NoDataFoundException;
import org.nikithra.aranidhi.common.exceptions.UpdateFailedException;
import org.nikithra.aranidhi.common.util.ExceptionHandlerMessage;
import org.nikithra.aranidhi.donation.controller.ReceiptMasterVO;
import org.nikithra.aranidhi.donation.service.IUserDonationsService;
import org.nikithra.aranidhi.user.controller.UserDetailsVO;
// End of user code

/**
 * Description of ReceiptController.
 * 
 * @author NIKITHRA
 */
@RestController
@CrossOrigin(origins = {ApplicationConstant.CROSS_ORIGIN, ApplicationConstant.CROSS_ORIGIN1})
@RestControllerAdvice

public class MakeDonationController {
	// Start of user code (user defined attributes for ReceiptController)
	//logger
	Logger logger = Logger.getLogger(MakeDonationController.class);

	@Autowired
	private IUserDonationsService userDonationService;
	
	// End of user code


	/**
	 * Description of the method makeDonationGet.
	 * @return 
	 */
	//To Get a all Services
	@RequestMapping(value = "/getServiceName/", method = RequestMethod.GET)
	public Map<String, String> getAllServices() {
		// Start of user code for method makeDonationGet
		logger.debug("Getting all Services to Make Donation");
		
		//To get a Service Name
		Map<String, String> serviceList = userDonationService
				.getAllServicesMap();
		return serviceList;
		// End of user code
	}

	/**
	 * Description of the method makeDonationPost.
	 * @param donationDetailsVO
	 * @param donateCharityDetailsVO
	 * @throws UpdateFailedException 
	 */
	//To Show the Donation Details
	@RequestMapping(value = "/makeDonation/", method = RequestMethod.POST)
	public DonationDetailsVO makeDonationPost(DonationDetailsVO donationDetailsVO,
			DonateCharityDetailsVO donateCharityDetailsVO) 
					throws UpdateFailedException{		
		// Start of user code for method makeDonationPost
		logger.debug(" Process the Donation");		
		donationDetailsVO=userDonationService.makeDonation(donationDetailsVO,donateCharityDetailsVO);
		logger.debug(ErrorCodeConstant.DONATION_ACCEPTED);
		return donationDetailsVO;
		// End of user code
	}


	/**
	 * Description of the method getReceiptDetails.
	 * @param donationDetailsVO
	 * @param donateCharityDetailsVO
	 * @throws NoDataFoundException
	 * @throws ParseException 
	 */
	// To Show the Receipt Details
	@RequestMapping(value = "/viewReceipt/", method = RequestMethod.POST)
	public ReceiptMasterVO getReceiptDetails(DonationDetailsVO donationDetailsVO,
			DonateCharityDetailsVO donateCharityDetailsVO) throws NoDataFoundException, ParseException {
		CharityDetailsVO charityDetailsVO=new CharityDetailsVO();
		// Start of user code for method getReceiptDetails
		//User Can  view the Receipt Details
		UserDetailsVO userDetailsVO=userDonationService.selectUserDetails(donationDetailsVO.getUlaId());
		
		//receiptMasterVO sets a value to attribute DoantionMasterVO,userDetailsVo,donationDetailsVO,charityDetailsVO
		ReceiptMasterVO receiptMasterVO=new ReceiptMasterVO();
		receiptMasterVO.setUserDetailsVO(userDetailsVO);
		Map<String, String> serviceList =getAllServices();
		String serviceName=serviceList.get(donateCharityDetailsVO.getServiceId());
		donateCharityDetailsVO.setServiceName(serviceName);
		DonationMasterVO donationMasterVO=new DonationMasterVO();
		donationMasterVO.setDonateCharityDetailsVO(donateCharityDetailsVO);
		receiptMasterVO.setDonationMasterVO(donationMasterVO);
		receiptMasterVO.setCharityDetailsVO(charityDetailsVO);
		return receiptMasterVO;

		// End of user code
	}
	
	/**
	 * Description of the method printReceipt.
	 * @param receiptMasterVO 
	 * @throws IOException 
	 */
	//To Get a all Services
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/printReceipt", method = RequestMethod.POST, consumes="application/json", 
		produces = "application/pdf")
	public ResponseEntity<byte[]> printReceipt(@RequestBody ReceiptMasterVO receiptMasterVO,
				HttpServletRequest request) throws IOException {
		
		 // Start of user code for method printReceipt		
		 String input = request.getSession().getServletContext()
					.getRealPath("//WEB-INF//reports//Receipt.jrxml");
		JasperReport jasperReport1 = null;
		try {
			Map<String, Object> parameterMap = new HashMap<String, Object>();
			parameterMap.put("charityName", receiptMasterVO.getCharityDetailsVO().getCharityName());
			parameterMap.put("charityAddress1", receiptMasterVO.getCharityDetailsVO().getAddress1());
			parameterMap.put("charityAddress2", receiptMasterVO.getCharityDetailsVO().getAddress2());
			parameterMap.put("charityState", receiptMasterVO.getCharityDetailsVO().getState());
			parameterMap.put("charityCity", receiptMasterVO.getCharityDetailsVO().getCity());
			parameterMap.put("charityCountry", receiptMasterVO.getCharityDetailsVO().getCountry());
			parameterMap.put("charityPincode", receiptMasterVO.getCharityDetailsVO().getPincode());
			parameterMap.put("charityEmailId", receiptMasterVO.getCharityDetailsVO().getEmailId());
			parameterMap.put("charityMobileNo", receiptMasterVO.getCharityDetailsVO().getMobileNo());
			parameterMap.put("name", receiptMasterVO.getUserDetailsVO().getFirstName());
			parameterMap.put("address1", receiptMasterVO.getUserDetailsVO().getAddress1());
			parameterMap.put("address2", receiptMasterVO.getUserDetailsVO().getAddress2());
			parameterMap.put("state", receiptMasterVO.getUserDetailsVO().getState());
			parameterMap.put("city", receiptMasterVO.getUserDetailsVO().getCity());
			parameterMap.put("country", receiptMasterVO.getUserDetailsVO().getCountry());
			parameterMap.put("pincode", receiptMasterVO.getUserDetailsVO().getPincode());
			parameterMap.put("emailId", receiptMasterVO.getUserDetailsVO().getEmailId());
			parameterMap.put("mobileNo", receiptMasterVO.getUserDetailsVO().getMobileNo());
			parameterMap.put("billNo", receiptMasterVO.getDonationMasterVO().getDonationDetailsVO().getBillNo());
			parameterMap.put("date", receiptMasterVO.getDonationMasterVO().getDonationDetailsVO().getPaymentDate());
			parameterMap.put("accountType", receiptMasterVO.getDonationMasterVO().getDonationDetailsVO().getAccountType());
			parameterMap.put("amtDonated", receiptMasterVO.getDonationMasterVO().getDonationDetailsVO().getDonationAmt());
			parameterMap.put("serviceName", receiptMasterVO.getDonationMasterVO() .getDonateCharityDetailsVO().getServiceName());
			String path = request
					.getSession()
					.getServletContext()
					.getRealPath( "//WEB-INF//images//aranidhi.png");
			parameterMap.put("logo", path);
			logger.debug("Generating Receipt PDF...");
			JRExporter exporter = new JRPdfExporter();
			jasperReport1 = JasperCompileManager.compileReport(input);
			JasperPrint jasperPrint = JasperFillManager.fillReport(
					jasperReport1, parameterMap,new JREmptyDataSource());
			exporter.setParameter(JRPdfExporterParameter.JASPER_PRINT,
					jasperPrint);
			String outputPdf = request.getSession().getServletContext()
					.getRealPath("//WEB-INF//reports//Receipt.pdf");
			FileOutputStream output = new FileOutputStream(new File(outputPdf));
			exporter.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, output);
		
			exporter.exportReport();
		
			InputStream file1 = new FileInputStream(new File(outputPdf));
		
			byte[] contents = IOUtils.toByteArray(file1);
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.parseMediaType("application/pdf"));
	        String filename = "Receipt.pdf";
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

	// Start of user code (user defined methods for ReceiptController)
	// Exception handler for User List page
	
	@ExceptionHandler({ NoDataFoundException.class,UpdateFailedException.class })
	public ExceptionHandlerMessage handleException(Exception ex) {
		logger.error("Exception in Make Donation Controller");
		logger.error(ErrorCodeConstant.DONATION_FAILED);
		return new ExceptionHandlerMessage(ex.getMessage(),ApplicationConstant.ERROR);
	}
	// End of user code

}
