package action.lead;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import action.lead.bean.CreateBean;
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

		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();

		ShowAction sa = new ShowAction(request, response);
		String ret = "";
		try {
			ret = sa.handle();
		} catch (Exception e) {
			fail(e.getMessage());
			return;
		}

		assertEquals(JspPath.Lead.CREATE, ret);

		CreateBean bean = (CreateBean)request.getAttribute("leadBean");
		assertNotEquals(null, bean);

		// ソース
		assertNotEquals(null, bean.getSourceMap());
		// 状況
		assertNotEquals(null, bean.getStatusMap());
		// 評価
		assertNotEquals(null, bean.getEstimationMap());
		// 業種
		assertNotEquals(null, bean.getIndustryMap());
		// 都道府県
		assertNotEquals(null, bean.getDivisionMap());
	}

}
