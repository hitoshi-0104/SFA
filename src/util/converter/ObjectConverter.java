package util.converter;

/**
 * Objectコンバートクラス
 *
 */
public class ObjectConverter {

	/**
	 * 数値をLong型に変換
	 * @param obj
	 * @return
	 */
	public static Long longValue(Object obj) {

		if (obj instanceof Short) {
			return ((Short)obj).longValue();
		} else if (obj instanceof Integer) {
			return ((Integer)obj).longValue();
		} else if (obj instanceof Long) {
			return (Long)obj;
		}

		return null;
	}

}
