<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<jsp:useBean id="updateBean" scope="request" class="action.contact.bean.UpdateBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>取引先担当者更新</title>

		<link rel="stylesheet" type="text/css" href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/css/common/bootstrap.min.css"></link>
		<link rel="stylesheet" type="text/css" href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/css/common/common.css"></link>
		<link rel="stylesheet" type="text/css" href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/css/contact/update.css"></link>

		<script type="text/javascript" src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/js/common/jquery-3.2.1.min.js"></script>
		<script type="text/javascript" src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/js/common/popper.js"></script>
		<script type="text/javascript" src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/js/common/bootstrap.min.js"></script>
		<script type="text/javascript" src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/js/common/common.js"></script>
		<script type="text/javascript" src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/js/contact/update.js"></script>
	</head>
	<body>

		<!-- ヘッダエリア -->
		<jsp:include page="../parts/header.jsp" />

		<!-- パンくずエリア -->
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">メニュー</a></li>
			<li class="breadcrumb-item active">取引先担当者更新</li>
		</ol>

		<!-- メッセージエリア -->
		<jsp:include page="../parts/message.jsp" />

		<!-- コンテンツエリア -->
		<div class="contentsarea">
			<form id="contactform" method="POST">
				<!-- 見込み客情報のコンテンツ -->
				<div class="subtitle">
					<label class="subtitlelabel">取引先担当者情報</label>
				</div>
				<div class="twocolumns">
					<div class="content-item">
						<label class="caption">取引先担当者ID：</label>
					</div>
					<div class="content-item">
						<label class="caption">姓：</label>
						<input class="text3" type="text" name="lastname" value="<%=updateBean.getLastName() == null ? "" : updateBean.getLastName() %>" />
					</div>
					<div class="content-item">
						<label class="caption">名：</label>
						<input class="text3" type="text" name="firstname" value="<%=updateBean.getFirstName() == null ? "" : updateBean.getFirstName() %>" />
					</div>
					<div class="content-item">
						<label class="caption">取引先：</label>
						<input class="text2" type="text" id="accountname" name="accountname" value="<%=updateBean.getAccountName() == null ? "" : updateBean.getAccountName() %>" readonly="readonly" />
						<input class="text2" type="hidden" id="accountid" name="accountid" value="<%=updateBean.getAccountId() == null ? "" : updateBean.getAccountId() %>" />
						<button type="button" id="accountsearchbutton" class="btn btn-primary btn-sm button1" data-toggle="modal" data-target="#accountdialog">検索</button>
						<button type="button" id="accountclearbutton" class="btn btn-default btn-sm button2">クリア</button>
					</div>
					<div class="content-item">
						<label class="caption">部署：</label>
						<input class="text3" type="text" name="department" value="<%=updateBean.getDepartment() == null ? "" : updateBean.getDepartment() %>" />
					</div>
					<div class="content-item">
						<label class="caption">役職：</label>
						<input class="text3" type="text" name="position" value="<%=updateBean.getPosition() == null ? "" : updateBean.getPosition() %>" />
					</div>
				</div>
				<div class="twocolumns">
					<div class="content-item">
						<label class="caption">上司：</label>
						<input class="text2" type="text" id="bossname" name="bossname" value="<%=updateBean.getBossName() == null ? "" : updateBean.getBossName() %>" readonly="readonly" />
						<input class="text2" type="hidden" id="bossid" name="bossid" value="<%=updateBean.getBoss() == null ? "" : updateBean.getBoss() %>" />
						<button type="button" id="bosssearchbutton" class="btn btn-primary btn-sm button1" data-toggle="modal" data-target="#contactsearchdialog">検索</button>
						<button type="button" id="bossclearbutton" class="btn btn-default btn-sm button2">クリア</button>
					</div>
					<div class="content-item">
						<label class="caption">電話：</label>
						<input class="text2" type="text" name="phone" value="<%=updateBean.getPhone() == null ? "" : updateBean.getPhone() %>" />
					</div>
					<div class="content-item">
						<label class="caption">携帯：</label>
						<input class="text2" type="text" name="mobilephone" value="<%=updateBean.getMobilePhone() == null ? "" : updateBean.getMobilePhone() %>" />
					</div>
					<div class="content-item">
						<label class="caption">FAX：</label>
						<input class="text2" type="text" name="fax" value="<%=updateBean.getFax() == null ? "" : updateBean.getFax() %>" />
					</div>
					<div class="content-item">
						<label class="caption">メール：</label>
						<input class="text3" type="text" name="mailaddress" value="<%=updateBean.getMail() == null ? "" : updateBean.getMail() %>" />
					</div>
				</div>
				<!-- その他のコンテンツ -->
				<div class="subtitle">
					<label class="subtitlelabel">その他</label>
				</div>
				<div class="onecolumn">
					<div class="content-item">
						<label class="caption-top">その他：</label>
						<textarea class="textarea5" name=note><%=updateBean.getNote() == null ? "" : updateBean.getNote() %></textarea>
					</div>
				</div>
				<!-- ボタン -->
				<div class="onecolumn">
					<div class="buttonarea">
						<button type="button" id="continuousbutton" class="btn btn-info button3">連続登録</button>
						<button type="button" id="insertbutton" class="btn btn-primary button3">登録</button>
						<button type="button" id="returnbutton" class="btn btn-default button3">戻る</button>
					</div>
				</div>
				<jsp:include page="../dialog/contactsearchdialog.jsp" />
				<jsp:include page="../dialog/accountsearchdialog.jsp" />
			</form>
		</div>

		<!-- フッタエリア -->
		<jsp:include page="../parts/footer.jsp" />

	</body>
</html>