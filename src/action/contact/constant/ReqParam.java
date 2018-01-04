package action.contact.constant;

/**
 * 取引先担当者機能のリクエストパラメータ定義クラス
 *
 */
public class ReqParam {

	/**
	 * 新規作成
	 *
	 */
	public class Create {
		/** 取引先担当者ID */
		public static final String ID = "id";
		/** 姓 */
		public static final String LAST_NAME = "lastname";
		/** 名 */
		public static final String FIRST_NAME = "firstname";
		/** 取引先ID */
		public static final String ACCOUNT_ID = "accountid";
		/** 部署 */
		public static final String DEPARTMENT = "department";
		/** 役職 */
		public static final String POSITION = "position";
		/** 電話 */
		public static final String PHONE = "phone";
		/** 携帯 */
		public static final String MOBILE_PHONE = "mobilephone";
		/** FAX */
		public static final String FAX = "fax";
		/** メール */
		public static final String MAIL = "mail";
		/** 上司 */
		public static final String BOSS = "boss";
		/** その他 */
		public static final String NOTE = "note";
	}

}
