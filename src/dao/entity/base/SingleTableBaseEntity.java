package dao.entity.base;

/**
 * 単一テーブルのエンティティ基底クラス
 *
 */
public class SingleTableBaseEntity extends BaseEntity {

	/** ID */
	private Integer id;
	/** 作成者ID */
	private Integer createrId;
	/** 作成日時 */
	private String createDate;
	/** 更新者ID */
	private Integer updaterId;
	/** 更新日時 */
	private String updateDate;
	/** 削除フラグ */
	private Integer deleteFlag;

	/**
	 * @return id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id セットする id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return createrId
	 */
	public Integer getCreaterId() {
		return createrId;
	}
	/**
	 * @param createrId セットする createrId
	 */
	public void setCreaterId(Integer createrId) {
		this.createrId = createrId;
	}
	/**
	 * @return createDate
	 */
	public String getCreateDate() {
		return createDate;
	}
	/**
	 * @param createDate セットする createDate
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	/**
	 * @return updaterId
	 */
	public Integer getUpdaterId() {
		return updaterId;
	}
	/**
	 * @param updaterId セットする updaterId
	 */
	public void setUpdaterId(Integer updaterId) {
		this.updaterId = updaterId;
	}
	/**
	 * @return updateDate
	 */
	public String getUpdateDate() {
		return updateDate;
	}
	/**
	 * @param updateDate セットする updateDate
	 */
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * @return deleteFlag
	 */
	public Integer getDeleteFlag() {
		return deleteFlag;
	}
	/**
	 * @param deleteFlag セットする deleteFlag
	 */
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

}
