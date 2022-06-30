/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.donation.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//Start of user code (user defined imports)


//End of user code

/**
 * Description of IUserDetailsDAO.
 * 
 * @author NIKITHRA
 */
@Repository
public interface IMakeDonationDAO extends JpaRepository<DonationDetails,String> {
	
	// Start of user code (user defined attributes for ILoginDao)
	
	// End of user code
	
}
