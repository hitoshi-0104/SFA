/**
 * 取引先検索ダイアログ
 */
$(function () {

	// 検索ボタン押下時の処理
	$('#accountdialogsearchbutton').click(function() {

		search(1);

	});

	// 選択ボタン押下時の処理
	$('#accountselectbutton').click(function() {

		// 取引先IDのセット
		$($('#retaccountid').val()).val($('#selectedaccountid').val());
		// 取引先名のセット
		$($('#retaccountname').val()).val($('#selectedaccountname').val());

	});

});

//一覧検索処理
function search(curPage) {

	$.ajax({
		url: 'SFA/account.dialog.search.rest',
		type: 'POST',
		data: {
			'accountname' : $('input[name=accountname]').val(),
			'page' : curPage
		},
		timeout: 10000,
		// 送信前処理
		beforeSend: function(xhr, settings) {
			$('#accountdialogsearchbutton').attr('disabled', true);
		}
	}).done(function(result, textStatus, xhr) {

		// 一覧を非表示
		$('#accountdialoglist').css('display', 'none');
		$('#accountdialoglistpagination').css('display', 'none');

		// テーブルのクリア
		$('#accountdialoglistbody').empty();
		$('#accountdialoglistpagination').empty();

		if (result == null || Object.keys(result).length === 0 || result[0].cnt === '0') {
			return;
		}

		var cnt = Number(result[0].cnt);
		var lastPage = cnt % Number(result[0].maxrow) == 0 ? Math.floor(cnt / Number(result[0].maxrow)) : Math.floor(cnt / Number(result[0].maxrow)) + 1;

		// ページネーションの設定
		if (lastPage > 1) {
			$('#accountdialoglistpagination').append('<ul id="pageul" class="pagination"></ul>');
			var previousPage = curPage - 1 > 0 ? curPage - 1 : 1;
			$('#pageul').append('<li class="page-item ' + (curPage == 1 ? 'disabled' : '') +  '"><button type="button" id="previousbutton" class="page-link" onclick="search('+ previousPage +')">前へ</button></li>');
			var startIndex = curPage - 5 <= 0 ? 0 : curPage - 5;
			var endIndex = lastPage < startIndex + 10 ? lastPage : startIndex + 10;
			startIndex = endIndex - 10;
			if (startIndex < 0) {
				startIndex = 0;
			}
			for (var i = startIndex; i < endIndex; i++) {
				var buttonId = 'page' + (i + 1);
				$('#pageul').append('<li class="page-item ' + (i == (curPage - 1) ? 'active' : '') + '"><button type="button" id="' + buttonId + '" class="page-link" onclick="search(' + (i + 1) + ')">' + (i + 1) +'</button></li>');
			}
			$('#pageul').append('<li class="page-item ' + (curPage == lastPage ? 'disabled' : '') + '"><button type="button" id="nextbutton" class="page-link" onclick="search(' + (curPage + 1) + ')">次へ</button></li>');
		}

		var count = 0;
		var data = result[0].data;
		$(data).each( function () {

			// テーブルに行を1行追加
			$('#accountdialoglistbody').append('<tr id="row' + count +'"></tr>');

			// 行にカラムの設定
			var id = '#row' + count;
			// 選択
			$(id).append('<td id="col' + count + '1" class="accountselectcolumn"><input type="radio" name="accountselect"></td>>');
			$('#col' + count + '1').on('click', { value: '#col' + count }, onAccountRadioChanged);
			// ID
			$(id).append('<td id="col' + count + '2" class="accountidcolumn">' + data[count].AccountId + '</td>');
			// 取引先名
			$(id).append('<td id="col' + count + '3" class="accountnamecolumn">' + moldingListItem(data[count].AccountName, 15) + '</td>');
			// 会社名
			$(id).append('<td id="col' + count + '4" class="addresscolumn">' + moldingListItem(data[count].Address, 13) + '</td>');

			count++;
		});

		// 一覧を表示
		$('#accountdialoglist').css('display', 'inline');
		$('#accountdialoglistpagination').css('display', 'inline');

	}).fail(function(xhr, textStatus, error) {
		window.alert(error);
	}).always(function(xhr, settings) {
		$('#accountdialogsearchbutton').attr('disabled', false);
	});

}

// 一覧のラジオボタン変更時の処理
function onAccountRadioChanged(e) {

	// 取引先IDのセット
	$('#selectedaccountid').val($(e.data.value + '2').text());
	// 取引先名のセット
	$('#selectedaccountname').val($(e.data.value + '3').text());

}