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
import util.json.JsonProvider;
import util.session.SessionInfo;

/**
 * 取引先検索のサービスクラス
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
		AccountEntity entity = createAccountEntityForSearch(si, dto);

		ConnectionProvider cp = ConnectionProvider.getInstance();
		AccountDao dao = new AccountDao(cp);
		List<AccountDialogListEntity> list = null;
		try (Connection conn = cp.getConnection()) {
			list = dao.selectForAccountDialogList(entity);
		}

		// エンティティからDtoに変換
		String ret = createAccountDialogListEntityList2Json(list);

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
	private String createAccountDialogListEntityList2Json(List<AccountDialogListEntity> list) {

		List<Map<String, String>> ret = new ArrayList<Map<String, String>>();
		for (AccountDialogListEntity en : list) {

			Map<String, String> m = new LinkedHashMap<String, String>();

			// ID
			m.put("AccountId", en.getId().toString());
			// 取引先名
			m.put("AccountName", en.getAccountName());
			// 業種
			m.put("Industry", en.getIndustry());
			// 住所
			m.put("Address", en.getAddress());

			ret.add(m);
		}
		return JsonProvider.provide(ret);
	}

}
