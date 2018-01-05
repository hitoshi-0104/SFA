package service.contact.dto;

/**
 * ContactDto
 *
 */
public class ContactDto {

	/** 取引先担当者ID */
	private Integer id;
	/** 姓 */
	private String lastName;
	/** 名 */
	private String firstName;
	/** 取引先 */
	private Integer accountId;
	/** 部署 */
	private String department;
	/** 役職 */
	private String position;
	/** 電話 */
	private String phone;
	/** 携帯 */
	private String mobilePhone;
	/** FAX */
	private String fax;
	/** メール */
	private String mail;
	/** 上司 */
	private Integer boss;
	/** その他 */
	private String note;

	/**
	 * @return id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id セットする id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName セットする lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName セットする firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return accountId
	 */
	public Integer getAccountId() {
		return accountId;
	}
	/**
	 * @param accountId セットする accountId
	 */
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	/**
	 * @return division
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * @param division セットする division
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * @return position
	 */
	public String getPosition() {
		return position;
	}
	/**
	 * @param position セットする position
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	/**
	 * @return phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone セットする phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return mobilePhone
	 */
	public String getMobilePhone() {
		return mobilePhone;
	}
	/**
	 * @param mobilePhone セットする mobilePhone
	 */
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	/**
	 * @return fax
	 */
	public String getFax() {
		return fax;
	}
	/**
	 * @param fax セットする fax
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}
	/**
	 * @return mail
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * @param mail セットする mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	/**
	 * @return boss
	 */
	public Integer getBoss() {
		return boss;
	}
	/**
	 * @param boss セットする boss
	 */
	public void setBoss(Integer boss) {
		this.boss = boss;
	}
	/**
	 * @return note
	 */
	public String getNote() {
		return note;
	}
	/**
	 * @param note セットする note
	 */
	public void setNote(String note) {
		this.note = note;
	}

}
