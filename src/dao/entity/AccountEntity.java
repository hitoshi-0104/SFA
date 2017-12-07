package dao.entity;

import dao.entity.base.SingleTableBaseEntity;

/**
 * 取引先テーブルエンティティ
 *
 */
public class AccountEntity extends SingleTableBaseEntity {

	/** 取引先名 */
	private String accountName;
	/** 親取引先 */
	private Integer parent;
	/** 取引先番号 */
	private String accountNo;
	/** 取引部門 */
	private String department;
	/** 種別 */
	private String type;
	/** 業種 */
	private String industry;
	/** 年間売上 */
	private Long amount;
	/** 評価 */
	private String evaluation;
	/** 電話 */
	private String phone;
	/** FAX */
	private String fax;
	/** URL */
	private String url;
	/** 証券コード */
	private String stockCode;
	/** 郵便番号 */
	private String postalCode;
	/** 都道府県 */
	private String division;
	/** 市区郡 */
	private String city;
	/** 町名・番地・建物 */
	private String town;
	/** その他 */
	private String note;

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
	 * @return parent
	 */
	public Integer getParent() {
		return parent;
	}
	/**
	 * @param parent セットする parent
	 */
	public void setParent(Integer parent) {
		this.parent = parent;
	}
	/**
	 * @return accountNo
	 */
	public String getAccountNo() {
		return accountNo;
	}
	/**
	 * @param accountNo セットする accountNo
	 */
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
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
	 * @return type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type セットする type
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return industry
	 */
	public String getIndustry() {
		return industry;
	}
	/**
	 * @param industry セットする industry
	 */
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	/**
	 * @return amount
	 */
	public Long getAmount() {
		return amount;
	}
	/**
	 * @param amount セットする amount
	 */
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	/**
	 * @return evaluation
	 */
	public String getEvaluation() {
		return evaluation;
	}
	/**
	 * @param evaluation セットする evaluation
	 */
	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
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
	 * @return url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url セットする url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return stockCode
	 */
	public String getStockCode() {
		return stockCode;
	}
	/**
	 * @param stockCode セットする stockCode
	 */
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	/**
	 * @return postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}
	/**
	 * @param postalCode セットする postalCode
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	/**
	 * @return division
	 */
	public String getDivision() {
		return division;
	}
	/**
	 * @param division セットする division
	 */
	public void setDivision(String division) {
		this.division = division;
	}
	/**
	 * @return city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city セットする city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return town
	 */
	public String getTown() {
		return town;
	}
	/**
	 * @param town セットする town
	 */
	public void setTown(String town) {
		this.town = town;
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
