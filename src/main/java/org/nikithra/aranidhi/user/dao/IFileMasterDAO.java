/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//Start of user code (user defined imports)

//End of user code

/**
 * Description of IUserDetailsDao.
 * 
 * @author NIKITHRA
 */

@Repository
public interface IFileMasterDAO extends JpaRepository<FileMaster,String> {
 
	/**
	 * Description of the method selectImage.
	 * @param ulaId
	 * @param delFlg
	 */
    @Query(value="select * from file_master where ULA_ID= :ulaID and DEL_FLG = :delFlg" ,nativeQuery=true)
    public FileMaster selectImage(@Param("ulaID")String ulaId,@Param("delFlg") String delFlg);
    
    
	// Start of user code (user defined attributes for IFileMasterDao)
	 
	// End of user code

}
