<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<jsp:useBean id="updateBean" scope="request" class="action.lead.bean.UpdateBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>見込み客更新</title>

		<link rel="stylesheet" type="text/css" href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/css/common/bootstrap.min.css"></link>
		<link rel="stylesheet" type="text/css" href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/css/common/common.css"></link>
		<link rel="stylesheet" type="text/css" href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/css/lead/update.css"></link>

		<script type="text/javascript" src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/js/common/jquery-3.2.1.min.js"></script>
		<script type="text/javascript" src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/js/common/popper.js"></script>
		<script type="text/javascript" src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/js/common/bootstrap.min.js"></script>
		<script type="text/javascript" src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/js/lead/update.js"></script>
		<script type="text/javascript" src="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/js/common/common.js"></script>
	</head>
	<body>

		<!-- ヘッダエリア -->
		<jsp:include page="../parts/header.jsp" />

		<!-- パンくずエリア -->
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">メニュー</a></li>
			<li class="breadcrumb-item"><a href="#">見込み客一覧</a></li>
			<li class="breadcrumb-item active">見込み客更新</li>
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
						<label class="text2"><%=updateBean.getId() == null ? "" : updateBean.getId() %></label>
						<input type="hidden" name="leadid" value="<%=updateBean.getId() == null ? "" : updateBean.getId() %>" />
					</div>
					<div class="content-item">
						<label class="caption">姓：</label>
						<input class="text2" type="text" name="lastname" value="<%=updateBean.getLastName() == null ? "" : updateBean.getLastName() %>" />
					</div>
					<div class="content-item">
						<label class="caption">名：</label>
						<input class="text2" type="text" name="firstname" value="<%=updateBean.getFirstName() == null ? "" : updateBean.getFirstName() %>" />
					</div>
					<div class="content-item">
						<label class="caption">会社名：</label>
						<input class="text4" type="text" name="companyname" value="<%=updateBean.getCompanyName() == null ? "" : updateBean.getCompanyName() %>" />
					</div>
					<div class="content-item">
						<label class="caption">役職名：</label>
						<input class="text3" type="text" name="positionname" value="<%=updateBean.getPosition() == null ? "" : updateBean.getPosition() %>" />
					</div>
					<div class="content-item">
						<label class="caption">ソース：</label>
						<select class="select1" name="source">
							<% for(Map.Entry<String, String> m : updateBean.getSourceMap().entrySet()) { %>
							<option value="<%=m.getKey() %>" <%=m.getKey().equals(updateBean.getSourceCode()) ? "selected" : "" %>><%=m.getValue() %></option>
							<% } %>
						</select>
					</div>
					<div class="content-item">
						<label class="caption">状況：</label>
						<select class="select2" name="status">
							<% for(Map.Entry<String, String> m : updateBean.getStatusMap().entrySet()) { %>
							<option value="<%=m.getKey() %>" <%=m.getKey().equals(updateBean.getStatusCode()) ? "selected" : "" %>><%=m.getValue() %></option>
							<% } %>
						</select>
					</div>
					<div class="content-item">
						<label class="caption">評価：</label>
						<select class="select1" name="estimation">
							<% for(Map.Entry<String, String> m : updateBean.getEstimationMap().entrySet()) { %>
							<option value="<%=m.getKey() %>" <%=m.getKey().equals(updateBean.getEstimationCode()) ? "selected" : "" %>><%=m.getValue() %></option>
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
						<label class="caption">携帯：</label>
						<input class="text2" type="text" name="mobilephone" value="<%=updateBean.getMobilePhone() == null ? "" : updateBean.getMobilePhone() %>" />
					</div>
					<div class="content-item">
						<label class="caption">FAX：</label>
						<input class="text2" type="text" name="fax" value="<%=updateBean.getFax() == null ? "" : updateBean.getFax() %>" />
					</div>
					<div class="content-item">
						<label class="caption">メール：</label>
						<input class="text3" type="text" name="mailaddress" value="<%=updateBean.getMailAddress() == null ? "" : updateBean.getMailAddress() %>" />
					</div>
					<div class="content-item">
						<label class="caption">URL：</label>
						<input class="text4" type="text" name="url" value="<%=updateBean.getUrl() == null ? "" : updateBean.getUrl() %>" />
					</div>
					<div class="content-item">
						<label class="caption">業種：</label>
						<select class="select3" name="industry">
							<% for(Map.Entry<String, String> m : updateBean.getIndustryMap().entrySet()) { %>
							<option value="<%=m.getKey() %>" <%=m.getKey().equals(updateBean.getIndustryCode()) ? "selected" : "" %>><%=m.getValue() %></option>
							<% } %>
						</select>
					</div>
					<div class="content-item">
						<label class="caption">年間売上：</label>
						<input class="text2" type="text" name="amount" value="<%=updateBean.getAmount() == null ? "" : updateBean.getAmount() %>" />
					</div>
					<div class="content-item">
						<label class="caption">従業員数：</label>
						<input class="text1" type="text" name="employee" value="<%=updateBean.getEmployees() == null ? "" : updateBean.getEmployees() %>" />
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
							<option value="<%=m.getKey() %>" <%=m.getKey().equals(updateBean.getDivisionCode()) ? "selected" : "" %>><%=m.getValue() %></option>
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
						<button type="button" class="btn btn-info button3" data-toggle="modal" data-target="#selectdialog">取引の開始</button>
						<button type="button" id="updatebutton" class="btn btn-primary button3">更新</button>
						<button type="button" id="returnbutton" class="btn btn-default button3">戻る</button>
					</div>
				</div>

				<!-- 取引の開始ボタン押下時に表示されるダイアログ -->
				<div class="modal" id="selectdialog" tabindex="-1">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h4>選択</h4>
							</div>
							<div class="modal-body">
								<div class="onecolumn">
									<ul class="nonepointlist modal-item">
										<li>
											<input type="radio" id="newradio" name="account" checked="checked"><label>新規取引先の作成</label></input>
										</li>
										<li>
											<input type="radio" id="curradio" name="account"><label>既存取引先の担当者として作成</label></input>
										</li>
									</ul>
								</div>
								<div class="onecolumn">
									<div class="modal-item" id="accountsearchitem">
										<input type="text" id="acocountname" class="text3" readonly="readonly" />
										<input type="hidden" id="acocountid" class="text3" />
										<button type="button" id="accountsearchbutton" class="btn btn-primary btn-sm button2" data-toggle="modal" data-target="#accountdialog">取引先検索</button>
									</div>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" id="accountbutton" class="btn btn-info button2">開始</button>
								<button type="button" class="btn btn-default" data-dismiss="modal">キャンセル</button>
							</div>
						</div>
					</div>
				</div>
				<jsp:include page="../dialog/accountsearchdialog.jsp" />
			</form>
		</div>

		<!-- フッタエリア -->
		<jsp:include page="../parts/footer.jsp" />

	</body>
</html>