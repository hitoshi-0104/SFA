package service.account.common;

import java.util.LinkedHashMap;
import java.util.Map;

import service.account.dto.AccountDto;

/**
 * 取引先のバリデータクラス
 *
 */
public class AccountValidater {

	/**
	 * バリデート
	 * @param dto
	 * @return
	 */
	public Map<String, String> validate(AccountDto dto, String displayId) {

		Map<String, String> messageMap = new LinkedHashMap<String, String>();
		String id = "E" + displayId;

//		// 姓：必須入力・最大桁数チェック
//		Validater.validate(dto.getLastName(), id + "002", ItemDefine.Name.LAST_NAME,
//				null, ItemDefine.Digit.LAST_NAME,
//				new ValidationType[] { ValidationType.REQURIRED, ValidationType.MAXLENGTH },
//				messageMap);
//		// 名：最大桁数チェック
//		Validater.validate(dto.getFirstName(), id + "003", ItemDefine.Name.FIRST_NAME,
//				null, ItemDefine.Digit.FIRST_NAME,
//				new ValidationType[] { ValidationType.MAXLENGTH },
//				messageMap);
//		// 会社名：必須入力・最大桁数チェック
//		Validater.validate(dto.getCompanyName(), id + "004", ItemDefine.Name.COMPANY_NAME,
//				null, ItemDefine.Digit.COMPANY_NAME,
//				new ValidationType[] { ValidationType.REQURIRED, ValidationType.MAXLENGTH },
//				messageMap);
//		// 役職名：最大桁数チェック
//		Validater.validate(dto.getPosition(), id + "005", ItemDefine.Name.POSITION,
//				null, ItemDefine.Digit.POSITION,
//				new ValidationType[] { ValidationType.MAXLENGTH },
//				messageMap);
//		// 状況：必須入力チェック
//		Validater.validate(dto.getStatusCode(), id + "007", ItemDefine.Name.STATUS,
//				null, null,
//				new ValidationType[] { ValidationType.REQURIRED },
//				messageMap);
//		// 電話：最大桁数・数値のみチェック
//		Validater.validate(dto.getPhone(), id + "009", ItemDefine.Name.PHONE,
//				null, ItemDefine.Digit.PHONE,
//				new ValidationType[] { ValidationType.MAXLENGTH, ValidationType.NUMERICONLY },
//				messageMap);
//		// 携帯：最大桁数・数値のみチェック
//		Validater.validate(dto.getMobilePhone(), id + "010", ItemDefine.Name.MOBILE_PHONE,
//				null, ItemDefine.Digit.MOBILE_PHONE,
//				new ValidationType[] { ValidationType.MAXLENGTH, ValidationType.NUMERICONLY },
//				messageMap);
//		// FAX：最大桁数・数値のみチェック
//		Validater.validate(dto.getFax(), id + "011", ItemDefine.Name.FAX,
//				null, ItemDefine.Digit.FAX,
//				new ValidationType[] { ValidationType.MAXLENGTH, ValidationType.NUMERICONLY },
//				messageMap);
//		// メール：最大桁数・メールアドレスフォーマットチェック
//		Validater.validate(dto.getMailAddress(), id + "012", ItemDefine.Name.MAILADDRESS,
//				null, ItemDefine.Digit.MAILADDRESS,
//				new ValidationType[] { ValidationType.MAXLENGTH, ValidationType.MAIL_FORMAT },
//				messageMap);
//		// URL：最大桁数・URLフォーマットチェック
//		Validater.validate(dto.getUrl(), id + "013", ItemDefine.Name.URL,
//				null, ItemDefine.Digit.URL,
//				new ValidationType[] { ValidationType.MAXLENGTH, ValidationType.URL_FORMAT },
//				messageMap);
//		// 年間売上：最大桁数・数値のみチェック
//		Validater.validate(dto.getAmount(), id + "014", ItemDefine.Name.AMOUNT,
//				null, ItemDefine.Digit.AMOUNT,
//				new ValidationType[] { ValidationType.MAXLENGTH, ValidationType.NUMERICONLY },
//				messageMap);
//		// 従業員数：最大桁数・数値のみチェック
//		Validater.validate(dto.getEmployees(), id + "016", ItemDefine.Name.EMPLOYEE,
//				null, ItemDefine.Digit.EMPLOYEE,
//				new ValidationType[] { ValidationType.MAXLENGTH, ValidationType.NUMERICONLY },
//				messageMap);
//		// 郵便番号：最大桁数・数値のみチェック
//		Validater.validate(dto.getPostalCode(), id + "017", ItemDefine.Name.POSTAL_CODE,
//				null, ItemDefine.Digit.POSTAL_CODE,
//				new ValidationType[] { ValidationType.MAXLENGTH, ValidationType.NUMERICONLY },
//				messageMap);
//		// 市区町村：最大桁数チェック
//		Validater.validate(dto.getCity(), id + "019", ItemDefine.Name.CITY,
//				null, ItemDefine.Digit.CITY,
//				new ValidationType[] { ValidationType.MAXLENGTH },
//				messageMap);
//		// 町名・番地・建物名：最大桁数チェック
//		Validater.validate(dto.getCity(), id + "020", ItemDefine.Name.TOWN,
//				null, ItemDefine.Digit.TOWN,
//				new ValidationType[] { ValidationType.MAXLENGTH },
//				messageMap);
//		// その他：最大桁数チェック
//		Validater.validate(dto.getCity(), id + "021", ItemDefine.Name.NOTE,
//				null, ItemDefine.Digit.NOTE,
//				new ValidationType[] { ValidationType.MAXLENGTH },
//				messageMap);

		return messageMap;

	}

}
