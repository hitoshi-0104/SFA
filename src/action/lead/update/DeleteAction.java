package action.lead.update;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.lead.constant.ReqParam;
import exception.SalesManagementApplicationException;
import exception.SalesManagementRuntimeException;
import exception.SalesManagementSystemException;
import service.lead.dto.LeadDto;
import service.lead.update.DeleteService;
import util.constant.JspPath;
import util.converter.StringConverter;
import util.message.MessageReader;
import util.session.SessionInfo;

/**
 * 見込み客の削除アクションクラス
 *
 */
public class DeleteAction extends UpdateBaseAction {

	/**
	 * コンストラクタ
	 * @param request
	 * @param response
	 * @throws SalesManagementSystemException
	 */
	public DeleteAction(HttpServletRequest request, HttpServletResponse response)
			throws SalesManagementSystemException {
		super(request, response);
	}

	/**
	 * ハンドル
	 */
	@Override
	public String handle() throws ServletException, IOException, SalesManagementApplicationException,
			SalesManagementSystemException, SalesManagementRuntimeException {

		// リクエストパラメータをBeanにセット
		setParamsToUpdateBean();

		// 更新
		delete();

		return JspPath.Lead.LIST_ACTION;
	}

	/**
	 * 更新処理
	 * @throws ServletException
	 * @throws IOException
	 * @throws SalesManagementApplicationException
	 * @throws SalesManagementSystemException
	 * @throws SalesManagementRuntimeException
	 */
	private void delete() throws ServletException, IOException,
		SalesManagementApplicationException, SalesManagementSystemException, SalesManagementRuntimeException {

		// リクエストパラメータの取得
		LeadDto dto = new LeadDto();

		// ID
		dto.setId(StringConverter.toInteger(request.getParameter(ReqParam.Update.ID)));

		DeleteService service = new DeleteService();

		try {
	    	// 削除
    		SessionInfo si = (SessionInfo)request.getAttribute(SessionInfo.SESSION_ATTRIBUTE_NAME);
	    	service.delete(si, dto);
    	} catch (Exception e) {
    		Map<String, String> messageMap = new HashMap<String, String>();
    		messageMap.put("E" + getDisplayId() + "90002", String.format(MessageReader.read("E803")));
    		throw new SalesManagementSystemException(messageMap);
    	}

	}

}
