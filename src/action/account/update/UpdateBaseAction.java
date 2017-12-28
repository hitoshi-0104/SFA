package action.account.update;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.account.bean.UpdateBean;
import action.account.constant.ReqParam;
import action.base.BaseAction;
import exception.SalesManagementSystemException;
import service.account.common.GetSelectItems;
import service.account.dto.SelectItemsDto;
import service.account.dto.UpdateDto;
import service.account.dto.UpdateSearchDto;
import service.account.update.SearchService;
import util.converter.StringConverter;
import util.message.MessageReader;
import util.session.SessionInfo;
import util.validate.StringValidater;

/**
 * 取引先更新の基底アクションクラス
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

    	// セレクトボック用のアイテム取得
    	GetSelectItems gsi = new GetSelectItems();
    	SelectItemsDto dto = gsi.get();

    	// DTOからBEANに設定
    	UpdateBean bean = getUpdateBeanInstance();

    	// 取引先ID
    	bean.setId(udto.getId());
    	// 取引先名
    	bean.setAccountName(udto.getAccountName());
    	// 親取引先ID
    	bean.setParentId(udto.getParentId());
    	// 親取引先
    	bean.setParent(udto.getParent());
    	// 取引先番号
    	bean.setAccountNo(udto.getAccountNo());
    	// 取引先部門
    	bean.setDepartment(udto.getDepartment());
    	// 業種
    	bean.setIndustry(udto.getIndustry());
    	// 年間売上
    	bean.setAmount(udto.getAmount());
    	// 評価
    	bean.setEvaluation(udto.getEvaluation());
    	// 電話
    	bean.setPhone(udto.getPhone());
    	// FAX
    	bean.setFax(udto.getFax());
    	// URL
    	bean.setUrl(udto.getUrl());
    	// 従業員数
    	bean.setEmployee(udto.getEmployee());
    	// 証券コード
    	bean.setStockCode(udto.getStockCode());
    	// 郵便番号
    	bean.setPostalCode(udto.getPostalCode());
    	// 都道府県
    	bean.setDivision(udto.getDivision());
    	// 市区郡
    	bean.setCity(udto.getCity());
    	// 町名・番地・建物名
    	bean.setTown(udto.getTown());
    	// その他
    	bean.setNote(udto.getNote());

    	// セレクトボックス用のアイテムのセット
    	bean.setEstimationMap(dto.getEstimationMap());
    	bean.setIndustryMap(dto.getIndustryMap());
    	bean.setDivisionMap(dto.getDivisionMap());

    	// BEANのセット
    	request.setAttribute(UPDATE_BEAN, bean);

    }

	/**
	 * 画面ID取得
	 */
	@Override
	protected String getDisplayId() {
		return "012";
	}

    /**
     * リクエストパラメータからCreateBeanの作成
     * @param request
     * @return
     */
    protected void setParamsToUpdateBean() {

    	UpdateBean bean = getUpdateBeanInstance();

    	// 取引先ID
    	bean.setId(StringConverter.toInteger(request.getParameter(ReqParam.Update.ID)));
    	// 取引先名
    	bean.setAccountName(request.getParameter(ReqParam.Update.ACCOUNT_NAME));
    	// 親取引先
    	bean.setParentId(StringConverter.toInteger(request.getParameter(ReqParam.Update.PARENT)));
    	// 取引先番号
    	bean.setAccountName(request.getParameter(ReqParam.Update.ACCOUNT_NO));
    	// 取引先部門
    	bean.setDepartment(request.getParameter(ReqParam.Update.DEPARTMENT));
    	// 業種
    	bean.setIndustry(request.getParameter(ReqParam.Update.INDUSTRY));
    	// 年間売上
    	bean.setAmount(StringConverter.toLong(request.getParameter(ReqParam.Update.AMOUNT)));
    	// 評価
    	bean.setEvaluation(request.getParameter(ReqParam.Update.EVALUATION));
    	// 電話
    	bean.setPhone(request.getParameter(ReqParam.Update.PHONE));
    	// FAX
    	bean.setFax(request.getParameter(ReqParam.Update.FAX));
    	// URL
    	bean.setUrl(request.getParameter(ReqParam.Update.URL));
    	// 従業員数
    	bean.setEmployee(StringConverter.toInteger(request.getParameter(ReqParam.Update.EMPLOYEE)));
    	// 証券コード
    	bean.setStockCode(request.getParameter(ReqParam.Update.STOCK_CODE));
    	// 郵便番号
    	bean.setPostalCode(request.getParameter(ReqParam.Update.POSTAL_CODE));
    	// 都道府県
    	bean.setDivision(request.getParameter(ReqParam.Update.DIVISION));
    	// 市区郡
    	bean.setCity(request.getParameter(ReqParam.Update.CITY));
    	// 町名・番地・建物名
    	bean.setTown(request.getParameter(ReqParam.Update.TOWN));
    	// その他
    	bean.setNote(request.getParameter(ReqParam.Update.NOTE));

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
