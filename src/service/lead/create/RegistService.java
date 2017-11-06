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
		Validater.validate(dto.getCompanyName(), "E001004", ItemDefine.Name.COMPANY_NAME,
				null, ItemDefine.Digit.COMPANY_NAME,
				new ValidationType[] { ValidationType.REQURIRED, ValidationType.MAXLENGTH },
				messageMap);
		// 役職名
		Validater.validate(dto.getPosition(), "E001005", ItemDefine.Name.POSITION,
				null, ItemDefine.Digit.POSITION,
				new ValidationType[] { ValidationType.MAXLENGTH },
				messageMap);
		// 状況
		Validater.validate(dto.getStatusCode(), "E001007", ItemDefine.Name.STATUS,
				null, null,
				new ValidationType[] { ValidationType.REQURIRED },
				messageMap);
		// 電話
		Validater.validate(dto.getPhone(), "E001009", ItemDefine.Name.PHONE,
				null, ItemDefine.Digit.PHONE,
				new ValidationType[] { ValidationType.MAXLENGTH, ValidationType.NUMERICONLY },
				messageMap);
		// 携帯
		Validater.validate(dto.getMobilePhone(), "E001010", ItemDefine.Name.MOBILE_PHONE,
				null, ItemDefine.Digit.MOBILE_PHONE,
				new ValidationType[] { ValidationType.MAXLENGTH, ValidationType.NUMERICONLY },
				messageMap);
		// FAX
		Validater.validate(dto.getFax(), "E001011", ItemDefine.Name.FAX,
				null, ItemDefine.Digit.FAX,
				new ValidationType[] { ValidationType.MAXLENGTH, ValidationType.NUMERICONLY },
				messageMap);
		// メール
		Validater.validate(dto.getMailAddress(), "E001012", ItemDefine.Name.MAILADDRESS,
				null, ItemDefine.Digit.MAILADDRESS,
				new ValidationType[] { ValidationType.MAXLENGTH, ValidationType.MAIL_FORMAT },
				messageMap);
		// URL
		Validater.validate(dto.getUrl(), "E001013", ItemDefine.Name.URL,
				null, ItemDefine.Digit.URL,
				new ValidationType[] { ValidationType.MAXLENGTH, ValidationType.URL_FORMAT },
				messageMap);
		// 年間売上
		Validater.validate(dto.getAmount(), "E001014", ItemDefine.Name.AMOUNT,
				null, ItemDefine.Digit.AMOUNT,
				new ValidationType[] { ValidationType.MAXLENGTH },
				messageMap);
		// 従業員数
		Validater.validate(dto.getEmployees(), "E001016", ItemDefine.Name.EMPLOYEE,
				null, ItemDefine.Digit.EMPLOYEE,
				new ValidationType[] { ValidationType.MAXLENGTH, ValidationType.NUMERICONLY },
				messageMap);
		// 郵便番号
		Validater.validate(dto.getPostalCode(), "E001017", ItemDefine.Name.POSTAL_CODE,
				null, ItemDefine.Digit.POSTAL_CODE,
				new ValidationType[] { ValidationType.MAXLENGTH, ValidationType.NUMERICONLY },
				messageMap);
		// 市区町村
		Validater.validate(dto.getCity(), "E001019", ItemDefine.Name.CITY,
				null, ItemDefine.Digit.CITY,
				new ValidationType[] { ValidationType.MAXLENGTH },
				messageMap);
		// 町名・番地・建物名
		Validater.validate(dto.getCity(), "E001020", ItemDefine.Name.TOWN,
				null, ItemDefine.Digit.TOWN,
				new ValidationType[] { ValidationType.MAXLENGTH },
				messageMap);
		// その他
		Validater.validate(dto.getCity(), "E001021", ItemDefine.Name.NOTE,
				null, ItemDefine.Digit.NOTE,
				new ValidationType[] { ValidationType.MAXLENGTH },
				messageMap);

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
