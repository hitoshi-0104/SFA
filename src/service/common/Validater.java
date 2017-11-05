package service.common;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import util.message.MessageReader;
import util.validate.StringValidater;

/**
 * 値検証クラス
 *
 */
public class Validater {

	/** バリデーションID：必須入力 */
	private static final String VALID_TYPE_ID_REQURIRED = "01";
	/** バリデーションID：最大桁数 */
	private static final String VALID_TYPE_ID_MAXLENGTH = "02";
	/** バリデーションID：桁数FROMTO */
	private static final String VALID_TYPE_ID_FROMTO = "03";
	/** バリデーションID：数値のみ */
	private static final String VALID_TYPE_ID_NUMERICONLY = "04";

	/**
	 * バリデート
	 * @return
	 */
	public static void validate(Object val, String errorId, String itemName,
			Integer digitFrom, Integer digitTo, ValidationType[] types, Map<String, String> messageMap) {

		List<ValidationType> validationTypeList = Arrays.asList(types);

		// 必須入力チェック
		if (validationTypeList.contains(ValidationType.REQURIRED)) {
			if (StringValidater.isEmpty(String.valueOf(val))) {
				messageMap.put(errorId + VALID_TYPE_ID_REQURIRED,
						String.format(MessageReader.read("E001"), itemName));
				return;
			}
		}

		// 最大桁数チェック
		if (validationTypeList.contains(ValidationType.MAXLENGTH)) {
			if (StringValidater.isOverflow(String.valueOf(val), digitTo)) {
				messageMap.put(errorId + VALID_TYPE_ID_MAXLENGTH,
						String.format(MessageReader.read("E002"), itemName, digitTo));
				return;
			}
		}

		// 桁数のFROM, TOチェック
		if (validationTypeList.contains(ValidationType.FROMTO)) {
			if (StringValidater.isUnderflow(String.valueOf(val), digitFrom) ||
				StringValidater.isOverflow(String.valueOf(val), digitTo)) {
				messageMap.put(errorId + VALID_TYPE_ID_FROMTO,
						String.format(MessageReader.read("E003"), itemName, digitFrom, digitTo));
				return;
			}
		}

		// 数値のみチェック
		if (validationTypeList.contains(ValidationType.NUMERICONLY)) {
			if (!StringValidater.isNumericOnly(String.valueOf(val))) {
				messageMap.put(errorId + VALID_TYPE_ID_NUMERICONLY,
						String.format(MessageReader.read("E004"), itemName));
				return;
			}
		}
	}
}
