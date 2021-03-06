package service.account.dto;

/**
 * 検索DTO
 *
 */
public class SearchDto {

	/** 取引先名 */
	private String accountName;
	/** ページ */
	private Integer page;

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
