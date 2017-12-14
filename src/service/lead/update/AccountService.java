package service.lead.update;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import dao.AccountDao;
import dao.ConnectionProvider;
import dao.ContactDao;
import dao.LeadDao;
import dao.entity.AccountEntity;
import dao.entity.ContactEntity;
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

		ConnectionProvider cp = ConnectionProvider.getInstance();
		try (Connection conn = cp.getConnection()) {

			// トランザクション開始
			cp.beginTransaction();

			Integer accountId = null;
			if (dto.isNew()) {
				// 取引先の作成
				AccountEntity account = createAccountEntity(si, dto);
				AccountDao accountDao = new AccountDao(cp);
				accountDao.insert(account);

				// 作成した取引先のIDを取得
				accountId = accountDao.selectMaxId();
			} else {
				accountId = dto.getLinkedAccountId();
			}

			// 取引先担当者の作成
			ContactEntity contact = createContactEntity(si, accountId, dto);
			ContactDao contactDao = new ContactDao(cp);
			contactDao.insert(contact);

			// 見込み客の削除
			LeadDao leadDao = new LeadDao(cp);
			leadDao.deleteById(dto.getId());

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
	private AccountEntity createAccountEntity(SessionInfo si, LeadDto dto) {

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

		// 作成者ID
		entity.setCreaterId(si.getLoginUserId());
		// 作成日時
		entity.setCreateDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss.SSS")));
		// 更新者ID
		entity.setUpdaterId(si.getLoginUserId());
		// 更新日時
		entity.setUpdateDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss.SSS")));

		return entity;
	}

	/**
	 * LeadDtoからContactEntityを作成する
	 * @param dto
	 * @return
	 */
	private ContactEntity createContactEntity(SessionInfo si, Integer accountId, LeadDto dto) {

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

		// 作成者ID
		entity.setCreaterId(si.getLoginUserId());
		// 作成日時
		entity.setCreateDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss.SSS")));
		// 更新者ID
		entity.setUpdaterId(si.getLoginUserId());
		// 更新日時
		entity.setUpdateDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss.SSS")));

		return entity;
	}

}
