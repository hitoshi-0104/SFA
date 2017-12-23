package service.lead.update;

import java.sql.Connection;

import dao.ConnectionProvider;
import dao.LeadDao;
import dao.entity.LeadEntity;
import service.base.BaseService;
import service.lead.common.LeadEntityProvider;
import service.lead.dto.LeadDto;
import util.session.SessionInfo;

/**
 * 見込み客削除のサービスクラス
 *
 */
public class DeleteService extends BaseService {

	/**
	 * 更新
	 * @param si
	 * @param dto
	 * @throws Exception
	 */
	public void delete(SessionInfo si, LeadDto dto) throws Exception {

		LeadEntityProvider provider = new LeadEntityProvider();
		LeadEntity entity = provider.provideFromLeadDto(si, dto);

		ConnectionProvider cp = ConnectionProvider.getInstance();
		LeadDao dao = new LeadDao(cp);
		try (Connection conn = cp.getConnection()) {
			dao.deleteById(entity.getId());
		}

	}

}
