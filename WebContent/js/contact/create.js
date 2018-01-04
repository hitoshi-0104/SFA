/**
 * 取引先担当者新規登録画面用のJS
 */
$(function() {

	// 連続登録ボタン押下
	$('#continuousbutton').click(function() {
		submitAction('#contactform', '/SFA/contact.create.continuous.action');
	});

	// 登録ボタン押下
	$('#insertbutton').click(function() {
		submitAction('#contactform', '/SFA/contact.create.regist.action');
	});

	// 戻るボタン押下
	$('#returnbutton').click(function() {
		submitAction('#contactform', '/SFA/contact.create.return.action');
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