/**
 * 見込み客検索画面
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
			'division' : $('#listform [name=division').val(),
			'curpage' : curPage
		},
		timeout : 10000,
		// 送信前処理
		beforeSend : function(xhr, settings) {
			$('#searchbutton').attr('disabled', true);
		}
	}).done(function(result, textStatus, xhr) {

		// 一覧を非表示
		$('.leadlist').css('display', 'none');
		$('#leadlistpagination').css('display', 'none');

		// クリア
		$('.leadlistbody').empty();
		$('#leadlistpagination').empty();

		if (result == null || Object.keys(result).length === 0 || result[0].cnt === '0') {
			return;
		}

		var cnt = Number(result[0].cnt);
		var lastPage = Math.floor(cnt / Number(result[0].maxrow)) + 1;

		// ページネーションの設定
		if (lastPage > 1) {
			$('#leadlistpagination').append('<ul id="pageul" class="pagination"></ul>');
			var previousPage = curPage - 1 > 0 ? curPage - 1 : 1;
			$('#pageul').append('<li class="page-item ' + (curPage == 1 ? 'disabled' : '') +  '"><button type="button" id="previousbutton" class="page-link" onclick="search('+ previousPage +')">前へ</button></li>');
			var startIndex = curPage - 5 <= 0 ? 0 : curPage - 5;
			var endIndex = lastPage < startIndex + 10 ? lastPage : startIndex + 10;
			if (startIndex - endIndex < 10) {
				startIndex = endIndex - 10;
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
			$('.leadlistbody').append('<tr id="row' + count +'"></tr>');

			// 行にカラムの設定
			var id = '#row' + count;
			// ID
			$(id).append('<td class="idcolumn"><a href="/SFA/lead.update.show.action?leadid=' + data[count].LeadId + '">' + data[count].LeadId + '</a></td>');
			// 姓
			$(id).append('<td class="lastnamecolumn">' + moldingListItem(data[count].LastName, 12) + '</td>');
			// 名
			$(id).append('<td class="firstnamecolumn">' + moldingListItem(data[count].FirstName, 12) + '</td>');
			// 会社名
			$(id).append('<td class="companynamecolumn">' + moldingListItem(data[count].CompanyName, 17) + '</td>');
			// 状況名称
			$(id).append('<td class="statusnamecolumn">' + data[count].StatusName + '</td>');
			// 評価名称
			$(id).append('<td class="estimationnamecolumn">' + data[count].EstimationName + '</td>');
			// 都道府県名称
			$(id).append('<td class="divisionnamecolumn">' + data[count].DivisionName + '</td>');

			count++;
		});

		// 一覧を表示
		$('.leadlist').css('display', 'inline');
		$('#leadlistpagination').css('display', 'inline');

	}).fail(function(xhr, textStatus, error) {
		window.alert(error);
	}).always(function(xhr, settings) {
		$('#searchbutton').attr('disabled', false);
	});

}