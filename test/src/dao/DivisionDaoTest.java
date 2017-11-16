package dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.List;

import org.junit.jupiter.api.Test;

import dao.entity.DivisionEntity;

/**
 * DivisionDaoクラスのテストクラス
 *
 */
class DivisionDaoTest {

	/**
	 * selectAllメソッドのテスト
	 */
	@Test
	void testSelectAll() {

		ConnectionProvider cp = ConnectionProvider.getInstance();

		DivisionDao dao = new DivisionDao(cp);

		List<DivisionEntity> list = null;
		Integer count = null;
		try (Connection conn = cp.getConnection()) {
			list = dao.selectAll();
			count = dao.countAll();
		} catch (Exception e) {
			fail(e.getMessage());
			return;
		}

		assertNotEquals(null, list);
		assertNotEquals(null, count);
		assertEquals(count, (Integer)list.size());

	}

}
