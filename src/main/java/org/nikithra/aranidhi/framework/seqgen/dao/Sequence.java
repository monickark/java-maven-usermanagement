/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.framework.seqgen.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of DonationDetails.
 * 
 * @author NIKITHRA
 */
@Entity
@Table(name="sequence")
public class Sequence {
	/**
	 * Description of the property nextSequenceId.
	 */
	private Integer nextSequenceId ;

	/**
	 * Description of the property sequenceType.
	 */
	@Id
	@Column(length = 20)
	private String sequenceType;
	/**
	 * Returns sequenceType.
	 * @return sequenceType 
	 */

	public String getSequenceType() {
		return sequenceType;
	}


	/**
	 * Sets a value to attribute sequenceType. 
	 * @param newSequenceType 
	 */
	public void setSequenceType(String sequenceType) {
		this.sequenceType = sequenceType;
	}

	/**
	 * Returns NextSequenceId.
	 * @return NextSequenceId. 
	 */
	public Integer getNextSequenceId() {
		return nextSequenceId;
	}

	/**
	 * Sets a value to attribute NextSequenceId. 
	 * @param newNextSequenceId 
	 */
	public void setNextSequenceId(Integer nextSequenceId) {
		this.nextSequenceId = nextSequenceId;
	}

}
