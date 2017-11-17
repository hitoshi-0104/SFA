package action.lead.list;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.SalesManagementApplicationException;
import exception.SalesManagementRuntimeException;
import exception.SalesManagementSystemException;
import util.constant.JspPath;

/**
 * 見込み客一覧表示のアクションクラス
 *
 */
public class ShowAction extends ListAction {

	/**
	 * コンストラクタ
	 * @param request
	 * @param response
	 * @throws SalesManagementSystemException
	 */
	public ShowAction(HttpServletRequest request, HttpServletResponse response) throws SalesManagementSystemException {
		super(request, response);
	}

	/**
	 * ハンドル
	 */
	@Override
	public String handle() throws ServletException, IOException, SalesManagementApplicationException,
			SalesManagementSystemException, SalesManagementRuntimeException {

		return JspPath.Lead.LIST;
	}

}
