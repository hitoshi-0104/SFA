package action.contact.list;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.contact.constant.ReqParam;
import exception.SalesManagementApplicationException;
import exception.SalesManagementRuntimeException;
import exception.SalesManagementSystemException;
import service.contact.dto.SearchDto;
import service.contact.list.SearchService;
import util.constant.ServletSettings;
import util.converter.StringConverter;
import util.message.MessageReader;
import util.session.SessionInfo;

/**
 * 取引先担当者の検索アクションクラス
 *
 */
public class SearchAction extends ListAction {

	/**
	 * コンストラクタ
	 * @param request
	 * @param response
	 * @throws SalesManagementSystemException
	 */
	public SearchAction(HttpServletRequest request, HttpServletResponse response)
			throws SalesManagementSystemException {
		super(request, response);
	}

	/**
	 * ハンドル
	 */
	@Override
	public String handle() throws ServletException, IOException, SalesManagementApplicationException,
			SalesManagementSystemException, SalesManagementRuntimeException {

		// 検索処理
		search();

		return "";
	}

	/**
	 * 検索処理
	 * @throws ServletException
	 * @throws IOException
	 * @throws SalesManagementApplicationException
	 * @throws SalesManagementSystemException
	 * @throws SalesManagementRuntimeException
	 */
	private void search() throws ServletException, IOException,
		SalesManagementApplicationException, SalesManagementSystemException, SalesManagementRuntimeException {

		SearchService service = new SearchService();

		// リクエストパラメータの取得
		SearchDto dto = new SearchDto();

		// 姓
		dto.setLastName(request.getParameter(ReqParam.List.LAST_NAME));
		// 名
		dto.setFirstName(request.getParameter(ReqParam.List.FIRST_NAME));
		// 取引先
		dto.setAccountId(StringConverter.toInteger(request.getParameter(ReqParam.List.ACCOUNT_ID)));
		// ページ
		dto.setPage(StringConverter.toInteger(request.getParameter(ReqParam.List.PAGE)));

		try {
			// 検索
    		SessionInfo si = (SessionInfo)request.getAttribute(SessionInfo.SESSION_ATTRIBUTE_NAME);
	    	String json = service.search(si, dto);
	    	request.setAttribute(ServletSettings.REST_ATTRIBUTE_NAME, json);
		} catch(Exception e) {
			Map<String, String> messageMap = new LinkedHashMap<String, String>();
			messageMap.put("E00490002", String.format(MessageReader.read("E805")));
			throw new SalesManagementSystemException(messageMap);
		}
	}

}
