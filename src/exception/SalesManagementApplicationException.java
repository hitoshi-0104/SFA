package exception;

import java.util.Map;

import exception.base.SalesManagementBaseException;

/**
 * 営業管理システムのアプリケーションExceptionクラス
 *
 */
public class SalesManagementApplicationException extends SalesManagementBaseException {

	/**
	 * コンストラクタ
	 * @param list
	 */
	public SalesManagementApplicationException(Map<String, String> messages) {
		super(messages);
	}

}
