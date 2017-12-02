package service.lead.update;

import java.sql.Connection;

import dao.ConnectionProvider;
import dao.LeadDao;
import dao.entity.LeadEntity;
import service.lead.common.LeadEntityProvider;
import service.lead.dto.LeadDto;
import util.session.SessionInfo;

/**
 * 見込み客更新のサービスクラス
 *
 */
public class UpdateService {

	/**
	 * 更新
	 * @param si
	 * @param dto
	 * @throws Exception
	 */
	public void update(SessionInfo si, LeadDto dto) throws Exception {

		LeadEntityProvider provider = new LeadEntityProvider();
		LeadEntity entity = provider.provideFromLeadDto(si, dto);

		ConnectionProvider cp = ConnectionProvider.getInstance();
		LeadDao dao = new LeadDao(cp);
		try (Connection conn = cp.getConnection()) {
			dao.update(entity);
		}

	}

}
