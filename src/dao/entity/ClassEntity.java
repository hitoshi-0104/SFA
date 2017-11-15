package dao.entity;

import dao.entity.base.SingleTableBaseEntity;

/**
 * 分類マスタエンティティ
 *
 */
public class ClassEntity extends SingleTableBaseEntity {

	/** CODE1 */
	private String code1;
	/** CODE1NAME */
	private String code1Name;
	/** CODE2 */
	private String code2;
	/** CODE2NAME */
	private String code2Name;

	/**
	 * @return code1
	 */
	public String getCode1() {
		return code1;
	}
	/**
	 * @param code1 セットする code1
	 */
	public void setCode1(String code1) {
		this.code1 = code1;
	}
	/**
	 * @return code1Name
	 */
	public String getCode1Name() {
		return code1Name;
	}
	/**
	 * @param code1Name セットする code1Name
	 */
	public void setCode1Name(String code1Name) {
		this.code1Name = code1Name;
	}
	/**
	 * @return code2
	 */
	public String getCode2() {
		return code2;
	}
	/**
	 * @param code2 セットする code2
	 */
	public void setCode2(String code2) {
		this.code2 = code2;
	}
	/**
	 * @return code2Name
	 */
	public String getCode2Name() {
		return code2Name;
	}
	/**
	 * @param code2Name セットする code2Name
	 */
	public void setCode2Name(String code2Name) {
		this.code2Name = code2Name;
	}

}
