package action.lead.bean;

import java.util.Map;

import action.base.bean.BaseBean;

/**
 * 見込み客のBeanクラス
 *
 */
public class CreateBean extends BaseBean {

	/** ID */
	private String id;
	/** 姓 */
	private String lastName;
	/** 名 */
	private String firstName;
	/** 会社名 */
	private String companyName;
	/** 役職名 */
	private String position;
	/** ソース */
	private String sourceCode;
	/** 状況 */
	private String statusCode;
	/** 評価 */
	private String estimationCode;
	/** 電話 */
	private String phone;
	/** 携帯 */
	private String mobilePhone;
	/** FAX */
	private String fax;
	/** メール */
	private String mailAddress;
	/** URL */
	private String url;
	/** 業種 */
	private String industryCode;
	/** 売上 */
	private Long amount;
	/** 従業員数 */
	private Integer employees;
	/** 郵便番号 */
	private String postalCode;
	/** 都道府県 */
	private String divisionCode;
	/** 市区郡 */
	private String city;
	/** 町名・番地・建物 */
	private String town;
	/** その他 */
	private String note;

	/** ソースリスト */
	private Map<String, String> sourceMap;
	/** 状況リスト */
	private Map<String, String> statusMap;
	/** 評価リスト */
	private Map<String, String> estimationMap;
	/** 業種リスト */
	private Map<String, String> industryMap;
	/** 都道府県リスト */
	private Map<String, String> divisionMap;

	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id セットする id
	 */
	public void setId(String id) {
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
	 * @return companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName セットする companyName
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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
	 * @return sourceCode
	 */
	public String getSourceCode() {
		return sourceCode;
	}
	/**
	 * @param sourceCode セットする sourceCode
	 */
	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}
	/**
	 * @return stateCode
	 */
	public String getStatusCode() {
		return statusCode;
	}
	/**
	 * @param stateCode セットする stateCode
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	/**
	 * @return estimationCode
	 */
	public String getEstimationCode() {
		return estimationCode;
	}
	/**
	 * @param estimationCode セットする estimationCode
	 */
	public void setEstimationCode(String estimationCode) {
		this.estimationCode = estimationCode;
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
	 * @return mailAddress
	 */
	public String getMailAddress() {
		return mailAddress;
	}
	/**
	 * @param mailAddress セットする mailAddress
	 */
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
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
	 * @return industry
	 */
	public String getIndustryCode() {
		return industryCode;
	}
	/**
	 * @param industryCode セットする industryCode
	 */
	public void setIndustryCode(String industryCode) {
		this.industryCode = industryCode;
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
	 * @return employees
	 */
	public Integer getEmployees() {
		return employees;
	}
	/**
	 * @param employees セットする employees
	 */
	public void setEmployees(Integer employees) {
		this.employees = employees;
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
	public String getDivisionCode() {
		return divisionCode;
	}
	/**
	 * @param divisionCode セットする divisionCode
	 */
	public void setDivisionCode(String divisionCode) {
		this.divisionCode = divisionCode;
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
	 * @return sourceMap
	 */
	public Map<String, String> getSourceMap() {
		return sourceMap;
	}
	/**
	 * @param sourceMap セットする sourceMap
	 */
	public void setSourceMap(Map<String, String> sourceMap) {
		this.sourceMap = sourceMap;
	}
	/**
	 * @return statusMap
	 */
	public Map<String, String> getStatusMap() {
		return statusMap;
	}
	/**
	 * @param statusMap セットする statusMap
	 */
	public void setStatusMap(Map<String, String> statusMap) {
		this.statusMap = statusMap;
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
