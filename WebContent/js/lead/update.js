/**
 * 見込み客更新画面用のJS
 */
$(function() {

	// 開始ボタン押下
	$('#accountbutton').click(function() {
		submitAction('#leadform', '/SFA/lead.update.account.action');
	});

	// 更新ボタン押下
	$('#updatebutton').click(function() {
		submitAction('#leadform', '/SFA/lead.update.update.action');
	});

	// 戻るボタン押下
	$('#returnbutton').click(function() {
		submitAction('#leadform', '/SFA/lead.list.show.action');
	});

	// 新規取引先の作成ラジオボタン選択
	$('#newradio').change(function() {

	});

	// 既存取引先の担当者として作成
	$('#curradio').change(function() {

	});

});