package service.account.common;

import java.util.LinkedHashMap;
import java.util.Map;

import service.account.dto.AccountDto;
import service.common.Validater;
import service.common.ValidationType;
import util.constant.ItemDefine;

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

		// 取引先名：必須入力・最大桁数チェック
		Validater.validate(dto.getAccountName(), id + "001", ItemDefine.Name.ACCOUNT_NAME,
				null, ItemDefine.Digit.ACCOUNT_NAME,
				new ValidationType[] { ValidationType.REQURIRED, ValidationType.MAXLENGTH },
				messageMap);
		// 取引先番号：最大桁数チェック
		Validater.validate(dto.getAccountNo(), id + "002", ItemDefine.Name.ACCOUNT_NO,
				null, ItemDefine.Digit.ACCOUNT_NO,
				new ValidationType[] { ValidationType.MAXLENGTH },
				messageMap);
		// 取引先部門：最大桁数チェック
		Validater.validate(dto.getDepartment(), id + "003", ItemDefine.Name.DEPARTMENT,
				null, ItemDefine.Digit.DEPARTMENT,
				new ValidationType[] { ValidationType.MAXLENGTH },
				messageMap);
		// 年間売上：最大桁数・数値のみチェック
		Validater.validate(dto.getAmount(), id + "004", ItemDefine.Name.AMOUNT,
				null, ItemDefine.Digit.AMOUNT,
				new ValidationType[] { ValidationType.MAXLENGTH, ValidationType.NUMERICONLY },
				messageMap);
		// 電話：最大桁数・数値のみチェック
		Validater.validate(dto.getPhone(), id + "005", ItemDefine.Name.PHONE,
				null, ItemDefine.Digit.PHONE,
				new ValidationType[] { ValidationType.MAXLENGTH, ValidationType.NUMERICONLY },
				messageMap);
		// FAX：最大桁数・数値のみチェック
		Validater.validate(dto.getFax(), id + "006", ItemDefine.Name.FAX,
				null, ItemDefine.Digit.FAX,
				new ValidationType[] { ValidationType.MAXLENGTH, ValidationType.NUMERICONLY },
				messageMap);
		// URL：最大桁数チェック・URLフォーマットチェック
		Validater.validate(dto.getUrl(), id + "007", ItemDefine.Name.URL,
				null, ItemDefine.Digit.URL,
				new ValidationType[] { ValidationType.MAXLENGTH, ValidationType.URL_FORMAT },
				messageMap);
		// 従業員数：最大桁数・数値のみチェック
		Validater.validate(dto.getEmployee(), id + "008", ItemDefine.Name.EMPLOYEE,
				null, ItemDefine.Digit.EMPLOYEE,
				new ValidationType[] { ValidationType.MAXLENGTH, ValidationType.NUMERICONLY },
				messageMap);
		// 証券コード：最大桁数・数値のみチェック
		Validater.validate(dto.getStockCode(), id + "009", ItemDefine.Name.STOCK_CODE,
				null, ItemDefine.Digit.STOCK_CODE,
				new ValidationType[] { ValidationType.MAXLENGTH, ValidationType.NUMERICONLY },
				messageMap);
		// 郵便番号：最大桁数・数値のみチェック
		Validater.validate(dto.getPostalCode(), id + "010", ItemDefine.Name.POSTAL_CODE,
				null, ItemDefine.Digit.POSTAL_CODE,
				new ValidationType[] { ValidationType.MAXLENGTH, ValidationType.NUMERICONLY },
				messageMap);
		// 市区郡：最大桁数チェック
		Validater.validate(dto.getCity(), id + "011", ItemDefine.Name.CITY,
				null, ItemDefine.Digit.CITY,
				new ValidationType[] { ValidationType.MAXLENGTH },
				messageMap);
		// 町名・番地・建物名：最大桁数チェック
		Validater.validate(dto.getTown(), id + "012", ItemDefine.Name.TOWN,
				null, ItemDefine.Digit.TOWN,
				new ValidationType[] { ValidationType.MAXLENGTH },
				messageMap);
		// その他：最大桁数チェック
		Validater.validate(dto.getNote(), id + "013", ItemDefine.Name.NOTE,
				null, ItemDefine.Digit.NOTE,
				new ValidationType[] { ValidationType.MAXLENGTH },
				messageMap);

		return messageMap;

	}

}
