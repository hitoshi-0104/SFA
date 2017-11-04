package service.lead.create;

import java.util.LinkedHashMap;
import java.util.Map;

import service.common.Validater;
import service.common.ValidationType;
import service.lead.dto.CreateDto;
import util.constant.ItemDefine;

/**
 * 見込み客新規顧客用のモデルクラス
 *
 */
public class RegistService {

	/**
	 * 見込み客新規登録画面の入力チェック
	 * @return メッセージ
	 */
	public Map<String, String> validate(CreateDto dto) {

		Map<String, String> messageMap = new LinkedHashMap<String, String>();

		// 姓：必須入力・最大桁数チェック
		Validater.validate(dto.getLastName(), "E001002", ItemDefine.Name.LAST_NAME,
				null, ItemDefine.Digit.LAST_NAME,
				new ValidationType[] { ValidationType.REQURIRED, ValidationType.MAXLENGTH },
				messageMap);
		// 名：最大桁数チェック
		Validater.validate(dto.getLastName(), "E001003", ItemDefine.Name.FIRST_NAME,
				null, ItemDefine.Digit.FIRST_NAME,
				new ValidationType[] { ValidationType.MAXLENGTH },
				messageMap);
		// 会社名：必須入力・最大桁数チェック
		
		
//		// 会社名
//		if (Validater.isEmpty(dto.getCompanyName())) {
//			// 必須入力
//			messageMap.put("E00100401", String.format(MessageReader.read("E001"), ItemDefine.COMPANY_NAME));
//		} else if (Validater.isOverflow(dto.getCompanyName(), 200)) {
//			// 200桁オーバー
//			messageMap.put("E00100402", String.format(MessageReader.read("E002"), ItemDefine.COMPANY_NAME, 200));
//		}
//		// 役職名
//		if (Validater.isOverflow(dto.getPosition(), 50)) {
//			// 50桁オーバー
//			messageMap.put("E00100501", String.format(MessageReader.read("E002"), ItemDefine.POSITION, 50));
//		}
//		// 状況
//		if (Validater.isEmpty(dto.getStatusCode())) {
//			// 必須入力
//			messageMap.put("E00100701", String.format(MessageReader.read("E001"), ItemDefine.STATUS));
//		}
//		// 電話
//		if (Validater.isNotNumericOnly(dto.getPhone())) {
//			// 数値以外
//			messageMap.put("E00100901", String.format(MessageReader.read("E004"), ItemDefine.PHONE));
//		} else if (Validater.isOverflow(dto.getPhone(), 11)) {
//			// 11桁オーバー
//			messageMap.put("E00100902", String.format(MessageReader.read("E002"), ItemDefine.PHONE, 11));
//		}
//		// 携帯
//		if (Validater.isNotNumericOnly(dto.getMobilePhone())) {
//			// 数値以外
//			messageMap.put("E00101001", String.format(MessageReader.read("E004"), ItemDefine.MOBILE_PHONE));
//		} else if (Validater.isOverflow(dto.getMobilePhone(), 11)) {
//			// 11桁オーバー
//			messageMap.put("E00101002", String.format(MessageReader.read("E002"), ItemDefine.MOBILE_PHONE, 11));
//		}
//		// FAX
//		if (Validater.isNotNumericOnly(dto.getFax())) {
//			// 数値以外
//			messageMap.put("E00101001", String.format(MessageReader.read("E004"), ItemDefine.FAX));
//		} else if (Validater.isOverflow(dto.getFax(), 11)) {
//			// 11桁オーバー
//			messageMap.put("E00101002", String.format(MessageReader.read("E002"), ItemDefine.FAX, 11));
//		}
//		// メール
//		if (Validater.isNotMailAddressFormat(dto.getMailAddress())) {
//			// メールアドレスフォーマット以外
//			messageMap.put("E00101201", String.format(MessageReader.read("E007"), ItemDefine.MAILADDRESS));
//		} else if (Validater.isOverflow(dto.getMailAddress(), 256)) {
//			// 256桁オーバー
//			messageMap.put("E00101202", String.format(MessageReader.read("E002"), ItemDefine.MAILADDRESS, 256));
//		}
//		// URL
//		if (Validater.isNotUrlFormat(dto.getUrl())) {
//			// メールアドレスフォーマット以外
//			messageMap.put("E00101301", String.format(MessageReader.read("E009"), ItemDefine.URL));
//		} else if (Validater.isOverflow(dto.getUrl(), 2048)) {
//			// 2048桁オーバー
//			messageMap.put("E00101302", String.format(MessageReader.read("E002"), ItemDefine.URL, 2048));
//		}
//		// 年間売上
//		if (Validater.isOverflow(String.valueOf(dto.getAmount()), 13)) {
//			// 13桁オーバー
//			messageMap.put("E00101302", String.format(MessageReader.read("E002"), ItemDefine.URL, 2048));
//		}

		return messageMap;
	}

	/**
	 * 見込み客新規登録画面の登録処理
	 * @return true : 成功  false : 失敗
	 */
	public boolean insert(CreateDto dto) {
		return true;
	}

}
