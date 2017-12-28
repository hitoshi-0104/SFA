<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<jsp:useBean id="updateBean" scope="request" class="action.account.bean.UpdateBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>取引先更新</title>

		<link rel="stylesheet" type="text/css" href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/css/common/bootstrap.min.css"></link>
		<link rel="stylesheet" type="text/css" href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/css/common/common.css"></link>
		<link rel="stylesheet" type="text/css" href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/css/account/update.css"></link>

		<script type="text/javascript" src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/js/common/jquery-3.2.1.min.js"></script>
		<script type="text/javascript" src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/js/common/popper.js"></script>
		<script type="text/javascript" src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/js/common/bootstrap.min.js"></script>
		<script type="text/javascript" src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/js/common/common.js"></script>
		<script type="text/javascript" src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/js/account/update.js"></script>
	</head>
	<body>

		<!-- ヘッダエリア -->
		<jsp:include page="../parts/header.jsp" />

		<!-- パンくずエリア -->
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">メニュー</a></li>
			<li class="breadcrumb-item active">取引先更新</li>
		</ol>

		<!-- メッセージエリア -->
		<jsp:include page="../parts/message.jsp" />

		<!-- コンテンツエリア -->
		<div class="contentsarea">
			<form id="accountform" method="POST">
				<!-- 見込み客情報のコンテンツ -->
				<div class="subtitle">
					<label class="subtitlelabel">取引先情報</label>
				</div>
				<div class="twocolumns">
					<div class="content-item">
						<label class="caption">取引先ID：</label>
						<label class="text2"><%=updateBean.getId() == null ? "" : updateBean.getId() %></label>
						<input type="hidden" name="accountid" value="<%=updateBean.getId() == null ? "" : updateBean.getId() %>" />
					</div>
					<div class="content-item">
						<label class="caption">取引先名：</label>
						<input class="text4" type="text" name="accountname" value="<%=updateBean.getAccountName() == null ? "" : updateBean.getAccountName() %>" />
					</div>
					<div class="content-item">
						<label class="caption">親取引先：</label>
						<input class="text2" type="text" id="parent" name="parent" value="<%=updateBean.getParent() == null ? "" : updateBean.getParent() %>" readonly="readonly" />
						<input class="text2" type="hidden" id="parentid" name="parentid" value="<%=updateBean.getParentId() == null ? "" : updateBean.getParentId() %>" />
						<button type="button" id="parentsearchbutton" class="btn btn-primary btn-sm button1" data-toggle="modal" data-target="#accountdialog">検索</button>
						<button type="button" id="parentclearbutton" class="btn btn-default btn-sm button2">クリア</button>
					</div>
					<div class="content-item">
						<label class="caption">取引先番号：</label>
						<input class="text3" type="text" name="accountno" value="<%=updateBean.getAccountNo() == null ? "" : updateBean.getAccountNo() %>" />
					</div>
					<div class="content-item">
						<label class="caption">取引先部門：</label>
						<input class="text3" type="text" name="department" value="<%=updateBean.getDepartment() == null ? "" : updateBean.getDepartment() %>" />
					</div>
					<div class="content-item">
						<label class="caption">業種：</label>
						<select class="select3" name="industry">
							<% for(Map.Entry<String, String> m : updateBean.getIndustryMap().entrySet()) { %>
							<option value="<%=m.getKey() %>" <%=m.getKey().equals(updateBean.getIndustry()) ? "selected" : "" %>><%=m.getValue() %></option>
							<% } %>
						</select>
					</div>
					<div class="content-item">
						<label class="caption">評価：</label>
						<select class="select1" name="evaluation">
							<% for(Map.Entry<String, String> m : updateBean.getEstimationMap().entrySet()) { %>
							<option value="<%=m.getKey() %>" <%=m.getKey().equals(updateBean.getEvaluation()) ? "selected" : "" %>><%=m.getValue() %></option>
							<% } %>
						</select>
					</div>
				</div>
				<div class="twocolumns">
					<div class="content-item">
						<label class="caption">電話：</label>
						<input class="text2" type="text" name="phone" value="<%=updateBean.getPhone() == null ? "" : updateBean.getPhone() %>" />
					</div>
					<div class="content-item">
						<label class="caption">FAX：</label>
						<input class="text2" type="text" name="fax" value="<%=updateBean.getFax() == null ? "" : updateBean.getFax() %>" />
					</div>
					<div class="content-item">
						<label class="caption">URL：</label>
						<input class="text4" type="text" name="url" value="<%=updateBean.getUrl() == null ? "" : updateBean.getUrl() %>" />
					</div>
					<div class="content-item">
						<label class="caption">証券コード：</label>
						<input class="text1" type="text" name="stockcode" value="<%=updateBean.getStockCode() == null ? "" : updateBean.getStockCode() %>" />
					</div>
					<div class="content-item">
						<label class="caption">年間売上：</label>
						<input class="text2" type="text" name="amount" value="<%=updateBean.getAmount() == null ? "" : updateBean.getAmount() %>" />
					</div>
					<div class="content-item">
						<label class="caption">従業員数：</label>
						<input class="text1" type="text" name="employee" value="<%=updateBean.getEmployee() == null ? "" : updateBean.getEmployee() %>" />
					</div>
				</div>
				<!-- 所在地情報のコンテンツ -->
				<div class="subtitle">
					<label class="subtitlelabel">所在地情報</label>
				</div>
				<div class="onecolumn">
					<div class="content-item">
						<label class="caption">郵便番号：</label>
						<input class="text1" type="text" name="postalcode" value="<%=updateBean.getPostalCode() == null ? "" : updateBean.getPostalCode() %>" />
					</div>
					<div class="content-item">
						<label class="caption">都道府県：</label>
						<select class="select1" name="division">
							<% for(Map.Entry<String, String> m : updateBean.getDivisionMap().entrySet()) { %>
							<option value="<%=m.getKey() %>" <%=m.getKey().equals(updateBean.getDivision()) ? "selected" : "" %>><%=m.getValue() %></option>
							<% } %>
						</select>
					</div>
					<div class="content-item">
						<label class="caption">市区郡：</label>
						<input class="text2" type="text" name="city" value="<%=updateBean.getCity() == null ? "" : updateBean.getCity() %>" />
					</div>
					<div class="content-item">
						<label class="caption">町名・番地・建物名：</label>
						<input class="text5" type="text" name="town" value="<%=updateBean.getTown() == null ? "" : updateBean.getTown() %>" />
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
						<button type="button" id="updatebutton" class="btn btn-primary button3">更新</button>
						<button type="button" id="deletebutton" class="btn btn-danger button3">削除</button>
						<button type="button" id="returnbutton" class="btn btn-default button3">戻る</button>
					</div>
				</div>
				<jsp:include page="../dialog/accountsearchdialog.jsp" />
			</form>
		</div>

		<!-- フッタエリア -->
		<jsp:include page="../parts/footer.jsp" />

	</body>
</html>