package service.contact.common;

import java.util.LinkedHashMap;
import java.util.Map;

import service.common.Validater;
import service.common.ValidationType;
import service.contact.dto.ContactDto;
import util.constant.ItemDefine;

public class ContactValidater {

	/**
	 * バリデート
	 * @param dto
	 * @return
	 */
	public Map<String, String> validate(ContactDto dto, String displayId) {

		Map<String, String> messageMap = new LinkedHashMap<String, String>();
		String id = "E" + displayId;

		// 姓：必須入力・最大桁数チェック
		Validater.validate(dto.getLastName(), id + "002", ItemDefine.Name.LAST_NAME,
				null, ItemDefine.Digit.LAST_NAME,
				new ValidationType[] { ValidationType.REQURIRED, ValidationType.MAXLENGTH },
				messageMap);
		// 名：最大桁数チェック
		Validater.validate(dto.getFirstName(), id + "003", ItemDefine.Name.FIRST_NAME,
				null, ItemDefine.Digit.FIRST_NAME,
				new ValidationType[] { ValidationType.MAXLENGTH },
				messageMap);
		// 部署：最大桁数チェック
		Validater.validate(dto.getDepartment(), id + "007", ItemDefine.Name.DEPARTMENT,
				null, ItemDefine.Digit.DEPARTMENT,
				new ValidationType[] { ValidationType.MAXLENGTH },
				messageMap);
		// 役職：最大桁数チェック
		Validater.validate(dto.getPosition(), id + "008", ItemDefine.Name.POSITION,
				null, ItemDefine.Digit.POSITION,
				new ValidationType[] { ValidationType.MAXLENGTH },
				messageMap);
		// 電話：最大桁数・数値のみチェック
		Validater.validate(dto.getPhone(), id + "012", ItemDefine.Name.PHONE,
				null, ItemDefine.Digit.PHONE,
				new ValidationType[] { ValidationType.MAXLENGTH, ValidationType.NUMERICONLY },
				messageMap);
		// 携帯：最大桁数・数値のみチェック
		Validater.validate(dto.getMobilePhone(), id + "013", ItemDefine.Name.MOBILE_PHONE,
				null, ItemDefine.Digit.MOBILE_PHONE,
				new ValidationType[] { ValidationType.MAXLENGTH, ValidationType.NUMERICONLY },
				messageMap);
		// FAX：最大桁数・数値のみチェック
		Validater.validate(dto.getFax(), id + "014", ItemDefine.Name.FAX,
				null, ItemDefine.Digit.FAX,
				new ValidationType[] { ValidationType.MAXLENGTH, ValidationType.NUMERICONLY },
				messageMap);
		// メール：最大桁数チェック・メールフォーマットチェック
		Validater.validate(dto.getMail(), id + "015", ItemDefine.Name.MAILADDRESS,
				null, ItemDefine.Digit.MAILADDRESS,
				new ValidationType[] { ValidationType.MAXLENGTH, ValidationType.MAIL_FORMAT },
				messageMap);
		// その他：最大桁数チェック
		Validater.validate(dto.getNote(), id + "016", ItemDefine.Name.NOTE,
				null, ItemDefine.Digit.NOTE,
				new ValidationType[] { ValidationType.MAXLENGTH },
				messageMap);

		return messageMap;

	}

}
