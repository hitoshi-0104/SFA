package action.lead.create;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.base.BaseAction;
import action.lead.bean.CreateBean;
import action.lead.constant.ReqParam;
import exception.SalesManagementSystemException;
import service.lead.common.GetSelectItems;
import service.lead.dto.SelectItemsDto;
import util.converter.StringConverter;

/**
 * Servlet implementation class ListController
 */
abstract class CreateAction extends BaseAction {

	/** Attribute設定名：LeadBean */
	private static final String LEAD_BEAN = "leadBean";

	/**
	 * コンストラクタ
	 */
	protected CreateAction(HttpServletRequest request, HttpServletResponse response) throws SalesManagementSystemException {
		super(request, response);
	}

	/**
     * 初期処理
     */
	@Override
    protected void initialize() throws SalesManagementSystemException {

    	// セレクトボック用のアイテム取得
    	GetSelectItems logic = new GetSelectItems();
    	SelectItemsDto dto = logic.get();

    	// DTOからBEANに設定
    	CreateBean bean = getCreateBeanInstance();
    	bean.setSourceMap(dto.getSourceMap());
    	bean.setStatusMap(dto.getStatusMap());
    	bean.setEstimationMap(dto.getEstimationMap());
    	bean.setIndustryMap(dto.getIndustryMap());
    	bean.setDivisionMap(dto.getDivisionMap());

    	// BEANのセット
    	request.setAttribute(LEAD_BEAN, bean);

    }

    /**
     * リクエストパラメータからCreateBeanの作成
     * @param request
     * @return
     */
    protected void setParamsToLeadBean() {

    	CreateBean bean = getCreateBeanInstance();

    	// 姓
    	bean.setLastName(request.getParameter(ReqParam.Create.LAST_NAME));
    	// 名
    	bean.setFirstName(request.getParameter(ReqParam.Create.FIRST_NAME));
    	// 会社名
    	bean.setCompanyName(request.getParameter(ReqParam.Create.COMPANY_NAME));
    	// 役職名
    	bean.setPosition(request.getParameter(ReqParam.Create.POSITION_NAME));
    	// ソース
    	bean.setSourceCode(request.getParameter(ReqParam.Create.SOURCE));
    	// 状況
    	bean.setStatusCode(request.getParameter(ReqParam.Create.STATUS));
    	// 評価
    	bean.setEstimationCode(request.getParameter(ReqParam.Create.ESTIMATION));
    	// 電話
    	bean.setPhone(request.getParameter(ReqParam.Create.PHONE));
    	// 携帯
    	bean.setMobilePhone(request.getParameter(ReqParam.Create.MOBILE_PHONE));
    	// FAX
    	bean.setFax(request.getParameter(ReqParam.Create.FAX));
    	// メール
    	bean.setMailAddress(request.getParameter(ReqParam.Create.MAIL_ADDRESS));
    	// URL
    	bean.setUrl(request.getParameter(ReqParam.Create.URL));
    	// 業種
    	bean.setIndustryCode(request.getParameter(ReqParam.Create.INDUSTRY));
    	// 年間売上
    	bean.setAmount(StringConverter.toLong(request.getParameter(ReqParam.Create.AMOUNT)));
    	// 従業員数
    	bean.setEmployees(StringConverter.toInteger(request.getParameter(ReqParam.Create.EMPLOYEE)));
    	// 郵便番号
    	bean.setPostalCode(request.getParameter(ReqParam.Create.POSTAL_CODE));
    	// 都道府県
    	bean.setDivisionCode(request.getParameter(ReqParam.Create.DIVISION));
    	// 市区郡
    	bean.setCity(request.getParameter(ReqParam.Create.CITY));
    	// 町名・番地・建物名
    	bean.setTown(request.getParameter(ReqParam.Create.TOWN));
    	// その他
    	bean.setNote(request.getParameter(ReqParam.Create.NOTE));

    	request.setAttribute(LEAD_BEAN, bean);

    }

    /**
     * CreateBeanインスタンスの生成
     * @return
     */
    private CreateBean getCreateBeanInstance() {
		CreateBean bean;
    	if (request.getAttribute(LEAD_BEAN) == null) {
    		bean = new CreateBean();
    	} else {
    		bean = (CreateBean)request.getAttribute(LEAD_BEAN);
    	}
    	return bean;
	}

}
