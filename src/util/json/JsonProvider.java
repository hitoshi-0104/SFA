package util.json;

import java.util.List;
import java.util.Map;

/**
 * JSON作成クラス
 *
 */
public class JsonProvider {

	/**
	 * MapからJSON作成
	 * @param m
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String provide(Map<String, Object> m) {

		if (m.size() == 0) {
			return "{}";
		}

		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (Map.Entry<String, Object> e : m.entrySet()) {
			sb.append("\"");
			sb.append(e.getKey());
			sb.append("\" : ");
			if (e.getValue() instanceof List) {
				sb.append(provide((List<Map<String, Object>>)e.getValue()));
			} else {
				sb.append("\"");
				sb.append(e.getValue() == null ? "" : e.getValue());
				sb.append("\"");
			}
			sb.append(", ");
		}
		sb.delete(sb.length() - 2, sb.length());
		sb.append("}");
		return sb.toString();
	}

	/**
	 * MapのListからJSON作成
	 * @param list
	 * @return
	 */
	public static String provide(List<Map<String, Object>> list) {

		if (list.size() == 0) {
			return "{}";
		}

		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (Map<String, Object> m : list) {
			sb.append(provide(m));
			sb.append(",");
		}
		sb.delete(sb.length() - 1, sb.length());
		sb.append("]");
		return sb.toString();
	}

}
