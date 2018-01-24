package service.opportunity.common;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import dao.ClassDao;
import dao.ConnectionProvider;
import exception.SalesManagementSystemException;
import service.common.GetClassItems;
import service.opportunity.dto.SelectItemsDto;
import util.constant.ClassCode1;
import util.message.MessageReader;

/**
 * 商談画面のセレクトボックス用アイテム取得クラス
 *
 */
public class GetSelectItems {

	/**
	 * 取得
	 * @return
	 * @throws ClassNotFoundException
	 */
	public SelectItemsDto get() throws SalesManagementSystemException {

		SelectItemsDto dto = new SelectItemsDto();

		ConnectionProvider cp = ConnectionProvider.getInstance();

		try (Connection conn = cp.getConnection()) {
			ClassDao dao = new ClassDao(cp);

			// 種別の取得
			dto.setTypeMap(GetClassItems.get(ClassCode1.OPPORTUNITY_TYPE, dao));

			// リードソースの取得
			dto.setLeadSourceMap(GetClassItems.get(ClassCode1.LEAD_SOURCE, dao));

			// フェーズの取得
			dto.setPhaseMap(GetClassItems.get(ClassCode1.PHASE, dao));
		} catch (Exception e) {
			Map<String, String> messageMap = new HashMap<String, String>();
			messageMap.put("E00190001", String.format(MessageReader.read("E804")));
    		throw new SalesManagementSystemException(messageMap);
		}

		return dto;

	}

}
