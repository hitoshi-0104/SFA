package dao.entity;

import dao.entity.base.BaseEntity;

/**
 * 取引先担当者ダイアログ一覧用のエンティティクラス
 *
 */
public class ContactListEntity extends BaseEntity {

	/** ID */
	private Integer id;
	/** 取引先担当者名 */
	private String contactName;
	/** 取引先 */
	private String accountName;
	/** メール */
	private String mail;

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
	 * @return contactName
	 */
	public String getContactName() {
		return contactName;
	}
	/**
	 * @param contactName セットする contactName
	 */
	public void setContactName(String contactName) {
		this.contactName = contactName;
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

}
