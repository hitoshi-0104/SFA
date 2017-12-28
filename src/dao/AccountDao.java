package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.base.BaseDao;
import dao.entity.AccountEntity;
import dao.entity.AccountListEntity;
import util.constant.Limit;
import util.converter.ObjectConverter;
import util.validate.StringValidater;

/**
 * 取引先テーブルDAO
 *
 */
public class AccountDao extends BaseDao {

	/** countForAccountDialogListメソッドで使用するSQL */
	private static final String COUNT_FOR_ACCOUNT_DIALOG_LIST = "SELECT COUNT(*) FROM T_ACCOUNT T1 LEFT JOIN M_DIVISION T2 ON T1.DIVISION = T2.DIVISION_ID";
	/** selectForAccountDialogListメソッドで使用するSQL */
	private static final String SELECT_FOR_ACCOUNT_DIALOG_LIST = "SELECT T1.ACCOUNT_ID, T1.ACCOUNT_NAME, T1.PHONE, T2.NAME || T1.CITY || T1.TOWN AS ADDRESS FROM T_ACCOUNT T1 LEFT JOIN M_DIVISION T2 ON T1.DIVISION = T2.DIVISION_ID";
	/** selectMaxIdメソッドで使用するSQL */
	private static final String SELECT_MAX_ID_SQL = "SELECT MAX(ACCOUNT_ID) AS MAX_ID FROM T_ACCOUNT";
	/** selectByIdメソッドで使用するSQL */
	private static final String SELECT_BY_ID = "SELECT T1.ACCOUNT_ID, T1.ACCOUNT_NAME, T2.ACCOUNT_ID AS PARENT_ID, T2.ACCOUNT_NAME AS PARENT, T1.ACCOUNT_NO, T1.DEPARTMENT, T1.INDUSTRY, T1.AMOUNT, T1.EVALUATION, T1.PHONE, T1.FAX, T1.URL, T1.EMPLOYEE, T1.STOCK_CODE, T1.POSTAL_CODE, T1.DIVISION, T1.CITY, T1.TOWN, T1.NOTE, T1.CREATE_DATE, T1.CREATER_ID, T1.UPDATE_DATE, T1.UPDATER_ID, T1.DELETE_FLAG FROM T_ACCOUNT T1 LEFT JOIN T_ACCOUNT T2 ON T1.PARENT = T2.ACCOUNT_ID WHERE T1.ACCOUNT_ID = ?";
	/** insertメソッドで使用するSQL */
	private static final String INSERT_SQL = "INSERT INTO T_ACCOUNT (ACCOUNT_NAME, PARENT, ACCOUNT_NO, DEPARTMENT, TYPE, INDUSTRY, AMOUNT, EVALUATION, PHONE, FAX, URL, STOCK_CODE, POSTAL_CODE, DIVISION, CITY, TOWN, NOTE, CREATE_DATE, CREATER_ID, UPDATE_DATE, UPDATER_ID) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	/**
	 * コンストラクタ
	 * @param cp
	 */
	public AccountDao(ConnectionProvider cp) {
		super(cp);
	}

	/**
	 * 取引先検索一覧の件数取得
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Integer countForAccountList(AccountEntity entity) throws Exception {

		try (PreparedStatement statement = cp.getPreparedStatement(COUNT_FOR_ACCOUNT_DIALOG_LIST + createWhereForAccountList(entity, null, false))) {

			ResultSet rs = statement.executeQuery();
			Integer ret = null;
			if (rs.next()) {
				ret = ObjectConverter.intValue(rs.getObject(1));
			}
			return ret;
		}
	}

	/**
	 * 取引先検索一覧用の取得処理
	 * @return
	 */
	public List<AccountListEntity> selectForAccountList(AccountEntity entity, Integer offset) throws Exception {

		try (PreparedStatement statement = cp.getPreparedStatement(SELECT_FOR_ACCOUNT_DIALOG_LIST + createWhereForAccountList(entity, offset, true))) {

			ResultSet rs = statement.executeQuery();
			List<AccountListEntity> list = new ArrayList<AccountListEntity>();
			while(rs.next()) {
				AccountListEntity en = new AccountListEntity();
				// ID
				en.setId(ObjectConverter.intValue(rs.getObject("ACCOUNT_ID")));
				// 取引先名
				en.setAccountName(ObjectConverter.stringValue(rs.getObject("ACCOUNT_NAME")));
				// 電話
				en.setPhone(ObjectConverter.stringValue(rs.getObject("PHONE")));
				// 住所
				en.setAddress(ObjectConverter.stringValue(rs.getObject("ADDRESS")));

				list.add(en);
			}
			return list;
		}
	}

	/**
	 * IDの最大値を取得
	 * @return
	 * @throws Exception
	 */
	public Integer selectMaxId() throws Exception {

		try (PreparedStatement statement = cp.getPreparedStatement(SELECT_MAX_ID_SQL)) {
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				return ObjectConverter.intValue(rs.getObject("MAX_ID"));
			}
		}
		return 0;
	}

	/**
	 * IDから取引先情報を取得
	 * @return
	 * @throws Exception
	 */
	public AccountEntity selectById(Integer id) throws Exception {

		try (PreparedStatement statement = cp.getPreparedStatement(SELECT_BY_ID)) {

			statement.setObject(1, id);

			ResultSet rs = statement.executeQuery();
			if (rs.next()) {

				AccountEntity entity = new AccountEntity();

				// 取引先ID
				entity.setId(ObjectConverter.intValue(rs.getObject("ACCOUNT_ID")));
				// 取引先名
				entity.setAccountName(ObjectConverter.stringValue(rs.getObject("ACCOUNT_NAME")));
				// 親取引先ID
				entity.setParentId(ObjectConverter.intValue(rs.getObject("PARENT_ID")));
				// 親取引先
				entity.setParent(ObjectConverter.stringValue(rs.getObject("PARENT")));
				// 取引先番号
				entity.setAccountNo(ObjectConverter.stringValue(rs.getObject("ACCOUNT_NO")));
				// 取引先部門
				entity.setDepartment(ObjectConverter.stringValue(rs.getObject("DEPARTMENT")));
				// 業種
				entity.setIndustry(ObjectConverter.stringValue(rs.getObject("INDUSTRY")));
				// 年間売上
				entity.setAmount(ObjectConverter.longValue(rs.getObject("AMOUNT")));
				// 評価
				entity.setEvaluation(ObjectConverter.stringValue(rs.getObject("EVALUATION")));
				// 電話
				entity.setPhone(ObjectConverter.stringValue(rs.getObject("PHONE")));
				// FAX
				entity.setFax(ObjectConverter.stringValue(rs.getObject("FAX")));
				// URL
				entity.setUrl(ObjectConverter.stringValue(rs.getObject("URL")));
				// 従業員数
				entity.setEmployee(ObjectConverter.intValue(rs.getObject("EMPLOYEE")));
				// 証券コード
				entity.setStockCode(ObjectConverter.stringValue(rs.getObject("STOCK_CODE")));
				// 郵便番号
				entity.setPostalCode(ObjectConverter.stringValue(rs.getObject("POSTAL_CODE")));
				// 都道府県
				entity.setDivision(ObjectConverter.stringValue(rs.getObject("DIVISION")));
				// 市区郡
				entity.setCity(ObjectConverter.stringValue(rs.getObject("CITY")));
				// 町名・番地・建物名
				entity.setTown(ObjectConverter.stringValue(rs.getObject("TOWN")));
				// その他
				entity.setNote(ObjectConverter.stringValue(rs.getObject("NOTE")));
				// 作成日
				entity.setCreateDate(ObjectConverter.stringValue(rs.getObject("CREATE_DATE")));
				// 作成者ID
				entity.setCreaterId(ObjectConverter.intValue(rs.getObject("CREATER_ID")));
				// 最終更新日
				entity.setUpdateDate(ObjectConverter.stringValue(rs.getObject("UPDATE_DATE")));
				// 最終更新者ID
				entity.setUpdaterId(ObjectConverter.intValue(rs.getObject("UPDATER_ID")));
				// 削除フラグ
				entity.setDeleteFlag(ObjectConverter.intValue(rs.getObject("DELETE_FLAG")));

				return entity;
			}
		}
		return null;
	}

	/**
	 * 登録
	 * @param entity
	 * @throws Exception
	 */
	public void insert(AccountEntity entity) throws Exception {

		try (PreparedStatement statement = cp.getPreparedStatement(INSERT_SQL)) {

			// 取引先名
			statement.setObject(1, entity.getAccountName());
			// 親取引先
			statement.setObject(2, entity.getParentId());
			// 取引先番号
			statement.setObject(3, entity.getAccountNo());
			// 取引部門
			statement.setObject(4, entity.getDepartment());
			// 種別
			statement.setObject(5, entity.getType());
			// 業種
			statement.setObject(6, entity.getIndustry());
			// 年間売上
			statement.setObject(7, entity.getAmount());
			// 評価
			statement.setObject(8, entity.getEvaluation());
			// 電話
			statement.setObject(9, entity.getPhone());
			// FAX
			statement.setObject(10, entity.getFax());
			// URL
			statement.setObject(11, entity.getUrl());
			// 証券コード
			statement.setObject(12, entity.getStockCode());
			// 郵便番号
			statement.setObject(13, entity.getPostalCode());
			// 都道府県
			statement.setObject(14, entity.getDivision());
			// 市区郡
			statement.setObject(15, entity.getCity());
			// 町名・番地・建物
			statement.setObject(16, entity.getTown());
			// その他
			statement.setObject(17, entity.getNote());
			// 作成日時
			statement.setObject(18, entity.getCreateDate());
			// 作成者ID
			statement.setObject(19, entity.getCreaterId());
			// 更新日時
			statement.setObject(20, entity.getUpdateDate());
			// 更新者ID
			statement.setObject(21, entity.getUpdaterId());

			// SQL実行
			statement.executeUpdate();
		}

	}

	/**
	 * 見込み客一覧用のWhere句作成処理
	 * @param entity
	 * @param offset
	 * @param isSelect
	 * @return
	 */
	private String createWhereForAccountList(AccountEntity entity, Integer offset, boolean isSelect) {

		StringBuilder sb = new StringBuilder();

		// 取引先名
		if (!StringValidater.isEmpty(entity.getAccountName())) {
			sb.append(" T1.ACCOUNT_NAME LIKE '");
			sb.append(entity.getAccountName());
			sb.append("%' AND ");
		}

		if (sb.length() != 0) {
			sb.insert(0, " WHERE ");
			sb.delete(sb.length() - 5, sb.length() - 1);
		}

		sb.append(" ORDER BY T1.ACCOUNT_ID ");
		if(isSelect) {
			sb.append(" LIMIT ");
			sb.append(Limit.LIST_ROW_LIMIT);
			sb.append(" OFFSET ");
			sb.append(offset);
		}

		return sb.toString();
	}

}
