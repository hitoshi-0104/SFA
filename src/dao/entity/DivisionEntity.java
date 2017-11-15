package dao.entity;

import dao.entity.base.SingleTableBaseEntity;

/**
 * 都道府県エンティティ
 *
 */
public class DivisionEntity extends SingleTableBaseEntity {

	/** コード */
	private String code;
	/** 都道府県名 */
	private String name;

	/**
	 * @return code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code セットする code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

}
