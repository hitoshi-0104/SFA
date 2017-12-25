package action.account.create;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.account.bean.CreateBean;
import action.base.BaseAction;
import exception.SalesManagementSystemException;
import service.lead.common.GetSelectItems;
import service.lead.dto.SelectItemsDto;

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

		// セレクトボック用のアイテム取得
    	GetSelectItems logic = new GetSelectItems();
    	SelectItemsDto dto = logic.get();

    	// DTOからBEANに設定
    	CreateBean bean = getCreateBeanInstance();
    	bean.setEvaluationMap(dto.getEstimationMap());
    	bean.setIndustryMap(dto.getIndustryMap());
    	bean.setDivisionMap(dto.getDivisionMap());

    	// BEANのセット
    	request.setAttribute(CREATE_BEAN, bean);

	}

	/**
	 * 画面IDの取得
	 */
	@Override
	public String getDisplayId() {
		return "011";
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
