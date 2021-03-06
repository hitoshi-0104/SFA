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
import service.base.BaseSearchService;
import service.lead.dto.SearchDto;
import util.constant.Limit;
import util.json.JsonProvider;
import util.session.SessionInfo;

/**
 * 見込み客検索のサービスクラス
 *
 */
public class SearchService extends BaseSearchService {

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
		Integer cnt = null;
		List<LeadListEntity> list = null;
		try (Connection conn = cp.getConnection()) {
			cnt = dao.countForLeadList(entity);
			list = dao.selectForLeadList(entity, getOffSet(dto.getPage()));
		}

		// エンティティからDtoに変換
		String ret = createLeadListEntitiList2Json(cnt, list);

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
	private String createLeadListEntitiList2Json(Integer cnt, List<LeadListEntity> list) {

		List<Map<String, Object>> ret = new ArrayList<Map<String, Object>>();

		Map<String, Object> retMap = new LinkedHashMap<String, Object>();
		retMap.put("cnt", cnt);
		retMap.put("maxrow", Limit.LIST_ROW_LIMIT);

		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		for (LeadListEntity en : list) {

			Map<String, Object> m = new LinkedHashMap<String, Object>();

			// ID
			m.put("LeadId", en.getId().toString());
			// 姓
			m.put("LastName", en.getLastName());
			// 名
			m.put("FirstName", en.getFirstName());
			// 会社名
			m.put("CompanyName", en.getCompanyName());
			// 状況名称
			m.put("StatusName", en.getStatusName());
			// 評価名称
			m.put("EstimationName", en.getEstimationName());
			// 都道府県名称
			m.put("DivisionName", en.getDivisionName());

			data.add(m);
		}
		retMap.put("data", data);
		ret.add(retMap);
		return JsonProvider.provide(ret);
	}

}
