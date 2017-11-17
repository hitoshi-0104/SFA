package action.lead.create;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import action.lead.bean.CreateBean;
import action.lead.constant.ReqParam;
import action.lead.create.RegistAction;
import exception.SalesManagementApplicationException;
import util.constant.JspPath;
import util.session.SessionInfo;

class RegistActionTest {

	/**
	 * handleメソッドテスト
	 * <summary>
	 * リクエストパラメータに必要項目がセットされているときのテスト
	 * </summary>
	 */
	@Test
	void testHandle() {

		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();

		// SessionInfo
		SessionInfo si = new SessionInfo();
		si.setLoginUserId(0);
		request.setAttribute(SessionInfo.SESSION_ATTRIBUTE_NAME, si);

		// 姓
		String lastName = "０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９";
		request.setParameter(ReqParam.Create.LAST_NAME, lastName);
		// 名
		String firstName = "１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０";
		request.setParameter(ReqParam.Create.FIRST_NAME, firstName);
		// 会社名
		String companyName = "０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９";
		request.setParameter(ReqParam.Create.COMPANY_NAME, companyName);
		// 役職名
		String positionName = "２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１";
		request.setParameter(ReqParam.Create.POSITION_NAME, positionName);
		// ソース
		String source = "01";
		request.setParameter(ReqParam.Create.SOURCE, source);
		// 状況
		String status = "02";
		request.setParameter(ReqParam.Create.STATUS, status);
		// 評価
		String estimation = "03";
		request.setParameter(ReqParam.Create.ESTIMATION, estimation);
		// 電話
		String phone = "01234567890";
		request.setParameter(ReqParam.Create.PHONE, phone);
		// 携帯
		String mobilePhone = "12345678901";
		request.setParameter(ReqParam.Create.MOBILE_PHONE, mobilePhone);
		// FAX
		String fax = "0123456789012345";
		request.setParameter(ReqParam.Create.FAX, fax);
		// メール
		String mailAddress = "abcdefghijklmnopqrstuvwxyz123@0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345";
		request.setParameter(ReqParam.Create.MAIL_ADDRESS, mailAddress);
		// URL
		String url = "http://abc0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567";
		request.setParameter(ReqParam.Create.URL, url);
		// 業種
		String industry = "04";
		request.setParameter(ReqParam.Create.INDUSTRY, industry);
		// 年間売上
		String amount = "1234567890123";
		request.setParameter(ReqParam.Create.AMOUNT, amount);
		// 従業員数
		String employee = "1234567";
		request.setParameter(ReqParam.Create.EMPLOYEE, employee);
		// 郵便番号
		String postalCode = "0123456";
		request.setParameter(ReqParam.Create.POSTAL_CODE, postalCode);
		// 都道府県
		String division = "05";
		request.setParameter(ReqParam.Create.DIVISION, division);
		// 市区郡
		String city = "０１２３４５６７８９";
		request.setParameter(ReqParam.Create.CITY, city);
		// 町名・番地・建物名
		String town = "０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９";
		request.setParameter(ReqParam.Create.TOWN, town);
		// その他
		String note = "０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９";
		request.setParameter(ReqParam.Create.NOTE, note);

		String ret = "";
		try {
			RegistAction ra = new RegistAction(request, response);
			ret = ra.handle();
		} catch (Exception e) {
			fail(e.getMessage());
			return;
		}

		assertEquals(JspPath.Lead.LIST, ret);

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

		// 姓
		assertEquals(lastName, bean.getLastName());
		// 名
		assertEquals(firstName, bean.getFirstName());
		// 会社名
		assertEquals(companyName, bean.getCompanyName());
		// 役職名
		assertEquals(positionName, bean.getPosition());
		// ソース
		assertEquals(source, bean.getSourceCode());
		// 状況
		assertEquals(status, bean.getStatusCode());
		// 評価
		assertEquals(estimation, bean.getEstimationCode());
		// 電話
		assertEquals(phone, bean.getPhone());
		// 携帯
		assertEquals(mobilePhone, bean.getMobilePhone());
		// FAX
		assertEquals(fax, bean.getFax());
		// メール
		assertEquals(mailAddress, bean.getMailAddress());
		// URL
		assertEquals(url, bean.getUrl());
		// 業種
		assertEquals(industry, bean.getIndustryCode());
		// 年間売上
		assertEquals(Long.valueOf(amount), bean.getAmount());
		// 従業員数
		assertEquals(Integer.valueOf(employee), bean.getEmployees());
		// 郵便番号
		assertEquals(postalCode, bean.getPostalCode());
		// 都道府県
		assertEquals(division, bean.getDivisionCode());
		// 市区郡
		assertEquals(city, bean.getCity());
		// 町名・番地・建物名
		assertEquals(town, bean.getTown());
		// その他
		assertEquals(note, bean.getNote());
	}

	/**
	 * handleメソッドテスト２
	 * <summary>
	 * リクエストパラメータに必要項目がセットされていないときのテスト
	 * </summary>
	 */
	@Test
	void testHandle2() {

		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();

		// SessionInfo
		SessionInfo si = new SessionInfo();
		si.setLoginUserId(0);
		request.setAttribute(SessionInfo.SESSION_ATTRIBUTE_NAME, si);

		Map<String, String> messageMap = null;
		try {
			RegistAction ra = new RegistAction(request, response);
			ra.handle();
		} catch(SalesManagementApplicationException e) {
			messageMap = e.getMessages();
		} catch (Exception e) {
			fail(e.getMessage());
			return;
		}

		assertNotEquals(null, messageMap);

	}

}
