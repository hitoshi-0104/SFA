package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.base.BaseDao;
import dao.entity.LeadEntity;

/**
 * 見込み客Dao
 *
 */
public class LeadDao extends BaseDao {

	/** selectByIdメソッドで使用するSQL */
	private static final String SELECT_BY_ID_SQL = "SELECT * FROM T_LEAD WHERE LEAD_ID = ?";
	/** countAllメソッドで使用するSQL */
	private static final String COUNT_BY_ID_SQL = "SELECT COUNT(*) FROM T_LEAD";
	/** insertメソッドで使用するSQL */
	private static final String INSERT_SQL = "INSERT INTO T_LEAD(LAST_NAME, FIRST_NAME, COMPANY_NAME, POSITION, SOURCE, STATUS, ESTIMATION, PHONE, MOBILE_PHONE, FAX, MAIL, URL, INDUSTRY, AMOUNT, EMPLOYEE, POSTAL_CODE, DIVISION, CITY, TOWN, NOTE, CREATE_DATE, CREATER_ID, UPDATE_DATE, UPDATER_ID) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	/**
	 * コンストラクタ
	 * @param cp
	 */
	public LeadDao(ConnectionProvider cp) {
		super(cp);
	}

	/**
	 * IDを指定して見込み客を取得
	 * @param Id
	 * @return
	 * @throws Exception
	 */
	public LeadEntity selectById(Integer Id) throws Exception {

		try (PreparedStatement statement = cp.getPreparedStatement(SELECT_BY_ID_SQL);) {

			// ID
			statement.setInt(1, Id);

			// SQL実行
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				LeadEntity entity = new LeadEntity();
				// ID
				entity.setId((Integer)rs.getObject("LEAD_ID"));
				// 姓
				entity.setLastName((String)rs.getObject("LAST_NAME"));
				// 名
				entity.setFirstName((String)rs.getObject("FIRST_NAME"));
				// 会社名
				entity.setCompanyName((String)rs.getObject("COMPANY_NAME"));
				// 役職
				entity.setPosition((String)rs.getObject("POSITION"));
				// ソース
				entity.setSourceCode((String)rs.getObject("SOURCE"));
				// 状態
				entity.setStatusCode((String)rs.getObject("STATUS"));
				// 評価
				entity.setEstimationCode((String)rs.getObject("ESTIMATION"));
				// 電話
				entity.setPhone((String)rs.getObject("PHONE"));
				// 携帯
				entity.setMobilePhone((String)rs.getObject("MOBILE_PHONE"));
				// FAX
				entity.setFax((String)rs.getObject("FAX"));
				// メール
				entity.setMailAddress((String)rs.getObject("MAIL"));
				// URL
				entity.setUrl((String)rs.getObject("URL"));
				// 業種
				entity.setIndustryCode((String)rs.getObject("INDUSTRY"));
				// 年間売上
				entity.setAmount((Long)rs.getObject("AMOUNT"));
				// 従業員数
				entity.setEmployees((Integer)rs.getObject("EMPLOYEE"));
				// 郵便番号
				entity.setPostalCode((String)rs.getObject("POSTAL_CODE"));
				// 都道府県
				entity.setDivisionCode((String)rs.getObject("DIVISION"));
				// 市区郡
				entity.setCity((String)rs.getObject("CITY"));
				// 町名・番地・建物名
				entity.setTown((String)rs.getObject("TOWN"));
				// その他
				entity.setNote((String)rs.getObject("NOTE"));
				// 作成日
				entity.setCreateDate((String)rs.getObject("CREATE_DATE"));
				// 作成者
				entity.setCreaterId((Integer)rs.getObject("CREATER_ID"));
				// 更新日
				entity.setUpdateDate((String)rs.getObject("UPDATE_DATE"));
				// 更新者
				entity.setUpdaterId((Integer)rs.getObject("UPDATER_ID"));

				return entity;
			}
		}
		return null;
	}

	/**
	 * 見込み客テーブルの件数取得
	 * @return
	 * @throws Exception
	 */
	public Integer countAll() throws Exception {

		try (PreparedStatement statement = cp.getPreparedStatement(COUNT_BY_ID_SQL);) {

			// SQL実行
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		}
		return null;
	}

	/**
	 * 新規登録
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public void insert(LeadEntity entity) throws Exception {

		try (PreparedStatement statement = cp.getPreparedStatement(INSERT_SQL);) {
			// 姓
			statement.setObject(1, entity.getLastName());
			// 名
			statement.setObject(2, entity.getFirstName());
			// 会社名
			statement.setObject(3, entity.getCompanyName());
			// 役職
			statement.setObject(4, entity.getPosition());
			// ソース
			statement.setObject(5, entity.getSourceCode());
			// 状態
			statement.setObject(6, entity.getStatusCode());
			// 評価
			statement.setObject(7, entity.getEstimationCode());
			// 電話
			statement.setObject(8, entity.getPhone());
			// 携帯
			statement.setObject(9, entity.getMobilePhone());
			// FAX
			statement.setObject(10, entity.getFax());
			// メール
			statement.setObject(11, entity.getMailAddress());
			// URL
			statement.setObject(12, entity.getUrl());
			// 業種
			statement.setObject(13, entity.getIndustryCode());
			// 年間売上
			statement.setObject(14, entity.getAmount());
			// 従業員数
			statement.setObject(15, entity.getEmployees());
			// 郵便番号
			statement.setObject(16, entity.getPostalCode());
			// 都道府県
			statement.setObject(17, entity.getDivisionCode());
			// 市区郡
			statement.setObject(18, entity.getCity());
			// 町名・番地・建物名
			statement.setObject(19, entity.getTown());
			// その他
			statement.setObject(20, entity.getNote());
			// 作成日
			statement.setObject(21, entity.getCreateDate());
			// 作成者
			statement.setObject(22, entity.getCreaterId());
			// 更新日
			statement.setObject(23, entity.getUpdateDate());
			// 更新者
			statement.setObject(24, entity.getUpdaterId());

			// SQL実行
			statement.executeUpdate();
		}
	}
}
