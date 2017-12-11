/**
 * 取引先検索ダイアログ
 */
$(function () {

	// 検索ボタン押下時の処理
	$('#accountdialogsearchbutton').click(function() {

		$.ajax({
			url: 'SFA/accountsearch.rest',
			type: 'POST',
			data: {
				'accountname' : $('input[name=accountname]').val()
			},
			timeout: 10000,
			// 送信前処理
			beforeSend: function(xhr, settings) {
				$('#accountdialogsearchbutton').attr('disabled', true);
			}
		}).done(function(result, textStatus, xhr) {

			// 一覧を非表示
			$('#accountdialoglist').css('display', 'none');

			// テーブルのクリア
			$('#accountdialoglistbody').empty();

			if (Object.keys(result).length === 0) {
				return;
			}

			var count = 0;
			$(result).each( function () {

				// テーブルに行を1行追加
				$('#accountdialoglistbody').append('<tr id="row' + count +'"></tr>');

				// 行にカラムの設定
				var id = '#row' + count;
				// ID
				$(id).append('<td class="accountidcolumn">' + result[count].AccountId + '</td>');
				// 姓
				$(id).append('<td class="accountnamecolumn">' + result[count].AccountName + '</td>');
				// 名
				$(id).append('<td class="industrynamecolumn">' + result[count].Industry + '</td>');
				// 会社名
				$(id).append('<td class="addresscolumn">' + result[count].Address + '</td>');

				count++;
			});

			// 一覧を表示
			$('#accountdialoglist').css('display', 'inline');

		}).fail(function(xhr, textStatus, error) {
			window.alert(error);
		}).always(function(xhr, settings) {
			$('#accountdialogsearchbutton').attr('disabled', false);
		});

	});

});