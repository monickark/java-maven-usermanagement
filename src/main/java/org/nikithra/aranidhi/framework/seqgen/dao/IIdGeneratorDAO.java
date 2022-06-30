/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.framework.seqgen.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
//Start of user code (user defined imports)

//End of user code

/**
 * Description of MakeDonationService.
 * 
 * @author NIKITHRA
 */
@Repository
public interface IIdGeneratorDAO extends JpaRepository<Sequence, String> {
	// Start of user code (user defined attributes for IIdGeneratorDAO)
	 
	/**
	 * Description of the method getIdForSequence.
	 * @param key 
	 */
	@Query(value = "SELECT NEXT_SEQUENCE_ID FROM sequence WHERE SEQUENCE_TYPE =:key", nativeQuery = true)
	public int getIdForSequence(@Param("key") String key);
	
	
	/**
	 * Description of the method getNextSequence.
	 * @param nextSequence 
	 */
	@Modifying(clearAutomatically=true)
	@Query(value = "UPDATE sequence set NEXT_SEQUENCE_ID=:nextSequence where SEQUENCE_TYPE =:key", nativeQuery = true)
	public int getNextSequence(@Param("nextSequence") Integer nextSequence,
			@Param("key") String key);
	// End of user code


}
