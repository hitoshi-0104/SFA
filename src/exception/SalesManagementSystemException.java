package exception;

import java.util.Map;

import exception.base.SalesManagementBaseException;

/**
 * 営業管理システムのシステムExceptionクラス
 *
 */
public class SalesManagementSystemException extends SalesManagementBaseException {

	/**
	 * コンストラクタ
	 * @param messages
	 */
	public SalesManagementSystemException(Map<String, String> messages) {
		super(messages);
	}

}
