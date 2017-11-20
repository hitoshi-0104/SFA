package action.lead.list;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import util.constant.JspPath;

/**
 * ShowActionクラスのテストクラス
 *
 */
class ShowActionTest {

	/**
	 * handleメソッドのテスト
	 */
	@Test
	void testHandle() {

		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();

		String ret = "";

		try {
			ShowAction action = new ShowAction(request, response);
			ret = action.handle();
		} catch (Exception e) {
			fail(e.getMessage());
			return;
		}

		assertEquals(JspPath.Lead.LIST, ret);

	}

}
