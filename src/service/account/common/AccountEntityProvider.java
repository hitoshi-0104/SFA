package service.account.common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import dao.entity.AccountEntity;
import service.account.dto.AccountDto;
import util.session.SessionInfo;

/**
 * AccountEntity生成クラス
 *
 */
public class AccountEntityProvider {

	/**
	 * AccountDtoからAccountEntityを作成
	 * @param si
	 * @param dto
	 * @return
	 */
	public AccountEntity provideFromAccountDto(SessionInfo si, AccountDto dto) {

		AccountEntity entity = new AccountEntity();

		// ID
		entity.setId(dto.getId());
		// 取引先名
    	entity.setAccountName(dto.getAccountName());
    	// 親取引先
    	entity.setParentId(dto.getParent());
    	// 取引先番号
    	entity.setAccountNo(dto.getAccountNo());
    	// 取引先部門
    	entity.setDepartment(dto.getDepartment());
    	// 業種
    	entity.setIndustry(dto.getIndustry());
    	// 評価
    	entity.setEvaluation(dto.getEvaluation());
    	// 電話
    	entity.setPhone(dto.getPhone());
    	// FAX
    	entity.setFax(dto.getFax());
    	// URL
    	entity.setUrl(dto.getUrl());
    	// 年間売上
    	entity.setAmount(dto.getAmount());
    	// 従業員数
    	entity.setEmployee(dto.getEmployee());
    	// 郵便番号
    	entity.setPostalCode(dto.getPostalCode());
    	// 都道府県
    	entity.setDivision(dto.getDivision());
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
