/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.donation.controller;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of UserDonationsSearchVO.
 * 
 * @author NIKITHRA
 */
public class UserDonationsSearchVO {
	/**
	 * Description of the property fromDate.
	 */
	private String fromDate = "";

	/**
	 * Description of the property toDate.
	 */
	private String toDate = "";

	/**
	 * Description of the property dateRange.
	 */
	private String dateRange = "";

	/**
	 * Description of the property userDetail.
	 */
	private String userDetail = "";

	// Start of user code (user defined attributes for UserDonationsSearchVO)

	// End of user code

	/**
	 * The constructor.
	 */
	public UserDonationsSearchVO() {
		// Start of user code constructor for UserDonationsSearchVO)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for UserDonationsSearchVO)

	// End of user code
	/**
	 * Returns fromDate.
	 * @return fromDate 
	 */
	public String getFromDate() {
		return this.fromDate;
	}

	/**
	 * Sets a value to attribute fromDate. 
	 * @param newFromDate 
	 */
	public void setFromDate(String newFromDate) {
		this.fromDate = newFromDate;
	}

	/**
	 * Returns toDate.
	 * @return toDate 
	 */
	public String getToDate() {
		return this.toDate;
	}

	/**
	 * Sets a value to attribute toDate. 
	 * @param newToDate 
	 */
	public void setToDate(String newToDate) {
		this.toDate = newToDate;
	}

	/**
	 * Returns dateRange.
	 * @return dateRange 
	 */
	public String getDateRange() {
		return this.dateRange;
	}

	/**
	 * Sets a value to attribute dateRange. 
	 * @param newDateRange 
	 */
	public void setDateRange(String newDateRange) {
		this.dateRange = newDateRange;
	}

	/**
	 * Returns userDetail.
	 * @return userDetail 
	 */
	public String getUserDetail() {
		return this.userDetail;
	}

	/**
	 * Sets a value to attribute userDetail. 
	 * @param newUserDetail 
	 */
	public void setUserDetail(String newUserDetail) {
		this.userDetail = newUserDetail;
	}

	@Override
	public String toString() {
		return "UserDonationsSearchVO [fromDate=" + fromDate + ", toDate="
				+ toDate + ", dateRange=" + dateRange + ", userDetail="
				+ userDetail + "]";
	}
	
	

}
