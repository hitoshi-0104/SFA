/**
 * 共通のjavascript
 */

/**
 * サブミット処理
 * @param url
 * @returns
 */
function submitAction(id, url) {
	$(id).attr('action', url);
	$(id).submit();
}

/**
 * 一覧表示用に項目の値を成型する
 * @param item
 * @param index
 * @returns
 */
function moldingListItem(item, index) {
	if (item.length <= index) {
		// 指定された桁数以下なら何もしない
		return item;
	}

	// 指定された桁数を超過していたら値を成型する
	// 指定された桁数で値を切る
	// 文字の最後を「...」に変更
	var val = item.substring(item, index);
	val = val + '...';
	return val;
}