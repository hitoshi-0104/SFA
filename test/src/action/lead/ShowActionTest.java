package action.lead;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import action.lead.create.ShowAction;
import util.constant.JspPath;

/**
 * action.lead.create.ShowActionクラスのテスト
 *
 */
class ShowActionTest {

	/**
	 * handleメソッドのテスト
	 */
	@Test
	void testHandle() {

		ShowAction sa = new ShowAction(null, null);
		String ret = "";
		try {
			ret = sa.handle();
		} catch (Exception e) {
			fail(e.getMessage());
			return;
		}

		assertEquals(JspPath.Lead.CREATE, ret);
	}

}
