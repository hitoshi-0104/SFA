package service.lead.update;

import java.sql.Connection;

import dao.AccountDao;
import dao.ConnectionProvider;
import dao.ContactDao;
import dao.entity.AccountEntity;
import dao.entity.ContactEntity;
import dao.entity.LeadEntity;
import service.lead.common.LeadEntityProvider;
import service.lead.dto.LeadDto;
import util.session.SessionInfo;

/**
 * 見込み客更新のサービスクラス
 *
 */
public class AccountService {

	/**
	 * 見込み客から取引先と取引先担当者を作成
	 * @param si
	 * @param dto
	 */
	public void createAccountAndContact(SessionInfo si, LeadDto dto) throws Exception {

		LeadEntityProvider provider = new LeadEntityProvider();
		LeadEntity entity = provider.provideFromLeadDto(si, dto);

		ConnectionProvider cp = ConnectionProvider.getInstance();
		try (Connection conn = cp.getConnection()) {

			// トランザクション開始
			cp.beginTransaction();

			// 取引先の作成
			AccountEntity account = createAccountEntity(dto);
			AccountDao accountDao = new AccountDao(cp);
			accountDao.insert(account);

			// 作成した取引先のIDを取得
			Integer accountId = accountDao.selectMaxId();

			// 取引先担当者の作成
			ContactEntity contact = createContactEntity(accountId, dto);
			ContactDao contactDao = new ContactDao(cp);
			contactDao.insert(contact);

			// コミット
			cp.commit();

		} catch (Exception e) {
			// ロールバック
			cp.rollback();
			throw e;
		}

	}

	/**
	 * LeadDtoからAccountEntityを作成する
	 * @param dto
	 * @return
	 */
	private AccountEntity createAccountEntity(LeadDto dto) {

		AccountEntity entity = new AccountEntity();

		// 取引先名
		entity.setAccountName(dto.getCompanyName());
		// 親取引先
		entity.setParent(null);
		// 取引先番号
		entity.setAccountNo(null);
		// 取引部門
		entity.setDepartment(null);
		// 種別
		entity.setType(null);
		// 業種
		entity.setIndustry(dto.getIndustryCode());
		// 年間売上
		entity.setAmount(dto.getAmount());
		// 評価
		entity.setEvaluation(null);
		// 電話
		entity.setPhone(dto.getPhone());
		// FAX
		entity.setFax(dto.getFax());
		// URL
		entity.setUrl(dto.getUrl());
		// 証券コード
		entity.setStockCode(null);
		// 郵便番号
		entity.setPostalCode(dto.getPostalCode());
		// 都道府県
		entity.setDivision(dto.getDivisionCode());
		// 市区郡
		entity.setCity(dto.getCity());
		// 町名・番地・建物
		entity.setTown(dto.getTown());
		// その他
		entity.setNote(null);

		return entity;
	}

	/**
	 * LeadDtoからContactEntityを作成する
	 * @param dto
	 * @return
	 */
	private ContactEntity createContactEntity(Integer accountId, LeadDto dto) {

		ContactEntity entity = new ContactEntity();

		// 姓
		entity.setLastName(dto.getLastName());
		// 名
		entity.setFirstName(dto.getFirstName());
		// 取引先
		entity.setAccountId(accountId);
		// 部署
		entity.setDepartment(null);
		// 役職
		entity.setPosition(dto.getPosition());
		// 電話
		entity.setPhone(dto.getPhone());
		// 携帯
		entity.setMobilePhone(dto.getMobilePhone());
		// FAX
		entity.setFax(dto.getFax());
		// メール
		entity.setMail(dto.getMailAddress());
		// 上司
		entity.setBoss(null);
		// その他
		entity.setNote(null);

		return entity;
	}

}
