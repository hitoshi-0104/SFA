package service.lead.list;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dao.ConnectionProvider;
import dao.LeadDao;
import dao.entity.LeadEntity;
import dao.entity.LeadListEntity;
import service.lead.dto.LeadListDto;
import service.lead.dto.SearchDto;
import util.session.SessionInfo;

/**
 * 見込み客検索のサービスクラス
 *
 */
public class SearchService {

	/**
	 * 検索処理
	 * @param si
	 * @param dto
	 */
	public List<LeadListDto> search(SessionInfo si, SearchDto dto) throws Exception {

		// エンティティの作成
		LeadEntity entity = createLeadEntityForSearch(si, dto);

		ConnectionProvider cp = ConnectionProvider.getInstance();
		LeadDao dao = new LeadDao(cp);
		List<LeadListEntity> list = null;
		try (Connection conn = cp.getConnection()) {
			list = dao.selectForLeadList(entity);
		}

		// エンティティからDtoに変換
		List<LeadListDto> ret = createLeadListDtoList(list);

		return ret;
	}

	/**
	 * 検索条件をエンティティにセット
	 * @param si
	 * @param dto
	 * @return
	 */
	private LeadEntity createLeadEntityForSearch(SessionInfo si, SearchDto dto) {

		LeadEntity entity = new LeadEntity();

		// 姓
		entity.setLastName(dto.getLastName());
		// 名
		entity.setFirstName(dto.getFirstName());
		// 会社名
		entity.setCompanyName(dto.getCompanyName());
		// ソース
		entity.setSourceCode(dto.getSourceCode());
		// 状況
		entity.setStatusCode(dto.getStatusCode());
		// 評価
		entity.setEstimationCode(dto.getEstimationCode());
		// 業種
		entity.setIndustryCode(dto.getIndustryCode());
		// 都道府県
		entity.setDivisionCode(dto.getDivisionCode());

		return entity;

	}

	/**
	 * 検索結果をDtoにセット
	 * @param list
	 * @return
	 */
	private List<LeadListDto> createLeadListDtoList(List<LeadListEntity> list) {

		List<LeadListDto> ret = new ArrayList<LeadListDto>();

		for (LeadListEntity en : list) {

			LeadListDto dto = new LeadListDto();

			// 姓
			dto.setLastName(en.getLastName());
			// 名
			dto.setFirstName(en.getFirstName());
			// 会社名
			dto.setCompanyName(en.getCompanyName());
			// ソース
			dto.setSourceCode(en.getSourceCode());
			// ソース名称
			dto.setSourceName(en.getSourceName());
			// 状況
			dto.setStatusCode(en.getStatusCode());
			// 状況名称
			dto.setStatusName(en.getStatusName());
			// 評価
			dto.setEstimationCode(en.getEstimationCode());
			// 評価名称
			dto.setEstimationName(en.getEstimationName());
			// 業種
			dto.setIndustryCode(en.getIndustryCode());
			// 業種名称
			dto.setIndustryName(en.getIndustryName());
			// 都道府県
			dto.setDivisionCode(en.getDivisionCode());
			// 都道府県名称
			dto.setDivisionName(en.getDivisionName());

			ret.add(dto);
		}
		return ret;
	}

}
