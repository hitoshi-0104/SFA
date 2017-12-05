package util.validate;

/**
 * String値検証クラス
 *
 */
public class StringValidater {

	/**
	 * 未入力チェック
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str == null || str.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * アンダーフローチェック
	 * @param str
	 * @param digit
	 * @return
	 */
	public static boolean isUnderflow(String str, Integer digit) {
		if (!isEmpty(str) && str.length() < digit) {
			return true;
		}
		return false;
	}

	/**
	 * オーバーフローチェック
	 * @param str
	 * @param digit
	 * @return
	 */
	public static boolean isOverflow(String str, Integer digit) {
		if (!isEmpty(str) && str.length() > digit) {
			return true;
		}
		return false;
	}

	/**
	 * 数値のみチェック
	 * @param str
	 * @return
	 */
	public static boolean isNumericOnly(String str) {
		if (isEmpty(str) || str.matches("^[0-9]*$")) {
			return true;
		}
		return false;
	}

	/**
	 * メールアドレスフォーマットチェック
	 * @param str
	 * @return
	 */
	public static boolean isMailAddressFormat(String str) {
		if (isEmpty(str) || str.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")) {
			return true;
		}
		return false;
	}

	/**
	 * URLフォーマットチェック
	 * @param str
	 * @return
	 */
	public static boolean isUrlFormat(String str) {
		if (isEmpty(str) || str.matches("https?://[\\w/:%#\\$&\\?\\(\\)~\\.=\\+\\-]+")) {
			return true;
		}
		return false;
	}

}
