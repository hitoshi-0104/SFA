package service.opportunity.dto;

import java.util.Map;

/**
 * 商談のセレクトボックスのアイテムを格納するDTO
 * @author yamazaki
 *
 */
public class SelectItemsDto {

	/** 種別のリスト */
	private Map<String, String> typeMap;
	/** リードソースのリスト */
	private Map<String, String> leadSourceMap;
	/** フェーズのリスト */
	private Map<String, String> phaseMap;

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
