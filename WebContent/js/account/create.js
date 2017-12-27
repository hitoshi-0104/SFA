/**
 * 取引先新規登録画面用のJS
 */
$(function() {

	// 連続登録ボタン押下
	$('#continuousbutton').click(function() {
		submitAction('#accountform', '/SFA/account.create.continuous.action');
	});

	// 登録ボタン押下
	$('#insertbutton').click(function() {
		submitAction('#accountform', '/SFA/account.create.regist.action');
	});

	// 戻るボタン押下
	$('#returnbutton').click(function() {
		submitAction('#accountform', '/SFA/account.create.return.action');
	});

	// 親取引先の検索ボタン押下処理
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