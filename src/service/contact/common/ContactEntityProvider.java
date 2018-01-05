package service.contact.common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import dao.entity.ContactEntity;
import service.contact.dto.ContactDto;
import util.session.SessionInfo;

/**
 * ContactEntity生成クラス
 * @author HITOSHI
 *
 */
public class ContactEntityProvider {

	/**
	 * ContactDtoからContactEntityを作成
	 * @param si
	 * @param dto
	 * @return
	 */
	public ContactEntity provideFromContactDto(SessionInfo si, ContactDto dto) {

		ContactEntity entity = new ContactEntity();

		// 取引先担当者ID
		entity.setId(dto.getId());
		// 姓
		entity.setLastName(dto.getLastName());
		// 名
		entity.setFirstName(dto.getFirstName());
		// 取引先
		entity.setAccountId(dto.getAccountId());
		// 部署
		entity.setDepartment(dto.getDepartment());
		// 役職
		entity.setPosition(dto.getPosition());
		// 電話
		entity.setPhone(dto.getPhone());
		// 携帯
		entity.setMobilePhone(dto.getMobilePhone());
		// FAX
		entity.setFax(dto.getFax());
		// メール
		entity.setMail(dto.getMail());
		// 上司
		entity.setBoss(dto.getBoss());
		// その他
		entity.setNote(dto.getNote());

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
