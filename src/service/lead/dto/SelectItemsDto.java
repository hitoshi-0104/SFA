package service.lead.dto;

import java.util.Map;

/**
 * 見込み客で利用するセレクトボックスのアイテム格納DTO
 * @author HITOSHI
 *
 */
public class SelectItemsDto {

	/** ソースマップ */
	private Map<String, String> sourceMap;
	/** 状況マップ */
	private Map<String, String> statusMap;
	/** 評価マップ */
	private Map<String, String> estimationMap;
	/** 業種マップ */
	private Map<String, String> industryMap;
	/** 都道府県マップ */
	private Map<String, String> divisionMap;

	/**
	 * @return sourceMap
	 */
	public Map<String, String> getSourceMap() {
		return sourceMap;
	}
	/**
	 * @param sourceMap セットする sourceMap
	 */
	public void setSourceMap(Map<String, String> sourceMap) {
		this.sourceMap = sourceMap;
	}
	/**
	 * @return statusMap
	 */
	public Map<String, String> getStatusMap() {
		return statusMap;
	}
	/**
	 * @param statusMap セットする statusMap
	 */
	public void setStatusMap(Map<String, String> statusMap) {
		this.statusMap = statusMap;
	}
	/**
	 * @return estimationMap
	 */
	public Map<String, String> getEstimationMap() {
		return estimationMap;
	}
	/**
	 * @param estimationMap セットする estimationMap
	 */
	public void setEstimationMap(Map<String, String> estimationMap) {
		this.estimationMap = estimationMap;
	}
	/**
	 * @return industryMap
	 */
	public Map<String, String> getIndustryMap() {
		return industryMap;
	}
	/**
	 * @param industryMap セットする industryMap
	 */
	public void setIndustryMap(Map<String, String> industryMap) {
		this.industryMap = industryMap;
	}
	/**
	 * @return divisionMap
	 */
	public Map<String, String> getDivisionMap() {
		return divisionMap;
	}
	/**
	 * @param divisionMap セットする divisionMap
	 */
	public void setDivisionMap(Map<String, String> divisionMap) {
		this.divisionMap = divisionMap;
	}

}
