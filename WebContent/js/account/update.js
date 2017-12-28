/**
 * 取引先更新のJS
 */
$(function() {

	// 更新ボタン押下
	$('#updatebutton').click(function() {
		submitAction('#accountform', '/SFA/account.update.update.action');
	});

	// 削除ボタン押下
	$('#deletebutton').click(function() {
		submitAction('#accountform', '/SFA/account.update.delete.action');
	});

	// 戻るボタン押下
	$('#returnbutton').click(function() {
		submitAction('#accountform', '/SFA/account.list.show.action');
	});

	// 取引先の検索ボタン押下処理
	$('#parentsearchbutton').click(function() {
		$('#retaccountid').val('#parentid');
		$('#retaccountname').val('#parent');
	});

	// 親取引先のクリアボタン押下処理
	$('#parentclearbutton').click(function() {
		$('#parentid').val('');
		$('#parent').val('');
	});

});