package action.lead.create;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.SalesManagementApplicationException;
import exception.SalesManagementRuntimeException;
import exception.SalesManagementSystemException;
import util.constant.JspPath;

/**
 * 見込み客新規登録画面：戻るコントローラ
 *
 */
public class ReturnAction extends CreateAction {

	/**
	 * コンストラクタ
	 * @param request
	 * @param response
	 */
	public ReturnAction(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
	}

	/**
	 * ハンドラ
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 * @throws SalesManagementApplicationException
	 * @throws SalesManagementSystemException
	 * @throws SalesManagementRuntimeException
	 */
	@Override
	public String handle() throws ServletException, IOException,
		SalesManagementApplicationException, SalesManagementSystemException, SalesManagementRuntimeException {

		return JspPath.Lead.LIST;
	}
}
