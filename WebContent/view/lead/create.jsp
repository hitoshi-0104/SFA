<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<jsp:useBean id="leadBean" scope="request" class="action.lead.bean.CreateBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>見込み客新規登録</title>

		<link rel="stylesheet" type="text/css" href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/css/common/bootstrap.min.css"></link>
		<link rel="stylesheet" type="text/css" href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/css/common/common.css"></link>

		<script type="text/javascript" src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/js/common/jquery-3.2.1.min.js"></script>
		<script type="text/javascript" src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/js/common/popper.js"></script>
		<script type="text/javascript" src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/js/common/bootstrap.min.js"></script>
		<script type="text/javascript" src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/js/lead/create.js"></script>
		<script type="text/javascript" src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/js/common/common.js"></script>
	</head>
	<body>

		<!-- ヘッダエリア -->
		<jsp:include page="../parts/header.jsp" />

		<!-- パンくずエリア -->
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">メニュー</a></li>
			<li class="breadcrumb-item"><a href="#">見込み客一覧</a></li>
			<li class="breadcrumb-item active">見込み客新規登録</li>
		</ol>

		<!-- メッセージエリア -->
		<jsp:include page="../parts/message.jsp" />

		<!-- コンテンツエリア -->
		<div class="contentsarea">
			<form id="leadform" method="POST">
				<!-- 見込み客情報のコンテンツ -->
				<div class="subtitle">
					<label class="subtitlelabel">見込み客情報</label>
				</div>
				<div class="twocolumns">
					<div class="content-item">
						<label class="caption">見込み客ID：</label>
					</div>
					<div class="content-item">
						<label class="caption">姓：</label>
						<input class="text2" type="text" name="lastname" value="<%=leadBean.getLastName() == null ? "" : leadBean.getLastName() %>" />
					</div>
					<div class="content-item">
						<label class="caption">名：</label>
						<input class="text2" type="text" name="firstname" value="<%=leadBean.getFirstName() == null ? "" : leadBean.getFirstName() %>" />
					</div>
					<div class="content-item">
						<label class="caption">会社名：</label>
						<input class="text4" type="text" name="companyname" value="<%=leadBean.getCompanyName() == null ? "" : leadBean.getCompanyName() %>" />
					</div>
					<div class="content-item">
						<label class="caption">役職名：</label>
						<input class="text3" type="text" name="positionname" value="<%=leadBean.getPosition() == null ? "" : leadBean.getPosition() %>" />
					</div>
					<div class="content-item">
						<label class="caption">ソース：</label>
						<select class="select1" name="source">
							<% for(Map.Entry<String, String> m : leadBean.getSourceMap().entrySet()) { %>
							<option value="<%=m.getKey() %>" <%=m.getKey().equals(leadBean.getSourceCode()) ? "selected" : "" %>><%=m.getValue() %></option>
							<% } %>
						</select>
					</div>
					<div class="content-item">
						<label class="caption">状況：</label>
						<select class="select2" name="status">
							<% for(Map.Entry<String, String> m : leadBean.getStatusMap().entrySet()) { %>
							<option value="<%=m.getKey() %>" <%=m.getKey().equals(leadBean.getStatusCode()) ? "selected" : "" %>><%=m.getValue() %></option>
							<% } %>
						</select>
					</div>
					<div class="content-item">
						<label class="caption">評価：</label>
						<select class="select1" name="estimation">
							<% for(Map.Entry<String, String> m : leadBean.getEstimationMap().entrySet()) { %>
							<option value="<%=m.getKey() %>" <%=m.getKey().equals(leadBean.getEstimationCode()) ? "selected" : "" %>><%=m.getValue() %></option>
							<% } %>
						</select>
					</div>
				</div>
				<div class="twocolumns">
					<div class="content-item">
						<label class="caption">電話：</label>
						<input class="text2" type="text" name="phone" value="<%=leadBean.getPhone() == null ? "" : leadBean.getPhone() %>" />
					</div>
					<div class="content-item">
						<label class="caption">携帯：</label>
						<input class="text2" type="text" name="mobilephone" value="<%=leadBean.getMobilePhone() == null ? "" : leadBean.getMobilePhone() %>" />
					</div>
					<div class="content-item">
						<label class="caption">FAX：</label>
						<input class="text2" type="text" name="fax" value="<%=leadBean.getFax() == null ? "" : leadBean.getFax() %>" />
					</div>
					<div class="content-item">
						<label class="caption">メール：</label>
						<input class="text3" type="text" name="mailaddress" value="<%=leadBean.getMailAddress() == null ? "" : leadBean.getMailAddress() %>" />
					</div>
					<div class="content-item">
						<label class="caption">URL：</label>
						<input class="text4" type="text" name="url" value="<%=leadBean.getUrl() == null ? "" : leadBean.getUrl() %>" />
					</div>
					<div class="content-item">
						<label class="caption">業種：</label>
						<select class="select3" name="industry">
							<% for(Map.Entry<String, String> m : leadBean.getIndustryMap().entrySet()) { %>
							<option value="<%=m.getKey() %>" <%=m.getKey().equals(leadBean.getIndustryCode()) ? "selected" : "" %>><%=m.getValue() %></option>
							<% } %>
						</select>
					</div>
					<div class="content-item">
						<label class="caption">年間売上：</label>
						<input class="text2" type="text" name="amount" value="<%=leadBean.getAmount() == null ? "" : leadBean.getAmount() %>" />
					</div>
					<div class="content-item">
						<label class="caption">従業員数：</label>
						<input class="text1" type="text" name="employee" value="<%=leadBean.getEmployees() == null ? "" : leadBean.getEmployees() %>" />
					</div>
				</div>
				<!-- 所在地情報のコンテンツ -->
				<div class="subtitle">
					<label class="subtitlelabel">所在地情報</label>
				</div>
				<div class="onecolumn">
					<div class="content-item">
						<label class="caption">郵便番号：</label>
						<input class="text1" type="text" name="postalcode" value="<%=leadBean.getPostalCode() == null ? "" : leadBean.getPostalCode() %>" />
					</div>
					<div class="content-item">
						<label class="caption">都道府県：</label>
						<select class="select1" name="division">
							<% for(Map.Entry<String, String> m : leadBean.getDivisionMap().entrySet()) { %>
							<option value="<%=m.getKey() %>" <%=m.getKey().equals(leadBean.getDivisionCode()) ? "selected" : "" %>><%=m.getValue() %></option>
							<% } %>
						</select>
					</div>
					<div class="content-item">
						<label class="caption">市区郡：</label>
						<input class="text2" type="text" name="city" value="<%=leadBean.getCity() == null ? "" : leadBean.getCity() %>" />
					</div>
					<div class="content-item">
						<label class="caption">町名・番地・建物名：</label>
						<input class="text5" type="text" name="town" value="<%=leadBean.getTown() == null ? "" : leadBean.getTown() %>" />
					</div>
				</div>
				<!-- その他のコンテンツ -->
				<div class="subtitle">
					<label class="subtitlelabel">その他</label>
				</div>
				<div class="onecolumn">
					<div class="content-item">
						<label class="caption-top">その他：</label>
						<textarea class="textarea5" name=note><%=leadBean.getNote() == null ? "" : leadBean.getNote() %></textarea>
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