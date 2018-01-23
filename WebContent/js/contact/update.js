/**
 * 取引先更新のJS
 */
$(function() {

	// 更新ボタン押下
	$('#updatebutton').click(function() {
		submitAction('#accountform', '/SFA/contact.update.update.action');
	});

	// 削除ボタン押下
	$('#deletebutton').click(function() {
		submitAction('#accountform', '/SFA/contact.update.delete.action');
	});

	// 戻るボタン押下
	$('#returnbutton').click(function() {
		submitAction('#accountform', '/SFA/contact.list.show.action');
	});

	// 取引先の検索ボタン押下処理
	$('#accountsearchbutton').click(function() {
		$('#retaccountid').val('#accountid');
		$('#retaccountname').val('#accountname');
	});

	// 取引先のクリアボタン押下処理
	$('#accountclearbutton').click(function() {
		$('#accountid').val('');
		$('#accountname').val('');
	});

	// 上司の検索ボタン押下処理
	$('#bosssearchbutton').click(function() {
		$('#retcontactid').val('#bossid');
		$('#retcontactname').val('#bossname');
	});

	// 上司のクリアボタン押下処理
	$('#bossclearbutton').click(function() {
		$('#bossid').val('');
		$('#bossname').val('');
	});

});