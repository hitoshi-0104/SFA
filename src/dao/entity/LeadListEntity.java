package dao.entity;

import dao.entity.base.BaseEntity;

/**
 * 見込み客一覧エンティティ
 *
 */
public class LeadListEntity extends BaseEntity {

	/** ID */
	private String id;
	/** 姓 */
	private String lastName;
	/** 名 */
	private String firstName;
	/** 会社名 */
	private String companyName;
	/** ソース */
	private String sourceCode;
	/** ソース名称 */
	private String sourceName;
	/** 状況 */
	private String statusCode;
	/** 状況名称 */
	private String statusName;
	/** 評価 */
	private String estimationCode;
	/** 評価名称 */
	private String estimationName;
	/** 業種 */
	private String industryCode;
	/** 業種名称 */
	private String industryName;
	/** 都道府県 */
	private String divisionCode;
	/** 都道府県名称 */
	private String divisionName;

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
	 * @return sourceName
	 */
	public String getSourceName() {
		return sourceName;
	}
	/**
	 * @param sourceName セットする sourceName
	 */
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	/**
	 * @return statusCode
	 */
	public String getStatusCode() {
		return statusCode;
	}
	/**
	 * @param statusCode セットする statusCode
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	/**
	 * @return statusName
	 */
	public String getStatusName() {
		return statusName;
	}
	/**
	 * @param statusName セットする statusName
	 */
	public void setStatusName(String statusName) {
		this.statusName = statusName;
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
	 * @return estimationName
	 */
	public String getEstimationName() {
		return estimationName;
	}
	/**
	 * @param estimationName セットする estimationName
	 */
	public void setEstimationName(String estimationName) {
		this.estimationName = estimationName;
	}
	/**
	 * @return industryCode
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
	 * @return industryName
	 */
	public String getIndustryName() {
		return industryName;
	}
	/**
	 * @param industryName セットする industryName
	 */
	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}
	/**
	 * @return divisionCode
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
	 * @return divisionName
	 */
	public String getDivisionName() {
		return divisionName;
	}
	/**
	 * @param divisionName セットする divisionName
	 */
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

}
