package dao;

import dao.base.BaseDao;
import dao.entity.ContactEntity;

/**
 * 取引先担当者テーブルDAO
 *
 */
public class ContactDao extends BaseDao {

	/**
	 * コンストラクタ
	 * @param cp
	 */
	public ContactDao(ConnectionProvider cp) {
		super(cp);
	}

	/**
	 * 登録
	 * @param entity
	 * @throws Exception
	 */
	public void insert(ContactEntity entity) throws Exception {

	}

}
