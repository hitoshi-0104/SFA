package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.account.AccountController;
import controller.base.BaseController;
import controller.contact.ContactController;
import controller.lead.LeadController;
import exception.SalesManagementApplicationException;
import exception.SalesManagementRuntimeException;
import exception.SalesManagementSystemException;
import util.constant.ServletSettings;

/**
 * Servlet implementation class RestController
 */
@WebServlet("*.rest")
public class RestController extends BaseController {
	private static final long serialVersionUID = 1L;

	/** 見込み客REST APIの正規表現 */
	private static final String LEAD_MATCH = "lead.*.rest";
	/** 取引先REST APIの正規表現 */
	private static final String ACCOUNT_MATCH = "account.*.rest";
	/** 取引先担当者REST APIの正規表現 */
	private static final String CONTACT_MATCH = "contact.*.rest";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uri = request.getRequestURI();

		int lastIndex = uri.lastIndexOf("/");
		uri = uri.substring(lastIndex + 1);
		String rest = null;

		response.setContentType(ServletSettings.REST_CONTENT_TYPE);
    	request.setCharacterEncoding(ServletSettings.CHARACTER_ENCODING);

    	try {

    		// ディスパッチ
    		dispatch(uri, request, response);
    		rest = request.getAttribute(ServletSettings.REST_ATTRIBUTE_NAME).toString();

    	} catch (SalesManagementApplicationException e) {

    		// メッセージのセット
    		request.setAttribute(MESSAGES, e.getMessages());
    		rest = request.getAttribute(ServletSettings.REST_ATTRIBUTE_NAME).toString();

    	} catch (SalesManagementSystemException e) {

    	} catch (SalesManagementRuntimeException e) {

    	} catch (Exception e) {

    	}

    	PrintWriter pw = response.getWriter();
    	pw.print(rest);
    	pw.flush();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * ディスパッチ
	 * @param url
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws SalesManagementApplicationException
	 * @throws SalesManagementSystemException
	 * @throws SalesManagementRuntimeException
	 */
	private void dispatch(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,
		SalesManagementApplicationException, SalesManagementSystemException, SalesManagementRuntimeException {

	if (url.matches(LEAD_MATCH)) {
		// 見込み客
		LeadController dispatcher = new LeadController();
		dispatcher.dispatch(url, request, response);
	} else if (url.matches(ACCOUNT_MATCH)) {
		// 取引先
		AccountController dispatcher = new AccountController();
		dispatcher.dispatch(url, request, response);
	} else if (url.matches(CONTACT_MATCH)) {
		// 取引先担当者
		ContactController dispatcher = new ContactController();
		dispatcher.dispatch(url, request, response);
	}
}

}
