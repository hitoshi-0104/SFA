package controller.lead;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.lead.update.AccountAction;
import action.lead.update.DeleteAction;
import action.lead.update.ShowAction;
import action.lead.update.UpdateAction;
import exception.SalesManagementApplicationException;
import exception.SalesManagementRuntimeException;
import exception.SalesManagementSystemException;
import util.constant.JspPath;
import util.constant.ServletSettings;

/**
 * 見込み客更新ディスパッチャ
 *
 */
public class UpdateController {

	/** 初期表示 */
	private static final String SHOW_MATCH = "lead.update.show.action";
	/** 取引の開始 */
	private static final String ACCOUNT_MATCH = "lead.update.account.action";
	/** 更新 */
	private static final String UPDATE_MATCH = "lead.update.update.action";
	/** 削除 */
	private static final String DELETE_MATCH = "lead.update.delete.action";

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

		String dispatchUrl = JspPath.Lead.UPDATE;
		try {
			switch(action) {
			// 初期表示
			case SHOW_MATCH:
				ShowAction scon = new ShowAction(request, response);
				dispatchUrl = scon.handle();
				break;
			// 取引の開始
			case ACCOUNT_MATCH:
				AccountAction ccon = new AccountAction(request, response);
				dispatchUrl = ccon.handle();
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
