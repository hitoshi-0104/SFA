package dao;

import dao.base.BaseDao;
import dao.entity.AccountEntity;

/**
 * 取引先テーブルDAO
 *
 */
public class AccountDao extends BaseDao {

	/**
	 * コンストラクタ
	 * @param cp
	 */
	public AccountDao(ConnectionProvider cp) {
		super(cp);
	}

	/**
	 * 登録
	 * @param entity
	 * @throws Exception
	 */
	public void insert(AccountEntity entity) throws Exception {

	}

}
