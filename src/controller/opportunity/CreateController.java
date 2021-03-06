package controller.opportunity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.opportunity.create.ShowAction;
import exception.SalesManagementApplicationException;
import exception.SalesManagementRuntimeException;
import exception.SalesManagementSystemException;
import util.constant.JspPath;
import util.constant.ServletSettings;

/**
 * 商談新規作成コントローラ
 *
 */
public class CreateController {

	/** 初期表示 */
	private static final String SHOW_MATCH = "opportunity.create.show.action";
	/** 連続登録 */
	private static final String CONTINUOUS_MATCH = "opportunity.create.continuous.action";
	/** 登録 */
	private static final String REGIST_MATCH = "opportunity.create.regist.action";
	/** 戻る */
	private static final String RETURN_MATCH = "opportunity.create.return.action";

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

		String dispatchUrl = JspPath.Opportunity.CREATE;
		try {
			switch(action) {
			// 初期表示
			case SHOW_MATCH:
				ShowAction scon = new ShowAction(request, response);
				dispatchUrl = scon.handle();
				break;
			// 連続登録
			case CONTINUOUS_MATCH:
//				ContinuousAction ccon = new ContinuousAction(request, response);
//				dispatchUrl = ccon.handle();
				break;
			// 登録
			case REGIST_MATCH:
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
