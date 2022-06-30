/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.framework.seqgen.service;

//Start of user code (user defined imports)

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.nikithra.aranidhi.common.exceptions.UpdateFailedException;
import org.nikithra.aranidhi.framework.seqgen.dao.IIdGeneratorDAO;

//End of user code

/**
 * Description of MakeDonationService.
 * 
 * @author NIKITHRA
 */
@Service
@Transactional
public class SimpleIdGeneratorService implements
		IIdGeneratorService {

	// Logging
	Logger logger = Logger.getLogger(SimpleIdGeneratorService.class);
	// Start of user code (user defined attributes for SimpleIdGeneratorService)
	@Autowired
	IIdGeneratorDAO simpleIdGenDAO;
	// End of user code

	private static Object acquireLockForIDGeneration = new Object();
	Integer currentSeqValue = 0;
	
	/**
	 * Description of the method getNextId.
	 * @param granularity 
	 * @throws UpdateFailedException
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Integer getNextId(String key, int granularity)
			throws UpdateFailedException {
		synchronized (acquireLockForIDGeneration) {
			// Start of user code for method getNextId
			// sequence id generation is kept outside the originating transaction scope.
			for (int count = 1; count <= granularity; count++) {
				currentSeqValue = simpleIdGenDAO.getIdForSequence(key);
				int sequence=currentSeqValue+1;
				simpleIdGenDAO.getNextSequence(sequence, key);
			}
		}
		return currentSeqValue - (granularity - 1);
		// End of user code

	}

}
