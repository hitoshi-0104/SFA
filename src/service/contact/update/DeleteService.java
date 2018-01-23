package service.contact.update;

import java.sql.Connection;

import dao.ConnectionProvider;
import dao.ContactDao;
import dao.entity.ContactEntity;
import service.contact.common.ContactEntityProvider;
import service.contact.dto.ContactDto;
import util.session.SessionInfo;

/**
 * 取引先担当者の削除サービスクラス
 *
 */
public class DeleteService {

	/**
	 * 削除
	 * @param si
	 * @param dto
	 * @throws Exception
	 */
	public void delete(SessionInfo si, ContactDto dto) throws Exception {

		ContactEntityProvider provider = new ContactEntityProvider();
		ContactEntity entity = provider.provideFromContactDto(si, dto);

		ConnectionProvider cp = ConnectionProvider.getInstance();
		ContactDao dao = new ContactDao(cp);
		try (Connection conn = cp.getConnection()) {
			dao.delete(entity);
		}

	}

}
