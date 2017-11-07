package exception;

import java.util.Map;

import exception.base.SalesManagementBaseException;

/**
* 営業管理システムのランタイムExceptionクラス
*
*/
public class SalesManagementRuntimeException extends SalesManagementBaseException {

	/**
	 * コンストラクタ
	 * @param messages
	 */
	public SalesManagementRuntimeException(Map<String, String> messages) {
		super(messages);
	}

}
