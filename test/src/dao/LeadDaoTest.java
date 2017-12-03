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
				assertEquals("Web", en.getSourceName());
				// 状況
				assertEquals("コンタクト", en.getStatusName());
				// 評価
				assertEquals("低", en.getEstimationName());
				// 業種
				assertEquals("情報通信業", en.getIndustryName());
				// 都道府県
				assertEquals("秋田県", en.getDivisionName());
			}

			cp.rollback();

		} catch (Exception e) {
			fail(e.getMessage());
			return;
		}
	}

	/**
	 * updateメソッドのテスト
	 */
	@Test
	void testUpdate() {

		// テスト用データの作成
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

		ConnectionProvider cp = ConnectionProvider.getInstance();
		LeadDao dao = new LeadDao(cp);
		try (Connection conn = cp.getConnection()) {
			cp.beginTransaction();

			// シーケンスの取得
			SequenceDao seqDao = new SequenceDao(cp);
			SequenceEntity seqEntity = seqDao.selectByName("T_LEAD");

			// 更新データ作成
			LeadEntity upEntity = new LeadEntity();
			// ID
			upEntity.setId(seqEntity.getSeq());
			// 姓
			upEntity.setLastName("あ");
			// 名
			upEntity.setFirstName("い");
			// 会社名
			upEntity.setCompanyName("う");
			// 役職名
			upEntity.setPosition("え");
			// ソース
			upEntity.setSourceCode("51");
			// 状況
			upEntity.setStatusCode("52");
			// 評価
			upEntity.setEstimationCode("53");
			// 電話
			upEntity.setPhone("0");
			// 携帯
			upEntity.setMobilePhone("1");
			// FAX
			upEntity.setFax("2");
			// メール
			upEntity.setMailAddress("a@a");
			// URL
			upEntity.setUrl("http://abc.com");
			// 業種
			upEntity.setIndustryCode("54");
			// 年間売上
			upEntity.setAmount(1L);
			// 従業員数
			upEntity.setEmployees(2);
			// 郵便番号
			upEntity.setPostalCode("3");
			// 都道府県
			upEntity.setDivisionCode("55");
			// 市区郡
			upEntity.setCity("お");
			// 町名・番地・建物名
			upEntity.setTown("か");
			// その他
			upEntity.setNote("き");
			// 更新者ID
			String dt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss.SSS"));
			upEntity.setUpdaterId(3);
			// 更新日時
			upEntity.setUpdateDate(dt);

			dao.update(upEntity);

			// 確認
			LeadEntity chk = dao.selectById(seqEntity.getSeq());

			// ID
			assertEquals(upEntity.getId(), chk.getId());
			// 姓
			assertEquals(upEntity.getLastName(), chk.getLastName());
			// 名
			assertEquals(upEntity.getFirstName(), chk.getFirstName());
			// 会社名
			assertEquals(upEntity.getCompanyName(), chk.getCompanyName());
			// 役職名
			assertEquals(upEntity.getPosition(), chk.getPosition());
			// ソース
			assertEquals(upEntity.getSourceCode(), chk.getSourceCode());
			// 状況
			assertEquals(upEntity.getStatusCode(), chk.getStatusCode());
			// 評価
			assertEquals(upEntity.getEstimationCode(), chk.getEstimationCode());
			// 電話
			assertEquals(upEntity.getPhone(), chk.getPhone());
			// 携帯
			assertEquals(upEntity.getMobilePhone(), chk.getMobilePhone());
			// FAX
			assertEquals(upEntity.getFax(), chk.getFax());
			// メール
			assertEquals(upEntity.getMailAddress(), chk.getMailAddress());
			// URL
			assertEquals(upEntity.getUrl(), chk.getUrl());
			// 業種
			assertEquals(upEntity.getIndustryCode(), chk.getIndustryCode());
			// 年間売上
			assertEquals(upEntity.getAmount(), chk.getAmount());
			// 従業員数
			assertEquals(upEntity.getEmployees(), chk.getEmployees());
			// 郵便番号
			assertEquals(upEntity.getPostalCode(), chk.getPostalCode());
			// 都道府県
			assertEquals(upEntity.getDivisionCode(), chk.getDivisionCode());
			// 市区郡
			assertEquals(upEntity.getCity(), chk.getCity());
			// 町名・番地・建物名
			assertEquals(upEntity.getTown(), chk.getTown());
			// その他
			assertEquals(upEntity.getNote(), chk.getNote());
			// 更新者ID
			assertEquals(upEntity.getUpdaterId(), chk.getUpdaterId());
			// 更新日時
			assertEquals(upEntity.getUpdateDate(), chk.getUpdateDate());

			cp.rollback();
		} catch (Exception e) {
			fail(e.getMessage());
			return;
		}

	}

}
