package service.account.common;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import dao.ClassDao;
import dao.ConnectionProvider;
import dao.DivisionDao;
import exception.SalesManagementSystemException;
import service.account.dto.SelectItemsDto;
import service.common.GetClassItems;
import service.common.GetDivision;
import util.constant.ClassCode1;
import util.message.MessageReader;

/**
 * 取引先画面のセレクトボックス用アイテム取得クラス
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

			// 評価の取得
			dto.setEstimationMap(GetClassItems.get(ClassCode1.ESTIMATION, dao));

			// 業種の取得
			dto.setIndustryMap(GetClassItems.get(ClassCode1.INDUSTRY, dao));

			// 都道府県の取得
			DivisionDao ddao = new DivisionDao(cp);
			dto.setDivisionMap(GetDivision.get(ddao));
		} catch (Exception e) {
			Map<String, String> messageMap = new HashMap<String, String>();
			messageMap.put("E00190001", String.format(MessageReader.read("E804")));
    		throw new SalesManagementSystemException(messageMap);
		}

		return dto;

	}

}
