package service.contact.update;

import java.sql.Connection;

import dao.ConnectionProvider;
import dao.ContactDao;
import dao.entity.ContactEntity;
import service.contact.dto.UpdateDto;
import service.contact.dto.UpdateSearchDto;
import util.session.SessionInfo;

/**
 * 取引先担当者のサービスクラス
 *
 */
public class SearchService {

	/**
	 * 更新用の取引先担当者取得処理
	 * @param si
	 * @param dto
	 * @throws Exception
	 */
	public UpdateDto search(SessionInfo si, UpdateSearchDto dto) throws Exception {

		// データ取得
		ConnectionProvider cp = ConnectionProvider.getInstance();
		ContactDao dao = new ContactDao(cp);
		ContactEntity en = null;
		try(Connection conn = cp.getConnection()) {
			en = dao.selectById(dto.getId());
		}

		// DTO作成
		UpdateDto ret = new UpdateDto();

		// 取引先担当者ID
		ret.setId(en.getId());
		// 姓
		ret.setLastName(en.getLastName());
		// 名
		ret.setFirstName(en.getFirstName());
		// 取引先
		ret.setAccountId(en.getAccountId());
		// 取引先名
		ret.setAccountName(en.getAccountName());
		// 部署
		ret.setDepartment(en.getDepartment());
		// 役職
		ret.setPosition(en.getPosition());
		// 電話
		ret.setPhone(en.getPhone());
		// 携帯
		ret.setMobilePhone(en.getMobilePhone());
		// FAX
		ret.setFax(en.getFax());
		// メール
		ret.setMail(en.getMail());
		// 上司
		ret.setBoss(en.getBoss());
		// 上司名
		ret.setBossName(en.getBossName());
		// その他
		ret.setNote(en.getNote());

		return ret;
	}

}
