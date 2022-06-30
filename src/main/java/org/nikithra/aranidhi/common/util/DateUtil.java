/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.common.util;

//Start of user code (user defined imports)

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.nikithra.aranidhi.common.constants.ApplicationConstant;
import org.springframework.stereotype.Component;

//End of user code
/**
 * Description of DateUtil.
 * 
 * @author NIKITHRA
 */
@Component
public class DateUtil {

	// Logging
	// Start of user code (user defined attributes for DateUtil)
	Logger logger = Logger.getLogger(DateUtil.class);
	// End of user code
	
	/**
     * Description of the method getDateFormatByString.
     * @param date
	 * @return
     */
	public Date getDateFormatByString(String date) {
		// Start of user code for method getDateFormatByString
		SimpleDateFormat sdf = new SimpleDateFormat(
				ApplicationConstant.SIMPLE_DATE_FORMAT);
		Date returnDate = null;
		try {
			returnDate = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		logger.debug("current date " + sdf.format(returnDate));
		return returnDate;
		 // End of user code
	}
	
	/**
     * Description of the method getDateFormatInString.
     * @param date
	 * @return
     */
	public String getDateFormatInString(String date) {
		// Start of user code for method getDateFormatInString
		SimpleDateFormat sdf = new SimpleDateFormat(
				ApplicationConstant.SIMPLE_DATE_FORMAT);
		Date returnDate = null;
		try {
			returnDate = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		logger.debug("current date " + sdf.format(returnDate));
		return sdf.format(returnDate);
		// End of user code
	}
	
	// method to get the current date
	/**
	  * Description of the method getDateFormatInString.
	  * @return
	  */
	public String getDateFormatInString(Date date) {
		// Start of user code for method getCurrentDate
		logger.debug("inside getCurrentJavaDate method String");
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				ApplicationConstant.SIMPLE_DATE_FORMAT);
		String date1 = dateFormat.format(date);
		return date1;
			// End of user code
	}

	// method to get the current date with time
	/**
     * Description of the method getCurrentDateWithTime.
	 * @return
     */
	public String getCurrentDateWithTime() {
		// Start of user code for method getCurrentDateWithTime
		logger.debug("inside getCurrentJavaDateTime method String");
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				ApplicationConstant.SIMPLE_DATE_TIME_FORMAT);
		String dateTime = dateFormat.format(calendar.getTime());
		return dateTime;
		// End of user code
	}

	// method to get the current date
	/**
     * Description of the method getCurrentDate.
	 * @return
     */
	public String getCurrentDate() {
		// Start of user code for method getCurrentDate
		logger.debug("inside getCurrentJavaDate method String");
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				ApplicationConstant.SIMPLE_DATE_FORMAT);
		String date = dateFormat.format(calendar.getTime());
		return date;
		// End of user code
	}

	/**
     * Description of the method getCurrentDateInDateDataType.
	 * @return
     */
	public Date getCurrentDateInDateDataType() {
		// Start of user code for method getCurrentDateInDateDataType
		logger.debug("inside getCurrentJavaSqlDate method");

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				ApplicationConstant.SIMPLE_DATE_FORMAT);
		Date today = null;
		try {
			today = dateFormat.parse(dateFormat.format(calendar.getTime()));

		} catch (ParseException e) {

		}
		return today;
		// End of user code
	}

}
