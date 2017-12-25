package service.account.create;

import service.account.dto.CreateDto;
import util.session.SessionInfo;

/**
 * 取引先新規登録のサービスクラス
 *
 */
public class RegistService {

	/**
	 * 取引先新規登録画面の登録処理
	 * @throws Exception
	 */
	public void insert(SessionInfo si, CreateDto dto) throws Exception {

//		// エンティティの作成
//		LeadEntityProvider provider = new LeadEntityProvider();
//		LeadEntity entity = provider.provideFromLeadDto(si, dto);
//
//		ConnectionProvider cp = ConnectionProvider.getInstance();
//		LeadDao dao = new LeadDao(cp);
//		try (Connection conn = cp.getConnection()) {
//			dao.insert(entity);
//		}
	}

}
