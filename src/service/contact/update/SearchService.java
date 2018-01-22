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
		ContactEntity entity = null;
		try(Connection conn = cp.getConnection()) {
			entity = dao.selectById(dto.getId());
		}

		// DTO作成
		UpdateDto ret = new UpdateDto();
		return ret;
	}

}
