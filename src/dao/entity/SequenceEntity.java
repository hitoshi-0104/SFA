package dao.entity;

/**
 * シーケンスエンティティ
 *
 */
public class SequenceEntity {

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
