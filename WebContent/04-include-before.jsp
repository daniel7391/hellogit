<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8" />
<title>My JSP Page</title>
<!-- Twitter Bootstrap3 & jQuery -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" />
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
h1, h2 {
	margin: 0;
	line-height: 100px;
}
</style>
</head>
<body>
	<header>
		<div class="container" style='background: #f60'>
			<h1>웹 페이지 타이틀 영역</h1>
		</div>
	</header>
	<section>
		<div class="container">
			<div class="row">
				<div class="col-md-2" style='background: #0f0'>
					<h2>사이드바</h2>
				</div>
				<div class="col-md-10" style='background: #ff0'>
					<h2>본문 영역</h2>
				</div>
			</div>
		</div>
	</section>
	<footer>
		<div class="container" style='background: #f0f'>
			<h1>웹 페이지 하단 영역</h1>
		</div>
	</footer>
</body>
</html>