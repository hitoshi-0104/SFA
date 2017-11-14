package service.common;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

/**
 * Validaterクラスのテストクラス
 *
 */
class ValidaterTest {

	/**
	 * validateメソッドのテスト
	 */
	@Test
	void testValidate() {

		// 必須入力チェック
		ValidationType[] types = { ValidationType.REQURIRED };
		Map<String, String> messageMap = new LinkedHashMap<String, String>();
		Validater.validate("", "E999", "テスト", 0, 0, types, messageMap);
		assertEquals("テストが未入力です。", messageMap.get("E99901"));
		messageMap = new LinkedHashMap<String, String>();
		Validater.validate("あ", "E999", "テスト", 0, 0, types, messageMap);
		assertEquals(false, messageMap.containsKey("E99901"));

		// 桁数チェック
		ValidationType[] types2 = { ValidationType.MAXLENGTH };
		messageMap = new LinkedHashMap<String, String>();
		Validater.validate("あいうえおかきくけこさ", "E999", "テスト", 0, 10, types2, messageMap);
		assertEquals("テストは10桁以内で入力してください。", messageMap.get("E99902"));
		messageMap = new LinkedHashMap<String, String>();
		Validater.validate("あいうえおかきくけこ", "E999", "テスト", 0, 10, types2, messageMap);
		assertEquals(false, messageMap.containsKey("E99902"));

		// 桁数FROM・TOチェック
		ValidationType[] types3 = { ValidationType.FROMTO };
		messageMap = new LinkedHashMap<String, String>();
		Validater.validate("あいうえおかきくけこさ", "E999", "テスト", 5, 10, types3, messageMap);
		assertEquals("テストは5桁以上10桁以内で入力してください。", messageMap.get("E99903"));
		messageMap = new LinkedHashMap<String, String>();
		Validater.validate("あいうえ", "E999", "テスト", 5, 10, types3, messageMap);
		assertEquals("テストは5桁以上10桁以内で入力してください。", messageMap.get("E99903"));
		messageMap = new LinkedHashMap<String, String>();
		Validater.validate("あいうえお", "E999", "テスト", 5, 10, types3, messageMap);
		assertEquals(false, messageMap.containsKey("E99903"));
		Validater.validate("あいうえおかきくけこ", "E999", "テスト", 5, 10, types3, messageMap);
		assertEquals(false, messageMap.containsKey("E99903"));

		// 数値のみチェック
		ValidationType[] types4 = { ValidationType.NUMERICONLY };
		messageMap = new LinkedHashMap<String, String>();
		Validater.validate("あいうえお", "E999", "テスト", 0, 0, types4, messageMap);
		assertEquals("テストは数字のみの入力を行ってください。", messageMap.get("E99904"));
		messageMap = new LinkedHashMap<String, String>();
		Validater.validate("12345", "E999", "テスト", 0, 0, types4, messageMap);
		assertEquals(false, messageMap.containsKey("E99904"));

		// メールフォーマットチェック
		ValidationType[] types5 = { ValidationType.MAIL_FORMAT };
		messageMap = new LinkedHashMap<String, String>();
		Validater.validate("abc", "E999", "テスト", 0, 0, types5, messageMap);
		assertEquals("テストはメールアドレス形式（abc@abc.co.jpなど）の入力を行ってください。", messageMap.get("E99905"));
		messageMap = new LinkedHashMap<String, String>();
		Validater.validate("abc@abc.com", "E999", "テスト", 0, 0, types5, messageMap);
		assertEquals(false, messageMap.containsKey("E99905"));

		// URLフォーマットチェック
		ValidationType[] types6 = { ValidationType.URL_FORMAT };
		messageMap = new LinkedHashMap<String, String>();
		Validater.validate("abc", "E999", "テスト", 0, 0, types6, messageMap);
		assertEquals("テストはURL形式（http://abc.co.jpなど）の入力を行ってください。", messageMap.get("E99906"));
		messageMap = new LinkedHashMap<String, String>();
		Validater.validate("http://abc.co.jp", "E999", "テスト", 0, 0, types6, messageMap);
		assertEquals(false, messageMap.containsKey("E99906"));
	}

}
