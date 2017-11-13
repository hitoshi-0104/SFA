package action.lead.create;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.lead.constant.ReqParam;
import exception.SalesManagementApplicationException;
import exception.SalesManagementRuntimeException;
import exception.SalesManagementSystemException;
import service.lead.create.RegistService;
import service.lead.dto.CreateDto;
import util.constant.JspPath;
import util.converter.StringConverter;
import util.message.MessageReader;

/**
 * 見込み客新規登録画面：登録コントローラ
 *
 */
public class RegistAction extends CreateAction {

	/**
	 * コンストラクタ
	 * @param request
	 * @param response
	 */
	public RegistAction(HttpServletRequest request, HttpServletResponse response) {
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

		return JspPath.Lead.LIST;
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

		// 姓
		dto.setLastName(request.getParameter(ReqParam.Create.LAST_NAME));
		// 名
		dto.setFirstName(request.getParameter(ReqParam.Create.FIRST_NAME));
		// 会社名
		dto.setCompanyName(request.getParameter(ReqParam.Create.COMPANY_NAME));
		// 役職名
		dto.setPosition(request.getParameter(ReqParam.Create.POSITION_NAME));
		// ソース
		dto.setSourceCode(request.getParameter(ReqParam.Create.SOURCE));
		// 状況
		dto.setStatusCode(request.getParameter(ReqParam.Create.STATUS));
		// 評価
		dto.setEstimationCode(request.getParameter(ReqParam.Create.ESTIMATION));
		// 電話
		dto.setPhone(request.getParameter(ReqParam.Create.PHONE));
		// 携帯
		dto.setMobilePhone(request.getParameter(ReqParam.Create.MOBILE_PHONE));
		// FAX
		dto.setFax(request.getParameter(ReqParam.Create.FAX));
		// メール
		dto.setMailAddress(request.getParameter(ReqParam.Create.MAIL_ADDRESS));
		// URL
		dto.setUrl(request.getParameter(ReqParam.Create.URL));
		// 業種
		dto.setIndustryCode(request.getParameter(ReqParam.Create.INDUSTRY));
		// 年間売上
		dto.setAmount(StringConverter.toLong(request.getParameter(ReqParam.Create.AMOUNT)));
		// 従業員数
		dto.setEmployees(StringConverter.toInteger(request.getParameter(ReqParam.Create.EMPLOYEE)));
		// 郵便番号
		dto.setPostalCode(request.getParameter(ReqParam.Create.POSTAL_CODE));
		// 都道府県
		dto.setDivisionCode(request.getParameter(ReqParam.Create.DIVISION));
		// 市区郡
		dto.setCity(request.getParameter(ReqParam.Create.CITY));
		// 町名・番地・建物名
		dto.setTown(request.getParameter(ReqParam.Create.TOWN));
		// その他
		dto.setNote(request.getParameter(ReqParam.Create.NOTE));

    	// 入力チェック
    	Map<String, String> messageMap = service.validate(dto);
    	if (messageMap.size() != 0) {
    		throw new SalesManagementApplicationException(messageMap);
    	}

    	try {
	    	// 登録
	    	service.insert(request, dto);
    	} catch (Exception e) {
    		messageMap.put("E00190001", String.format(MessageReader.read("E801")));
    		throw new SalesManagementSystemException(messageMap);
    	}
	}
}
