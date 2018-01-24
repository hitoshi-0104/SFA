package action.opportunity.create;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.base.BaseAction;
import action.opportunity.bean.CreateBean;
import exception.SalesManagementSystemException;

/**
 * 商談新規登録の基底アクションクラス
 * @author yamazaki
 *
 */
public abstract class CreateAction extends BaseAction {

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

//		// セレクトボック用のアイテム取得
//    	GetSelectItems logic = new GetSelectItems();
//    	SelectItemsDto dto = logic.get();
//
//    	// DTOからBEANに設定
//    	CreateBean bean = getCreateBeanInstance();
//    	bean.setEvaluationMap(dto.getEstimationMap());
//    	bean.setIndustryMap(dto.getIndustryMap());
//    	bean.setDivisionMap(dto.getDivisionMap());
//
//    	// BEANのセット
//    	request.setAttribute(CREATE_BEAN, bean);

	}

	/**
	 * 画面IDの取得
	 */
	@Override
	public String getDisplayId() {
		return "031";
	}

	/**
     * リクエストパラメータからCreateBeanの作成
     * @param request
     * @return
     */
    protected void setParamsToCreateBean() {

//    	CreateBean bean = getCreateBeanInstance();
//
//    	// 取引先名
//    	bean.setAccountName(request.getParameter(ReqParam.Create.ACCOUNT_NAME));
//    	// 親取引先ID
//    	bean.setParentId(StringConverter.toInteger(request.getParameter(ReqParam.Create.PARENT_ID)));
//    	// 親取引先
//    	bean.setParent(request.getParameter(ReqParam.Create.PARENT));
//    	// 取引先番号
//    	bean.setAccountNo(request.getParameter(ReqParam.Create.ACCOUNT_NO));
//    	// 取引先部門
//    	bean.setDepartment(request.getParameter(ReqParam.Create.DEPARTMENT));
//    	// 業種
//    	bean.setIndustry(request.getParameter(ReqParam.Create.INDUSTRY));
//    	// 評価
//    	bean.setEvaluation(request.getParameter(ReqParam.Create.EVALUATION));
//    	// 電話
//    	bean.setPhone(request.getParameter(ReqParam.Create.PHONE));
//    	// FAX
//    	bean.setFax(request.getParameter(ReqParam.Create.FAX));
//    	// URL
//    	bean.setUrl(request.getParameter(ReqParam.Create.URL));
//    	// 年間売上
//    	bean.setAmount(StringConverter.toLong(request.getParameter(ReqParam.Create.AMOUNT)));
//    	// 従業員数
//    	bean.setEmployee(StringConverter.toInteger(request.getParameter(ReqParam.Create.EMPLOYEE)));
//    	// 証券コード
//    	bean.setStockCode(request.getParameter(ReqParam.Create.STOCK_CODE));
//    	// 郵便番号
//    	bean.setPostalCode(request.getParameter(ReqParam.Create.POSTAL_CODE));
//    	// 都道府県
//    	bean.setDivision(request.getParameter(ReqParam.Create.DIVISION));
//    	// 市区郡
//    	bean.setCity(request.getParameter(ReqParam.Create.CITY));
//    	// 町名・番地・建物名
//    	bean.setTown(request.getParameter(ReqParam.Create.TOWN));
//    	// その他
//    	bean.setNote(request.getParameter(ReqParam.Create.NOTE));
//
//    	request.setAttribute(CREATE_BEAN, bean);

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
