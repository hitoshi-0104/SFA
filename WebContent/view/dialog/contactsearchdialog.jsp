<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/css/common/common.css"></link>
<link rel="stylesheet" type="text/css" href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/css/common/dialogcommon.css"></link>
<link rel="stylesheet" type="text/css" href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/css/dialog/contactsearchdialog.css"></link>

<script type="text/javascript" src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/js/dialog/contactsearchdialog.js"></script>

<div class="modal" id="contactsearchdialog" tabindex="-1">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<h4>選択</h4>
			</div>
			<div class="modal-body">
				<div class="onecolumn">
					<div class="modal-item">
						<label class="caption">取引先担当者名：</label>
						<input class="text3" type="text" name="contactdgcontactname" value="" />
					</div>
					<div class="modal-item">
						<label class="caption">取引先：</label>
						<input class="text2" type="text" id="contactdgaccountname" name="contactdgaccountname" readonly="readonly" />
						<input class="text2" type="hidden" id="contactdgaccountid" name="contactdgaccountid" />
						<button type="button" id="contactdgaccountsearchbutton" class="btn btn-primary btn-sm button1" data-toggle="modal" data-target="#accountdialog">検索</button>
						<button type="button" id="contactdgaccountclearbutton" class="btn btn-default btn-sm button2">クリア</button>
					</div>
				</div>
				<div class="onecolumn">
					<table id="contactdglist">
						<thead id="contactdglistheader">
							<tr>
								<th></th>
								<th>ID</th>
								<th>取引先担当者名</th>
								<th>取引先</th>
								<th>メール</th>
							</tr>
						</thead>
						<tbody id="contactdglistbody">
						</tbody>
					</table>
					<nav id="contactdglistpagination">
					</nav>
					<input type="hidden" id="selectedcontactid" value="" />
					<input type="hidden" id="selectedcontactname" value="" />
				</div>
			</div>
			<div class="modal-footer">
				<input type="hidden" id="retcontactid" value="" />
				<input type="hidden" id="retcontactname" value="" />
				<button type="button" id="contactselectbutton" class="btn btn-info button2" data-dismiss="modal">選択</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">キャンセル</button>
			</div>
		</div>
	</div>
</div>
<jsp:include page="../dialog/accountsearchdialog.jsp" />