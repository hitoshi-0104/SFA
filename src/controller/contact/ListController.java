package controller.contact;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.contact.list.SearchAction;
import action.contact.list.ShowAction;
import exception.SalesManagementApplicationException;
import exception.SalesManagementRuntimeException;
import exception.SalesManagementSystemException;
import util.constant.JspPath;
import util.constant.ServletSettings;

public class ListController {

	/** 初期表示 */
	private static final String SHOW_MATCH = "contact.list.show.action";
	/** 一覧検索 */
	private static final String LIST_MATCH = "contact.list.search.rest";
	/** 検索ダイアログ */
	private static final String DIALOG_SEARCH_MATCH = "contact.dialog.search.rest";

	/**
	 * ディスパッチ
	 * @param action
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws SalesManagementApplicationException
	 * @throws SalesManagementSystemException
	 * @throws SalesManagementRuntimeException
	 */
	void dispatch(String action, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,
		SalesManagementApplicationException, SalesManagementSystemException, SalesManagementRuntimeException {

		String dispatchUrl = JspPath.Lead.LIST;
		try {
			switch(action) {
			// 初期表示
			case SHOW_MATCH:
				ShowAction sa = new ShowAction(request, response);
				dispatchUrl = sa.handle();
				break;
			// 検索
			case LIST_MATCH:
			// 検索ダイアログ
			case DIALOG_SEARCH_MATCH:
				SearchAction secon = new SearchAction(request, response);
				dispatchUrl = secon.handle();
				break;
			}
		} finally {
			request.setAttribute(ServletSettings.URL_ATTRIBUTE_NAME, dispatchUrl);
		}
	}

}
