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
 * 見込み客新規登録画面：連続登録コントローラ
 *
 */
public class ContinuousAction extends RegistAction {

	/**
	 * コンストラクタ
	 * @param request
	 * @param response
	 */
	public ContinuousAction(HttpServletRequest request, HttpServletResponse response) {
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

		// リクエストパラメータからCreateBeanの作成
		setParamsToLeadBean();

		// 登録処理
		regist();

		return JspPath.Lead.CREATE;
	}
}
