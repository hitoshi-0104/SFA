package controller.lead;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.lead.update.ShowAction;
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
	/** 登録 */
	private static final String UPDATE_MATCH = "lead.update.update.action";
	/** 戻る */
	private static final String RETURN_MATCH = "lead.update.return.action";

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

		String dispatchUrl = JspPath.Lead.CREATE;
		try {
			switch(action) {
			// 初期表示
			case SHOW_MATCH:
				ShowAction scon = new ShowAction(request, response);
				dispatchUrl = scon.handle();
				break;
			// 取引の開始
			case ACCOUNT_MATCH:
//				ContinuousAction ccon = new ContinuousAction(request, response);
//				dispatchUrl = ccon.handle();
				break;
			// 更新
			case UPDATE_MATCH:
//				RegistAction rgitcon = new RegistAction(request, response);
//				dispatchUrl = rgitcon.handle();
				break;
			// 戻る
			case RETURN_MATCH:
//				ReturnAction retcon = new ReturnAction(request, response);
//				dispatchUrl = retcon.handle();
				break;
			}
		} finally {
			request.setAttribute(ServletSettings.URL_ATTRIBUTE_NAME, dispatchUrl);
		}
	}

}
