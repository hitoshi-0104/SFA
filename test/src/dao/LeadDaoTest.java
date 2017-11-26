package dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.Test;

import dao.entity.LeadEntity;
import dao.entity.LeadListEntity;
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

		ConnectionProvider cp = ConnectionProvider.getInstance();

		// シーケンスの取得
		SequenceDao sDao = new SequenceDao(cp);
		SequenceEntity se = null;
		try (Connection conn = cp.getConnection()) {
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

		LeadEntity chk = null;
		LeadDao dao = new LeadDao(cp);
		try (Connection conn = cp.getConnection()) {
			cp.beginTransaction();
			dao.insert(entity);

			// チェック
			chk = dao.selectById(id);

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

			cp.rollback();
		} catch (Exception e) {
			fail(e.getMessage());
			return;
		}
	}

	/**
	 * insertメソッドテスト2
	 * <summary>
	 * エンティティに値がセットされない時のテスト
	 * </summary>
	 */
	@Test
	void testInsert2() {

		ConnectionProvider cp = ConnectionProvider.getInstance();

		// シーケンスの取得
		SequenceDao sDao = new SequenceDao(cp);
		SequenceEntity se = null;
		try (Connection conn = cp.getConnection()) {
			se = sDao.selectByName("T_LEAD");
		} catch (Exception e) {
			fail(e.getMessage());
			return;
		}
		Integer id = se.getSeq() + 1;

		// insertするデータ作成
		LeadEntity entity = new LeadEntity();

		LeadEntity chk = null;
		LeadDao dao = new LeadDao(cp);
		try (Connection conn = cp.getConnection()) {
			cp.beginTransaction();
			dao.insert(entity);

			// チェック
			chk = dao.selectById(id);

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

			cp.rollback();

		} catch (Exception e) {
			fail(e.getMessage());
			return;
		}

	}

	/**
	 * selectForLeadList(LeadEntity)メソッドのテスト
	 */
	@Test
	void testSelectForLeadListLeadEntity() {

		LeadEntity searchEntity = new LeadEntity();
		searchEntity.setLastName("あ");
		searchEntity.setFirstName("さ");
		searchEntity.setCompanyName("な");
		searchEntity.setSourceCode("01");
		searchEntity.setStatusCode("02");
		searchEntity.setEstimationCode("03");
		searchEntity.setIndustryCode("04");
		searchEntity.setDivisionCode("05");

		ConnectionProvider cp = ConnectionProvider.getInstance();
		try (Connection conn = cp.getConnection()) {

			cp.beginTransaction();

			LeadDao dao = new LeadDao(cp);

			// テスト用データの生成
			for (int i = 0; i < 5; i++) {
				LeadEntity insertEntity = new LeadEntity();
				// 姓
				insertEntity.setLastName("あいうえおかきくけこ");
				// 名
				insertEntity.setFirstName("さしすせそたちつてと");
				// 会社名
				insertEntity.setCompanyName("なにぬねのはひふへほ");
				// ソース
				insertEntity.setSourceCode("01");
				// 状況
				insertEntity.setStatusCode("02");
				// 評価
				insertEntity.setEstimationCode("03");
				// 業種
				insertEntity.setIndustryCode("04");
				// 都道府県
				insertEntity.setDivisionCode("05");

				dao.insert(insertEntity);
			}

			List<LeadListEntity> ret = dao.selectForLeadList(searchEntity);

			assertEquals(5, ret.size());
			for (LeadListEntity en : ret) {
				// 姓
				assertEquals("あいうえおかきくけこ", en.getLastName());
				// 名
				assertEquals("さしすせそたちつてと", en.getFirstName());
				// 会社名
				assertEquals("なにぬねのはひふへほ", en.getCompanyName());
				// ソース
				assertEquals("01", en.getSourceCode());
				// 状況
				assertEquals("02", en.getStatusCode());
				// 評価
				assertEquals("03", en.getEstimationCode());
				// 業種
				assertEquals("04", en.getIndustryCode());
				// 都道府県
				assertEquals("05", en.getDivisionCode());
			}

			cp.rollback();

		} catch (Exception e) {
			fail(e.getMessage());
			return;
		}
	}

}
