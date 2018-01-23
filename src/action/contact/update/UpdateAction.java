package action.contact.update;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.contact.constant.ReqParam;
import exception.SalesManagementApplicationException;
import exception.SalesManagementRuntimeException;
import exception.SalesManagementSystemException;
import service.contact.common.ContactValidater;
import service.contact.dto.ContactDto;
import service.contact.update.UpdateService;
import util.constant.JspPath;
import util.converter.StringConverter;
import util.message.MessageReader;
import util.session.SessionInfo;

/**
 * 取引先担当者更新画面のアクションクラス
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
		ContactDto dto = new ContactDto();

		// 取引先担当者ID
		dto.setId(StringConverter.toInteger(request.getParameter(ReqParam.Create.ID)));
		// 姓
		dto.setLastName(request.getParameter(ReqParam.Create.LAST_NAME));
		// 名
		dto.setFirstName(request.getParameter(ReqParam.Create.FIRST_NAME));
		// 取引先
		dto.setAccountId(StringConverter.toInteger(request.getParameter(ReqParam.Create.ACCOUNT_ID)));
		// 部署
		dto.setDepartment(request.getParameter(ReqParam.Create.DEPARTMENT));
		// 役職
		dto.setPosition(request.getParameter(ReqParam.Create.POSITION));
		// 電話
		dto.setPhone(request.getParameter(ReqParam.Create.PHONE));
		// 携帯
		dto.setMobilePhone(request.getParameter(ReqParam.Create.MOBILE_PHONE));
		// FAX
		dto.setFax(request.getParameter(ReqParam.Create.FAX));
		// メール
		dto.setMail(request.getParameter(ReqParam.Create.MAIL));
		// 上司
		dto.setBoss(StringConverter.toInteger(request.getParameter(ReqParam.Create.BOSS)));
		// その他
		dto.setNote(request.getParameter(ReqParam.Create.NOTE));

    	// 入力チェック
		ContactValidater valid = new ContactValidater();
    	Map<String, String> messageMap = valid.validate(dto, getDisplayId());
    	if (messageMap.size() != 0) {
    		throw new SalesManagementApplicationException(messageMap);
    	}

    	UpdateService service = new UpdateService();
    	try {
	    	// 更新
    		SessionInfo si = (SessionInfo)request.getAttribute(SessionInfo.SESSION_ATTRIBUTE_NAME);
	    	service.update(si, dto);
    	} catch (Exception e) {
    		messageMap.put("E00190002", String.format(MessageReader.read("E801")));
    		throw new SalesManagementSystemException(messageMap);
    	}

	}

}
