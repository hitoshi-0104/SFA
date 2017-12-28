package service.account.update;

import java.sql.Connection;

import dao.AccountDao;
import dao.ConnectionProvider;
import dao.entity.AccountEntity;
import service.account.common.AccountEntityProvider;
import service.account.dto.AccountDto;
import util.session.SessionInfo;

/**
 * 取引先削除サービスクラス
 *
 */
public class DeleteService {

	/**
	 * 更新
	 * @param si
	 * @param dto
	 * @throws Exception
	 */
	public void delete(SessionInfo si, AccountDto dto) throws Exception {

		AccountEntityProvider provider = new AccountEntityProvider();
		AccountEntity entity = provider.provideFromAccountDto(si, dto);

		ConnectionProvider cp = ConnectionProvider.getInstance();
		AccountDao dao = new AccountDao(cp);
		try (Connection conn = cp.getConnection()) {
			dao.deleteById(entity.getId());
		}

	}

}
