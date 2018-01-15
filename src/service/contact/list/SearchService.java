package service.contact.list;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import dao.ConnectionProvider;
import dao.ContactDao;
import dao.entity.ContactEntity;
import dao.entity.ContactListEntity;
import service.base.BaseSearchService;
import service.contact.dto.SearchDto;
import util.constant.Limit;
import util.json.JsonProvider;
import util.session.SessionInfo;

/**
 * 取引先担当者検索のサービスクラス
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
		ContactEntity entity = createContactEntityForSearch(si, dto);

		ConnectionProvider cp = ConnectionProvider.getInstance();
		ContactDao dao = new ContactDao(cp);
		Integer cnt = null;
		List<ContactListEntity> list = null;
		try (Connection conn = cp.getConnection()) {
			cnt = dao.countForContactSearchListAndDialog(entity);
			list = dao.selectForContactSearchListAndDialog(entity, getOffSet(dto.getPage()));
		}

		// エンティティからDtoに変換
		String ret = createContactDialogListEntityList2Json(cnt, list);

		return ret;
	}

	/**
	 * 検索条件をエンティティにセット
	 * @param si
	 * @param dto
	 * @return
	 */
	private ContactEntity createContactEntityForSearch(SessionInfo si, SearchDto dto) {

		ContactEntity entity = new ContactEntity();

		// 姓
		entity.setLastName(dto.getLastName());
		// 名
		entity.setFirstName(dto.getFirstName());
		// 取引先
		entity.setAccountId(dto.getAccountId());

		return entity;

	}

	/**
	 * 検索結果をDtoにセット
	 * @param list
	 * @return
	 */
	private String createContactDialogListEntityList2Json(Integer cnt, List<ContactListEntity> list) {

		List<Map<String, Object>> ret = new ArrayList<Map<String, Object>>();

		Map<String, Object> retMap = new LinkedHashMap<String, Object>();
		retMap.put("cnt", cnt);
		retMap.put("maxrow", Limit.LIST_ROW_LIMIT);

		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		for (ContactListEntity en : list) {

			Map<String, Object> m = new LinkedHashMap<String, Object>();

			// ID
			m.put("ContactId", en.getId().toString());
			// 取引先担当者名
			m.put("ContactName", en.getContactName());
			// 取引先名
			m.put("AccountName", en.getAccountName());
			// 携帯
			m.put("MobilePhone", en.getMobilePhone());
			// メール
			m.put("Mail", en.getMail());

			data.add(m);
		}
		retMap.put("data", data);
		ret.add(retMap);
		return JsonProvider.provide(ret);
	}

}
