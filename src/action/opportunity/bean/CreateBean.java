package action.opportunity.bean;

import java.util.Map;

import action.base.bean.BaseBean;

/**
 * 商談新規登録のビーン
 *
 */
public class CreateBean extends BaseBean {

	/** ID */
	private String id;
	/** 商談名 */
	private String opportunityName;
	/** 見込み客ID */
	private String leadId;
	/** 見込み客名 */
	private String leadName;
	/** 取引先ID */
	private String accountId;
	/** 取引先名 */
	private String accountName;
	/** 種別 */
	private String type;
	/** リードソース */
	private String leadSource;
	/** 金額 */
	private String ammount;
	/** 完了予定日 */
	private String completionDate;
	/** フェーズID */
	private String phase;
	/** 確度 */
	private String accuracy;
	/** その他 */
	private String note;

	/** 種別のリスト */
	private Map<String, String> typeMap;
	/** リードソースのリスト */
	private Map<String, String> leadSourceMap;
	/** フェーズのリスト */
	private Map<String, String> phaseMap;

	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id セットする id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return opportunityName
	 */
	public String getOpportunityName() {
		return opportunityName;
	}
	/**
	 * @param opportunityName セットする opportunityName
	 */
	public void setOpportunityName(String opportunityName) {
		this.opportunityName = opportunityName;
	}
	/**
	 * @return leadId
	 */
	public String getLeadId() {
		return leadId;
	}
	/**
	 * @param leadId セットする leadId
	 */
	public void setLeadId(String leadId) {
		this.leadId = leadId;
	}
	/**
	 * @return leadName
	 */
	public String getLeadName() {
		return leadName;
	}
	/**
	 * @param leadName セットする leadName
	 */
	public void setLeadName(String leadName) {
		this.leadName = leadName;
	}
	/**
	 * @return accountId
	 */
	public String getAccountId() {
		return accountId;
	}
	/**
	 * @param accountId セットする accountId
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	/**
	 * @return accountName
	 */
	public String getAccountName() {
		return accountName;
	}
	/**
	 * @param accountName セットする accountName
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	/**
	 * @return type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type セットする type
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return leadSource
	 */
	public String getLeadSource() {
		return leadSource;
	}
	/**
	 * @param leadSource セットする leadSource
	 */
	public void setLeadSource(String leadSource) {
		this.leadSource = leadSource;
	}
	/**
	 * @return ammount
	 */
	public String getAmmount() {
		return ammount;
	}
	/**
	 * @param ammount セットする ammount
	 */
	public void setAmmount(String ammount) {
		this.ammount = ammount;
	}
	/**
	 * @return completionDate
	 */
	public String getCompletionDate() {
		return completionDate;
	}
	/**
	 * @param completionDate セットする completionDate
	 */
	public void setCompletionDate(String completionDate) {
		this.completionDate = completionDate;
	}
	/**
	 * @return phaseId
	 */
	public String getPhase() {
		return phase;
	}
	/**
	 * @param phaseId セットする phaseId
	 */
	public void setPhase(String phase) {
		this.phase = phase;
	}
	/**
	 * @return accuracy
	 */
	public String getAccuracy() {
		return accuracy;
	}
	/**
	 * @param accuracy セットする accuracy
	 */
	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}
	/**
	 * @return note
	 */
	public String getNote() {
		return note;
	}
	/**
	 * @param note セットする note
	 */
	public void setNote(String note) {
		this.note = note;
	}
	/**
	 * @return typeMap
	 */
	public Map<String, String> getTypeMap() {
		return typeMap;
	}
	/**
	 * @param typeMap セットする typeMap
	 */
	public void setTypeMap(Map<String, String> typeMap) {
		this.typeMap = typeMap;
	}
	/**
	 * @return leadSourceMap
	 */
	public Map<String, String> getLeadSourceMap() {
		return leadSourceMap;
	}
	/**
	 * @param leadSourceMap セットする leadSourceMap
	 */
	public void setLeadSourceMap(Map<String, String> leadSourceMap) {
		this.leadSourceMap = leadSourceMap;
	}
	/**
	 * @return phaseMap
	 */
	public Map<String, String> getPhaseMap() {
		return phaseMap;
	}
	/**
	 * @param phaseMap セットする phaseMap
	 */
	public void setPhaseMap(Map<String, String> phaseMap) {
		this.phaseMap = phaseMap;
	}

}
