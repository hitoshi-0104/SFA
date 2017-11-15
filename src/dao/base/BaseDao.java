package dao.base;

import dao.ConnectionProvider;

/**
 * Daoの基底クラス
 *
 */
public class BaseDao {

	/** データアクセス補助クラス */
	public ConnectionProvider cp;

	/**
	 * コンストラクタ
	 * @param cp
	 */
	public BaseDao(ConnectionProvider cp) {
		this.cp = cp;
	}

}
