package action.account.constant;

/**
 * 取引先機能のリクエストパラメータ定数クラス
 *
 */
public class ReqParam {

	/**
	 * 取引先新規登録画面
	 *
	 */
	public class Create {
		/** 取引先 */
		public static final String ACCOUNT_NAME = "accountname";
		/** 親取引先 */
		public static final String PARENT = "parent";
		/** 取引先番号 */
		public static final String ACCOUNT_NO = "accountno";
		/** 取引先部門 */
		public static final String DEPARTMENT = "department";
		/** 業種 */
		public static final String INDUSTRY = "industry";
		/** 評価 */
		public static final String EVALUATION = "evaluation";
		/** 電話 */
		public static final String PHONE = "phone";
		/** FAX */
		public static final String FAX = "fax";
		/** URL */
		public static final String URL = "url";
		/** 年間売上 */
		public static final String AMOUNT = "amount";
		/** 従業員数 */
		public static final String EMPLOYEE = "employee";
		/** 郵便番号 */
		public static final String POSTAL_CODE = "postalcode";
		/** 都道府県 */
		public static final String DIVISION = "division";
		/** 市区郡 */
		public static final String CITY = "city";
		/** 町名・番地・建物名 */
		public static final String TOWN = "town";
		/** その他 */
		public static final String NOTE = "note";
	}

	/**
	 * 一覧
	 *
	 */
	public class List {
		/** 取引先名 */
		public static final String ACCOUNT_NAME = "accountname";
		/** ページ */
		public static final String PAGE = "page";
	}

}
