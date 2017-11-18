package controller.base;

import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class BaseController
 */
public abstract class BaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/** Attribute設定名：MessageBean */
	protected static final String MESSAGES = "messages";

    /**
     * @see HttpServlet#HttpServlet()
     */
    protected BaseController() {
        super();
    }

}
