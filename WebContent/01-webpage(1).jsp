<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	String color = "blue";
%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8" />
	<title>My JSP Page</title>
	<!-- Twitter Bootstrap3 & jQuery -->
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" />
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css" />
	<script src="http://code.jquery.com/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<%
			if (color.equals("red")) {
				out.print("<h1 style='color: red'>Hello JSP</h1>");
			} else {
				out.print("<h1 style='color: blue'>Hello JSP</h1>");
			}
		%>

		<% if (color.equals("red")) { %>
		<h2 style='color: red'>안녕하세요. JSP</h2>
		<% } else { %>
		<h2 style='color: blue'>안녕하세요. JSP</h2>
		<% } %>
		
		<h3 style='color: <%=color%>'>JSP로 작성한 웹 페이지 입니다.</h3>
	</div>
</body>
</html>
