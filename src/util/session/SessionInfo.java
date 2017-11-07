package util.session;

/**
 * セッション情報
 *
 */
public class SessionInfo {

	/** セッションアトリビュート名 */
	public static final String SESSION_ATTRIBUTE_NAME = "session";

	/** ログインユーザーID */
	private String loginUserId;

	/**
	 * @return loginUserId
	 */
	public String getLoginUserId() {
		return loginUserId;
	}

	/**
	 * @param loginUserId セットする loginUserId
	 */
	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

}
