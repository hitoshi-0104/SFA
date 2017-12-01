package service.lead.update;

import java.sql.Connection;

import dao.ConnectionProvider;
import dao.LeadDao;
import dao.entity.LeadEntity;
import service.lead.dto.UpdateDto;
import service.lead.dto.UpdateSearchDto;
import util.session.SessionInfo;

/**
 * 見込み客更新のデータ取得用サービスクラス
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
		LeadEntity entity = createEntityForSearch(si, dto);

		// データ取得
		ConnectionProvider cp = ConnectionProvider.getInstance();
		LeadDao dao = new LeadDao(cp);
		LeadEntity data = null;
		try (Connection conn = cp.getConnection()) {
			data = dao.selectById(entity.getId());
		}

		// DTOにセット
		UpdateDto ret = new UpdateDto();

		// ID
		ret.setId(data.getId());
    	// 姓
		ret.setLastName(data.getLastName());
    	// 名
		ret.setFirstName(data.getFirstName());
    	// 会社名
		ret.setCompanyName(data.getCompanyName());
    	// 役職名
		ret.setPosition(data.getPosition());
    	// ソース
		ret.setSourceCode(data.getSourceCode());
    	// 状況
		ret.setStatusCode(data.getStatusCode());
    	// 評価
		ret.setEstimationCode(data.getEstimationCode());
    	// 電話
		ret.setPhone(data.getPhone());
    	// 携帯
		ret.setMobilePhone(data.getMobilePhone());
    	// FAX
		ret.setFax(data.getFax());
    	// メール
		ret.setMailAddress(data.getMailAddress());
    	// URL
		ret.setUrl(data.getUrl());
    	// 業種
		ret.setIndustryCode(data.getIndustryCode());
    	// 年間売上
		ret.setAmount(data.getAmount());
    	// 従業員数
		ret.setEmployees(data.getEmployees());
    	// 郵便番号
		ret.setPostalCode(data.getPostalCode());
    	// 都道府県
		ret.setDivisionCode(data.getDivisionCode());
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
	private LeadEntity createEntityForSearch(SessionInfo si, UpdateSearchDto dto) {

		LeadEntity entity = new LeadEntity();

		// ID
		entity.setId(dto.getId());

		return entity;

	}

}
