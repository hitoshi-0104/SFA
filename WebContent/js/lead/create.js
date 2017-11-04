/**
 * 見込み客新規登録画面用のJS
 */
$(function() {

	// 連続登録ボタン押下
	$('#continuousbutton').click(function() {
		submitAction('#leadform', '/SFAMock/lead.create.continuous.action');
	});

	// 登録ボタン押下
	$('#insertbutton').click(function() {
		submitAction('#leadform', '/SFAMock/lead.create.regist.action');
	});

	// 戻るボタン押下
	$('#returnbutton').click(function() {
		submitAction('#leadform', '/SFAMock/lead.create.return.action');
	});

});