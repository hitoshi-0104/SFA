<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<jsp:useBean id="createBean" scope="request" class="action.account.bean.CreateBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>取引先新規登録</title>

		<link rel="stylesheet" type="text/css" href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/css/common/bootstrap.min.css"></link>
		<link rel="stylesheet" type="text/css" href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/css/common/common.css"></link>

		<script type="text/javascript" src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/js/common/jquery-3.2.1.min.js"></script>
		<script type="text/javascript" src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/js/common/popper.js"></script>
		<script type="text/javascript" src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/js/common/bootstrap.min.js"></script>
		<script type="text/javascript" src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/js/common/common.js"></script>
		<script type="text/javascript" src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/js/account/create.js"></script>
	</head>
	<body>

		<!-- ヘッダエリア -->
		<jsp:include page="../parts/header.jsp" />

		<!-- パンくずエリア -->
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">メニュー</a></li>
			<li class="breadcrumb-item active">取引先新規登録</li>
		</ol>

		<!-- メッセージエリア -->
		<jsp:include page="../parts/message.jsp" />

		<!-- コンテンツエリア -->
		<div class="contentsarea">
			<form id="leadform" method="POST">
				<!-- 見込み客情報のコンテンツ -->
				<div class="subtitle">
					<label class="subtitlelabel">取引先情報</label>
				</div>
				<div class="twocolumns">
					<div class="content-item">
						<label class="caption">取引先ID：</label>
					</div>
					<div class="content-item">
						<label class="caption">取引先名：</label>
						<input class="text2" type="text" name="accountname" value="<%=createBean.getAccountName() == null ? "" : createBean.getAccountName() %>" />
					</div>
					<div class="content-item">
						<label class="caption">親取引先：</label>
						<input class="text2" type="text" name="parent" value="<%=createBean.getParent() == null ? "" : createBean.getParent() %>" />
					</div>
					<div class="content-item">
						<label class="caption">取引先番号：</label>
						<input class="text4" type="text" name="accountno" value="<%=createBean.getAccountNo() == null ? "" : createBean.getAccountNo() %>" />
					</div>
					<div class="content-item">
						<label class="caption">取引先部門：</label>
						<input class="text3" type="text" name="department" value="<%=createBean.getDepartment() == null ? "" : createBean.getDepartment() %>" />
					</div>
					<div class="content-item">
						<label class="caption">種別：</label>
						<select class="select1" name="source">
							<% for(Map.Entry<String, String> m : createBean.getTypeMap().entrySet()) { %>
							<option value="<%=m.getKey() %>" <%=m.getKey().equals(createBean.getType()) ? "selected" : "" %>><%=m.getValue() %></option>
							<% } %>
						</select>
					</div>
					<div class="content-item">
						<label class="caption">評価：</label>
						<select class="select1" name="estimation">
							<% for(Map.Entry<String, String> m : createBean.getEvaluationMap().entrySet()) { %>
							<option value="<%=m.getKey() %>" <%=m.getKey().equals(createBean.getEvaluation()) ? "selected" : "" %>><%=m.getValue() %></option>
							<% } %>
						</select>
					</div>
				</div>
				<div class="twocolumns">
					<div class="content-item">
						<label class="caption">電話：</label>
						<input class="text2" type="text" name="phone" value="<%=createBean.getPhone() == null ? "" : createBean.getPhone() %>" />
					</div>
					<div class="content-item">
						<label class="caption">FAX：</label>
						<input class="text2" type="text" name="fax" value="<%=createBean.getFax() == null ? "" : createBean.getFax() %>" />
					</div>
					<div class="content-item">
						<label class="caption">URL：</label>
						<input class="text4" type="text" name="url" value="<%=createBean.getUrl() == null ? "" : createBean.getUrl() %>" />
					</div>
					<div class="content-item">
						<label class="caption">証券コード：</label>
						<input class="text4" type="text" name="stockcode" value="<%=createBean.getStockCode() == null ? "" : createBean.getStockCode() %>" />
					</div>
					<div class="content-item">
						<label class="caption">業種：</label>
						<select class="select3" name="industry">
							<% for(Map.Entry<String, String> m : createBean.getIndustryMap().entrySet()) { %>
							<option value="<%=m.getKey() %>" <%=m.getKey().equals(createBean.getIndustry()) ? "selected" : "" %>><%=m.getValue() %></option>
							<% } %>
						</select>
					</div>
					<div class="content-item">
						<label class="caption">年間売上：</label>
						<input class="text2" type="text" name="amount" value="<%=createBean.getAmount() == null ? "" : createBean.getAmount() %>" />
					</div>
					<div class="content-item">
						<label class="caption">従業員数：</label>
						<input class="text1" type="text" name="employee" value="<%=createBean.getEmployee() == null ? "" : createBean.getEmployee() %>" />
					</div>
				</div>
				<!-- 所在地情報のコンテンツ -->
				<div class="subtitle">
					<label class="subtitlelabel">所在地情報</label>
				</div>
				<div class="onecolumn">
					<div class="content-item">
						<label class="caption">郵便番号：</label>
						<input class="text1" type="text" name="postalcode" value="<%=createBean.getPostalCode() == null ? "" : createBean.getPostalCode() %>" />
					</div>
					<div class="content-item">
						<label class="caption">都道府県：</label>
						<select class="select1" name="division">
							<% for(Map.Entry<String, String> m : createBean.getDivisionMap().entrySet()) { %>
							<option value="<%=m.getKey() %>" <%=m.getKey().equals(createBean.getDivision()) ? "selected" : "" %>><%=m.getValue() %></option>
							<% } %>
						</select>
					</div>
					<div class="content-item">
						<label class="caption">市区郡：</label>
						<input class="text2" type="text" name="city" value="<%=createBean.getCity() == null ? "" : createBean.getCity() %>" />
					</div>
					<div class="content-item">
						<label class="caption">町名・番地・建物名：</label>
						<input class="text5" type="text" name="town" value="<%=createBean.getTown() == null ? "" : createBean.getTown() %>" />
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
			</form>
		</div>

		<!-- フッタエリア -->
		<jsp:include page="../parts/footer.jsp" />

	</body>
</html>