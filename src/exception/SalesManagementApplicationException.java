package exception;

import java.util.Map;

/**
 * 営業管理システムのアプリケーションExceptionクラス
 *
 */
public class SalesManagementApplicationException extends Exception {

	/** メッセージ */
	private Map<String, String> messages;

	/**
	 * @return messages
	 */
	public Map<String, String> getMessages() {
		return messages;
	}

	/**
	 * コンストラクタ
	 * @param list
	 */
	public SalesManagementApplicationException(Map<String, String> messages) {
		this.messages = messages;
	}

}
