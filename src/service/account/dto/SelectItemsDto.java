package service.account.dto;

import java.util.Map;

public class SelectItemsDto {

	/** 評価マップ */
	private Map<String, String> estimationMap;
	/** 業種マップ */
	private Map<String, String> industryMap;
	/** 都道府県マップ */
	private Map<String, String> divisionMap;

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
