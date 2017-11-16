package dao.entity;

import dao.entity.base.BaseEntity;

/**
 * シーケンスエンティティ
 *
 */
public class SequenceEntity extends BaseEntity {

	/** 名称 */
	private String name;
	/** シーケンス */
	private Integer seq;

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
	/**
	 * @return seq
	 */
	public Integer getSeq() {
		return seq;
	}
	/**
	 * @param seq セットする seq
	 */
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
}
