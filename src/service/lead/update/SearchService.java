package service.lead.update;

import service.lead.dto.UpdateDto;
import service.lead.dto.UpdateSearchDto;
import util.session.SessionInfo;

/**
 * 見込み客更新のデータ取得用サービスクラス
 *
 */
public class SearchService {

	/**
	 * 更新用データの取得処理
	 * @param si
	 * @param dto
	 * @return
	 */
	public UpdateDto search(SessionInfo si, UpdateSearchDto dto) {
		return new UpdateDto();
	}

}
