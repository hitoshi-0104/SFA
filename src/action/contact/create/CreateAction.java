package action.contact.create;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.base.BaseAction;
import action.contact.bean.CreateBean;
import action.contact.constant.ReqParam;
import exception.SalesManagementSystemException;
import util.converter.StringConverter;

/**
 * 取引先新規登録のアクションクラス
 *
 */
abstract class CreateAction extends BaseAction {

	/** Attribute設定名：CreateBean */
	private static final String CREATE_BEAN = "createBean";

	/**
	 * コンストラクタ
	 * @param request
	 * @param response
	 * @throws SalesManagementSystemException
	 */
	public CreateAction(HttpServletRequest request, HttpServletResponse response)
			throws SalesManagementSystemException {
		super(request, response);
	}

	/**
	 * 初期化処理
	 */
	@Override
	protected void initialize() throws SalesManagementSystemException {

    	// BEANに設定
    	CreateBean bean = getCreateBeanInstance();

    	// BEANのセット
    	request.setAttribute(CREATE_BEAN, bean);

	}

	/**
	 * 画面IDの取得
	 */
	@Override
	public String getDisplayId() {
		return "021";
	}

	/**
     * リクエストパラメータからCreateBeanの作成
     * @param request
     * @return
     */
    protected void setParamsToCreateBean() {

    	CreateBean bean = getCreateBeanInstance();

    	// 取引先担当者ID
    	bean.setId(request.getParameter(ReqParam.Create.ID));
    	// 姓
    	bean.setLastName(request.getParameter(ReqParam.Create.LAST_NAME));
    	// 名
    	bean.setFirstName(request.getParameter(ReqParam.Create.FIRST_NAME));
    	// 取引先ID
    	bean.setAccountId(StringConverter.toInteger(request.getParameter(ReqParam.Create.ACCOUNT_ID)));
    	// 部署
    	bean.setDepartment(request.getParameter(ReqParam.Create.DEPARTMENT));
    	// 役職
    	bean.setPosition(request.getParameter(ReqParam.Create.POSITION));
    	// 電話
    	bean.setPhone(request.getParameter(ReqParam.Create.PHONE));
    	// 携帯
    	bean.setMobilePhone(request.getParameter(ReqParam.Create.MOBILE_PHONE));
    	// FAX
    	bean.setFax(request.getParameter(ReqParam.Create.FAX));
    	// メール
    	bean.setMail(request.getParameter(ReqParam.Create.MAIL));
    	// 上司
    	bean.setBossId(StringConverter.toInteger(request.getParameter(ReqParam.Create.BOSS)));
    	// その他
    	bean.setNote(request.getParameter(ReqParam.Create.NOTE));

    	request.setAttribute(CREATE_BEAN, bean);

    }

	/**
     * CreateBeanインスタンスの生成
     * @return
     */
    private CreateBean getCreateBeanInstance() {
		CreateBean bean;
    	if (request.getAttribute(CREATE_BEAN) == null) {
    		bean = new CreateBean();
    	} else {
    		bean = (CreateBean)request.getAttribute(CREATE_BEAN);
    	}
    	return bean;
	}

}
