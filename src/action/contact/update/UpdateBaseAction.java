package action.contact.update;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.base.BaseAction;
import action.contact.bean.UpdateBean;
import action.contact.constant.ReqParam;
import exception.SalesManagementSystemException;
import service.contact.dto.UpdateDto;
import service.contact.dto.UpdateSearchDto;
import service.contact.update.SearchService;
import util.converter.StringConverter;
import util.message.MessageReader;
import util.session.SessionInfo;
import util.validate.StringValidater;

/**
 * 取引先担当者更新の基底クラス
 *
 */
public abstract class UpdateBaseAction extends BaseAction {

	/** Attribute設定名：UpdateBean */
	private static final String UPDATE_BEAN = "updateBean";

	/**
	 * コンストラクタ
	 */
	protected UpdateBaseAction(HttpServletRequest request, HttpServletResponse response) throws SalesManagementSystemException {
		super(request, response);
	}

	/**
     * 初期処理
     */
	@Override
    protected void initialize() throws SalesManagementSystemException {

		// 更新データの取得
		UpdateSearchDto usdto = new UpdateSearchDto();
		String id = request.getParameter(ReqParam.Update.ID);
		if (StringValidater.isEmpty(id)) {
			Map<String, String> m = new HashMap<String, String>();
			m.put("E00290001", String.format(MessageReader.read("E804")));
			throw new SalesManagementSystemException(m);
		}
		usdto.setId(Integer.valueOf(id));
		SessionInfo si = (SessionInfo)request.getAttribute(SessionInfo.SESSION_ATTRIBUTE_NAME);

		SearchService service = new SearchService();
		UpdateDto udto = null;
		try {
			udto = service.search(si, usdto);
		} catch (Exception e) {
			Map<String, String> m = new HashMap<String, String>();
			m.put("E00290001", String.format(MessageReader.read("E804")));
			throw new SalesManagementSystemException(m);
		}

		// DTOからBEANに設定
		UpdateBean bean = new UpdateBean();

		// 取引先担当者ID
		bean.setId(udto.getId());
		// 姓
		bean.setLastName(udto.getLastName());
		// 名
		bean.setFirstName(udto.getFirstName());
		// 取引先
		bean.setAccountId(udto.getAccountId());
		// 取引先名
		bean.setAccountName(udto.getAccountName());
		// 部署
		bean.setDepartment(udto.getDepartment());
		// 役職
		bean.setPosition(udto.getPosition());
		// 電話
		bean.setPhone(udto.getPhone());
		// 携帯
		bean.setMobilePhone(udto.getMobilePhone());
		// FAX
		bean.setFax(udto.getFax());
		// メール
		bean.setMail(udto.getMail());
		// 上司
		bean.setBoss(udto.getBoss());
		// 上司名
		bean.setBossName(udto.getBossName());
		// その他
		bean.setNote(udto.getNote());

		// BEANのセット
		request.setAttribute(UPDATE_BEAN, bean);

    }

	/**
	 * 画面ID取得
	 */
	@Override
	protected String getDisplayId() {
		return "022";
	}

    /**
     * リクエストパラメータからUpdateBeanの作成
     * @param request
     * @return
     */
    protected void setParamsToUpdateBean() {

    	UpdateBean bean = getUpdateBeanInstance();

    	// 取引先担当者ID
		bean.setId(StringConverter.toInteger(request.getParameter(ReqParam.Update.ID)));
		// 姓
		bean.setLastName(request.getParameter(ReqParam.Update.LAST_NAME));
		// 名
		bean.setFirstName(request.getParameter(ReqParam.Update.FIRST_NAME));
		// 取引先
		bean.setAccountId(StringConverter.toInteger(request.getParameter(ReqParam.Update.ACCOUNT_ID)));
		// 取引先名
		bean.setAccountName(request.getParameter(ReqParam.Update.ACCOUNT_NAME));
		// 部署
		bean.setDepartment(request.getParameter(ReqParam.Update.DEPARTMENT));
		// 役職
		bean.setPosition(request.getParameter(ReqParam.Update.POSITION));
		// 電話
		bean.setPhone(request.getParameter(ReqParam.Update.PHONE));
		// 携帯
		bean.setMobilePhone(request.getParameter(ReqParam.Update.MOBILE_PHONE));
		// FAX
		bean.setFax(request.getParameter(ReqParam.Update.FAX));
		// メール
		bean.setMail(request.getParameter(ReqParam.Update.MAIL));
		// 上司
		bean.setBoss(StringConverter.toInteger(request.getParameter(ReqParam.Update.BOSS)));
		// 上司名
		bean.setBossName(request.getParameter(ReqParam.Update.BOSS_NAME));
		// その他
		bean.setNote(request.getParameter(ReqParam.Update.NOTE));

		// BEANのセット
		request.setAttribute(UPDATE_BEAN, bean);

    }

    /**
     * UpdateBeanインスタンスの生成
     * @return
     */
    private UpdateBean getUpdateBeanInstance() {
		UpdateBean bean;
    	if (request.getAttribute(UPDATE_BEAN) == null) {
    		bean = new UpdateBean();
    	} else {
    		bean = (UpdateBean)request.getAttribute(UPDATE_BEAN);
    	}
    	return bean;
	}

}
