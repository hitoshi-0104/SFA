package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.entity.LeadEntity;

/**
 * 見込み客Dao
 *
 */
public class LeadDao {

	/** selectByIdメソッドで使用するSQL */
	private static final String SELECT_BY_ID_SQL = "SELECT * FROM T_LEAD WHERE LEAD_ID = ?";
	/** insertメソッドで使用するSQL */
	private static final String INSERT_SQL = "INSERT INTO T_LEAD(LAST_NAME, FIRST_NAME, COMPANY_NAME, POSITION, SOURCE, STATUS, ESTIMATION, PHONE, MOBILE_PHONE, FAX, MAIL, URL, INDUSTRY, AMOUNT, EMPLOYEE, POSTAL_CODE, DIVISION, CITY, TOWN, NOTE, CREATE_DATE, CREATER_ID, UPDATE_DATE, UPDATER_ID) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	/**
	 * IDを指定して見込み客を取得
	 * @param Id
	 * @return
	 * @throws Exception
	 */
	public LeadEntity selectById(Integer Id) throws Exception {

		try (ConnectionProvider cp = ConnectionProvider.getInstance();
				PreparedStatement statement = cp.getPreparedStatement(SELECT_BY_ID_SQL);) {

			// ID
			statement.setInt(1, Id);

			// SQL実行
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				LeadEntity entity = new LeadEntity();
				// ID
				entity.setId(rs.getString("LEAD_ID"));
				// 姓
				entity.setLastName(rs.getString("LAST_NAME"));
				// 名
				entity.setFirstName(rs.getString("FIRST_NAME"));
				// 会社名
				entity.setCompanyName(rs.getString("COMPANY_NAME"));
				// 役職
				entity.setPosition(rs.getString("POSITION"));
				// ソース
				entity.setSourceCode(rs.getString("SOURCE"));
				// 状態
				entity.setStatusCode(rs.getString("STATUS"));
				// 評価
				entity.setEstimationCode(rs.getString("ESTIMATION"));
				// 電話
				entity.setPhone(rs.getString("PHONE"));
				// 携帯
				entity.setMobilePhone(rs.getString("MOBILE_PHONE"));
				// FAX
				entity.setFax(rs.getString("FAX"));
				// メール
				entity.setMailAddress(rs.getString("MAIL"));
				// URL
				entity.setUrl(rs.getString("URL"));
				// 業種
				entity.setIndustryCode(rs.getString("INDUSTRY"));
				// 年間売上
				entity.setAmount(rs.getLong("AMOUNT"));
				// 従業員数
				entity.setEmployees(rs.getInt("EMPLOYEE"));
				// 郵便番号
				entity.setPostalCode(rs.getString("POSTAL_CODE"));
				// 都道府県
				entity.setDivisionCode(rs.getString("DIVISION"));
				// 市区郡
				entity.setCity(rs.getString("CITY"));
				// 町名・番地・建物名
				entity.setTown(rs.getString("TOWN"));
				// その他
				entity.setNote(rs.getString("NOTE"));
				// 作成日
				entity.setCreateDate(rs.getString("CREATE_DATE"));
				// 作成者
				entity.setCreaterId(rs.getString("CREATER_ID"));
				// 更新日
				entity.setUpdateDate(rs.getString("UPDATE_DATE"));
				// 更新者
				entity.setUpdaterId("UPDATER_ID");

				return entity;
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

		try (ConnectionProvider cp = ConnectionProvider.getInstance();
				PreparedStatement statement = cp.getPreparedStatement(INSERT_SQL);) {
			// 姓
			statement.setString(1, entity.getLastName());
			// 名
			statement.setString(2, entity.getFirstName());
			// 会社名
			statement.setString(3, entity.getCompanyName());
			// 役職
			statement.setString(4, entity.getPosition());
			// ソース
			statement.setString(5, entity.getSourceCode());
			// 状態
			statement.setString(6, entity.getStatusCode());
			// 評価
			statement.setString(7, entity.getEstimationCode());
			// 電話
			statement.setString(8, entity.getPhone());
			// 携帯
			statement.setString(9, entity.getMobilePhone());
			// FAX
			statement.setString(10, entity.getFax());
			// メール
			statement.setString(11, entity.getMailAddress());
			// URL
			statement.setString(12, entity.getUrl());
			// 業種
			statement.setString(13, entity.getIndustryCode());
			// 年間売上
			statement.setLong(14, entity.getAmount());
			// 従業員数
			statement.setInt(15, entity.getEmployees());
			// 郵便番号
			statement.setString(16, entity.getPostalCode());
			// 都道府県
			statement.setString(17, entity.getDivisionCode());
			// 市区郡
			statement.setString(18, entity.getCity());
			// 町名・番地・建物名
			statement.setString(19, entity.getTown());
			// その他
			statement.setString(20, entity.getNote());
			// 作成日
			statement.setString(21, entity.getCreateDate());
			// 作成者
			statement.setString(22, entity.getCreaterId());
			// 更新日
			statement.setString(23, entity.getUpdateDate());
			// 更新者
			statement.setString(24, entity.getUpdaterId());

			// SQL実行
			statement.executeUpdate();
		}
	}
}
