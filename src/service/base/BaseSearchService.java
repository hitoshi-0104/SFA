package service.base;

import util.constant.Limit;

/**
 * 検索の基底となるサービスクラス
 *
 */
public class BaseSearchService extends BaseService {

	/**
	 * ページ数からオフセットを計算
	 * @param page
	 * @return
	 */
	protected Integer getOffSet(Integer page) {
		return (page - 1) * Limit.LIST_ROW_LIMIT;
	}

}
