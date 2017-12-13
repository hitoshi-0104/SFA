package service.account.dto;

/**
 * 検索DTO
 *
 */
public class SearchDto {

	/** 取引先名 */
	private String accountName;

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


}
