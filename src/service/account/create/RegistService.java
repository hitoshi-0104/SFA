package service.account.create;

import java.sql.Connection;

import dao.AccountDao;
import dao.ConnectionProvider;
import dao.entity.AccountEntity;
import service.account.common.AccountEntityProvider;
import service.account.dto.AccountDto;
import util.session.SessionInfo;

/**
 * 取引先新規登録のサービスクラス
 *
 */
public class RegistService {

	/**
	 * 取引先新規登録画面の登録処理
	 * @throws Exception
	 */
	public void insert(SessionInfo si, AccountDto dto) throws Exception {

		// エンティティの作成
		AccountEntityProvider provider = new AccountEntityProvider();
		AccountEntity entity = provider.provideFromAccountDto(si, dto);

		ConnectionProvider cp = ConnectionProvider.getInstance();
		AccountDao dao = new AccountDao(cp);
		try (Connection conn = cp.getConnection()) {
			dao.insert(entity);
		}
	}

}
