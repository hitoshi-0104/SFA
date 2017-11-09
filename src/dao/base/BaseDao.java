package dao.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.delegate.ICreatePrepareStatement;

/**
 * Daoの基底クラス
 *
 */
public class BaseDao {

	/** コネクション */
	private Connection connection;
	/** ステートメント */
	private PreparedStatement statement;

	/**
	 * コネクションの生成
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void connection() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		connection = DriverManager.getConnection("jdbc:sqlite:/c:/db/sfa.db");
	}

	/**
	 * クローズ
	 * @throws SQLException
	 */
	public void close() throws SQLException {
		if (statement != null) {
			statement.close();
		}
		if (connection != null) {
			connection.close();
		}
	}

	/**
	 * PrepareStatement.executeUpdateの実行
	 * @param stat
	 * @return
	 */
	protected int executeUpdate(String sql, ICreatePrepareStatement stat) throws ClassNotFoundException, SQLException {
		return stat.create(connection, sql).executeUpdate();
	}
}
