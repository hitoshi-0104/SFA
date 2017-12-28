package action.account.bean;

import java.util.Map;

import action.base.bean.BaseBean;

public class UpdateBean extends BaseBean {

	/** 取引先ID */
	private Integer id;
	/** 取引先名 */
	private String accountName;
	/** 親取引先ID */
	private Integer parentId;
	/** 親取引先 */
	private String parent;
	/** 取引先番号 */
	private String accountNo;
	/** 取引先部門 */
	private String department;
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
	/** 従業員数 */
	private Integer employee;
	/** 証券コード */
	private String stockCode;
	/** 郵便番号 */
	private String postalCode;
	/** 都道府県 */
	private String division;
	/** 市区郡 */
	private String city;
	/** 町名・番地・建物名 */
	private String town;
	/** その他 */
	private String note;

	/** 評価リスト */
	private Map<String, String> estimationMap;
	/** 業種リスト */
	private Map<String, String> industryMap;
	/** 都道府県リスト */
	private Map<String, String> divisionMap;

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
	 * @return parentId
	 */
	public Integer getParentId() {
		return parentId;
	}
	/**
	 * @param parentId セットする parentId
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	/**
	 * @return parent
	 */
	public String getParent() {
		return parent;
	}
	/**
	 * @param parent セットする parent
	 */
	public void setParent(String parent) {
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
	 * @return employee
	 */
	public Integer getEmployee() {
		return employee;
	}
	/**
	 * @param employee セットする employee
	 */
	public void setEmployee(Integer employee) {
		this.employee = employee;
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
	/**
	 * @return estimationMap
	 */
	public Map<String, String> getEstimationMap() {
		return estimationMap;
	}
	/**
	 * @param estimationMap セットする estimationMap
	 */
	public void setEstimationMap(Map<String, String> estimationMap) {
		this.estimationMap = estimationMap;
	}
	/**
	 * @return industryMap
	 */
	public Map<String, String> getIndustryMap() {
		return industryMap;
	}
	/**
	 * @param industryMap セットする industryMap
	 */
	public void setIndustryMap(Map<String, String> industryMap) {
		this.industryMap = industryMap;
	}
	/**
	 * @return divisionMap
	 */
	public Map<String, String> getDivisionMap() {
		return divisionMap;
	}
	/**
	 * @param divisionMap セットする divisionMap
	 */
	public void setDivisionMap(Map<String, String> divisionMap) {
		this.divisionMap = divisionMap;
	}

}
