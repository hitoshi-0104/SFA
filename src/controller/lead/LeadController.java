package controller.lead;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.SalesManagementApplicationException;
import exception.SalesManagementRuntimeException;
import exception.SalesManagementSystemException;

/**
 * 見込み客ディスパッチャ
 *
 */
public class LeadController {

	/** 見込み客新規登録の正規表現 */
	private static final String CREATE_MATCH = "lead.create.*.action";
	/** 見込み客検索の正規表現 */
	private static final String SEARCH_MATCH = "lead.list.*.action";

	/**
	 * ディスパッチ
	 * @param action
	 * @param request
	 * @param response
	 * @return
	 * @throws SalesManagementRuntimeException
	 * @throws SalesManagementSystemException
	 * @throws SalesManagementApplicationException
	 * @throws IOException
	 * @throws ServletException
	 */
	public void dispatch(String action, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,
		SalesManagementApplicationException, SalesManagementSystemException, SalesManagementRuntimeException {

		if (action.matches(SEARCH_MATCH)) {
			// 見込み客検索
			ListController dispatcher = new ListController();
			dispatcher.dispatch(action, request, response);
		} else if (action.matches(CREATE_MATCH)) {
			// 見込み客新規登録
			CreateController dispatcher = new CreateController();
			dispatcher.dispatch(action, request, response);
		}
	}
}
