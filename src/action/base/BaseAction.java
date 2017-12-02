package action.base;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.SalesManagementApplicationException;
import exception.SalesManagementRuntimeException;
import exception.SalesManagementSystemException;

/**
 * Servlet implementation class BaseController
 */
public abstract class BaseAction {

	/** リクエスト */
	protected HttpServletRequest request;
	/** レスポンス */
	protected HttpServletResponse response;

	/**
	 * コンストラクタ
	 * @param request
	 * @param response
	 */
	protected BaseAction(HttpServletRequest request, HttpServletResponse response) throws SalesManagementSystemException {
		this.request = request;
		this.response = response;
		initialize();
	}

	/**
	 * 初期化処理
	 * @param request
	 * @param response
	 */
    protected abstract void initialize() throws SalesManagementSystemException;

    /**
     * 画面ID取得
     */
    protected abstract String getDisplayId();

    /**
     * ハンドラ
     * @param request
     * @param response
     * @return
     */
    protected abstract String handle() throws ServletException, IOException,
		SalesManagementApplicationException, SalesManagementSystemException, SalesManagementRuntimeException;

}
