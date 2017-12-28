package controller.account;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.account.update.DeleteAction;
import action.account.update.ShowAction;
import action.account.update.UpdateAction;
import exception.SalesManagementApplicationException;
import exception.SalesManagementRuntimeException;
import exception.SalesManagementSystemException;
import util.constant.JspPath;
import util.constant.ServletSettings;

/**
 * 取引先更新のコントローラ
 *
 */
public class UpdateController {

	/** 初期表示 */
	private static final String SHOW_MATCH = "account.update.show.action";
	/** 更新 */
	private static final String UPDATE_MATCH = "account.update.update.action";
	/** 削除 */
	private static final String DELETE_MATCH = "account.update.delete.action";

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
	void dispatch(String action, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,
		SalesManagementApplicationException, SalesManagementSystemException, SalesManagementRuntimeException {

		String dispatchUrl = JspPath.Account.UPDATE;
		try {
			switch(action) {
			// 初期表示
			case SHOW_MATCH:
				ShowAction scon = new ShowAction(request, response);
				dispatchUrl = scon.handle();
				break;
			// 更新
			case UPDATE_MATCH:
				UpdateAction ua = new UpdateAction(request, response);
				dispatchUrl = ua.handle();
				break;
			// 削除
			case DELETE_MATCH:
				DeleteAction da = new DeleteAction(request, response);
				dispatchUrl = da.handle();
				break;
			}
		} finally {
			request.setAttribute(ServletSettings.URL_ATTRIBUTE_NAME, dispatchUrl);
		}
	}

}
