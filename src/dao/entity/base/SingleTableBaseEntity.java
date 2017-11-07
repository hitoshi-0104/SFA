package dao.entity.base;

import java.time.LocalDateTime;

/**
 * 単一テーブルのエンティティ基底クラス
 *
 */
public class SingleTableBaseEntity extends BaseEntity {

	/** ID */
	private String id;
	/** 作成者ID */
	private String createrId;
	/** 作成日時 */
	private LocalDateTime createDate;
	/** 更新者ID */
	private String updaterId;
	/** 更新日時 */
	private LocalDateTime updateDate;
	/** 削除フラグ */
	private Integer deleteFlag;

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
	 * @return createrId
	 */
	public String getCreaterId() {
		return createrId;
	}
	/**
	 * @param createrId セットする createrId
	 */
	public void setCreaterId(String createrId) {
		this.createrId = createrId;
	}
	/**
	 * @return createDate
	 */
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	/**
	 * @param createDate セットする createDate
	 */
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
	/**
	 * @return updaterId
	 */
	public String getUpdaterId() {
		return updaterId;
	}
	/**
	 * @param updaterId セットする updaterId
	 */
	public void setUpdaterId(String updaterId) {
		this.updaterId = updaterId;
	}
	/**
	 * @return updateDate
	 */
	public LocalDateTime getUpdateDate() {
		return updateDate;
	}
	/**
	 * @param updateDate セットする updateDate
	 */
	public void setUpdateDate(LocalDateTime updateDate) {
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
