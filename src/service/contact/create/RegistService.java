package service.contact.create;

import java.sql.Connection;

import dao.ConnectionProvider;
import dao.ContactDao;
import dao.entity.ContactEntity;
import service.contact.common.ContactEntityProvider;
import service.contact.dto.ContactDto;
import util.session.SessionInfo;

/**
 * 取引先担当者新規登録のサービスクラス
 *
 */
public class RegistService {

	/**
	 * 取引先担当者新規登録画面の登録処理
	 * @throws Exception
	 */
	public void insert(SessionInfo si, ContactDto dto) throws Exception {

		// エンティティの作成
		ContactEntityProvider provider = new ContactEntityProvider();
		ContactEntity entity = provider.provideFromContactDto(si, dto);

		ConnectionProvider cp = ConnectionProvider.getInstance();
		ContactDao dao = new ContactDao(cp);
		try (Connection conn = cp.getConnection()) {
			dao.insert(entity);
		}
	}

}
