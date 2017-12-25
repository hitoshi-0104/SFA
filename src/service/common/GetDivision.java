package service.common;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import dao.DivisionDao;
import dao.entity.DivisionEntity;

public class GetDivision {

	/**
	 * 都道府県の取得
	 * @param code
	 * @param dao
	 * @return
	 * @throws Exception
	 */
	public static Map<String, String> get(DivisionDao dao) throws Exception {
		List<DivisionEntity> list = dao.selectAll();
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("", "");
		for (DivisionEntity en : list) {
			m.put(en.getCode(), en.getName());
		}
		return m;
	}

}
