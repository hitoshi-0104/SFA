package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.base.BaseDao;
import dao.entity.ContactEntity;
import dao.entity.ContactListEntity;
import util.constant.Limit;
import util.converter.ObjectConverter;
import util.validate.StringValidater;

/**
 * 取引先担当者テーブルDAO
 *
 */
public class ContactDao extends BaseDao {

	/** insertメソッドで使用するSQL */
	private static final String INSERT_SQL = "INSERT INTO T_CONTACT(LAST_NAME, FIRST_NAME, ACCOUNT_ID, DEPARTMENT, POSITION, PHONE, MOBILE_PHONE, FAX, MAIL, BOSS, NOTE, CREATE_DATE, CREATER_ID, UPDATE_DATE, UPDATER_ID) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	/** selectForContactSearchDialogで使用するSQL */
	private static final String SELECT_FOR_CONTACT_SEARCH_DIALOG = "SELECT T1.CONTACT_ID, T1.LAST_NAME || ' ' || T1.FIRST_NAME AS CONTACT_NAME, T2.ACCOUNT_NAME, T1.MAIL FROM T_CONTACT T1 LEFT JOIN T_ACCOUNT T2 ON T1.ACCOUNT_ID = T2.ACCOUNT_ID ";
	/** countForContactSearchDialogで使用するSQL */
	private static final String COUNT_FOR_CONTACT_SEARCH_DIALOG = "SELECT COUNT(*) FROM T_CONTACT T1 LEFT JOIN T_ACCOUNT T2 ON T1.ACCOUNT_ID = T2.ACCOUNT_ID ";

	/**
	 * コンストラクタ
	 * @param cp
	 */
	public ContactDao(ConnectionProvider cp) {
		super(cp);
	}

	public Integer countForContactSearchDialog(ContactEntity param) throws Exception {

		try (PreparedStatement statement = cp.getPreparedStatement(COUNT_FOR_CONTACT_SEARCH_DIALOG + createWhereForContactList(param, null, false))) {

			// 姓
			if (!StringValidater.isEmpty(param.getLastName())) {
				statement.setString(1, param.getLastName());
			}
			// 名
			if (!StringValidater.isEmpty(param.getFirstName())) {
				statement.setString(2, param.getFirstName());
			}
			// 取引先
			if (param.getAccountId() != null) {
				statement.setInt(3, param.getAccountId());
			}

			ResultSet rs = statement.executeQuery();
			Integer ret = null;
			if(rs.next()) {
				ret = ObjectConverter.intValue(rs.getObject(1));
			}

			return ret;

		}

	}

	/**
	 * 取引先担当者ダイアログ用
	 * @return
	 * @throws Exception
	 */
	public List<ContactListEntity> selectForContactSearchDialog(ContactEntity param, Integer page) throws Exception {

		try (PreparedStatement statement = cp.getPreparedStatement(SELECT_FOR_CONTACT_SEARCH_DIALOG + createWhereForContactList(param, page, true))) {

			// 姓
			if (!StringValidater.isEmpty(param.getLastName())) {
				statement.setString(1, param.getLastName());
			}
			// 名
			if (!StringValidater.isEmpty(param.getFirstName())) {
				statement.setString(2, param.getFirstName());
			}
			// 取引先
			if (param.getAccountId() != null) {
				statement.setInt(3, param.getAccountId());
			}

			ResultSet rs = statement.executeQuery();
			List<ContactListEntity> list = new ArrayList<ContactListEntity>();
			while(rs.next()) {

				ContactListEntity entity = new ContactListEntity();

				// ID
				entity.setId(ObjectConverter.intValue(rs.getObject("CONTACT_ID")));
				// 取引先担当者名
				entity.setContactName(ObjectConverter.stringValue(rs.getObject("CONTACT_NAME")));
				// 取引先名
				entity.setAccountName(ObjectConverter.stringValue(rs.getObject("ACCOUNT_NAME")));
				// メール
				entity.setMail(ObjectConverter.stringValue(rs.getObject("MAIL")));

				list.add(entity);

			}

			return list;

		}

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

	/**
	 * 取引先担当者一覧用のWhere句作成処理
	 * @param entity
	 * @param offset
	 * @param isSelect
	 * @return
	 */
	private String createWhereForContactList(ContactEntity entity, Integer offset, boolean isSelect) {

		StringBuilder sb = new StringBuilder();

		// 姓
		if (!StringValidater.isEmpty(entity.getLastName())) {
			sb.append(" LAST_NAME LIKE ?");
			sb.append(" AND ");
		}
		// 名
		if (!StringValidater.isEmpty(entity.getFirstName())) {
			sb.append(" FIRST_NAME LIKE ?");
			sb.append(" AND ");
		}
		// 取引先
		if (entity.getAccountId() != null) {
			sb.append(" ACCOUNT_ID = ?");
			sb.append(" AND ");
		}

		if (sb.length() != 0) {
			sb.insert(0, " WHERE ");
			sb.delete(sb.length() - 5, sb.length() - 1);
		}

		sb.append("ORDER BY CONTACT_ID");

		if(isSelect) {
			sb.append(" LIMIT ");
			sb.append(Limit.LIST_ROW_LIMIT);
			sb.append(" OFFSET ");
			sb.append(offset);
		}

		return sb.toString();
	}

}
