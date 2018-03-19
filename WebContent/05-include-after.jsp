<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!doctype html>
<html>
<head>
<%@ include file="/inc/common.jsp"%>
</head>
<body>
	<%@ include file="/inc/header.jsp"%>
	<section>
		<div class="container">
			<div class="row">
				<div class="col-md-2" style='background: #0f0'>
					<%@ include file="/inc/sidebar.jsp"%>
				</div>
				<div class="col-md-10" style='background: #ff0'>
					<h2>본문 영역</h2>
				</div>
			</div>
		</div>
	</section>
	<%@ include file="/inc/footer.jsp"%>
</body>
</html>