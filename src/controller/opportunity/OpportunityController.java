package controller.opportunity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.SalesManagementApplicationException;
import exception.SalesManagementRuntimeException;
import exception.SalesManagementSystemException;

/**
 * 商談コントローラ
 *
 */
public class OpportunityController {

	/** 商談新規登録の正規表現 */
	private static final String CREATE_MATCH = "opportunity.create.*";
	/** 商談検索の正規表現 */
	private static final String SEARCH_MATCH = "opportunity.list.*";
	/** 商談更新の正規表現 */
	private static final String UPDATE_MATCH = "opportunity.update.*";

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
			// 商談検索
			ListController dispatcher = new ListController();
			dispatcher.dispatch(action, request, response);
		} else if (action.matches(CREATE_MATCH)) {
			// 商談新規登録
			CreateController dispatcher = new CreateController();
			dispatcher.dispatch(action, request, response);
		} else if (action.matches(UPDATE_MATCH)) {
			// 商談更新
			UpdateController dispatcher = new UpdateController();
			dispatcher.dispatch(action, request, response);
		}
	}

}
