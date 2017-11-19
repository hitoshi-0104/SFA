package action.lead.list;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

/**
 * SearchActionクラスのテストクラス
 *
 */
class SearchActionTest {

	/**
	 * handleメソッドのテスト
	 */
	@Test
	void testHandle() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();

		String ret = null;

		try {
			SearchAction action = new SearchAction(request, response);
			ret = action.handle();
		} catch (Exception e) {
			fail(e.getMessage());
			return;
		}

		assertNotEquals(null, ret);

	}

}
