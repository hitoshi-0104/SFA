package dao;

import java.sql.PreparedStatement;

import dao.base.BaseDao;
import dao.entity.ContactEntity;

/**
 * 取引先担当者テーブルDAO
 *
 */
public class ContactDao extends BaseDao {

	/** insertメソッドで使用するSQL */
	private static final String INSERT_SQL = "INSERT INTO T_CONTACT(LAST_NAME, FIRST_NAME, ACCOUNT_ID, DEPARTMENT, POSITION, PHONE, MOBILE_PHONE, FAX, MAIL, BOSS, NOTE, CREATE_DATE, CREATER_ID, UPDATE_DATE, UPDATER_ID) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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

		try (PreparedStatement statement = cp.getPreparedStatement(INSERT_SQL)) {

			//姓
			statement.setObject(1, entity.getLastName());
			//名
			statement.setObject(2, entity.getFirstName());
			//取引先
			statement.setObject(3, entity.getAccountId());
			//部署
			statement.setObject(4, entity.getDepartment());
			//役職
			statement.setObject(5, entity.getPosition());
			//電話
			statement.setObject(6, entity.getPhone());
			//携帯
			statement.setObject(7, entity.getMobilePhone());
			//FAX
			statement.setObject(8, entity.getFax());
			//メール
			statement.setObject(9, entity.getMail());
			//上司
			statement.setObject(10, entity.getBoss());
			//その他
			statement.setObject(11, entity.getNote());
			//作成日
			statement.setObject(12, entity.getCreateDate());
			//作成者ID
			statement.setObject(13, entity.getCreaterId());
			//最終更新日
			statement.setObject(14, entity.getUpdateDate());
			//最終更新者ID
			statement.setObject(15, entity.getUpdaterId());

			statement.executeUpdate();
		}

	}

}
