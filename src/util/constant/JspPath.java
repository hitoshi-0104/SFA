package util.constant;

/**
 * JSPパスを定義する定数クラス
 *
 */
public class JspPath {

	/**
	 * 見込み客
	 *
	 */
	public class Lead {
		/** 見込み客新規登録 */
		public static final String CREATE = "/view/lead/create.jsp";
		/** 見込み客更新 */
		public static final String UPDATE = "/view/lead/update.jsp";
		/** 見込み客削除 */
		public static final String DELETE = "/view/lead/delete.jsp";
		/** 見込み客一覧 */
		public static final String LIST = "/view/lead/list.jsp";
		/** 見込み客一覧アクション */
		public static final String LIST_ACTION = "/lead.list.show.action";
	}

	/**
	 * 取引先
	 *
	 */
	public class Account {
		/** 取引先新規登録 */
		public static final String CREATE = "/view/account/create.jsp";
		/** 取引先更新 */
		public static final String UPDATE = "/view/account/update.jsp";
		/** 取引先削除 */
		public static final String DELETE = "/view/account/delete.jsp";
		/** 取引先一覧 */
		public static final String LIST = "/view/account/list.jsp";
		/** 見込み客一覧アクション */
		public static final String LIST_ACTION = "/account.list.show.action";
	}

}
