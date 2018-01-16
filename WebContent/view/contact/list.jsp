<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<jsp:useBean id="listBean" scope="request" class="action.contact.bean.ListBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>取引先担当者検索</title>

		<link rel="stylesheet" type="text/css" href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/css/common/bootstrap.min.css"></link>
		<link rel="stylesheet" type="text/css" href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/css/common/common.css"></link>
		<link rel="stylesheet" type="text/css" href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/css/contact/list.css"></link>

		<script type="text/javascript" src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/js/common/jquery-3.2.1.min.js"></script>
		<script type="text/javascript" src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/js/common/popper.js"></script>
		<script type="text/javascript" src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/js/common/bootstrap.min.js"></script>
		<script type="text/javascript" src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/js/common/common.js"></script>
		<script type="text/javascript" src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/js/contact/list.js"></script>
	</head>
	<body>

		<!-- ヘッダエリア -->
		<jsp:include page="../parts/header.jsp" />

		<!-- パンくずエリア -->
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">メニュー</a></li>
			<li class="breadcrumb-item active">取引先担当者一覧</li>
		</ol>

		<!-- メッセージエリア -->
		<jsp:include page="../parts/message.jsp" />

		<!-- コンテンツエリア -->
		<div class="contentsarea">
			<form id="listform" method="POST">
				<!-- 検索項目のコンテンツ -->
				<div class="subtitle">
					<label class="subtitlelabel">検索</label>
				</div>
				<div class="onecolumn">
					<div class="content-item">
						<label class="caption">姓：</label>
						<input class="text3" type="text" name="lastname" value="<%=listBean.getLastName() == null ? "" : listBean.getLastName() %>" />
					</div>
					<div class="content-item">
						<label class="caption">名：</label>
						<input class="text3" type="text" name="firstname" value="<%=listBean.getFirstName() == null ? "" : listBean.getFirstName() %>" />
					</div>
					<div class="content-item">
						<label class="caption">取引先：</label>
						<input class="text2" type="text" id="account" name="account" value="<%=listBean.getAccountName() == null ? "" : listBean.getAccountName() %>" readonly="readonly" />
						<input class="text2" type="hidden" id="accountid" name="accountid" value="<%=listBean.getAccountId() == null ? "" : listBean.getAccountId() %>" />
						<button type="button" id="accountsearchbutton" class="btn btn-primary btn-sm button1" data-toggle="modal" data-target="#accountdialog">検索</button>
						<button type="button" id="accountclearbutton" class="btn btn-default btn-sm button2">クリア</button>
					</div>
				</div>
				<!-- ボタン -->
				<div class="onecolumn">
					<div class="buttonarea">
						<button type="button" id="searchbutton" class="btn btn-primary button3">検索</button>
						<button type="button" id="returnbutton" class="btn btn-default button3">戻る</button>
					</div>
				</div>
				<!-- 一覧 -->
				<div class="onecolumn">
					<table id="contactlist">
						<thead id="contactlistheader">
							<tr>
								<th>ID</th>
								<th>取引先担当者名</th>
								<th>取引先</th>
								<th>携帯</th>
								<th>メール</th>
							</tr>
						</thead>
						<tbody id="contactlistbody">
						</tbody>
					</table>
					<nav id="contactlistpagination">
					</nav>
				</div>
			</form>
			<jsp:include page="../dialog/accountsearchdialog.jsp" />
		</div>

		<!-- フッタエリア -->
		<jsp:include page="../parts/footer.jsp" />

	</body>
</html>