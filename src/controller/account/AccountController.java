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

	/** 取引先新規登録の正規表現 */
	private static final String CREATE_MATCH = "account.create.*";
	/** 取引先更新の正規表現 */
	private static final String UPDATE_MATCH = "account.update.*";
	/** 取引先検索の正規表現 */
	private static final String LIST_MATCH = "account.list.*";
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

		if (action.matches(CREATE_MATCH)) {
			// 取引先新規登録
			CreateController dispathcer = new CreateController();
			dispathcer.dispatch(action, request, response);
		} else if (action.matches(UPDATE_MATCH)) {
			// 取引先更新
			UpdateController dispathcer = new UpdateController();
			dispathcer.dispatch(action, request, response);
		} else if (action.matches(LIST_MATCH) || action.matches(DIALOG_SEARCH_MATCH)) {
			// 取引先検索
			ListController dispatcher = new ListController();
			dispatcher.dispatch(action, request, response);
		}
	}

}
