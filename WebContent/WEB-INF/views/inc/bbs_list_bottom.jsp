<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 검색폼 + 글 쓰기 버튼 시작 -->
<div class="clearfix">
   <!-- 검색 폼 -->
    <div class="pull-left">
		<form method="get" action="${pageContext.request.contextPath}/bbs/document_list.do" style="width: 200px">
			<input type="hidden" name="category" value="${category}" />
			<div class="input-group">
				<input type="text" name="keyword" class="form-control"
					placeholder="제목,내용 검색"  value="${keyword}"/>
				<span class="input-group-btn">
					<button class="btn btn-success" type="submit">
						<i class="glyphicon glyphicon-search"></i>
					</button>
				</span>
			</div>
		</form>
	</div>
	    
    <!-- 글 쓰기 버튼 -->
    <div class="pull-right">
        <a href="${pageContext.request.contextPath}/bbs/document_write.do?category=${category}" class="btn btn-primary">
        	<i class="glyphicon glyphicon-pencil"></i> 글쓰기
        </a>
	</div>
</div>
<!--// 검색폼 + 글 쓰기 버튼 끝 -->

<!-- 페이지 번호 시작 -->
<nav class="text-center">
	<ul class="pagination">
		<!-- 이전그룹으로이동 -->
		<c:choose>
			<c:when test="${pageHelper.prevPage > 0}">
				<c:url var="prevUrl" value="/bbs/document_list.do">
					<c:param name="category" value="${category}" ></c:param>
					<c:param name="keyword" value="${keyword}" ></c:param>
					<c:param name="page" value="${pageHelper.prevPage}" ></c:param>
				</c:url>
				
				<li><a href="${prevUrl}">&laquo;</a></li>
			</c:when>
			<c:otherwise>
				<li class="disabled"><a href="#">&laquo;</a></li>
			</c:otherwise>
		</c:choose>
		
		<!-- 페이지번호 -->
		<!-- 현재 그룹의 시작페이지-끝페이지 사이를 1씩 증가하면서 반복 -->
		<c:forEach var="i" begin="${pageHelper.startPage}" end="${pageHelper.endPage}" step="1">
			<c:url var="pageUrl" value="/bbs/document_list.do">
				<c:param name="category" value="${category}" ></c:param>
				<c:param name="keyword" value="${keyword}" ></c:param>
				<c:param name="page" value="${i}" ></c:param>
			</c:url>
			
			<c:choose>
				<c:when test="${pageHelper.page == i}">
					<li class="active"><a href="#">${i}</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${pageUrl}">${i}</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		<!-- 다음그룹으로이동 -->
		<c:choose>
			<c:when test="${pageHelper.nextPage > 0}">
				<c:url var="nextUrl" value="/bbs/document_list.do">
					<c:param name="category" value="${category}" ></c:param>
					<c:param name="keyword" value="${keyword}" ></c:param>
					<c:param name="page" value="${pageHelper.nextPage}" ></c:param>
				</c:url>
				
				<li><a href="${nextUrl}">&raquo;</a></li>
			</c:when>
			<c:otherwise>
				<li class="disabled"><a href="#">&raquo;</a></li>
			</c:otherwise>
		</c:choose>
	</ul>
</nav>
<!--// 페이지 번호 끝 -->
	