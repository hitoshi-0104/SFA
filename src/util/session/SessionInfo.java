package util.session;

/**
 * セッション情報
 *
 */
public class SessionInfo {

	/** セッションアトリビュート名 */
	public static final String SESSION_ATTRIBUTE_NAME = "session";

	/** ログインユーザーID */
	private Integer loginUserId;

	/**
	 * @return loginUserId
	 */
	public Integer getLoginUserId() {
		return loginUserId;
	}

	/**
	 * @param loginUserId セットする loginUserId
	 */
	public void setLoginUserId(Integer loginUserId) {
		this.loginUserId = loginUserId;
	}

}
