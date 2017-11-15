package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.base.BaseDao;
import dao.entity.SequenceEntity;

/**
 * シーケンスDao
 *
 */
public class SequenceDao extends BaseDao {

	/** selectByNameメソッドで使用するSQL */
	private static final String SELECT_BY_NAME_SQL = "SELECT * FROM sqlite_sequence WHERE name = ?";

	/**
	 * コンストラクタ
	 * @param cp
	 */
	public SequenceDao(ConnectionProvider cp) {
		super(cp);
	}

	/**
	 * Nameを指定してシーケンスを取得
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public SequenceEntity selectByName(String name) throws Exception {

		try (PreparedStatement statement = cp.getPreparedStatement(SELECT_BY_NAME_SQL);) {

			// name
			statement.setString(1, name);

			// SQL実行
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				SequenceEntity entity = new SequenceEntity();
				// name
				entity.setName((String)rs.getObject("name"));
				// seq
				entity.setSeq((Integer)rs.getObject("seq"));

				return entity;
			}
		}
		return null;
	}

}
