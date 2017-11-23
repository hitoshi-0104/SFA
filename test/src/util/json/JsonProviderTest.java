package util.json;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class JsonProviderTest {

	@Test
	void testProvideMapOfStringString() {

		List<Map<String, String>> list = setDate();

		String json = JsonProvider.provide(list.get(0));
		assertEquals("{\"a\" : \"あいうえお\", \"b\" : \"かきくけこ\", \"c\" : \"さしすせそ\", }", json);
	}

	@Test
	void testProvideListOfMapOfStringString() {

		List<Map<String, String>> list = setDate();

		String json = JsonProvider.provide(list);
		assertEquals("[{\"a\" : \"あいうえお\", \"b\" : \"かきくけこ\", \"c\" : \"さしすせそ\", },{\"d\" : \"たちつてと\", \"e\" : \"なにぬねの\", \"f\" : \"はひふへほ\", },{\"g\" : \"まみむめも\", },]", json);
	}

	/**
	 * テストデータセット
	 * @return
	 */
	private List<Map<String, String>> setDate() {

		List<Map<String, String>> list = new ArrayList<Map<String, String>>();

		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("a", "あいうえお");
		m.put("b", "かきくけこ");
		m.put("c", "さしすせそ");
		list.add(m);

		m = new LinkedHashMap<String, String>();
		m.put("d", "たちつてと");
		m.put("e", "なにぬねの");
		m.put("f", "はひふへほ");
		list.add(m);

		m = new LinkedHashMap<String, String>();
		m.put("g", "まみむめも");
		list.add(m);

		return list;

	}

}
