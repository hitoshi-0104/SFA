package dao.entity;

import dao.entity.base.SingleTableBaseEntity;

/**
 * 取引先担当者エンティティ
 *
 */
public class ContactEntity extends SingleTableBaseEntity {

	/** 姓 */
	private String lastName;
	/** 名 */
	private String firstName;
	/** 取引先 */
	private Integer accountId;
	/** 取引先名 */
	private String accountName;
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
	/** 上司名 */
	private String bossName;
	/** その他 */
	private String note;

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
	 * @return accountName
	 */
	public String getAccountName() {
		return accountName;
	}
	/**
	 * @param accountName セットする accountName
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	/**
	 * @return department
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * @param department セットする department
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
	 * @return bossName
	 */
	public String getBossName() {
		return bossName;
	}
	/**
	 * @param bossName セットする bossName
	 */
	public void setBossName(String bossName) {
		this.bossName = bossName;
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
