package controller.account;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.SalesManagementApplicationException;
import exception.SalesManagementRuntimeException;
import exception.SalesManagementSystemException;

/**
 * 取引先コントローラ
 *
 */
public class AccountController {

	/** 取引先ダイアログ検索の正規表現 */
	private static final String DIALOG_SEARCH_MATCH = "account.dialog.search.*";

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

		if (action.matches(DIALOG_SEARCH_MATCH)) {
			// 取引先検索
			ListController dispatcher = new ListController();
			dispatcher.dispatch(action, request, response);
		}
	}

}
