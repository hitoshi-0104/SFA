package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.entity.SequenceEntity;

/**
 * シーケンスDao
 *
 */
public class SequenceDao {

	private static final String SELECT_BY_NAME_SQL = "SELECT * FROM sqlite_sequence WHERE name = ?";

	public SequenceEntity selectByName(String name) throws Exception {

		try (ConnectionProvider cp = ConnectionProvider.getInstance();
				PreparedStatement statement = cp.getPreparedStatement(SELECT_BY_NAME_SQL);) {

			// name
			statement.setString(1, name);

			// SQL実行
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				SequenceEntity entity = new SequenceEntity();
				// name
				entity.setName(rs.getString("name"));
				// seq
				entity.setSeq(rs.getInt("seq"));

				return entity;
			}
		}
		return null;
	}

}
