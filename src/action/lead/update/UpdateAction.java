package action.lead.update;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.lead.constant.ReqParam;
import exception.SalesManagementApplicationException;
import exception.SalesManagementRuntimeException;
import exception.SalesManagementSystemException;
import service.lead.common.LeadValidater;
import service.lead.dto.LeadDto;
import service.lead.update.UpdateService;
import util.constant.JspPath;
import util.converter.StringConverter;
import util.message.MessageReader;
import util.session.SessionInfo;

/**
 * 見込み客の更新処理のアクションクラス
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

		return JspPath.Lead.LIST_ACTION;
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
		LeadDto dto = new LeadDto();

		// ID
		dto.setId(StringConverter.toInteger(request.getParameter(ReqParam.Update.ID)));
		// 姓
		dto.setLastName(request.getParameter(ReqParam.Update.LAST_NAME));
		// 名
		dto.setFirstName(request.getParameter(ReqParam.Update.FIRST_NAME));
		// 会社名
		dto.setCompanyName(request.getParameter(ReqParam.Update.COMPANY_NAME));
		// 役職名
		dto.setPosition(request.getParameter(ReqParam.Update.POSITION_NAME));
		// ソース
		dto.setSourceCode(request.getParameter(ReqParam.Update.SOURCE));
		// 状況
		dto.setStatusCode(request.getParameter(ReqParam.Update.STATUS));
		// 評価
		dto.setEstimationCode(request.getParameter(ReqParam.Update.ESTIMATION));
		// 電話
		dto.setPhone(request.getParameter(ReqParam.Update.PHONE));
		// 携帯
		dto.setMobilePhone(request.getParameter(ReqParam.Update.MOBILE_PHONE));
		// FAX
		dto.setFax(request.getParameter(ReqParam.Update.FAX));
		// メール
		dto.setMailAddress(request.getParameter(ReqParam.Update.MAIL_ADDRESS));
		// URL
		dto.setUrl(request.getParameter(ReqParam.Update.URL));
		// 業種
		dto.setIndustryCode(request.getParameter(ReqParam.Update.INDUSTRY));
		// 年間売上
		dto.setAmount(StringConverter.toLong(request.getParameter(ReqParam.Update.AMOUNT)));
		// 従業員数
		dto.setEmployees(StringConverter.toInteger(request.getParameter(ReqParam.Update.EMPLOYEE)));
		// 郵便番号
		dto.setPostalCode(request.getParameter(ReqParam.Update.POSTAL_CODE));
		// 都道府県
		dto.setDivisionCode(request.getParameter(ReqParam.Update.DIVISION));
		// 市区郡
		dto.setCity(request.getParameter(ReqParam.Update.CITY));
		// 町名・番地・建物名
		dto.setTown(request.getParameter(ReqParam.Update.TOWN));
		// その他
		dto.setNote(request.getParameter(ReqParam.Update.NOTE));

		UpdateService service = new UpdateService();

		// 入力チェック
		LeadValidater valid = new LeadValidater();
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
