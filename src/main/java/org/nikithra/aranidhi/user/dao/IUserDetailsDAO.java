/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.user.dao;

import java.util.List;

import org.nikithra.aranidhi.common.exceptions.UpdateFailedException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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
public interface IUserDetailsDAO extends JpaRepository<UserDetails,String> {
	
    // Start of user code (user defined attributes for ILoginDao)
	/**
	 * Description of the method getNextULAID.
	 * @param ulaId 
	 */
    @Query(value="select ULA_ID from user_details order by ULA_ID  desc limit 1" ,nativeQuery=true)
    public String getNextULAID();

    
    /**
	 * Description of the method selectUserDetails.
	 * @param UserDetails 
	 */
    @Query(value="select * from user_details where ULA_ID= :ulaID and DEL_FLG = :delFlg" ,nativeQuery=true)
    public UserDetails selectUserDetails(@Param("ulaID")String ulaId,@Param("delFlg") String delFlg);
    
    
    /**
	 * Description of the method updateProfile.
     * @param string 
     * @return 
	 */
	@Modifying(clearAutomatically=true)
	@Query(value="update user_details l set l.ula_id = :ulaId, l.city = :city, l.date_of_birth = :dateOfBirth, "
			+ "l.email_id = :emailId, l.first_name = :firstName ,l.gender =:gender,"
			+"l.last_name = :lastname, l.mobile_no = :mobileNo ,l.address1 =:address1 ,l.address2 = :address2, "
			+ "l.country = :country ,l.dbts =:dbts ,l.pincode = :pincode, l.profile_group = :profileGroup ,"
			+"l.r_mod_time = :rModTime, l.remarks = :remarks ,l.state =:state  WHERE l.ula_id = :userID or "
			+ "l.email_id = :userID and l.del_flg = :delFlg" ,nativeQuery=true)
	public int updateProfile(@Param("ulaId")String ulaId,@Param("city")String city,@Param("dateOfBirth")String dateOfBirth,
			@Param("emailId")String emailId,@Param("firstName")String firstName,
			@Param("gender")String gender,@Param("lastname")String lastname,@Param("mobileNo")String mobileNo,
			@Param("address1")String address1,@Param("address2")String address2,@Param("country")String country,
			@Param("dbts")Integer dbts,@Param("pincode")String pincode,@Param("profileGroup")String profileGroup,
			@Param("rModTime")String rModTime,@Param("remarks")String remarks,@Param("state")String state,
			@Param("userID")String userId,@Param("delFlg") String delFlg) throws UpdateFailedException ;
    
	
	/**
	 * Description of the method selectUserList.
	 * @param userDonationsKey 
	 */
	@Query(value="select u.ula_id, u.city, u.date_of_birth, u.del_flg, u.email_id, u.first_name, u.gender, "
			+ "u.last_name, u.mobile_no, u.address1, u.address2, u.country, u.dbts, u.pincode, u.profile_group, "
			+ "u.r_cre_time, u.r_mod_time, u.remarks, u.state from user_details u"
			+ " where u.first_name like %:userDetail% or u.ula_id like %:userDetail% and u.DEL_FLG = :delFlg",nativeQuery=true)
	public List<UserDetails> selectUserList(@Param("userDetail")String userDetail,@Param("delFlg") String delFlg);
    
	
 	/**
	 * Description of the method existEmailId.
	 * @param CharityProfile 
	 */
    @Query(value="select email_id from user_details where email_id= :emailId and del_flg = :delFlg" ,nativeQuery=true)
    public String existEmailId(@Param("emailId")String emailId,@Param("delFlg") String delFlg);

    /**
	 * Description of the method existEmailId.
	 * @param CharityProfile 
	 */
    @Query(value="select mobile_no from user_details where mobile_no= :contactNo and del_flg = :delFlg" ,nativeQuery=true)
    public String existContactNo(@Param("contactNo")String contactNo,@Param("delFlg") String delFlg);
    
	// End of user code


}
