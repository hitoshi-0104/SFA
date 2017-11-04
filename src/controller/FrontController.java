package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.lead.LeadController;
import exception.SalesManagementApplicationException;
import exception.SalesManagementRuntimeException;
import exception.SalesManagementSystemException;
import util.constant.ServletSettings;

/**
 * Servlet implementation class MainDispatcher
 */
@WebServlet("*.action")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/** Attribute設定名：MessageBean */
	private static final String MESSAGES = "messages";

	/** 見込み客機能の正規表現 */
	private static final String LEAD_MATCH = "lead.*.action";

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

		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);
		String dispatchUrl = null;

		response.setContentType(ServletSettings.CONTENT_TYPE);
    	request.setCharacterEncoding(ServletSettings.CHARACTER_ENCODING);

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
		}
	}

}
