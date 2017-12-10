<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/css/common/common.css"></link>
<link rel="stylesheet" type="text/css" href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/css/common/dialogcommon.css"></link>
<link rel="stylesheet" type="text/css" href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/css/dialog/accountdialog.css"></link>

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
						<input class="text3" type="text" name="lastname" value="" />
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" id="accountselectbutton" class="btn btn-info button2">選択</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">キャンセル</button>
			</div>
		</div>
	</div>
</div>