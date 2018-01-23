package service.contact.update;

import java.sql.Connection;

import dao.ConnectionProvider;
import dao.ContactDao;
import dao.entity.ContactEntity;
import service.contact.common.ContactEntityProvider;
import service.contact.dto.ContactDto;
import util.session.SessionInfo;

/**
 * 取引先担当者の更新サービスクラス
 *
 */
public class UpdateService {

	/**
	 * 更新
	 * @param si
	 * @param dto
	 * @throws Exception
	 */
	public void update(SessionInfo si, ContactDto dto) throws Exception {

		ContactEntityProvider provider = new ContactEntityProvider();
		ContactEntity entity = provider.provideFromContactDto(si, dto);

		ConnectionProvider cp = ConnectionProvider.getInstance();
		ContactDao dao = new ContactDao(cp);
		try (Connection conn = cp.getConnection()) {
			dao.update(entity);
		}

	}

}
