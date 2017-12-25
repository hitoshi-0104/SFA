package action.account.create;

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
import service.account.create.RegistService;
import service.account.dto.CreateDto;
import util.constant.JspPath;
import util.converter.StringConverter;
import util.message.MessageReader;
import util.session.SessionInfo;

/**
 * 取引先の登録アクションクラス
 *
 */
public class RegistAction extends CreateAction {

	/**
	 * コンストラクタ
	 * @param request
	 * @param response
	 * @throws SalesManagementSystemException
	 */
	public RegistAction(HttpServletRequest request, HttpServletResponse response)
			throws SalesManagementSystemException {
		super(request, response);
	}

	/**
	 * ハンドル
	 */
	@Override
	protected String handle() throws ServletException, IOException, SalesManagementApplicationException,
			SalesManagementSystemException, SalesManagementRuntimeException {

		// リクエストパラメータからCreateBeanの作成
		setParamsToCreateBean();

		// 登録処理
		regist();

		return JspPath.Account.LIST;
	}

	/**
	 * 登録処理
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws SalesManagementApplicationException
	 * @throws SalesManagementSystemException
	 * @throws SalesManagementRuntimeException
	 */
	protected void regist() throws ServletException, IOException,
		SalesManagementApplicationException, SalesManagementSystemException, SalesManagementRuntimeException {

		RegistService service = new RegistService();

    	// リクエストパラメータの取得
    	CreateDto dto = new CreateDto();

    	// 取引先名
    	dto.setAccountName(request.getParameter(ReqParam.Create.ACCOUNT_NAME));
    	// 親取引先
    	dto.setParent(StringConverter.toInteger(request.getParameter(ReqParam.Create.PARENT)));
    	// 取引先番号
    	dto.setAccountNo(request.getParameter(ReqParam.Create.ACCOUNT_NO));
    	// 取引先部門
    	dto.setDepartment(request.getParameter(ReqParam.Create.DEPARTMENT));
    	// 業種
    	dto.setIndustry(request.getParameter(ReqParam.Create.INDUSTRY));
    	// 評価
    	dto.setEvaluation(request.getParameter(ReqParam.Create.EVALUATION));
    	// 電話
    	dto.setPhone(request.getParameter(ReqParam.Create.PHONE));
    	// FAX
    	dto.setFax(request.getParameter(ReqParam.Create.FAX));
    	// URL
    	dto.setUrl(request.getParameter(ReqParam.Create.URL));
    	// 年間売上
    	dto.setAmount(StringConverter.toLong(request.getParameter(ReqParam.Create.AMOUNT)));
    	// 従業員数
    	dto.setEmployee(StringConverter.toInteger(request.getParameter(ReqParam.Create.EMPLOYEE)));
    	// 郵便番号
    	dto.setPostalCode(request.getParameter(ReqParam.Create.POSTAL_CODE));
    	// 都道府県
    	dto.setDivision(request.getParameter(ReqParam.Create.DIVISION));
    	// 市区郡
    	dto.setCity(request.getParameter(ReqParam.Create.CITY));
    	// 町名・番地・建物名
    	dto.setTown(request.getParameter(ReqParam.Create.TOWN));
    	// その他
    	dto.setNote(request.getParameter(ReqParam.Create.NOTE));

    	// 入力チェック
		AccountValidater valid = new AccountValidater();
    	Map<String, String> messageMap = valid.validate(dto, getDisplayId());
    	if (messageMap.size() != 0) {
    		throw new SalesManagementApplicationException(messageMap);
    	}

    	try {
	    	// 登録
    		SessionInfo si = (SessionInfo)request.getAttribute(SessionInfo.SESSION_ATTRIBUTE_NAME);
	    	service.insert(si, dto);
    	} catch (Exception e) {
    		messageMap.put("E00190002", String.format(MessageReader.read("E801")));
    		throw new SalesManagementSystemException(messageMap);
    	}
	}

}
