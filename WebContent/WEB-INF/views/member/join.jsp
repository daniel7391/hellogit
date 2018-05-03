<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<%@ include file="/WEB-INF/views/inc/head.jsp" %>
</head>
<body>
<%@ include file="/WEB-INF/views/inc/topbar.jsp" %>
	<div class="container">
		<div class="page-header">
			<h1>회원가입</h1>
		</div>	
		<form class="form-horizontal" name="myform" method="post" enctype="multipart/form-data"
			action="${pageContext.request.contextPath}/member/join_ok.do">
			
			<div class="form-group">
				<label for="userid" class="col-md-2">아이디 *</label>
				<div class="col-md-10">
					<input type="text" name="user_id" id="user_id" class="form-control" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="password" class="col-md-2">비밀번호 *</label>
				<div class="col-md-10">
					<input type="password" name="user_pw" id="user_pw" class="form-control" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="password_re" class="col-md-2">비밀번호 확인 *</label>
				<div class="col-md-10">
					<input type="password" name="user_pw_re" id="user_pw_re" class="form-control" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="name" class="col-md-2">이름 *</label>
				<div class="col-md-10">
					<input type="text" name="name" id="name" class="form-control" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="email" class="col-md-2">이메일 *</label>
				<div class="col-md-10">
					<input type="email" name="email" id="email" class="form-control" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="tel" class="col-md-2">연락처 *</label>
				<div class="col-md-10">
					<input type="tel" name="tel" id="tel" class="form-control" placeholder="'-'없이 입력"/>
				</div>
			</div>
			
			<div class="form-group">
				<label for="birthdate" class="col-md-2">생년월일 *</label>
				<div class="col-md-10">
					<input type="date" name="birthdate" id="birthdate" class="form-control" placeholder="yyyy-mm-dd"/>
				</div>
			</div>
			
			<div class="form-group">
				<label for="gender1" class="col-md-2">성별 *</label>
				<div class="col-md-10">
					<label class="radio-inline">
						<input type="radio" name="gender" id="gender1" value="M" /> 남자
					</label>
					<label class="radio-inline">
						<input type="radio" name="gender" id="gender2" value="F" /> 여자
					</label>
				</div>
			</div>
			
			<div class="form-group">
				<label for="postcode" class="col-md-2">우편번호</label>
				<div class="col-md-10 clearfix">
					<input type="text" name="postcode" id="postcode" class="form-control pull-left" style="width:120px; margin-right:5px;"/>
					<input type="button" value="우편번호 찾기" class="btn btn-warning" onclick='execDaumPostcode("postcode", "addr1", "addr2")'/>
				</div>
			</div>
			
			<div class="form-group">
				<label for="addr1" class="col-md-2">주소 </label>
				<div class="col-md-10">
					<input type="text" name="addr1" id="addr1" class="form-control" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="addr2" class="col-md-2">상세주소 </label>
				<div class="col-md-10">
					<input type="text" name="addr2" id="addr2" class="form-control" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="profile_img" class="col-md-2">프로필사진</label>
				<div class="col-md-10">
					<input type="file" name="profile_img" id="profile_img" class="form-control" />
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-md-offest-2 col-md-10">
					<button type="submit" class="btn btn-primary">가입하기</button>
					<button type="reset" class="btn btn-danger">다시작성</button>
				</div>
			</div>
		</form>
	</div>
<%@ include file="/WEB-INF/views/inc/footer.jsp" %>
</body>
</html>