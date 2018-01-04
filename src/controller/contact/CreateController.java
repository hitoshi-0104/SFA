package controller.contact;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.contact.create.ContinuousAction;
import action.contact.create.RegistAction;
import action.contact.create.ShowAction;
import exception.SalesManagementApplicationException;
import exception.SalesManagementRuntimeException;
import exception.SalesManagementSystemException;
import util.constant.JspPath;
import util.constant.ServletSettings;

/**
 * 取引先担当者新規作成コントローラ
 *
 */
public class CreateController {

	/** 初期表示 */
	private static final String SHOW_MATCH = "contact.create.show.action";
	/** 連続登録 */
	private static final String CONTINUOUS_MATCH = "contact.create.continuous.action";
	/** 登録 */
	private static final String REGIST_MATCH = "contact.create.regist.action";

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

		String dispatchUrl = JspPath.Account.CREATE;
		try {
			switch(action) {
			// 初期表示
			case SHOW_MATCH:
				ShowAction scon = new ShowAction(request, response);
				dispatchUrl = scon.handle();
				break;
			// 連続登録
			case CONTINUOUS_MATCH:
				ContinuousAction ccon = new ContinuousAction(request, response);
				dispatchUrl = ccon.handle();
				break;
			// 登録
			case REGIST_MATCH:
				RegistAction rgitcon = new RegistAction(request, response);
				dispatchUrl = rgitcon.handle();
				break;
			}
		} finally {
			request.setAttribute(ServletSettings.URL_ATTRIBUTE_NAME, dispatchUrl);
		}
	}

}
