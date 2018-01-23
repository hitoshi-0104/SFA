package controller.opportunity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.SalesManagementApplicationException;
import exception.SalesManagementRuntimeException;
import exception.SalesManagementSystemException;
import util.constant.JspPath;
import util.constant.ServletSettings;

/**
 * 商談一覧のコントローラ
 *
 */
public class ListController {

	/** 初期表示 */
	private static final String SHOW_MATCH = "opportunity.list.show.action";
	/** 検索 */
	private static final String SEARCH_MATCH = "opportunity.list.search.rest";

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

		String dispatchUrl = JspPath.Opportunity.LIST;
		try {
			switch(action) {
			// 初期表示
			case SHOW_MATCH:
//				ShowAction scon = new ShowAction(request, response);
//				dispatchUrl = scon.handle();
				break;
			// 検索
			case SEARCH_MATCH:
//				SearchAction secon = new SearchAction(request, response);
//				dispatchUrl = secon.handle();
				break;
			}
		} finally {
			request.setAttribute(ServletSettings.URL_ATTRIBUTE_NAME, dispatchUrl);
		}
	}

}
