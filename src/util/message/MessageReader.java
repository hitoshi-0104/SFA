package util.message;

import java.util.ResourceBundle;

/**
 * メッセージ読み込みクラス
 *
 */
public class MessageReader {

	/** メッセージプロパティファイル名 */
	private static final String MESSAGE_FILE_NAME = "message";

	/**
	 * 読み込み
	 * @param id メッセージID
	 * @return メッセージ
	 */
	public static String read(String id) {
		ResourceBundle rb = ResourceBundle.getBundle(MESSAGE_FILE_NAME, new ResourceBundleUtf8Control());
		return rb.getString(id);
	}
}
