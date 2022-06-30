/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.donation.controller;


import org.springframework.stereotype.Component;
// Start of user code (user defined imports)


// End of user code

/**
 * Description of DonateCharityDetailsVO.
 * 
 * @author NIKITHRA
 */
@Component
public class DonateCharityDetailsVO {
	/**
	 * Description of the property charityName.
	 */
	private String charityName = "";

	/**
	 * Description of the property charityId.
	 */
	private String charityId = "";

	/**
	 * Description of the property serviceId.
	 */
	private String serviceId;

	/**
	 * Description of the property serviceName.
	 */
	private String serviceName;

	// Start of user code (user defined attributes for DonateCharityDetailsVO)

	// End of user code

	/**
	 * The constructor.
	 */
	public DonateCharityDetailsVO() {
		// Start of user code constructor for DonateCharityDetailsVO)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for DonateCharityDetailsVO)

	// End of user code
	/**
	 * Returns charityName.
	 * @return charityName 
	 */
	public String getCharityName() {
		return this.charityName;
	}

	/**
	 * Sets a value to attribute charityName. 
	 * @param newCharityName 
	 */
	public void setCharityName(String newCharityName) {
		this.charityName = newCharityName;
	}

	/**
	 * Returns charityId.
	 * @return charityId 
	 */
	public String getCharityId() {
		return this.charityId;
	}

	/**
	 * Sets a value to attribute charityId. 
	 * @param newCharityId 
	 */
	public void setCharityId(String newCharityId) {
		this.charityId = newCharityId;
	}

	/**
	 * Returns serviceId.
	 * @return serviceId 
	 */
	public String getServiceId() {
		return this.serviceId;
	}

	/**
	 * Sets a value to attribute serviceId. 
	 * @param newServiceId 
	 */
	public void setServiceId(String newServiceId) {
		this.serviceId = newServiceId;
	}

	/**
	 * Returns serviceName.
	 * @return serviceName 
	 */
	public String getServiceName() {
		return this.serviceName;
	}

	/**
	 * Sets a value to attribute serviceName. 
	 * @param newServiceName 
	 */
	public void setServiceName(String newServiceName) {
		this.serviceName = newServiceName;
	}

	@Override
	public String toString() {
		return "DonateCharityDetailsVO [charityName=" + charityName
				+ ", charityId=" + charityId + ", serviceId=" + serviceId
				+ ", serviceName=" + serviceName + "]";
	}
	
	

}
