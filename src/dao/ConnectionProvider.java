package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

/**
 * データアクセス補助クラス
 *
 */
public class ConnectionProvider implements AutoCloseable {

	/** データアクセス補助クラス */
	private static ConnectionProvider instance;
	/** コネクション */
	private Connection connection;
	/** ステートメント */
	private PreparedStatement statement;

	/**
	 * コンストラクタ
	 */
	private ConnectionProvider( ) {

	}

	/**
	 * インスタンス生成
	 * @return
	 */
	public static synchronized ConnectionProvider getInstance() {
		if (instance == null) {
			instance = new ConnectionProvider();
		}
		return instance;
	}

	/**
	 * コネクションの生成
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		if (connection == null || connection.isClosed()) {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:/c:/db/sfa.db");
		}
		return connection;
	}

	/**
	 * ステートメントの生成
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public PreparedStatement getPreparedStatement(String sql) throws SQLException {
		statement = connection.prepareStatement(sql);
		return statement;
	}

	/**
	 * トランザクション開始
	 * @throws SQLException
	 */
	public void beginTransaction() throws SQLException {
		connection.setAutoCommit(false);
	}

	/**
	 * セーブポイントのセット
	 * @return
	 * @throws SQLException
	 */
	public Savepoint setSavepoint() throws SQLException {
		return connection.setSavepoint();
	}

	/**
	 * コミット
	 * @throws SQLException
	 */
	public void commit() throws SQLException {
		connection.commit();
	}

	/**
	 * ロールバック
	 * @throws SQLException
	 */
	public void rollback() throws SQLException {
		connection.rollback();
	}

	/**
	 * セーブポイントまでロールバック
	 * @param sp
	 * @throws SQLException
	 */
	public void rollback(Savepoint sp) throws SQLException {
		connection.rollback(sp);
	}

	/**
	 * クローズ処理
	 */
	@Override
	public void close() throws Exception {
		if (statement != null) {
			statement.close();
		}
		if (connection != null) {
			connection.close();
		}
	}

}
