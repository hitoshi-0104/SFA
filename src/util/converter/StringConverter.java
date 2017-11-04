package util.converter;

/**
 * コンバータ
 *
 */
public class StringConverter {

	/**
	 * 文字列を数値に変換
	 * @param str
	 * @return
	 */
	public static Integer toInteger(String str) {
		try {
			Integer i = Integer.parseInt(str);
			return i;
		} catch (NumberFormatException e) {
			return null;
		}
	}

	/**
	 * 文字列を数値に変換
	 * @param str
	 * @return
	 */
	public static Long toLong(String str) {
		try {
			Long l = Long.parseLong(str);
			return l;
		} catch (NumberFormatException e) {
			return null;
		}
	}

}
