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