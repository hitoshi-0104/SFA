/**
 * 見込み客検索画面
 */
$(function() {

	// 検索ボタン押下時
	$('#searchbutton').click(function() {

		$.ajax({
			url : '/SFA/lead.list.search.rest',
			type : 'POST',
			data : {
				'lastname' : $('#listform [name=lastname]').val(),
				'firstname' : $('#listform [name=firstname]').val(),
				'companyname' : $('#listform [name=companyname]').val(),
				'industry' : $('#listform [name=industry]').val(),
				'source' : $('#listform [name=source]').val(),
				'status' : $('#listform [name=status').val(),
				'estimation' : $('#listform [name=estimation]').val(),
				'division' : $('#listform [name=division').val()
			},
			timeout : 10000,
			// 送信前処理
			beforeSend : function(xhr, settings) {
				$('#searchbutton').attr('disabled', true);
			},
			// 送信後処理
			complete : function(xhr, settings) {
				$('#searchbutton').attr('disabled', false);
			},
			// 成功時
			success : function(result, textStatus, xhr) {

			},
			// エラー
			error : function(xhr, textStatus, error) {

			}
		});

	});

});