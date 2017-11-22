package service.lead.list;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import dao.ConnectionProvider;
import dao.LeadDao;
import dao.entity.LeadEntity;
import dao.entity.LeadListEntity;
import service.lead.dto.SearchDto;
import util.json.JsonProvider;
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
	public String search(SessionInfo si, SearchDto dto) throws Exception {

		// エンティティの作成
		LeadEntity entity = createLeadEntityForSearch(si, dto);

		ConnectionProvider cp = ConnectionProvider.getInstance();
		LeadDao dao = new LeadDao(cp);
		List<LeadListEntity> list = null;
		try (Connection conn = cp.getConnection()) {
			list = dao.selectForLeadList(entity);
		}

		// エンティティからDtoに変換
		String ret = createLeadListEntitiList2Json(list);

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
	private String createLeadListEntitiList2Json(List<LeadListEntity> list) {

		List<Map<String, String>> ret = new ArrayList<Map<String, String>>();
		for (LeadListEntity en : list) {

			Map<String, String> m = new LinkedHashMap<String, String>();

			// 姓
			m.put("LastName", en.getLastName());
			// 名
			m.put("FirstName", en.getFirstName());
			// 会社名
			m.put("CompanyName", en.getCompanyName());
			// ソース
			m.put("SourceCode", en.getSourceCode());
			// ソース名称
			m.put("SourceName", en.getSourceName());
			// 状況
			m.put("StatusCode", en.getStatusCode());
			// 状況名称
			m.put("StatusName", en.getStatusName());
			// 評価
			m.put("EstimationCode", en.getEstimationCode());
			// 評価名称
			m.put("EstimationName", en.getEstimationName());
			// 業種
			m.put("IndustryCode", en.getIndustryCode());
			// 業種名称
			m.put("IndustryName", en.getIndustryName());
			// 都道府県
			m.put("DivisionCode", en.getDivisionCode());
			// 都道府県名称
			m.put("DivisionName", en.getDivisionName());

			ret.add(m);
		}
		return JsonProvider.provide(ret);
	}

}
