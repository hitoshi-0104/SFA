package util.constant;

/**
 * 項目の定義（名称・桁）の定数クラス
 *
 */
public class ItemDefine {

	/**
	 * 名称定義
	 *
	 */
	public class Name {
		/** 姓 */
		public static final String LAST_NAME = "姓";
		/** 名 */
		public static final String FIRST_NAME = "名";
		/** 会社名 */
		public static final String COMPANY_NAME = "会社名";
		/** 役職名 */
		public static final String POSITION = "役職名";
		/** 状況 */
		public static final String STATUS = "状況";
		/** 電話 */
		public static final String PHONE = "電話";
		/** 携帯 */
		public static final String MOBILE_PHONE = "携帯";
		/** FAX */
		public static final String FAX = "FAX";
		/** メール */
		public static final String MAILADDRESS = "メール";
		/** URL */
		public static final String URL = "URL";
		/** 年間売上 */
		public static final String AMOUNT = "年間売上";
		/** 従業員数 */
		public static final String EMPLOYEE = "従業員数";
		/** 郵便番号 */
		public static final String POSTAL_CODE = "郵便番号";
		/** 市区町村 */
		public static final String CITY = "市区町村";
		/** 町名・番地・建物 */
		public static final String TOWN = "町名・番地・建物";
		/** その他 */
		public static final String NOTE = "その他";
	}

	/**
	 * 桁定義
	 *
	 */
	public class Digit {
		/** 姓 */
		public static final int LAST_NAME = 50;
		/** 名 */
		public static final int FIRST_NAME = 50;
		/** 会社名 */
		public static final int COMPANY_NAME = 200;
		/** 役職名 */
		public static final int POSITION = 50;
		/** 電話 */
		public static final int PHONE = 11;
		/** 携帯 */
		public static final int MOBILE_PHONE = 11;
		/** FAX */
		public static final int FAX = 16;
		/** メール */
		public static final int MAILADDRESS = 256;
		/** URL */
		public static final int URL = 2048;
		/** 年間売上 */
		public static final int AMOUNT = 13;
		/** 従業員数 */
		public static final int EMPLOYEE = 7;
		/** 郵便番号 */
		public static final int POSTAL_CODE = 7;
		/** 市区町村 */
		public static final int CITY = 10;
		/** 町名・番地・建物 */
		public static final int TOWN = 500;
		/** その他 */
		public static final int NOTE = 1000;
	}

}
