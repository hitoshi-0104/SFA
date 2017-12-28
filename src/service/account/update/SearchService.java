package service.account.update;

import java.sql.Connection;

import dao.AccountDao;
import dao.ConnectionProvider;
import dao.entity.AccountEntity;
import service.account.dto.UpdateDto;
import service.account.dto.UpdateSearchDto;
import util.session.SessionInfo;

/**
 * 取引先更新のデータ取得用サービスクラス
 *
 */
public class SearchService {

	/**
	 * 更新用データの取得処理
	 * @param si
	 * @param dto
	 * @return
	 */
	public UpdateDto search(SessionInfo si, UpdateSearchDto dto) throws Exception {

		// エンティティの作成
		AccountEntity entity = createEntityForSearch(si, dto);

		// データ取得
		ConnectionProvider cp = ConnectionProvider.getInstance();
		AccountDao dao = new AccountDao(cp);
		AccountEntity data = null;
		try (Connection conn = cp.getConnection()) {
			data = dao.selectById(entity.getId());
		}

		// DTOにセット
		UpdateDto ret = new UpdateDto();

		// 取引先ID
		ret.setId(data.getId());
		// 取引先名
		ret.setAccountName(data.getAccountName());
		// 親取引先ID
		ret.setParentId(data.getParentId());
		// 親取引先
		ret.setParent(data.getParent());
		// 取引先番号
		ret.setAccountNo(data.getAccountNo());
		// 取引先部門
		ret.setDepartment(data.getDepartment());
		// 業種
		ret.setIndustry(data.getIndustry());
		// 年間売上
		ret.setAmount(data.getAmount());
		// 評価
		ret.setEvaluation(data.getEvaluation());
		// 電話
		ret.setPhone(data.getPhone());
		// FAX
		ret.setFax(data.getFax());
		// URL
		ret.setUrl(data.getUrl());
		// 従業員数
		ret.setEmployee(data.getEmployee());
		// 証券コード
		ret.setStockCode(data.getStockCode());
		// 郵便番号
		ret.setPostalCode(data.getPostalCode());
		// 都道府県
		ret.setDivision(data.getDivision());
		// 市区郡
		ret.setCity(data.getCity());
		// 町名・番地・建物名
		ret.setTown(data.getTown());
		// その他
		ret.setNote(data.getNote());

		return ret;
	}

	/**
	 * 検索用にエンティティを作成
	 * @return
	 */
	private AccountEntity createEntityForSearch(SessionInfo si, UpdateSearchDto dto) {

		AccountEntity entity = new AccountEntity();

		// ID
		entity.setId(dto.getId());

		return entity;

	}

}
