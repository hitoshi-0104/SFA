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
		if (str != null && str.length() < digit) {
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
		if (str != null && str.length() > digit) {
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
		if (str == null || str.matches("^[0-9]*$")) {
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
		if (str == null || str.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")) {
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
		if (str == null || str.matches("/^(http|https|ftp):\\/\\/([A-Z0-9][A-Z0-9_-]*(?:\\.[A-Z0-9][A-Z0-9_-]*)+):?(\\d+)?\\/?/i")) {
			return true;
		}
		return false;
	}

}
