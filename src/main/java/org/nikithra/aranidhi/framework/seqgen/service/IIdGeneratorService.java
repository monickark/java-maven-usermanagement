/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.framework.seqgen.service;

import org.springframework.stereotype.Repository;

//Start of user code (user defined imports)
import org.nikithra.aranidhi.common.exceptions.UpdateFailedException;
//End of user code

/**
 * Description of MakeDonationService.
 * 
 * @author NIKITHRA
 */
@Repository
public interface IIdGeneratorService {
	
	// Start of user code (user defined attributes for IIdGeneratorService)
	/**
	 * Description of the method getNextId.
	 * @param granularity 
	 */
	public Integer getNextId(String key, int granularity)
			throws UpdateFailedException;

}	// End of user code

