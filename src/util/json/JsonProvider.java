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
	public static String provide(Map<String, String> m) {

		if (m.size() == 0) {
			return "{}";
		}

		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (Map.Entry<String, String> e : m.entrySet()) {
			sb.append("\"");
			sb.append(e.getKey());
			sb.append("\" : ");
			sb.append("\"");
			sb.append(e.getValue() == null ? "" : e.getValue());
			sb.append("\", ");
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
	public static String provide(List<Map<String, String>> list) {

		if (list.size() == 0) {
			return "{}";
		}

		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (Map<String, String> m : list) {
			sb.append(provide(m));
			sb.append(",");
		}
		sb.delete(sb.length() - 1, sb.length());
		sb.append("]");
		return sb.toString();
	}

}
