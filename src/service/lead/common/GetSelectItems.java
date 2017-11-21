package service.lead.common;

import java.sql.Connection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import dao.ClassDao;
import dao.ConnectionProvider;
import dao.DivisionDao;
import dao.entity.ClassEntity;
import dao.entity.DivisionEntity;
import exception.SalesManagementSystemException;
import service.lead.dto.SelectItemsDto;
import util.constant.ClassCode1;
import util.message.MessageReader;

/**
 * セレクトボックス用のアイテム取得ロジック
 * @author HITOSHI
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
			// ソースの取得
			dto.setSourceMap(getClass(ClassCode1.SOURCE, dao));

			// 状況の取得
			dto.setStatusMap(getClass(ClassCode1.LEAD_STATUS, dao));

			// 評価の取得
			dto.setEstimationMap(getClass(ClassCode1.ESTIMATION, dao));

			// 業種の取得
			dto.setIndustryMap(getClass(ClassCode1.INDUSTRY, dao));

			// 都道府県の取得
			DivisionDao ddao = new DivisionDao(cp);
			dto.setDivisionMap(getDivision(ddao));
		} catch (Exception e) {
			Map<String, String> messageMap = new HashMap<String, String>();
			messageMap.put("E00190001", String.format(MessageReader.read("E804")));
    		throw new SalesManagementSystemException(messageMap);
		}

		return dto;

	}

	/**
	 * 分類の取得
	 * @param code1
	 * @param dao
	 * @return
	 * @throws Exception
	 */
	private Map<String, String> getClass(String code1, ClassDao dao) throws Exception {
		List<ClassEntity> list = dao.seleceByCode1(code1);
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("", "");
		for (ClassEntity en : list) {
			m.put(en.getCode2(), en.getCode2Name());
		}
		return m;
	}

	/**
	 * 都道府県の取得
	 * @param code
	 * @param dao
	 * @return
	 * @throws Exception
	 */
	private Map<String, String> getDivision(DivisionDao dao) throws Exception {
		List<DivisionEntity> list = dao.selectAll();
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("", "");
		for (DivisionEntity en : list) {
			m.put(en.getCode(), en.getName());
		}
		return m;
	}

}
