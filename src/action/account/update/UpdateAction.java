package action.account.update;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.account.constant.ReqParam;
import exception.SalesManagementApplicationException;
import exception.SalesManagementRuntimeException;
import exception.SalesManagementSystemException;
import service.account.common.AccountValidater;
import service.account.dto.AccountDto;
import service.account.update.UpdateService;
import util.constant.JspPath;
import util.converter.StringConverter;
import util.message.MessageReader;
import util.session.SessionInfo;

/**
 * 取引先更新画面の更新処理アクションクラス
 *
 */
public class UpdateAction extends UpdateBaseAction {

	/**
	 * コンストラクタ
	 * @param request
	 * @param response
	 * @throws SalesManagementSystemException
	 */
	public UpdateAction(HttpServletRequest request, HttpServletResponse response)
			throws SalesManagementSystemException {
		super(request, response);
	}

	/**
	 * ハンドル
	 */
	@Override
	public String handle() throws ServletException, IOException, SalesManagementApplicationException,
			SalesManagementSystemException, SalesManagementRuntimeException {

		// リクエストパラメータをBeanにセット
		setParamsToUpdateBean();

		// 更新
		update();

		return JspPath.Account.LIST_ACTION;
	}

	/**
	 * 更新処理
	 * @throws ServletException
	 * @throws IOException
	 * @throws SalesManagementApplicationException
	 * @throws SalesManagementSystemException
	 * @throws SalesManagementRuntimeException
	 */
	private void update() throws ServletException, IOException,
		SalesManagementApplicationException, SalesManagementSystemException, SalesManagementRuntimeException {

		// リクエストパラメータの取得
		AccountDto dto = new AccountDto();

		// 取引先ID
		dto.setId(StringConverter.toInteger(request.getParameter(ReqParam.Update.ID)));
		// 取引先名
		dto.setAccountName(request.getParameter(ReqParam.Update.ACCOUNT_NAME));
		// 親取引先
		dto.setParent(StringConverter.toInteger(request.getParameter(ReqParam.Update.PARENT_ID)));
		// 取引先番号
		dto.setAccountNo(request.getParameter(ReqParam.Update.ACCOUNT_NO));
		// 取引先部門
		dto.setDepartment(request.getParameter(ReqParam.Update.DEPARTMENT));
		// 業種
		dto.setIndustry(request.getParameter(ReqParam.Update.INDUSTRY));
		// 年間売上
		dto.setAmount(StringConverter.toLong(request.getParameter(ReqParam.Update.AMOUNT)));
		// 評価
		dto.setEvaluation(request.getParameter(ReqParam.Update.EVALUATION));
		// 電話
		dto.setPhone(request.getParameter(ReqParam.Update.PHONE));
		// FAX
		dto.setFax(request.getParameter(ReqParam.Update.FAX));
		// URL
		dto.setUrl(request.getParameter(ReqParam.Update.URL));
		// 従業員数
		dto.setEmployee(StringConverter.toInteger(request.getParameter(ReqParam.Update.EMPLOYEE)));
		// 証券コード
		dto.setStockCode(request.getParameter(ReqParam.Update.STOCK_CODE));
		// 郵便番号
		dto.setPostalCode(request.getParameter(ReqParam.Update.POSTAL_CODE));
		// 都道府県
		dto.setDivision(request.getParameter(ReqParam.Update.DIVISION));
		// 市区郡
		dto.setCity(request.getParameter(ReqParam.Update.CITY));
		// 町名・番地・建物名
		dto.setTown(request.getParameter(ReqParam.Update.TOWN));
		// その他
		dto.setNote(request.getParameter(ReqParam.Update.NOTE));

		UpdateService service = new UpdateService();

		// 入力チェック
		AccountValidater valid = new AccountValidater();
		Map<String, String> messageMap = valid.validate(dto, getDisplayId());
		if (messageMap.size() != 0) {
    		throw new SalesManagementApplicationException(messageMap);
    	}

		try {
	    	// 更新
    		SessionInfo si = (SessionInfo)request.getAttribute(SessionInfo.SESSION_ATTRIBUTE_NAME);
	    	service.update(si, dto);
    	} catch (Exception e) {
    		messageMap.put("E" + getDisplayId() + "90002", String.format(MessageReader.read("E801")));
    		throw new SalesManagementSystemException(messageMap);
    	}

	}

}
