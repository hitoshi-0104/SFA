package action.lead.constant;

/**
 * リクエストパラメータ名の定数クラス
 *
 */
public class ReqParam {

	/**
	 * 見込み客新規登録画面
	 *
	 */
	public class Create {
		/** 姓 */
		public static final String LAST_NAME = "lastname";
		/** 名 */
		public static final String FIRST_NAME = "firstname";
		/** 会社名 */
		public static final String COMPANY_NAME = "companyname";
		/** 役職名 */
		public static final String POSITION_NAME = "positionname";
		/** ソース */
		public static final String SOURCE = "source";
		/** 状況 */
		public static final String STATUS = "status";
		/** 評価 */
		public static final String ESTIMATION = "estimation";
		/** 電話 */
		public static final String PHONE = "phone";
		/** 携帯 */
		public static final String MOBILE_PHONE = "mobilephone";
		/** FAX */
		public static final String FAX = "fax";
		/** メール */
		public static final String MAIL_ADDRESS = "mailaddress";
		/** URL */
		public static final String URL = "url";
		/** 業種 */
		public static final String INDUSTRY = "industry";
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
	 * 見込み客更新画面
	 *
	 */
	public class Update {
		/** ID */
		public static final String ID = "leadid";
		/** 姓 */
		public static final String LAST_NAME = "lastname";
		/** 名 */
		public static final String FIRST_NAME = "firstname";
		/** 会社名 */
		public static final String COMPANY_NAME = "companyname";
		/** 役職名 */
		public static final String POSITION_NAME = "positionname";
		/** ソース */
		public static final String SOURCE = "source";
		/** 状況 */
		public static final String STATUS = "status";
		/** 評価 */
		public static final String ESTIMATION = "estimation";
		/** 電話 */
		public static final String PHONE = "phone";
		/** 携帯 */
		public static final String MOBILE_PHONE = "mobilephone";
		/** FAX */
		public static final String FAX = "fax";
		/** メール */
		public static final String MAIL_ADDRESS = "mailaddress";
		/** URL */
		public static final String URL = "url";
		/** 業種 */
		public static final String INDUSTRY = "industry";
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
		/** 新規／既存 */
		public static final String ACCOUNT = "account";
		/** 紐づけ先の取引先ID */
		public static final String LINKED_ACCOUNT_ID = "acocountid";
	}

	/**
	 * 見込み客検索画面
	 *
	 */
	public class List {
		/** 姓 */
		public static final String LAST_NAME = "lastname";
		/** 名 */
		public static final String FIRST_NAME = "firstname";
		/** 会社名 */
		public static final String COMPANY_NAME = "companyname";
		/** ソース */
		public static final String SOURCE = "source";
		/** 状況 */
		public static final String STATUS = "status";
		/** 評価 */
		public static final String ESTIMATION = "estimation";
		/** 業種 */
		public static final String INDUSTRY = "industry";
		/** 都道府県 */
		public static final String DIVISION = "division";
		/** ページ */
		public static final String CUR_PAGE = "curpage";
	}

}
