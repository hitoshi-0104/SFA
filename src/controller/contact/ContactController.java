package controller.contact;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.contact.CreateController;
import controller.contact.ListController;
import controller.contact.UpdateController;
import exception.SalesManagementApplicationException;
import exception.SalesManagementRuntimeException;
import exception.SalesManagementSystemException;

/**
 * 取引先担当者コントローラ
 *
 */
public class ContactController {

	/** 取引先担当者新規登録の正規表現 */
	private static final String CREATE_MATCH = "contact.create.*";
	/** 取引先担当者更新の正規表現 */
	private static final String UPDATE_MATCH = "contact.update.*";
	/** 取引先担当者検索の正規表現 */
	private static final String LIST_MATCH = "contact.list.*";
	/** 取引先担当者ダイアログ検索の正規表現 */
	private static final String DIALOG_SEARCH_MATCH = "contact.dialog.search.*";

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
