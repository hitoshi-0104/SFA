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

				if (Object.keys(result).length === 0) {
					return;
				}

				var count = 0;
				$(result).each( function () {

					// テーブルに行を1行追加
					$('.leadlistbody').append('<tr id="row' + count +'"></tr>');

					// 行にカラムの設定
					var id = '#row' + count;
					// ID
					$(id).append('<td class="idcolumn"><a href="/SFA/lead.update.show.action?leadid=' + result[count].LeadId + '">' + result[count].LeadId + '</a></td>');
					// 姓
					$(id).append('<td class="lastnamecolumn">' + moldingListItem(result[count].LastName, 12) + '</td>');
					// 名
					$(id).append('<td class="firstnamecolumn">' + moldingListItem(result[count].FirstName, 12) + '</td>');
					// 会社名
					$(id).append('<td class="companynamecolumn">' + moldingListItem(result[count].CompanyName, 17) + '</td>');
					// 状況名称
					$(id).append('<td class="statusnamecolumn">' + result[count].StatusName + '</td>');
					// 評価名称
					$(id).append('<td class="estimationnamecolumn">' + result[count].EstimationName + '</td>');
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