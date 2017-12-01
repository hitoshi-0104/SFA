/**
 * 見込み客更新画面用のJS
 */
$(function() {

	// 取引の開始ボタン押下
	$('#accountbutton').click(function() {
		submitAction('#leadform', '/SFA/lead.update.account.action');
	});

	// 更新ボタン押下
	$('#updatebutton').click(function() {
		submitAction('#leadform', '/SFA/lead.update.update.action');
	});

	// 戻るボタン押下
	$('#returnbutton').click(function() {
		submitAction('#leadform', '/SFA/lead.update.return.action');
	});

});