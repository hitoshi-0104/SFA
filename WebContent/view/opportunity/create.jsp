<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<jsp:useBean id="createBean" scope="request" class="action.opportunity.bean.CreateBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>商談新規登録</title>

		<link rel="stylesheet" type="text/css" href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/css/common/bootstrap.min.css"></link>
		<link rel="stylesheet" type="text/css" href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/css/common/common.css"></link>
		<link rel="stylesheet" type="text/css" href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/css/opportunity/create.css"></link>

		<script type="text/javascript" src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/js/common/jquery-3.2.1.min.js"></script>
		<script type="text/javascript" src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/js/common/popper.js"></script>
		<script type="text/javascript" src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/js/common/bootstrap.min.js"></script>
		<script type="text/javascript" src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/js/common/common.js"></script>
		<script type="text/javascript" src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/js/opportunity/create.js"></script>
	</head>
	<body>

		<!-- ヘッダエリア -->
		<jsp:include page="../parts/header.jsp" />

		<!-- パンくずエリア -->
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">メニュー</a></li>
			<li class="breadcrumb-item active">商談新規登録</li>
		</ol>

		<!-- メッセージエリア -->
		<jsp:include page="../parts/message.jsp" />

		<!-- コンテンツエリア -->
		<div class="contentsarea">
			<form id="opportunityform" method="POST">
				<!-- 商談情報のコンテンツ -->
				<div class="subtitle">
					<label class="subtitlelabel">商談情報</label>
				</div>
				<div class="twocolumns">
					<div class="content-item">
						<label class="caption">商談ID：</label>
					</div>
					<div class="content-item">
						<label class="caption">商談名：</label>
						<input class="text3" type="text" name="opportunityname" value="<%=createBean.getOpportunityName() == null ? "" : createBean.getOpportunityName() %>" />
					</div>
					<div class="content-item">
						<label class="caption">見込み客：</label>
						<input class="text2" type="text" id="leadname" name="leadname" value="<%=createBean.getLeadName() == null ? "" : createBean.getLeadName() %>" readonly="readonly" />
						<input class="text2" type="hidden" id="leadid" name="leadid" value="<%=createBean.getLeadId() == null ? "" : createBean.getLeadId() %>" />
						<button type="button" id="leadsearchbutton" class="btn btn-primary btn-sm button1" data-toggle="modal" data-target="#leadsearchdialog">検索</button>
						<button type="button" id="leadclearbutton" class="btn btn-default btn-sm button2">クリア</button>
					</div>
					<div class="content-item">
						<label class="caption">取引先：</label>
						<input class="text2" type="text" id="accountname" name="accountname" value="<%=createBean.getAccountName() == null ? "" : createBean.getAccountName() %>" readonly="readonly" />
						<input class="text2" type="hidden" id="accountid" name="accountid" value="<%=createBean.getAccountId() == null ? "" : createBean.getAccountId() %>" />
						<button type="button" id="accountsearchbutton" class="btn btn-primary btn-sm button1" data-toggle="modal" data-target="#accountdialog">検索</button>
						<button type="button" id="accountclearbutton" class="btn btn-default btn-sm button2">クリア</button>
					</div>
					<div class="content-item">
						<label class="caption">種別：</label>
						<select class="select1" name="type">
							<% for(Map.Entry<String, String> m : createBean.getTypeMap().entrySet()) { %>
							<option value="<%=m.getKey() %>" <%=m.getKey().equals(createBean.getType()) ? "selected" : "" %>><%=m.getValue() %></option>
							<% } %>
						</select>
					</div>
					<div class="content-item">
						<label class="caption">リードソース：</label>
						<select class="select1" name="leadsource">
							<% for(Map.Entry<String, String> m : createBean.getLeadSourceMap().entrySet()) { %>
							<option value="<%=m.getKey() %>" <%=m.getKey().equals(createBean.getLeadSource()) ? "selected" : "" %>><%=m.getValue() %></option>
							<% } %>
						</select>
					</div>
				</div>
				<div class="twocolumns">
					<div class="content-item">
						<label class="caption">金額：</label>
						<input class="text2" type="text" name="ammount" value="<%=createBean.getAmmount() == null ? "" : createBean.getAmmount() %>" />
					</div>
					<div class="content-item">
						<label class="caption">完了予定日：</label>
						<input class="text2" type="text" name="completiondate" value="<%=createBean.getCompletionDate() == null ? "" : createBean.getCompletionDate() %>" />
					</div>
					<div class="content-item">
						<label class="caption">フェーズ：</label>
						<select class="select1" name="leadsource">
							<% for(Map.Entry<String, String> m : createBean.getPhaseMap().entrySet()) { %>
							<option value="<%=m.getKey() %>" <%=m.getKey().equals(createBean.getPhase()) ? "selected" : "" %>><%=m.getValue() %></option>
							<% } %>
						</select>
					</div>
					<div class="content-item">
						<label class="caption">確度：</label>
						<input class="text3" type="text" name="accuracy" value="<%=createBean.getAccuracy() == null ? "" : createBean.getAccuracy() %>" />
					</div>
				</div>
				<!-- その他のコンテンツ -->
				<div class="subtitle">
					<label class="subtitlelabel">その他</label>
				</div>
				<div class="onecolumn">
					<div class="content-item">
						<label class="caption-top">その他：</label>
						<textarea class="textarea5" name=note><%=createBean.getNote() == null ? "" : createBean.getNote() %></textarea>
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