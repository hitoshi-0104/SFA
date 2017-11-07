package exception.base;

import java.util.Map;

/**
 * 営業管理システムの基底Exceptionクラス
 *
 */
public class SalesManagementBaseException extends Exception {

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
	public SalesManagementBaseException(Map<String, String> messages) {
		this.messages = messages;
	}

}
