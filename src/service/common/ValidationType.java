package service.common;

/**
 * バリデーションタイプ
 *
 */
public enum ValidationType {
	// 必須入力チェック
	REQURIRED,
	// 最大桁数チェック
	MAXLENGTH,
	// 桁数FROM, TOチェック
	FROMTO,
	// 数値入力チェック
	NUMERICONLY
}
