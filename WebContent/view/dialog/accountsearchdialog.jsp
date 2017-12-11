<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/css/common/common.css"></link>
<link rel="stylesheet" type="text/css" href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/css/common/dialogcommon.css"></link>
<link rel="stylesheet" type="text/css" href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/css/dialog/accountsearchdialog.css"></link>

<script type="text/javascript" src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/js/dialog/accountsearchdialog.js"></script>

<div class="modal" id="accountdialog" tabindex="-1">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<h4>選択</h4>
			</div>
			<div class="modal-body">
				<div class="onecolumn">
					<div class="modal-item">
						<label class="caption">取引先名：</label>
						<input class="text3" type="text" name="accountname" value="" />
						<button type="button" id="accountdialogsearchbutton" class="btn btn-primary btn-sm button1">検索</button>
					</div>
				</div>
				<div class="onecolumn">
					<table id="accountdialoglist">
						<thead id="accountdialoglistheader">
							<tr>
								<th>ID</th>
								<th>取引先名</th>
								<th>業種</th>
								<th>住所</th>
							</tr>
						</thead>
						<tbody id="accountdialoglistbody">
						</tbody>
					</table>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" id="accountselectbutton" class="btn btn-info button2">選択</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">キャンセル</button>
			</div>
		</div>
	</div>
</div>