<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page trimDirectiveWhitespaces="true"%>
<!doctype html>
<html>
<head>
<%@ include file="/WEB-INF/views/inc/head.jsp" %>
</head>
<body>
<%@ include file="/WEB-INF/views/inc/topbar.jsp" %>
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<h1 class="page-header">비밀번호 확인</h1>
			<p>
				탈퇴를 위해서는 비밀번호를 입력해 주세요 
			</p>
				
			<!-- 비밀번호 입력 폼 시작 -->
			<form name="myform" method="post" action="${pageContext.request.contextPath}/member/out_ok.do">
				<div class="form-group">
					<input type="password" name="user_pw" class="form-control" />
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary btn-block">
						회원 탈퇴</button>
				</div>
			</form>
			<!--// 이메일 주소 입력 폼 끝 -->
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/views/inc/footer.jsp" %>
</body>
</html>