package service.account.list;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import dao.AccountDao;
import dao.ConnectionProvider;
import dao.entity.AccountDialogListEntity;
import dao.entity.AccountEntity;
import service.account.dto.SearchDto;
import service.base.BaseSearchService;
import util.constant.Limit;
import util.json.JsonProvider;
import util.session.SessionInfo;

/**
 * 取引先検索のサービスクラス
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
		AccountEntity entity = createAccountEntityForSearch(si, dto);

		ConnectionProvider cp = ConnectionProvider.getInstance();
		AccountDao dao = new AccountDao(cp);
		Integer cnt = null;
		List<AccountDialogListEntity> list = null;
		try (Connection conn = cp.getConnection()) {
			cnt = dao.countForAccountDialogList(entity);
			list = dao.selectForAccountDialogList(entity, getOffSet(dto.getPage()));
		}

		// エンティティからDtoに変換
		String ret = createAccountDialogListEntityList2Json(cnt, list);

		return ret;
	}

	/**
	 * 検索条件をエンティティにセット
	 * @param si
	 * @param dto
	 * @return
	 */
	private AccountEntity createAccountEntityForSearch(SessionInfo si, SearchDto dto) {

		AccountEntity entity = new AccountEntity();

		// 取引先名
		entity.setAccountName(dto.getAccountName());

		return entity;

	}

	/**
	 * 検索結果をDtoにセット
	 * @param list
	 * @return
	 */
	private String createAccountDialogListEntityList2Json(Integer cnt, List<AccountDialogListEntity> list) {

		List<Map<String, Object>> ret = new ArrayList<Map<String, Object>>();

		Map<String, Object> retMap = new LinkedHashMap<String, Object>();
		retMap.put("cnt", cnt);
		retMap.put("maxrow", Limit.LIST_ROW_LIMIT);

		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		for (AccountDialogListEntity en : list) {

			Map<String, Object> m = new LinkedHashMap<String, Object>();

			// ID
			m.put("AccountId", en.getId().toString());
			// 取引先名
			m.put("AccountName", en.getAccountName());
			// 住所
			m.put("Address", en.getAddress());

			data.add(m);
		}
		retMap.put("data", data);
		ret.add(retMap);
		return JsonProvider.provide(ret);
	}

}
