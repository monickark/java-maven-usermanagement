/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.user.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
//Start of user code (user defined imports)
//End of user code

@Repository
public interface IUserDetailsListDAO extends JpaRepository<UserDetailsList,String> {

    
    /**
	 * Description of the method selectUsersList.
	 * @param delFlg 
	 */
	@Query(value="select u.ula_id, u.city, u.date_of_birth, u.del_flg, u.email_id, u.first_name, u.gender, "
			+ "u.last_name, u.mobile_no, u.address1, u.address2, u.country, u.dbts, u.pincode, u.profile_group, "
			+ "u.r_cre_time, u.r_mod_time, u.remarks, u.state from user_details u"
			+ " where u.DEL_FLG = :delFlg and u.profile_group = :user",nativeQuery=true)
	public List<UserDetailsList> selectUsersList(@Param("delFlg") String delFlg,@Param("user") String user);
	
    // Start of user code (user defined attributes for IUserDetailsListDao)
	// End of user code

}

