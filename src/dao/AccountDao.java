package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.base.BaseDao;
import dao.entity.AccountDialogListEntity;
import dao.entity.AccountEntity;
import util.converter.ObjectConverter;
import util.validate.StringValidater;

/**
 * 取引先テーブルDAO
 *
 */
public class AccountDao extends BaseDao {

	/** selectForAccountDialogListメソッドで使用するSQL */
	private static final String SELECT_FOR_ACCOUNT_DIALOG_LIST = "SELECT T1.ACCOUNT_ID, T1.ACCOUNT_NAME, T2.CODE2_NAME AS INDUSTRY, T3.NAME + T1.CITY + T1.TOWN FROM T_ACCOUNT T1 LEFT JOIN M_CLASS T2 ON T1.INDUSTRY = T2.CODE2 AND T2.CODE1 = ? LEFT JOIN M_DIVISION T3 ON T1.DIVISION = T3.DIVISION_ID";
	/** selectMaxIdメソッドで使用するSQL */
	private static final String SELECT_MAX_ID_SQL = "SELECT MAX(ACCOUNT_ID) AS MAX_ID FROM T_ACCOUNT";
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
	 * 取引先検索一覧用の取得処理
	 * @return
	 */
	public List<AccountDialogListEntity> selectForAccountDialogList(AccountEntity entity) throws Exception {

		StringBuilder sb = new StringBuilder();
		if (StringValidater.isEmpty(entity.getAccountName())) {
			sb.append(" WHERE T1.ACCOUNT_NAME LIKE ? ");
		}

		try (PreparedStatement statement = cp.getPreparedStatement(SELECT_FOR_ACCOUNT_DIALOG_LIST + sb.toString())) {

			// 分類：業種
			statement.setObject(1, "004");
			// 取引先名
			statement.setObject(2, entity.getAccountName() + "%");

			ResultSet rs = statement.executeQuery();
			List<AccountDialogListEntity> list = new ArrayList<AccountDialogListEntity>();
			while(rs.next()) {
				AccountDialogListEntity en = new AccountDialogListEntity();
				// ID
				en.setId(ObjectConverter.intValue(rs.getObject("ACCOUNT_ID")));
				// 取引先名
				en.setAccountName(ObjectConverter.stringValue(rs.getObject("ACCOUNT_NAME")));
				// 業種
				en.setIndustry(ObjectConverter.stringValue(rs.getObject("INDUSTRY")));
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
	 * 登録
	 * @param entity
	 * @throws Exception
	 */
	public void insert(AccountEntity entity) throws Exception {

		try (PreparedStatement statement = cp.getPreparedStatement(INSERT_SQL)) {

			// 取引先名
			statement.setObject(1, entity.getAccountName());
			// 親取引先
			statement.setObject(2, entity.getParent());
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

}
