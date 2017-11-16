package dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import dao.entity.SequenceEntity;

class SequenceDaoTest {

	@Test
	void testSelectByName() {

		ConnectionProvider cp = ConnectionProvider.getInstance();

		SequenceDao dao = new SequenceDao(cp);

		SequenceEntity en = null;
		try (Connection conn = cp.getConnection()) {
			en = dao.selectByName("T_LEAD");
		} catch (Exception e) {
			fail(e.getMessage());
			return;
		}

		assertNotEquals(null, en);
		assertEquals("T_LEAD", en.getName());

	}

}
