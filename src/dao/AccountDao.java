package dao;

import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import dao.base.BaseDao;
import dao.entity.AccountEntity;

/**
 * 取引先テーブルDAO
 *
 */
public class AccountDao extends BaseDao {

	/** insertメソッドで使用するSQL */
	private static final String INSERT_SQL = "INSERT INTO ACCOUNT (ACCOUNT_NAME, PARENT, ACCOUNT_NO, DEPARTMENT, TYPE, INDUSTRY, AMOUNT, EVALUATION, PHONE, FAX, URL, STOCK_CODE, POSTAL_CODE, DIVISION, CITY, TOWN, NOTE, CREATE_DATE, CREATER_ID, UPDATE_DATE, UPDATER_ID) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	/**
	 * コンストラクタ
	 * @param cp
	 */
	public AccountDao(ConnectionProvider cp) {
		super(cp);
	}

	/**
	 * IDの最大値を取得
	 * @return
	 * @throws Exception
	 */
	public Integer selectMaxId() throws Exception {
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
			// 作成者ID
			statement.setObject(18, entity.getCreaterId());
			// 作成日時
			statement.setObject(19, entity.getCreateDate());
			// 更新者ID
			statement.setObject(20, entity.getUpdaterId());
			// 更新日時
			statement.setObject(21, entity.getUpdateDate());

			// SQL実行
			statement.executeUpdate();
		}

	}

}
