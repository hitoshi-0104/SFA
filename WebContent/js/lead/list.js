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

				// 一覧を非表示
				$('.leadlist').css('display', 'none');

				// テーブルのクリア
				$('.leadlistbody').empty();

				var count = 0;
				$(result).each( function () {

					// テーブルに行を1行追加
					$('.leadlistbody').append('<tr id="row' + count +'"></tr>');

					// 行にカラムの設定
					var id = '#row' + count;
					// 姓
					$(id).append('<td class="lastnamecolumn">' + result[count].LastName + '</td>');
					// 名
					$(id).append('<td class="firstnamecolumn">' + result[count].FirstName + '</td>');
					// 会社名
					$(id).append('<td class="companynamecolumn">' + result[count].CompanyName + '</td>');
					// ソース名称
					$(id).append('<td class="sourcenamecolumn">' + result[count].SourceName + '</td>');
					// 状況名称
					$(id).append('<td class="statusnamecolumn">' + result[count].StatusName + '</td>');
					// 評価名称
					$(id).append('<td class="estimationnamecolumn">' + result[count].EstimationName + '</td>');
					// 業種名称
					$(id).append('<td class="industrynamecolumn">' + result[count].IndustryName + '</td>');
					// 都道府県名称
					$(id).append('<td class="divisionnamecolumn">' + result[count].DivisionName + '</td>');

					count++;
				});

				// 一覧を表示
				$('.leadlist').css('display', 'inline');
			},
			// エラー
			error : function(xhr, textStatus, error) {
				window.alert(error);
			}
		});

	});

});