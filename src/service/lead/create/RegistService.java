package service.lead.create;

import java.sql.Connection;

import dao.ConnectionProvider;
import dao.LeadDao;
import dao.entity.LeadEntity;
import service.lead.common.LeadEntityProvider;
import service.lead.dto.LeadDto;
import util.session.SessionInfo;

/**
 * 見込み客新規顧客用のモデルクラス
 *
 */
public class RegistService {

	/**
	 * 見込み客新規登録画面の登録処理
	 * @return true : 成功  false : 失敗
	 * @throws Exception
	 */
	public void insert(SessionInfo si, LeadDto dto) throws Exception {

		// エンティティの作成
		LeadEntityProvider provider = new LeadEntityProvider();
		LeadEntity entity = provider.provideFromLeadDto(si, dto);

		ConnectionProvider cp = ConnectionProvider.getInstance();
		LeadDao dao = new LeadDao(cp);
		try (Connection conn = cp.getConnection()) {
			dao.insert(entity);
		}
	}

}
