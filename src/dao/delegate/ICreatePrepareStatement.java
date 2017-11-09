package dao.delegate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * PrepareStatement作成のインターフェース
 *
 */
public interface ICreatePrepareStatement {

	/**
	 * PrepareStatement作成
	 * @param conn
	 * @param sql
	 * @return
	 */
	public PreparedStatement create(Connection conn, String sql) throws SQLException;

}
