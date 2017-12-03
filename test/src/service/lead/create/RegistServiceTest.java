package service.lead.create;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;

import dao.ConnectionProvider;
import dao.LeadDao;
import service.lead.common.LeadValidater;
import service.lead.dto.LeadDto;
import util.session.SessionInfo;

/**
 * RegistServiceクラスのテストクラス
 *
 */
class RegistServiceTest {

	/**
	 * Validateメソッドのテスト
	 */
	@Test
	void testValidate() {

		RegistService service = new RegistService();
		Map<String, String> messageMap = null;
		LeadDto dto = new LeadDto();
		LeadValidater valid = new LeadValidater();

		// 姓：必須入力
		dto.setLastName("");
		messageMap = valid.validate(dto, "001");
		assertEquals(true, messageMap.containsKey("E00100201"));
		dto.setLastName("あ");
		messageMap = valid.validate(dto, "001");
		assertEquals(false, messageMap.containsKey("E00100201"));

		// 姓：最大桁数チェック
		dto.setLastName("０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０");
		messageMap = valid.validate(dto, "001");
		assertEquals(true, messageMap.containsKey("E00100202"));
		dto.setLastName("０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９");
		messageMap = valid.validate(dto, "001");
		assertEquals(false, messageMap.containsKey("E00100202"));

		// 名：最大桁数チェック
		dto.setFirstName("０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０");
		messageMap = valid.validate(dto, "001");
		assertEquals(true, messageMap.containsKey("E00100302"));
		dto.setFirstName("０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９");
		messageMap = valid.validate(dto, "001");
		assertEquals(false, messageMap.containsKey("E00100302"));

		// 会社名：必須入力
		dto.setCompanyName("");
		messageMap = valid.validate(dto, "001");
		assertEquals(true, messageMap.containsKey("E00100401"));
		dto.setCompanyName("あ");
		messageMap = valid.validate(dto, "001");
		assertEquals(false, messageMap.containsKey("E00100401"));

		// 会社名：最大桁数チェック
		dto.setCompanyName("０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０");
		messageMap = valid.validate(dto, "001");
		assertEquals(true, messageMap.containsKey("E00100402"));
		dto.setCompanyName("０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９");
		messageMap = valid.validate(dto, "001");
		assertEquals(false, messageMap.containsKey("E00100402"));

		// 役職名：最大桁数チェック
		dto.setPosition("０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０");
		messageMap = valid.validate(dto, "001");
		assertEquals(true, messageMap.containsKey("E00100502"));
		dto.setPosition("０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９");
		messageMap = valid.validate(dto, "001");
		assertEquals(false, messageMap.containsKey("E00100502"));

		// 状況：必須入力チェック
		dto.setStatusCode("");
		messageMap = valid.validate(dto, "001");
		assertEquals(true, messageMap.containsKey("E00100701"));
		dto.setStatusCode("01");
		messageMap = valid.validate(dto, "001");
		assertEquals(false, messageMap.containsKey("E00100701"));

		// 電話：最大桁数チェック
		dto.setPhone("012345678901");
		messageMap = valid.validate(dto, "001");
		assertEquals(true, messageMap.containsKey("E00100902"));
		dto.setPhone("01234567890");
		messageMap = valid.validate(dto, "001");
		assertEquals(false, messageMap.containsKey("E00100902"));

		// 電話：数値のみチェック
		dto.setPhone("あいうえお");
		messageMap = valid.validate(dto, "001");
		assertEquals(true, messageMap.containsKey("E00100904"));
		dto.setPhone("0");
		messageMap = valid.validate(dto, "001");
		assertEquals(false, messageMap.containsKey("E00100904"));

		// 携帯：最大桁数チェック
		dto.setMobilePhone("012345678901");
		messageMap = valid.validate(dto, "001");
		assertEquals(true, messageMap.containsKey("E00101002"));
		dto.setMobilePhone("01234567890");
		messageMap = valid.validate(dto, "001");
		assertEquals(false, messageMap.containsKey("E00101002"));

		// 携帯：数値のみチェック
		dto.setMobilePhone("あいうえお");
		messageMap = valid.validate(dto, "001");
		assertEquals(true, messageMap.containsKey("E00101004"));
		dto.setMobilePhone("0");
		messageMap = valid.validate(dto, "001");
		assertEquals(false, messageMap.containsKey("E00101004"));

		// FAX：最大桁数チェック
		dto.setFax("01234567890123456");
		messageMap = valid.validate(dto, "001");
		assertEquals(true, messageMap.containsKey("E00101102"));
		dto.setFax("0123456789012345");
		messageMap = valid.validate(dto, "001");
		assertEquals(false, messageMap.containsKey("E00101102"));

		// FAX：数値のみチェック
		dto.setFax("あいうえお");
		messageMap = valid.validate(dto, "001");
		assertEquals(true, messageMap.containsKey("E00101104"));
		dto.setFax("0");
		messageMap = valid.validate(dto, "001");
		assertEquals(false, messageMap.containsKey("E00101104"));

		// メール：最大桁数チェック
		dto.setMailAddress("012345678@0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456");
		messageMap = valid.validate(dto, "001");
		assertEquals(true, messageMap.containsKey("E00101202"));
		dto.setMailAddress("012345678@012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345");
		messageMap = valid.validate(dto, "001");
		assertEquals(false, messageMap.containsKey("E00101202"));

		// メール：メールアドレスフォーマットチェック
		dto.setMailAddress("abc");
		messageMap = valid.validate(dto, "001");
		assertEquals(true, messageMap.containsKey("E00101205"));
		dto.setMailAddress("abc@abc.com");
		messageMap = valid.validate(dto, "001");
		assertEquals(false, messageMap.containsKey("E00101205"));

		// URL：最大桁数チェック
		dto.setUrl("http://78901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678");
		messageMap = valid.validate(dto, "001");
		assertEquals(true, messageMap.containsKey("E00101302"));
		dto.setUrl("http://7890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567");
		messageMap = valid.validate(dto, "001");
		assertEquals(false, messageMap.containsKey("E00101302"));

		// URL：URLフォーマットチェック
		dto.setUrl("abc");
		messageMap = valid.validate(dto, "001");
		assertEquals(true, messageMap.containsKey("E00101306"));
		dto.setUrl("http://abc.com");
		messageMap = valid.validate(dto, "001");
		assertEquals(false, messageMap.containsKey("E00101306"));

		// 年間売上：最大桁数チェック
		dto.setAmount(12345678901234L);
		messageMap = valid.validate(dto, "001");
		assertEquals(true, messageMap.containsKey("E00101402"));
		dto.setAmount(1234567890123L);
		messageMap = valid.validate(dto, "001");
		assertEquals(false, messageMap.containsKey("E00101402"));

		// 従業員数：最大桁数チェック
		dto.setEmployees(12345678);
		messageMap = valid.validate(dto, "001");
		assertEquals(true, messageMap.containsKey("E00101602"));
		dto.setEmployees(1234567);
		messageMap = valid.validate(dto, "001");
		assertEquals(false, messageMap.containsKey("E00101602"));

		// 郵便番号：最大桁数チェック
		dto.setPostalCode("01234567");
		messageMap = valid.validate(dto, "001");
		assertEquals(true, messageMap.containsKey("E00101702"));
		dto.setPostalCode("0123456");
		messageMap = valid.validate(dto, "001");
		assertEquals(false, messageMap.containsKey("E00101702"));

		// 郵便番号：数値のみチェック
		dto.setPostalCode("あいうえお");
		messageMap = valid.validate(dto, "001");
		assertEquals(true, messageMap.containsKey("E00101704"));
		dto.setPostalCode("0123456");
		messageMap = valid.validate(dto, "001");
		assertEquals(false, messageMap.containsKey("E00101704"));

		// 市区町村：最大桁数チェック
		dto.setCity("０１２３４５６７８９０");
		messageMap = valid.validate(dto, "001");
		assertEquals(true, messageMap.containsKey("E00101902"));
		dto.setCity("０１２３４５６７８９");
		messageMap = valid.validate(dto, "001");
		assertEquals(false, messageMap.containsKey("E00101902"));

		// 町名・番地・建物名：最大桁数チェック
		dto.setCity("０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０");
		messageMap = valid.validate(dto, "001");
		assertEquals(true, messageMap.containsKey("E00102002"));
		dto.setCity("０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９");
		messageMap = valid.validate(dto, "001");
		assertEquals(false, messageMap.containsKey("E00102002"));

		// その他：最大桁数チェック
		dto.setCity("０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０");
		messageMap = valid.validate(dto, "001");
		assertEquals(true, messageMap.containsKey("E00102102"));
		dto.setCity("０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９");
		messageMap = valid.validate(dto, "001");
		assertEquals(false, messageMap.containsKey("E00102102"));
	}

	/**
	 * Insertメソッドのテスト
	 */
	@Test
	void testInsert() {

		ConnectionProvider cp = ConnectionProvider.getInstance();

		LeadDao dao = new LeadDao(cp);
		Integer i = null;
		try (Connection conn = cp.getConnection()) {
			i = dao.countAll();
		} catch (Exception e) {
			fail(e.getMessage());
			return;
		}

		MockHttpServletRequest request = new MockHttpServletRequest();

		RegistService rs = new RegistService();
		try (Connection conn = cp.getConnection()) {
			// SessionInfo
			SessionInfo si = new SessionInfo();
			si.setLoginUserId(0);
			rs.insert(si, new LeadDto());
		} catch (Exception e) {
			fail(e.getMessage());
			return;
		}

		Integer j = null;
		try (Connection conn = cp.getConnection()) {
			j = dao.countAll();
		} catch (Exception e) {
			fail(e.getMessage());
			return;
		}

		i++;
		assertEquals(i, j);
	}

}
