/**
 * 取引先一覧のJS
 */
$(function() {

	// 検索ボタン押下時
	$('#searchbutton').click(function() {

		search(1);

	});

});

// 一覧検索処理
function search(curPage) {

	$.ajax({
		url : '/SFA/account.list.search.rest',
		type : 'POST',
		data : {
			'accountname' : $('#listform [name=accountname]').val(),
			'page' : curPage
		},
		timeout : 10000,
		// 送信前処理
		beforeSend : function(xhr, settings) {
			$('#searchbutton').attr('disabled', true);
		}
	}).done(function(result, textStatus, xhr) {

		// 非表示
		$('#accountlist').css('display', 'none');
		$('#accountlistpagination').css('display', 'none');

		// クリア
		$('#accountlistbody').empty();
		$('#accountlistpagination').empty();

		if (result == null || Object.keys(result).length === 0 || result[0].cnt === '0') {
			return;
		}

		var cnt = Number(result[0].cnt);
		var lastPage = cnt % Number(result[0].maxrow) == 0 ? Math.floor(cnt / Number(result[0].maxrow)) : Math.floor(cnt / Number(result[0].maxrow)) + 1;

		// ページネーションの設定
		if (lastPage > 1) {
			$('#accountlistpagination').append('<ul id="pageul" class="pagination"></ul>');
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
			$('#accountlistbody').append('<tr id="row' + count +'"></tr>');

			// 行にカラムの設定
			var id = '#row' + count;
			// ID
			$(id).append('<td class="idcolumn"><a href="/SFA/account.update.show.action?leadid=' + data[count].AccountId + '">' + data[count].AccountId + '</a></td>');
			// 取引先名
			$(id).append('<td class="accountnamecolumn">' + moldingListItem(data[count].AccountName, 20) + '</td>');
			// 電話
			$(id).append('<td class="phonecolumn">' + data[count].Phone + '</td>');
			// 住所
			$(id).append('<td class="addresscolumn">' + moldingListItem(data[count].Address, 33) + '</td>');

			count++;
		});

		// 一覧を表示
		$('#accountlist').css('display', 'inline');
		$('#accountlistpagination').css('display', 'inline');

	}).fail(function(xhr, textStatus, error) {
		window.alert(error);
	}).always(function(xhr, settings) {
		$('#searchbutton').attr('disabled', false);
	});

}