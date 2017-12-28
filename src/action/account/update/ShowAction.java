package action.account.update;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.SalesManagementApplicationException;
import exception.SalesManagementRuntimeException;
import exception.SalesManagementSystemException;
import util.constant.JspPath;

/**
 * 取引先初期表示のアクションクラス
 * @author HITOSHI
 *
 */
public class ShowAction extends UpdateBaseAction {

	/**
	 * コンストラクタ
	 * @param request
	 * @param response
	 */
	public ShowAction(HttpServletRequest request, HttpServletResponse response) throws SalesManagementSystemException {
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

		return JspPath.Account.UPDATE;
	}

}
