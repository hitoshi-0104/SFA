package dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

import dao.entity.LeadEntity;
import dao.entity.SequenceEntity;

/**
 * LeadDaoクラスUnitテスト
 *
 */
class LeadDaoTest {

	/**
	 * insertメソッドテスト
	 * <summary>
	 * エンティティに値がセットされる時のテスト
	 * </summary>
	 */
	@Test
	void testInsert() {

		// シーケンスの取得
		SequenceDao sDao = new SequenceDao();
		SequenceEntity se = null;
		try {
			se = sDao.selectByName("T_LEAD");
		} catch (Exception e) {
			fail(e.getMessage());
			return;
		}
		Integer id = se.getSeq() + 1;

		// insertするデータ作成
		LeadEntity entity = new LeadEntity();

		// 姓
		entity.setLastName("０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９");
		// 名
		entity.setFirstName("１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０");
		// 会社名
		entity.setCompanyName("０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９");
		// 役職名
		entity.setPosition("２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１");
		// ソース
		entity.setSourceCode("01");
		// 状況
		entity.setStatusCode("02");
		// 評価
		entity.setEstimationCode("03");
		// 電話
		entity.setPhone("01234567890");
		// 携帯
		entity.setMobilePhone("12345678901");
		// FAX
		entity.setFax("0123456789012345");
		// メール
		entity.setMailAddress("abcdefghijklmnopqrstuvwxyz123@0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345");
		// URL
		entity.setUrl("http://abc0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567");
		// 業種
		entity.setIndustryCode("04");
		// 年間売上
		entity.setAmount(1234567890123L);
		// 従業員数
		entity.setEmployees(1234567);
		// 郵便番号
		entity.setPostalCode("0123456");
		// 都道府県
		entity.setDivisionCode("05");
		// 市区郡
		entity.setCity("０１２３４５６７８９");
		// 町名・番地・建物名
		entity.setTown("０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９");
		// その他
		entity.setNote("０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９");
		// 作成者ID
		entity.setCreaterId(123456789);
		// 作成日時
		entity.setCreateDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss.SSS")));
		// 更新者ID
		entity.setUpdaterId(234567890);
		// 更新日時
		entity.setUpdateDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss.SSS")));

		LeadDao dao = new LeadDao();
		try {
			dao.insert(entity);
		} catch (Exception e) {
			fail(e.getMessage());
			return;
		}

		// チェック
		LeadEntity chk = null;
		try {
			chk = dao.selectById(id);
		} catch (Exception e) {
			fail(e.getMessage());
			return;
		}

		// ID
		assertEquals(id, chk.getId());
		// 姓
		assertEquals(entity.getLastName(), chk.getLastName());
		// 名
		assertEquals(entity.getFirstName(), chk.getFirstName());
		// 会社名
		assertEquals(entity.getCompanyName(), chk.getCompanyName());
		// 役職名
		assertEquals(entity.getPosition(), chk.getPosition());
		// ソース
		assertEquals(entity.getSourceCode(), chk.getSourceCode());
		// 状況
		assertEquals(entity.getStatusCode(), chk.getStatusCode());
		// 評価
		assertEquals(entity.getEstimationCode(), chk.getEstimationCode());
		// 電話
		assertEquals(entity.getPhone(), chk.getPhone());
		// 携帯
		assertEquals(entity.getMobilePhone(), chk.getMobilePhone());
		// FAX
		assertEquals(entity.getFax(), chk.getFax());
		// メール
		assertEquals(entity.getMailAddress(), chk.getMailAddress());
		// URL
		assertEquals(entity.getUrl(), chk.getUrl());
		// 業種
		assertEquals(entity.getIndustryCode(), chk.getIndustryCode());
		// 年間売上
		assertEquals(entity.getAmount(), chk.getAmount());
		// 従業員数
		assertEquals(entity.getEmployees(), chk.getEmployees());
		// 郵便番号
		assertEquals(entity.getPostalCode(), chk.getPostalCode());
		// 都道府県
		assertEquals(entity.getDivisionCode(), chk.getDivisionCode());
		// 市区郡
		assertEquals(entity.getCity(), chk.getCity());
		// 町名・番地・建物名
		assertEquals(entity.getTown(), chk.getTown());
		// その他
		assertEquals(entity.getNote(), chk.getNote());
		// 作成者ID
		assertEquals(entity.getCreaterId(), chk.getCreaterId());
		// 作成日時
		assertEquals(entity.getCreateDate(), chk.getCreateDate());
		// 更新者ID
		assertEquals(entity.getUpdaterId(), chk.getUpdaterId());
		// 更新日時
		assertEquals(entity.getUpdateDate(), chk.getUpdateDate());
	}
	
	/**
	 * insertメソッドテスト2
	 * <summary>
	 * エンティティに値がセットされない時のテスト
	 * </summary>
	 */
	@Test
	void testInsert2() {

		// シーケンスの取得
		SequenceDao sDao = new SequenceDao();
		SequenceEntity se = null;
		try {
			se = sDao.selectByName("T_LEAD");
		} catch (Exception e) {
			fail(e.getMessage());
			return;
		}
		Integer id = se.getSeq() + 1;

		// insertするデータ作成
		LeadEntity entity = new LeadEntity();

		LeadDao dao = new LeadDao();
		try {
			dao.insert(entity);
		} catch (Exception e) {
			fail(e.getMessage());
			return;
		}

		// チェック
		LeadEntity chk = null;
		try {
			chk = dao.selectById(id);
		} catch (Exception e) {
			fail(e.getMessage());
			return;
		}

		// ID
		assertEquals(id, chk.getId());
		// 姓
		assertEquals(entity.getLastName(), chk.getLastName());
		// 名
		assertEquals(entity.getFirstName(), chk.getFirstName());
		// 会社名
		assertEquals(entity.getCompanyName(), chk.getCompanyName());
		// 役職名
		assertEquals(entity.getPosition(), chk.getPosition());
		// ソース
		assertEquals(entity.getSourceCode(), chk.getSourceCode());
		// 状況
		assertEquals(entity.getStatusCode(), chk.getStatusCode());
		// 評価
		assertEquals(entity.getEstimationCode(), chk.getEstimationCode());
		// 電話
		assertEquals(entity.getPhone(), chk.getPhone());
		// 携帯
		assertEquals(entity.getMobilePhone(), chk.getMobilePhone());
		// FAX
		assertEquals(entity.getFax(), chk.getFax());
		// メール
		assertEquals(entity.getMailAddress(), chk.getMailAddress());
		// URL
		assertEquals(entity.getUrl(), chk.getUrl());
		// 業種
		assertEquals(entity.getIndustryCode(), chk.getIndustryCode());
		// 年間売上
		assertEquals(entity.getAmount(), chk.getAmount());
		// 従業員数
		assertEquals(entity.getEmployees(), chk.getEmployees());
		// 郵便番号
		assertEquals(entity.getPostalCode(), chk.getPostalCode());
		// 都道府県
		assertEquals(entity.getDivisionCode(), chk.getDivisionCode());
		// 市区郡
		assertEquals(entity.getCity(), chk.getCity());
		// 町名・番地・建物名
		assertEquals(entity.getTown(), chk.getTown());
		// その他
		assertEquals(entity.getNote(), chk.getNote());
		// 作成者ID
		assertEquals(entity.getCreaterId(), chk.getCreaterId());
		// 作成日時
		assertEquals(entity.getCreateDate(), chk.getCreateDate());
		// 更新者ID
		assertEquals(entity.getUpdaterId(), chk.getUpdaterId());
		// 更新日時
		assertEquals(entity.getUpdateDate(), chk.getUpdateDate());
	}

}
