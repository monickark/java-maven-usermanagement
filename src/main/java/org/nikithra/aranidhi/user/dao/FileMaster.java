/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package org.nikithra.aranidhi.user.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of FileMaster.
 * 
 * @author NIKITHRA
 */
@Entity
@Table(name = "file_master")
public class FileMaster {

	/**
	 * Description of the property ulaId.
	 */
	@Id
	@Column(nullable=false,length=8)
	private String ulaId = "";
	
	/**
	 * Description of the property dbts.
	 */
	private Integer dbts;
	
	/**
	 * Description of the property data.
	 */
	@Column(columnDefinition = "LONGBLOB")
	private byte[] file;
	
	/**
	 * Description of the property fileName.
	 */
	@Column(length = 45)
	private String fileName;
	
	/**
	 * Description of the property contentType.
	 */
	@Column(length = 45)
	private String contentType;
	
	/**
	 * Description of the property fileSize.
	 */
	private Long fileSize;
	
	/**
	 * Description of the property delFlg.
	 */
	@Column(length = 1)
	private String delFlg = "";

	/**
	 * Description of the property rCreTime.
	 */
	private String rCreTime = "";

	/**
	 * Description of the property rModTime.
	 */
	private String rModTime = "";

	/**
	 * Description of the property rCreId.
	 */
	@Column(length = 8)
	private String rCreId = "";

	/**
	 * Description of the property rModId.
	 */
	@Column(length = 8)
	private String rModId = "";
	
	/**
	 * Description of the property userDonations.
	 */
	/*@OneToMany(mappedBy = "fileMaster",fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@BatchSize(size=2)
    private List<UserDonationsList> userDonations = new ArrayList<>();*/
	// Start of user code (user defined attributes for UserDetails)

	// End of user code

	/**
	 * The constructor.
	 */
	public FileMaster() {
		// Start of user code constructor for UserDetails)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for UserDetails)

	// End of user code

	/**
	 * Returns ulaId.
	 * 
	 * @return ulaId
	 */
	public String getUlaId() {
		return this.ulaId;
	}

	/**
	 * Sets a value to attribute ulaId.
	 * 
	 * @param newUlaId
	 */
	public void setUlaId(String newUlaId) {
		this.ulaId = newUlaId;
	}

	/**
	 * Returns fileName.
	 * 
	 * @return fileName
	 */
	public String getFileName() {
		return this.fileName;
	}

	/**
	 * Sets a value to attribute fileName.
	 * 
	 * @param newFileName
	 */
	public void setFileName(String newFileName) {
		this.fileName = newFileName;
	}

	/**
	 * Returns file.
	 * 
	 * @return file
	 */
	public byte[] getFile() {
		return this.file;
	}

	/**
	 * Sets a value to attribute file.
	 * 
	 * @param newFile
	 */
	public void setFile(byte[] newFile) {
		this.file = newFile;
	}

	/**
	 * Returns fileSize.
	 * 
	 * @return fileSize
	 */
	public Long getFileSize() {
		return this.fileSize;
	}

	/**
	 * Sets a value to attribute fileSize.
	 * 
	 * @param newFileSize
	 */
	public void setFileSize(Long newFileSize) {
		this.fileSize = newFileSize;
	}

	/**
	 * Returns dbts.
	 * @return dbts 
	 */
	public Integer getDbts() {
		return this.dbts;
	}

	/**
	 * Sets a value to attribute dbts.
	 *  
	 * @param newDbts 
	 */
	public void setDbts(Integer newDbts) {
		this.dbts = newDbts;
	}

	/**
	 * Returns contentType.
	 * 
	 * @return contentType
	 */
	public String getContentType() {
		return this.contentType;
	}

	/**
	 * Sets a value to attribute contentType.
	 *  
	 * @param newContentType 
	 */
	public void setContentType(String newContentType) {
		this.contentType = newContentType;
	}

	/**
	 * Returns delFlg.
	 * 
	 * @return delFlg 
	 */
	public String getDelFlg() {
		return this.delFlg;
	}

	/**
	 * Sets a value to attribute delFlg.
	 *  
	 * @param newDelFlg 
	 */
	public void setDelFlg(String newDelFlg) {
		this.delFlg = newDelFlg;
	}

	/**
	 * Returns rCreTime.
	 * 
	 * @return rCreTime 
	 */
	public String getRCreTime() {
		return this.rCreTime;
	}

	/**
	 * Sets a value to attribute rCreTime.
	 *  
	 * @param newRCreTime 
	 */
	public void setRCreTime(String newRCreTime) {
		this.rCreTime = newRCreTime;
	}

	/**
	 * Returns rModTime.
	 * 
	 * @return rModTime 
	 */
	public String getRModTime() {
		return this.rModTime;
	}

	/**
	 * Sets a value to attribute rModTime.
	 *  
	 * @param newRModTime 
	 */
	public void setRModTime(String newRModTime) {
		this.rModTime = newRModTime;
	}
	
	/**
	 * Returns rCreId.
	 * @return rCreId 
	 */
	public String getRCreId() {
		return this.rCreId;
	}
	
	/**
	 * Sets a value to attribute rCreId. 
	 * @param newRCreId 
	 */
	public void setRCreId(String newRCreId) {
		this.rCreId = newRCreId;
	}

	/**
	 * Returns rModId.
	 * @return rModId 
	 */
	public String getRModId() {
		return this.rModId;
	}

	/**
	 * Sets a value to attribute rModId. 
	 * @param newRModId 
	 */
	public void setRModId(String newRModId) {
		this.rModId = newRModId;
	}
	
	/**
	 * Returns userDonations.
	 * @return userDonations
	 */
	/*public List<UserDonationsList> getUserDonations() {
		return userDonations;
	}*/

	/**
	 * Sets a value to attribute newUserDonations. 
	 * @param newUserDonations 
	 */
	/*public void setUserDonations(List<UserDonationsList> newUserDonations) {
		this.userDonations = newUserDonations;
	}*/
	
}
