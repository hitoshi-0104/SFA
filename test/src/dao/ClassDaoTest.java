package dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.List;

import org.junit.jupiter.api.Test;

import dao.entity.ClassEntity;
import service.constant.ClassCode1;

/**
 * ClassDaoクラスのテスト
 *
 */
class ClassDaoTest {

	/**
	 * selectByCode1メソッドのテスト
	 */
	@Test
	void testSeleceByCode1() {

		ConnectionProvider cp = ConnectionProvider.getInstance();

		ClassDao dao = new ClassDao(cp);

		List<ClassEntity> list = null;
		try (Connection conn = cp.getConnection()) {
			list = dao.seleceByCode1(ClassCode1.SOURCE);
		} catch (Exception e) {
			fail(e.getMessage());
			return;
		}

		for (ClassEntity en : list) {
			assertEquals(en.getCode1(), ClassCode1.SOURCE);
		}

	}

}
