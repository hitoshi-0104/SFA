package service.common;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import dao.ClassDao;
import dao.entity.ClassEntity;

public class GetClassItems {

	/**
	 * 分類の取得
	 * @param code1
	 * @param dao
	 * @return
	 * @throws Exception
	 */
	public static Map<String, String> get(String code1, ClassDao dao) throws Exception {
		List<ClassEntity> list = dao.seleceByCode1(code1);
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("", "");
		for (ClassEntity en : list) {
			m.put(en.getCode2(), en.getCode2Name());
		}
		return m;
	}

}
