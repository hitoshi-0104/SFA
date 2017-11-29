<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<jsp:useBean id="listBean" scope="request" class="action.lead.bean.ListBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>見込み客検索</title>

		<link rel="stylesheet" type="text/css" href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/css/common/bootstrap.min.css"></link>
		<link rel="stylesheet" type="text/css" href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/css/common/common.css"></link>
		<link rel="stylesheet" type="text/css" href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/css/lead/list.css"></link>

		<script type="text/javascript" src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/js/common/jquery-3.2.1.min.js"></script>
		<script type="text/javascript" src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/js/common/popper.js"></script>
		<script type="text/javascript" src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/js/common/bootstrap.min.js"></script>
		<script type="text/javascript" src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/js/lead/list.js"></script>
		<script type="text/javascript" src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/js/common/common.js"></script>
	</head>
	<body>

		<!-- ヘッダエリア -->
		<jsp:include page="../parts/header.jsp" />

		<!-- パンくずエリア -->
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">メニュー</a></li>
			<li class="breadcrumb-item active">見込み客一覧</li>
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
				<div class="twocolumns">
					<div class="content-item">
						<label class="caption">姓：</label>
						<input class="text2" type="text" name="lastname" value="<%=listBean.getLastName() == null ? "" : listBean.getLastName() %>" />
					</div>
					<div class="content-item">
						<label class="caption">名：</label>
						<input class="text2" type="text" name="firstname" value="<%=listBean.getFirstName() == null ? "" : listBean.getFirstName() %>" />
					</div>
					<div class="content-item">
						<label class="caption">会社名：</label>
						<input class="text4" type="text" name="companyname" value="<%=listBean.getCompanyName() == null ? "" : listBean.getCompanyName() %>" />
					</div>
				</div>
				<div class="twocolumns">
					<div class="content-item">
						<label class="caption">状況：</label>
						<select class="select2" name="status">
							<% for(Map.Entry<String, String> m : listBean.getStatusMap().entrySet()) { %>
							<option value="<%=m.getKey() %>" <%=m.getKey().equals(listBean.getStatusCode()) ? "selected" : "" %>><%=m.getValue() %></option>
							<% } %>
						</select>
					</div>
					<div class="content-item">
						<label class="caption">評価：</label>
						<select class="select1" name="estimation">
							<% for(Map.Entry<String, String> m : listBean.getEstimationMap().entrySet()) { %>
							<option value="<%=m.getKey() %>" <%=m.getKey().equals(listBean.getEstimationCode()) ? "selected" : "" %>><%=m.getValue() %></option>
							<% } %>
						</select>
					</div>
					<div class="content-item">
						<label class="caption">都道府県：</label>
						<select class="select1" name="division">
							<% for(Map.Entry<String, String> m : listBean.getDivisionMap().entrySet()) { %>
							<option value="<%=m.getKey() %>" <%=m.getKey().equals(listBean.getDivisionCode()) ? "selected" : "" %>><%=m.getValue() %></option>
							<% } %>
						</select>
					</div>
				</div>
				<!-- ボタン -->
				<div class="onecolumn">
					<div class="buttonarea">
						<button type="button" id="searchbutton" class="btn btn-primary button3">検索</button>
					</div>
				</div>
				<!-- 一覧 -->
				<div class="onecolumn">
					<table class="leadlist">
						<thead class="leadlistheader">
							<tr>
								<th>ID</th>
								<th>姓</th>
								<th>名</th>
								<th>会社名</th>
								<th>状況</th>
								<th>評価</th>
								<th>都道府県</th>
							</tr>
						</thead>
						<tbody class="leadlistbody">
						</tbody>
					</table>
				</div>
			</form>
		</div>

		<!-- フッタエリア -->
		<jsp:include page="../parts/footer.jsp" />

	</body>
</html>