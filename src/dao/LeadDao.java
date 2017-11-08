package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.entity.LeadEntity;

/**
 * 見込み客Dao
 *
 */
public class LeadDao {

	/**
	 * 新規登録
	 * @param entity
	 * @return
	 */
	public boolean insert(LeadEntity entity) throws ClassNotFoundException, SQLException {

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			Class.forName("org.sqlite.JDBC");

			connection = DriverManager.getConnection("jdbc:sqlite:/c:/db/sfa.db");

			String sql = "INSERT INTO T_LEAD(LAST_NAME, FIRST_NAME, COMPANY_NAME, POSITION, SOURCE, STATUS, ESTIMATION, PHONE, MOBILE_PHONE, FAX, MAIL, URL, INDUSTRY, AMOUNT, EMPLOYEE, POSTAL_CODE, DIVISION, CITY, TOWN, NOTE, CREATE_DATE, CREATER_ID, UPDATE_DATE, UPDATER_ID) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			statement = connection.prepareStatement(sql);

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

		} catch (ClassNotFoundException e) {
			throw e;
		} catch (SQLException e) {
			throw e;
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				throw e;
			}
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw e;
			}
		}

		return true;
	}
}
