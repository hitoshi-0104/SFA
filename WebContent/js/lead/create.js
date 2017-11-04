/**
 * 見込み客新規登録画面用のJS
 */
$(function() {

	// 連続登録ボタン押下
	$('#continuousbutton').click(function() {
		submitAction('#leadform', '/SFA/lead.create.continuous.action');
	});

	// 登録ボタン押下
	$('#insertbutton').click(function() {
		submitAction('#leadform', '/SFA/lead.create.regist.action');
	});

	// 戻るボタン押下
	$('#returnbutton').click(function() {
		submitAction('#leadform', '/SFA/lead.create.return.action');
	});

});