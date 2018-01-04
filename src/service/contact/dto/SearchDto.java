package service.contact.dto;

/**
 * 検索DTO
 *
 */
public class SearchDto {

	/** 姓 */
	private String lastName;
	/** 名 */
	private String firstName;
	/** 取引先 */
	private Integer accountId;
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
