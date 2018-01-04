package action.contact.create;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.SalesManagementApplicationException;
import exception.SalesManagementRuntimeException;
import exception.SalesManagementSystemException;
import util.constant.JspPath;

/**
 * 取引先の連続登録アクションクラス
 *
 */
public class ContinuousAction extends RegistAction {

	/**
	 * コンストラクタ
	 * @param request
	 * @param response
	 * @throws SalesManagementSystemException
	 */
	public ContinuousAction(HttpServletRequest request, HttpServletResponse response)
			throws SalesManagementSystemException {
		super(request, response);
	}

	/**
	 * ハンドル
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

		super.handle();

		return JspPath.Account.CREATE;
	}

}
