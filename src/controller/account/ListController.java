package controller.account;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.lead.list.SearchAction;
import controller.base.BaseController;
import exception.SalesManagementApplicationException;
import exception.SalesManagementRuntimeException;
import exception.SalesManagementSystemException;
import util.constant.JspPath;
import util.constant.ServletSettings;

public class ListController extends BaseController {

	/** 検索ダイアログ */
	private static final String DIALOG_SEARCH_MATCH = "account.dialog.search.rest";

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
