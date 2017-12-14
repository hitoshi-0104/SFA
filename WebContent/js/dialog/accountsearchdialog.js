/**
 * 取引先検索ダイアログ
 */
$(function () {

	// 検索ボタン押下時の処理
	$('#accountdialogsearchbutton').click(function() {

		$.ajax({
			url: 'SFA/account.dialog.search.rest',
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
				// 選択
				$(id).append('<td id="col' + count + '1" class="accountselectcolumn"><input type="radio" name="accountselect"></td>>');
				$('#col' + count + '1').on('click', { value: '#col' + count }, onAccountRadioChanged);
				// ID
				$(id).append('<td id="col' + count + '2" class="accountidcolumn">' + result[count].AccountId + '</td>');
				// 取引先名
				$(id).append('<td id="col' + count + '3" class="accountnamecolumn">' + moldingListItem(result[count].AccountName, 15) + '</td>');
				// 会社名
				$(id).append('<td id="col' + count + '4" class="addresscolumn">' + moldingListItem(result[count].Address, 13) + '</td>');

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

	// 選択ボタン押下時の処理
	$('#accountselectbutton').click(function() {

		window.alert('retaccountid = ' + $('#retaccountid').val());
		window.alert('selectedaccountid = ' + $('#selectedaccountid').val());
		window.alert('retaccountname = ' + $('#retaccountname').val());
		window.alert('selectedaccountname = ' + $('#selectedaccountname').val());

		// 取引先IDのセット
		$($('#retaccountid').val()).val($('#selectedaccountid').val());
		// 取引先名のセット
		$($('#retaccountname').val()).val($('#selectedaccountname').val());

	});

});

// 一覧のラジオボタン変更時の処理
function onAccountRadioChanged(e) {

	// 取引先IDのセット
	$('#selectedaccountid').val($(e.data.value + '2').text());
	// 取引先名のセット
	$('#selectedaccountname').val($(e.data.value + '3').text());

}