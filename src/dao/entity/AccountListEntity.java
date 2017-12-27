package dao.entity;

import dao.entity.base.BaseEntity;

/**
 * 取引先ダイアログ一覧用のエンティティクラス
 *
 */
public class AccountListEntity extends BaseEntity {

	/** ID */
	private Integer id;
	/** 取引先名 */
	private String accountName;
	/** 電話 */
	private String phone;
	/** 住所 */
	private String address;

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
	 * @return address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address セットする address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

}
