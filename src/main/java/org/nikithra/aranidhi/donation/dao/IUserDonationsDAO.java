/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.donation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
// Start of user code (user defined imports)


// End of user code

/**
 * Description of IUserDonationsDAO.
 * 
 * @author NIKITHRA
 */
@Repository
public interface IUserDonationsDAO extends JpaRepository<UserDonationsList, String> {
	// Start of user code (user defined attributes for IUserDonationsDAO)
	/**
	 * Description of the method selectUserDonationsList.
	 * @param userDonationsKey 
	 */
	@Query(value="select d.donation_id, d.account_type, d.bill_no, d.charity_id, d.dbts, d.del_flg, d.donation_amt, "
			+ "d.payment_date, d.payment_desc, d.payment_mode, d.r_cre_id, d.r_cre_time, d.r_mod_id, d.r_mod_time, "
			+ "d.service_id, d.ula_id, d.email_id from donation_details d left join user_details u on d.email_id= u.email_id "
			+ " where u.ula_id = :userDetail or u.first_name = :userDetail or d.PAYMENT_DATE BETWEEN :startDate and :endDate and d.DEL_FLG = :delFlg",nativeQuery=true)
	public List<UserDonationsList> selectUserDonationsList(@Param("startDate")String startDate,@Param("endDate")String endDate,
			@Param("userDetail")String userDetail,@Param("delFlg") String delFlg);

	
	/**
	 * Description of the method selectUserDonationsUserList.
	 * @param userDonationsKey 
	 */
	@Query(value="select d.donation_id, d.account_type, d.bill_no, d.charity_id, d.dbts, d.del_flg, d.donation_amt, "
			+ "d.payment_date, d.payment_desc, d.payment_mode, d.r_cre_id, d.r_cre_time, d.r_mod_id, d.r_mod_time, "
			+ "d.service_id, d.ula_id, d.email_id from donation_details d left join user_details u on d.email_id= u.email_id "
			+ " where u.ula_id = :userDetail and d.PAYMENT_DATE BETWEEN :startDate and :endDate and d.DEL_FLG = :delFlg",nativeQuery=true)
	public List<UserDonationsList> selectUserDonationsUserList(@Param("startDate")String startDate,@Param("endDate")String endDate,
			@Param("userDetail")String userDetail,@Param("delFlg") String delFlg);

	// End of user code

}
