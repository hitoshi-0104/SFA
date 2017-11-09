package service.lead.create;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import dao.LeadDao;
import dao.entity.LeadEntity;
import service.common.Validater;
import service.common.ValidationType;
import service.lead.dto.CreateDto;
import util.constant.ItemDefine;
import util.session.SessionInfo;

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
	public void insert(HttpServletRequest request, CreateDto dto) throws ClassNotFoundException, SQLException {

		// エンティティの作成
		LeadEntity entity = createLeadEntityForInsert(request, dto);

		LeadDao dao = new LeadDao();
		dao.connection();
		dao.insert(entity);
		dao.close();
	}

	/**
	 * 登録処理用にLeadEntityを生成する
	 * @param dto
	 * @return
	 */
	private LeadEntity createLeadEntityForInsert(HttpServletRequest request, CreateDto dto) {

		LeadEntity entity = new LeadEntity();

		// 姓
		entity.setLastName(dto.getLastName());
		// 名
		entity.setFirstName(dto.getFirstName());
		// 会社名
		entity.setCompanyName(dto.getCompanyName());
		// 役職名
		entity.setPosition(dto.getPosition());
		// ソース
		entity.setSourceCode(dto.getSourceCode());
		// 状況
		entity.setStatusCode(dto.getStatusCode());
		// 評価
		entity.setEstimationCode(dto.getEstimationCode());
		// 電話
		entity.setPhone(dto.getPhone());
		// 携帯
		entity.setMobilePhone(dto.getMobilePhone());
		// FAX
		entity.setFax(dto.getFax());
		// メール
		entity.setMailAddress(dto.getMailAddress());
		// URL
		entity.setUrl(dto.getUrl());
		// 業種
		entity.setIndustryCode(dto.getIndustryCode());
		// 年間売上
		entity.setAmount(dto.getAmount());
		// 従業員数
		entity.setEmployees(dto.getEmployees());
		// 郵便番号
		entity.setPostalCode(dto.getPostalCode());
		// 都道府県
		entity.setDivisionCode(dto.getDivisionCode());
		// 市区郡
		entity.setCity(dto.getCity());
		// 町名・番地・建物名
		entity.setTown(dto.getTown());
		// その他
		entity.setNote(dto.getNote());

		SessionInfo si = (SessionInfo)request.getAttribute(SessionInfo.SESSION_ATTRIBUTE_NAME);

		// 作成者ID
		entity.setCreaterId(si.getLoginUserId());
		// 作成日時
		entity.setCreateDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss.sss")));
		// 更新者ID
		entity.setUpdaterId(si.getLoginUserId());
		// 更新日時
		entity.setUpdateDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss.sss")));

		return entity;

	}

}
