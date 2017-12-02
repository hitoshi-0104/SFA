package action.lead.update;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.base.BaseAction;
import action.lead.bean.UpdateBean;
import action.lead.constant.ReqParam;
import exception.SalesManagementSystemException;
import service.lead.common.GetSelectItems;
import service.lead.dto.SelectItemsDto;
import service.lead.dto.UpdateDto;
import service.lead.dto.UpdateSearchDto;
import service.lead.update.SearchService;
import util.converter.StringConverter;
import util.message.MessageReader;
import util.session.SessionInfo;
import util.validate.StringValidater;

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

    	// セレクトボック用のアイテム取得
    	GetSelectItems gsi = new GetSelectItems();
    	SelectItemsDto dto = gsi.get();

    	// DTOからBEANに設定
    	UpdateBean bean = getUpdateBeanInstance();
    	// ID
    	bean.setId(udto.getId());
    	// 姓
    	bean.setLastName(udto.getLastName());
    	// 名
    	bean.setFirstName(udto.getFirstName());
    	// 会社名
    	bean.setCompanyName(udto.getCompanyName());
    	// 役職名
    	bean.setPosition(udto.getPosition());
    	// ソース
    	bean.setSourceCode(udto.getSourceCode());
    	// 状況
    	bean.setStatusCode(udto.getStatusCode());
    	// 評価
    	bean.setEstimationCode(udto.getEstimationCode());
    	// 電話
    	bean.setPhone(udto.getPhone());
    	// 携帯
    	bean.setMobilePhone(udto.getMobilePhone());
    	// FAX
    	bean.setFax(udto.getFax());
    	// メール
    	bean.setMailAddress(udto.getMailAddress());
    	// URL
    	bean.setUrl(udto.getUrl());
    	// 業種
    	bean.setIndustryCode(udto.getIndustryCode());
    	// 年間売上
    	bean.setAmount(udto.getAmount());
    	// 従業員数
    	bean.setEmployees(udto.getEmployees());
    	// 郵便番号
    	bean.setPostalCode(udto.getPostalCode());
    	// 都道府県
    	bean.setDivisionCode(udto.getDivisionCode());
    	// 市区郡
    	bean.setCity(udto.getCity());
    	// 町名・番地・建物名
    	bean.setTown(udto.getTown());
    	// その他
    	bean.setNote(udto.getNote());

    	// セレクトボックス用のアイテムのセット
    	bean.setSourceMap(dto.getSourceMap());
    	bean.setStatusMap(dto.getStatusMap());
    	bean.setEstimationMap(dto.getEstimationMap());
    	bean.setIndustryMap(dto.getIndustryMap());
    	bean.setDivisionMap(dto.getDivisionMap());

    	// BEANのセット
    	request.setAttribute(UPDATE_BEAN, bean);

    }

	/**
	 * 画面ID取得
	 */
	protected String getDisplayId() {
		return "002";
	}

    /**
     * リクエストパラメータからCreateBeanの作成
     * @param request
     * @return
     */
    protected void setParamsToUpdateBean() {

    	UpdateBean bean = getUpdateBeanInstance();

    	// ID
    	bean.setId(Integer.valueOf(request.getParameter(ReqParam.Update.ID)));
    	// 姓
    	bean.setLastName(request.getParameter(ReqParam.Update.LAST_NAME));
    	// 名
    	bean.setFirstName(request.getParameter(ReqParam.Update.FIRST_NAME));
    	// 会社名
    	bean.setCompanyName(request.getParameter(ReqParam.Update.COMPANY_NAME));
    	// 役職名
    	bean.setPosition(request.getParameter(ReqParam.Update.POSITION_NAME));
    	// ソース
    	bean.setSourceCode(request.getParameter(ReqParam.Update.SOURCE));
    	// 状況
    	bean.setStatusCode(request.getParameter(ReqParam.Update.STATUS));
    	// 評価
    	bean.setEstimationCode(request.getParameter(ReqParam.Update.ESTIMATION));
    	// 電話
    	bean.setPhone(request.getParameter(ReqParam.Update.PHONE));
    	// 携帯
    	bean.setMobilePhone(request.getParameter(ReqParam.Update.MOBILE_PHONE));
    	// FAX
    	bean.setFax(request.getParameter(ReqParam.Update.FAX));
    	// メール
    	bean.setMailAddress(request.getParameter(ReqParam.Update.MAIL_ADDRESS));
    	// URL
    	bean.setUrl(request.getParameter(ReqParam.Update.URL));
    	// 業種
    	bean.setIndustryCode(request.getParameter(ReqParam.Update.INDUSTRY));
    	// 年間売上
    	bean.setAmount(StringConverter.toLong(request.getParameter(ReqParam.Update.AMOUNT)));
    	// 従業員数
    	bean.setEmployees(StringConverter.toInteger(request.getParameter(ReqParam.Update.EMPLOYEE)));
    	// 郵便番号
    	bean.setPostalCode(request.getParameter(ReqParam.Update.POSTAL_CODE));
    	// 都道府県
    	bean.setDivisionCode(request.getParameter(ReqParam.Update.DIVISION));
    	// 市区郡
    	bean.setCity(request.getParameter(ReqParam.Update.CITY));
    	// 町名・番地・建物名
    	bean.setTown(request.getParameter(ReqParam.Update.TOWN));
    	// その他
    	bean.setNote(request.getParameter(ReqParam.Update.NOTE));

    	request.setAttribute(UPDATE_BEAN, bean);

    }

    /**
     * CreateBeanインスタンスの生成
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
