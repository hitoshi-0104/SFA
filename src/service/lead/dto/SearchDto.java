package service.lead.dto;

public class SearchDto {

	/** 姓 */
	private String lastName;
	/** 名 */
	private String firstName;
	/** 会社名 */
	private String companyName;
	/** ソース */
	private String sourceCode;
	/** 状況 */
	private String statusCode;
	/** 評価 */
	private String estimationCode;
	/** 業種 */
	private String industryCode;
	/** 都道府県 */
	private String divisionCode;
	/** ページ */
	private Integer page;

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
	 * @return page
	 */
	public Integer getPage() {
		return page;
	}
	/**
	 * @param page セットする page
	 */
	public void setPage(Integer page) {
		this.page = page;
	}

}
