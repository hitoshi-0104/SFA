package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.account.AccountController;
import controller.base.BaseController;
import controller.contact.ContactController;
import controller.lead.LeadController;
import controller.opportunity.OpportunityController;
import exception.SalesManagementApplicationException;
import exception.SalesManagementRuntimeException;
import exception.SalesManagementSystemException;
import util.constant.ServletSettings;
import util.session.SessionInfo;

/**
 * Servlet implementation class MainDispatcher
 */
@WebServlet("*.action")
public class FrontController extends BaseController {
	private static final long serialVersionUID = 1L;

	/** 見込み客機能の正規表現 */
	private static final String LEAD_MATCH = "lead.*.action";
	/** 取引先機能の正規表現 */
	private static final String ACCOUNT_MATCH = "account.*.action";
	/** 取引先担当者機能の正規表現 */
	private static final String CONTACT_MATCH = "contact.*.action";
	/** 商談機能の正規表現 */
	private static final String OPPORTUNITY_MATCH = "opportunity.*.action";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uri = request.getRequestURI();
		Object obj= request.getAttribute(ServletSettings.URL_ATTRIBUTE_NAME);
		if (obj != null) {
			uri = obj.toString();
		}

		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);
		String dispatchUrl = null;

		response.setContentType(ServletSettings.CONTENT_TYPE);
    	request.setCharacterEncoding(ServletSettings.CHARACTER_ENCODING);

    	// ログイン画面を作成するまでのダミー値
    	SessionInfo si = new SessionInfo();
    	si.setLoginUserId(0);
    	request.setAttribute(SessionInfo.SESSION_ATTRIBUTE_NAME, si);

    	try {

    		// ディスパッチ
    		dispatch(action, request, response);
    		dispatchUrl = request.getAttribute(ServletSettings.URL_ATTRIBUTE_NAME).toString();

    	} catch (SalesManagementApplicationException e) {

    		// メッセージのセット
    		request.setAttribute(MESSAGES, e.getMessages());
    		dispatchUrl = request.getAttribute(ServletSettings.URL_ATTRIBUTE_NAME).toString();

    	} catch (SalesManagementSystemException e) {

    	} catch (SalesManagementRuntimeException e) {

    	} catch (Exception e) {

    	}

		getServletContext().getRequestDispatcher(dispatchUrl).include(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * ディスパッチ
	 * @param action
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * @throws SalesManagementApplicationException
	 * @throws SalesManagementSystemException
	 * @throws SalesManagementRuntimeException
	 */
	private void dispatch(String action, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,
		SalesManagementApplicationException, SalesManagementSystemException, SalesManagementRuntimeException {

		if (action.matches(LEAD_MATCH)) {
			// 見込み客
			LeadController dispatcher = new LeadController();
			dispatcher.dispatch(action, request, response);
		} else if (action.matches(ACCOUNT_MATCH)) {
			// 取引先
			AccountController dispatcher = new AccountController();
			dispatcher.dispatch(action, request, response);
		} else if (action.matches(CONTACT_MATCH)) {
			// 取引先担当者
			ContactController dispatcher = new ContactController();
			dispatcher.dispatch(action, request, response);
		} else if (action.matches(OPPORTUNITY_MATCH)) {
			// 商談
			OpportunityController dispatcher = new OpportunityController();
			dispatcher.dispatch(action, request, response);
		}
	}

}
