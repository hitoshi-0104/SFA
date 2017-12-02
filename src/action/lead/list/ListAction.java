package action.lead.list;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.base.BaseAction;
import action.lead.bean.ListBean;
import action.lead.constant.ReqParam;
import exception.SalesManagementSystemException;
import service.lead.common.GetSelectItems;
import service.lead.dto.SelectItemsDto;

/**
 * 見込み客検索のアクションクラス
 *
 */
abstract class ListAction extends BaseAction {

	/** Attribute設定名：ListBean */
	private static final String LIST_BEAN = "listBean";

	/**
	 * コンストラクタ
	 * @param request
	 * @param response
	 * @throws SalesManagementSystemException
	 */
	public ListAction(HttpServletRequest request, HttpServletResponse response) throws SalesManagementSystemException {
		super(request, response);
	}

	/**
	 * 初期化処理
	 */
	@Override
	protected void initialize() throws SalesManagementSystemException {

		// セレクトボック用のアイテム取得
    	GetSelectItems gsi = new GetSelectItems();
    	SelectItemsDto dto = gsi.get();

    	// DTOからBEANに設定
    	ListBean bean = getListBeanInstance();
    	bean.setStatusMap(dto.getStatusMap());
    	bean.setEstimationMap(dto.getEstimationMap());
    	bean.setDivisionMap(dto.getDivisionMap());

    	// BEANのセット
    	request.setAttribute(LIST_BEAN, bean);
	}

	/**
	 * 画面IDの取得
	 */
	@Override
	protected String getDisplayId() {
		return "004";
	}

	/**
     * リクエストパラメータからCreateBeanの作成
     * @param request
     * @return
     */
    protected void setParamsToListBean() {

    	ListBean bean = getListBeanInstance();

    	// 姓
    	bean.setLastName(request.getParameter(ReqParam.List.LAST_NAME));
    	// 名
    	bean.setFirstName(request.getParameter(ReqParam.List.FIRST_NAME));
    	// 会社名
    	bean.setCompanyName(request.getParameter(ReqParam.List.COMPANY_NAME));
    	// ソース
    	bean.setSourceCode(request.getParameter(ReqParam.List.SOURCE));
    	// 状況
    	bean.setStatusCode(request.getParameter(ReqParam.List.STATUS));
    	// 評価
    	bean.setEstimationCode(request.getParameter(ReqParam.List.ESTIMATION));
    	// 業種
    	bean.setIndustryCode(request.getParameter(ReqParam.List.INDUSTRY));
    	// 都道府県
    	bean.setDivisionCode(request.getParameter(ReqParam.List.DIVISION));

    	request.setAttribute(LIST_BEAN, bean);

    }

	/**
     * ListBeanインスタンスの生成
     * @return
     */
    private ListBean getListBeanInstance() {
		ListBean bean;
    	if (request.getAttribute(LIST_BEAN) == null) {
    		bean = new ListBean();
    	} else {
    		bean = (ListBean)request.getAttribute(LIST_BEAN);
    	}
    	return bean;
	}

}
