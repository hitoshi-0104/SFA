/**
 * 取引先担当者一覧のJS
 */
$(function() {

	// 検索ボタン押下時
	$('#searchbutton').click(function() {

		contactSearch(1);

	});

	// 取引先の検索ボタン押下処理
	$('#accountsearchbutton').click(function() {
		$('#retaccountid').val('#accountid');
		$('#retaccountname').val('#account');
	});

	// 取引先のクリアボタン押下処理
	$('#accountclearbutton').click(function() {
		$('#accountid').val('');
		$('#account').val('');
	});

});

// 一覧検索処理
function contactSearch(curPage) {

	$.ajax({
		url: 'SFA/contact.dialog.search.rest',
		type: 'POST',
		data: {
			'lastname' : $('input[name=lastname]').val(),
			'firstname' : $('input[name=firstname]').val(),
			'accountid' : $('input[name=accountid]').val(),
			'page' : curPage
		},
		timeout: 10000,
		// 送信前処理
		beforeSend: function(xhr, settings) {
			$('#searchbutton').attr('disabled', true);
		}
	}).done(function(result, textStatus, xhr) {

		// 一覧を非表示
		$('#contactlist').css('display', 'none');
		$('#contactlistpagination').css('display', 'none');

		// テーブルのクリア
		$('#contactlistbody').empty();
		$('#contactlistpagination').empty();

		if (result == null || Object.keys(result).length === 0 || result[0].cnt === '0') {
			return;
		}

		var cnt = Number(result[0].cnt);
		var lastPage = cnt % Number(result[0].maxrow) == 0 ? Math.floor(cnt / Number(result[0].maxrow)) : Math.floor(cnt / Number(result[0].maxrow)) + 1;

		// ページネーションの設定
		if (lastPage > 1) {
			$('#contactlistpagination').append('<ul id="pageul" class="pagination"></ul>');
			var previousPage = curPage - 1 > 0 ? curPage - 1 : 1;
			$('#pageul').append('<li class="page-item ' + (curPage == 1 ? 'disabled' : '') +  '"><button type="button" id="previousbutton" class="page-link" onclick="contactSearch('+ previousPage +')">前へ</button></li>');
			var startIndex = curPage - 5 <= 0 ? 0 : curPage - 5;
			var endIndex = lastPage < startIndex + 10 ? lastPage : startIndex + 10;
			startIndex = endIndex - 10;
			if (startIndex < 0) {
				startIndex = 0;
			}
			for (var i = startIndex; i < endIndex; i++) {
				var buttonId = 'page' + (i + 1);
				$('#pageul').append('<li class="page-item ' + (i == (curPage - 1) ? 'active' : '') + '"><button type="button" id="' + buttonId + '" class="page-link" onclick="contactSearch(' + (i + 1) + ')">' + (i + 1) +'</button></li>');
			}
			$('#pageul').append('<li class="page-item ' + (curPage == lastPage ? 'disabled' : '') + '"><button type="button" id="nextbutton" class="page-link" onclick="contactSearch(' + (curPage + 1) + ')">次へ</button></li>');
		}

		var count = 0;
		var data = result[0].data;
		$(data).each( function () {

			// テーブルに行を1行追加
			$('#contactlistbody').append('<tr id="row' + count +'"></tr>');

			// 行にカラムの設定
			var id = '#row' + count;
			// ID
			$(id).append('<td id="col' + count + '1" class="contactidcolumn"><a href="/SFA/contact.update.show.action?contactid=' + data[count].ContactId + '">' + data[count].ContactId + '</a></td>');
			// 取引先担当者名
			$(id).append('<td id="col' + count + '2" class="contactnamecolumn">' + moldingListItem(data[count].ContactName, 17) + '</td>');
			// 取引先
			$(id).append('<td id="col' + count + '3" class="accountcolumn">' + moldingListItem(data[count].AccountName, 25) + '</td>');
			// 携帯
			$(id).append('<td id="col' + count + '4" class="mobilephonecolumn">' + moldingListItem(data[count].MobilePhone, 13) + '</td>');
			// メール
			$(id).append('<td id="col' + count + '5" class="mailcolumn">' + moldingListItem(data[count].Mail, 23) + '</td>');

			count++;
		});

		// 一覧を表示
		$('#contactlist').css('display', 'inline');
		$('#contactlistpagination').css('display', 'inline');

	}).fail(function(xhr, textStatus, error) {
		window.alert(error);
	}).always(function(xhr, settings) {
		$('#searchbutton').attr('disabled', false);
	});
}