package service.account.update;

import java.sql.Connection;

import dao.AccountDao;
import dao.ConnectionProvider;
import dao.entity.AccountEntity;
import service.account.common.AccountEntityProvider;
import service.account.dto.AccountDto;
import util.session.SessionInfo;

/**
 * 取引先更新のサービスクラス
 *
 */
public class UpdateService {

	/**
	 * 更新
	 * @param si
	 * @param dto
	 * @throws Exception
	 */
	public void update(SessionInfo si, AccountDto dto) throws Exception {

		AccountEntityProvider provider = new AccountEntityProvider();
		AccountEntity entity = provider.provideFromAccountDto(si, dto);

		ConnectionProvider cp = ConnectionProvider.getInstance();
		AccountDao dao = new AccountDao(cp);
		try (Connection conn = cp.getConnection()) {
			dao.update(entity);
		}

	}

}
