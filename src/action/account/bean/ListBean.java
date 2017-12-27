package action.account.bean;

import action.base.bean.BaseBean;

/**
 * 取引先検索画面のビーンクラス
 *
 */
public class ListBean extends BaseBean {

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
