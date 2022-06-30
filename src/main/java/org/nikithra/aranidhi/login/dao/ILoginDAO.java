/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.login.dao;


//Start of user code (user defined imports)

import org.nikithra.aranidhi.common.exceptions.UpdateFailedException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//End of user code

/**
 * Description of IUserDetailsDAO.
 * 
 * @author NIKITHRA
 */
public interface ILoginDAO extends JpaRepository<Login,String> {
	
	// Start of user code (user defined attributes for ILoginDao)
	/**
	 * Description of the method getUserLogin.
	 * @param Login 
	 */
	@Query(value="select * from login  where USER_ID=:userId or EMAIL_ID=:userId or MOBILE_NO=:userId and DEL_FLG = :delFlg" ,nativeQuery=true)
	public Login validateUserId(@Param("userId")String userId,@Param("delFlg") String delFlg);

	/**
	 * Description of the method updateLogin.
	 * @return 
	 */
	@Modifying(clearAutomatically=true)
	@Query(value="update login l set l.DBTS = :dbts, l.PASSWORD = :password, l.LAST_LOGIN_TIME = :lastLoginTime, l.IP_ADDRESS = :IpAddress,"
			+"l.LAST_LOGOUT_TIME = :lastLogoutTime, l.TOTAL_NO_OF_LOGIN = :totalNoOfLogin ,l.R_MOD_TIME = :rModTime"
			+" WHERE l.USER_ID = :userID or l.EMAIL_ID = :userID or MOBILE_NO=:mobileNo  and l.DEL_FLG = :delFlg" ,nativeQuery=true)
	public int updateLogin(@Param("dbts")int dbts,@Param("password")String password,@Param("lastLoginTime")String lastLoginTime,
			@Param("IpAddress")String ipAddress,@Param("lastLogoutTime")String lastLogoutTime,@Param("totalNoOfLogin")String totalNoOfLogin,
			@Param("rModTime")String rModTime,@Param("userID")String userId,@Param("delFlg") String delFlg,@Param("mobileNo")String mobilleNo)
					throws UpdateFailedException ;	
	// End of user code
	
}
