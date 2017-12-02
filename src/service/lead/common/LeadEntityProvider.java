package service.lead.common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import dao.entity.LeadEntity;
import service.lead.dto.LeadDto;
import util.session.SessionInfo;

/**
 * LeadEntity生成クラス
 *
 */
public class LeadEntityProvider {

	/**
	 * LeadDtoからLeadEntityを生成する
	 * @param si
	 * @param dto
	 * @return
	 */
	public LeadEntity provideFromLeadDto(SessionInfo si, LeadDto dto) {

		LeadEntity entity = new LeadEntity();

		// ID
		entity.setId(dto.getId());
		// 姓
		entity.setLastName(dto.getLastName());
		// 名
		entity.setFirstName(dto.getFirstName());
		// 会社名
		entity.setCompanyName(dto.getCompanyName());
		// 役職名
		entity.setPosition(dto.getPosition());
		// ソース
		entity.setSourceCode(dto.getSourceCode());
		// 状況
		entity.setStatusCode(dto.getStatusCode());
		// 評価
		entity.setEstimationCode(dto.getEstimationCode());
		// 電話
		entity.setPhone(dto.getPhone());
		// 携帯
		entity.setMobilePhone(dto.getMobilePhone());
		// FAX
		entity.setFax(dto.getFax());
		// メール
		entity.setMailAddress(dto.getMailAddress());
		// URL
		entity.setUrl(dto.getUrl());
		// 業種
		entity.setIndustryCode(dto.getIndustryCode());
		// 年間売上
		entity.setAmount(dto.getAmount());
		// 従業員数
		entity.setEmployees(dto.getEmployees());
		// 郵便番号
		entity.setPostalCode(dto.getPostalCode());
		// 都道府県
		entity.setDivisionCode(dto.getDivisionCode());
		// 市区郡
		entity.setCity(dto.getCity());
		// 町名・番地・建物名
		entity.setTown(dto.getTown());
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
