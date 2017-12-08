package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.base.BaseDao;
import dao.entity.LeadEntity;
import dao.entity.LeadListEntity;
import util.constant.ClassCode1;
import util.converter.ObjectConverter;
import util.validate.StringValidater;

/**
 * 見込み客Dao
 *
 */
public class LeadDao extends BaseDao {

	/** selectByIdメソッドで使用するSQL */
	private static final String SELECT_BY_ID_SQL = "SELECT * FROM T_LEAD WHERE LEAD_ID = ?";
	/** selectForLeadListメソッドで使用するSQL */
	private static final String SELECT_FOR_LEAD_LIST_SQL = "SELECT T1.LEAD_ID, T1.LAST_NAME, T1.FIRST_NAME, T1.COMPANY_NAME, T1.SOURCE, T2.CODE2_NAME AS SOURCE_NAME, T1.STATUS, T3.CODE2_NAME AS STATUS_NAME, T1.ESTIMATION, T4.CODE2_NAME AS ESTIMATION_NAME, T1.INDUSTRY, T5.CODE2_NAME AS INDUSTRY_NAME, T1.DIVISION, T6.NAME AS DIVISION_NAME FROM T_LEAD T1 LEFT JOIN M_CLASS T2 ON T1.SOURCE = T2.CODE2 AND T2.CODE1 = ? LEFT JOIN M_CLASS T3 ON T1.STATUS = T3.CODE2 AND T3.CODE1 = ? LEFT JOIN M_CLASS T4 ON T1.ESTIMATION = T4.CODE2 AND T4.CODE1 = ? LEFT JOIN M_CLASS T5 ON T1.INDUSTRY = T5.CODE2 AND T5.CODE1 = ? LEFT JOIN M_DIVISION T6 ON T1.DIVISION = T6.CODE";
	/** countAllメソッドで使用するSQL */
	private static final String COUNT_BY_ID_SQL = "SELECT COUNT(*) FROM T_LEAD";
	/** insertメソッドで使用するSQL */
	private static final String INSERT_SQL = "INSERT INTO T_LEAD(LAST_NAME, FIRST_NAME, COMPANY_NAME, POSITION, SOURCE, STATUS, ESTIMATION, PHONE, MOBILE_PHONE, FAX, MAIL, URL, INDUSTRY, AMOUNT, EMPLOYEE, POSTAL_CODE, DIVISION, CITY, TOWN, NOTE, CREATE_DATE, CREATER_ID, UPDATE_DATE, UPDATER_ID) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	/** updateメソッドで使用するSQL */
	private static final String UPDATE_SQL = "UPDATE T_LEAD SET LAST_NAME = ?, FIRST_NAME = ?, COMPANY_NAME = ?, POSITION = ?, SOURCE = ?, STATUS = ?, ESTIMATION = ?, PHONE = ?, MOBILE_PHONE = ?, FAX = ?, MAIL = ?, URL = ?, INDUSTRY = ?, AMOUNT = ?, EMPLOYEE = ?, POSTAL_CODE = ?, DIVISION = ?, CITY = ?, TOWN = ?, NOTE = ?, UPDATE_DATE = ?, UPDATER_ID = ? WHERE LEAD_ID = ?";
	/** deleteメソッドで使用するSQL */
	private static final String DELETE_BY_ID_SQL = "DELETE FROM T_LEAD WHERE LEAD_ID = ?";

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
			statement.setObject(1, Id);

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
				entity.setAmount(ObjectConverter.longValue(rs.getObject("AMOUNT")));
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
	 * 見込み客一覧の検索
	 * @param entity
	 * @return
	 */
	public List<LeadListEntity> selectForLeadList(LeadEntity entity) throws Exception {

		StringBuilder sb = new StringBuilder();

		// 姓
		if (!StringValidater.isEmpty(entity.getLastName())) {
			sb.append(" T1.LAST_NAME LIKE '");
			sb.append(entity.getLastName());
			sb.append("%' AND ");
		}
		// 名
		if (!StringValidater.isEmpty(entity.getFirstName())) {
			sb.append(" T1.FIRST_NAME LIKE '");
			sb.append(entity.getFirstName());
			sb.append("%' AND ");
		}
		// 会社名
		if (!StringValidater.isEmpty(entity.getCompanyName())) {
			sb.append(" T1.COMPANY_NAME LIKE '");
			sb.append(entity.getCompanyName());
			sb.append("%' AND ");
		}
		// ソース
		if (!StringValidater.isEmpty(entity.getSourceCode())) {
			sb.append(" T1.SOURCE = '");
			sb.append(entity.getSourceCode());
			sb.append("' AND ");
		}
		// 状況
		if (!StringValidater.isEmpty(entity.getStatusCode())) {
			sb.append(" T1.STATUS = '");
			sb.append(entity.getStatusCode());
			sb.append("' AND ");
		}
		// 評価
		if (!StringValidater.isEmpty(entity.getEstimationCode())) {
			sb.append(" T1.ESTIMATION = '");
			sb.append(entity.getEstimationCode());
			sb.append("' AND ");
		}
		// 業種
		if (!StringValidater.isEmpty(entity.getIndustryCode())) {
			sb.append(" T1.INDUSTRY = '");
			sb.append(entity.getIndustryCode());
			sb.append("' AND ");
		}
		// 都道府県
		if (!StringValidater.isEmpty(entity.getDivisionCode())) {
			sb.append(" T1.DIVISION = '");
			sb.append(entity.getDivisionCode());
			sb.append("' AND ");
		}

		if (sb.length() != 0) {
			sb.insert(0, " WHERE ");
			sb.delete(sb.length() - 5, sb.length() - 1);
		}

		sb.append(" ORDER BY T1.LEAD_ID ");

		try (PreparedStatement statement = cp.getPreparedStatement(SELECT_FOR_LEAD_LIST_SQL + sb.toString());) {

			// ソース
			statement.setString(1, ClassCode1.SOURCE);
			// 状況
			statement.setString(2, ClassCode1.LEAD_STATUS);
			// 評価
			statement.setString(3, ClassCode1.ESTIMATION);
			// 業種
			statement.setString(4, ClassCode1.INDUSTRY);

			// SQL実行
			ResultSet rs = statement.executeQuery();

			// データ取得
			List<LeadListEntity> list = new ArrayList<LeadListEntity>();
			while(rs.next()) {

				LeadListEntity en = new LeadListEntity();

				// ID
				en.setId((Integer)rs.getObject("LEAD_ID"));
				// 姓
				en.setLastName((String)rs.getObject("LAST_NAME"));
				// 名
				en.setFirstName((String)rs.getObject("FIRST_NAME"));
				// 会社名
				en.setCompanyName((String)rs.getObject("COMPANY_NAME"));
				// ソース名称
				en.setSourceName((String)rs.getObject("SOURCE_NAME"));
				// 状況名称
				en.setStatusName((String)rs.getObject("STATUS_NAME"));
				// 評価名称
				en.setEstimationName((String)rs.getObject("ESTIMATION_NAME"));
				// 業種名称
				en.setIndustryName((String)rs.getObject("INDUSTRY_NAME"));
				// 都道府県名称
				en.setDivisionName((String)rs.getObject("DIVISION_NAME"));

				list.add(en);
			}
			return list;
		}
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

	/**
	 * 更新
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public void update(LeadEntity entity) throws Exception {

		try (PreparedStatement statement = cp.getPreparedStatement(UPDATE_SQL);) {

			// 更新項目

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
			// 更新日
			statement.setObject(21, entity.getUpdateDate());
			// 更新者
			statement.setObject(22, entity.getUpdaterId());

			// 更新条件

			// ID
			statement.setObject(23, entity.getId());

			// SQL実行
			statement.executeUpdate();
		}
	}

	/**
	 * IDを指定して見込み客を削除する
	 * @param id
	 * @throws Exception
	 */
	public void deleteById(String id) throws Exception {

		try (PreparedStatement statement = cp.getPreparedStatement(DELETE_BY_ID_SQL)) {

			// ID
			statement.setObject(1, id);

			// SQL実行
			statement.executeUpdate();

		}
	}
}
