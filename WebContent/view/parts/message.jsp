<%@ page import="java.util.*" %>
<jsp:useBean id="messages" scope="request" class="java.util.LinkedHashMap" type="java.util.LinkedHashMap<String, String>" />

<link rel="stylesheet" type="text/css" href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/css/parts/message.css">

<div class="messagearea">
	<% for(String msg : messages.values()) { %>
	<div>
		<label class="msg"><%= msg %></label>
	</div>
	<% } %>
</div>