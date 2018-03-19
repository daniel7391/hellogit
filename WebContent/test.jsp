<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!doctype html>
<html>
<head>
	<meta charset="utf-8" />
	<title>My JSP Page</title>
	<!-- Twitter Bootstrap3 & jQuery -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" />
	<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<!-- 내용영역 -->
    <div class="container">
        <!-- 메뉴바 -->
        <div class="navbar navbar-default" role="navigation">
            <!-- 로고 영역 -->
            <div class="navbar-header">
                <!-- 반응형 메뉴 버튼 -->
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">메뉴열기</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <!-- // 반응형 메뉴 버튼 -->
                <!-- 로고 -->
                <a class="navbar-brand" href="#">반응형 웹 만들기</a>
                <!-- // 로고 -->
            </div>
            <!-- //로고 영역 -->
            <!-- 메뉴 영역 -->
            <div class="navbar-collapse collapse">
                <!-- 메뉴항목 -->
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">Home</a></li>
                    <li><a href="#">HTML5</a></li>
                    <li><a href="#">CSS3</a></li>
                    <li><a href="#">Bootstrap3</a></li>
                </ul>
                <!-- //메뉴항목 -->
                <!-- 로그인(메뉴 우측) -->
                <form class="navbar-form navbar-right">
                    <div class="form-group">
                        <input type="text" placeholder="Email" class="form-control">
                    </div>
                    <div class="form-group">
                        <input type="password" placeholder="Password" class="form-control">
                    </div>
                    <button type="submit" class="btn btn-success">Login</button>
                    <button type="button" class="btn btn-warning">Join</button>
                </form>
                <!-- // 로그인(메뉴 우측) -->
            </div>
            <!-- //메뉴 영역 -->

        </div>
        <!-- // 메뉴바 -->
        <!-- 점보트론 -->
        <div class="jumbotron">
            <h1>hTML5+CSS3 &amp; 반응형웹</h1>
            <p>
                기존의 웹 표준 위에 새로워진 HTML5와 CSS3 요소를 더하여 인터렉티브한 반응형 웹페이지 기술을 제작할 수 있는 웹 퍼블리싱 기법들을 소개하고, CSS3의 코드를 편리하게 작성할 수 있도록 도와주는 LESS를 기반으로 한 Twitter Bootstrap3를 활용한 반응형 웹페이지 제작 기법을 소개하여 최고의 웹 퍼블리셔로 발돋음 할 수 있도록 도와드립니다.
            </p>
            <p>
                <a class="btn btn-primary btn-lg" role="button">자세히 보기 &raquo;</a>
            </p>
        </div>
        <!-- //점보트론 -->
        <!-- 그리드 시스템 (데스크탑 가로3칸) -->
        <div class="row">
            <div class="col-md-4">
                <h2>HTML5</h2>
                <p>웹 접근성과 시멘틱 웹, 그리고 XTHML1.0과 HTML5의 차이점에 대한 이해는 반응형 웹을 시작하는 첫 단계 입니다. 그렇기 때문에 이 단원에서는 가장 우선적으로 HTML5의 변경된 웹 페이지 구성과, 새롭게 추가된 시멘틱 요소들 및 멀티미디어 제어 요소들을 소개하고 기본적인 활용 과정을 소개합니다.</p>
                <a class="btn btn-default" href="#" role="button">더보기 &raquo;</a>
            </div>
            <div class="col-md-4">
                <h2>CSS3</h2>
                <p>기존에 사용되던 CSS2와 함께 사용할 수 있는 다채로운 그래픽 효과에 대해서 소개합니다. CSS3의 그림자,그라데이션 효과는 이미지 제작 없이 상당수의 웹 페이지들을 CSS만으로 제작 가능하게 해 주었습니다. CSS3는 CSS2에 효과들이 추가되는 개념이기 때문에 웹 표준기술(XHTML1.0+CSS2)에 대한 이해가 필요합니다.</p>
                <a class="btn btn-default" href="#" role="button">더보기 &raquo;</a>
            </div>
            <div class="col-md-4">
                <h2>Bootstrap3</h2>
                <p>Bootstrap은 트위터에서 만든 반응형 웹 Framework로, 어려운 CSS3나 Javascript에 대한 이해가 없이도 반응형 웹을 손쉽게 만들어 줄 수 있는 도구입니다. 기본적으로 제공하는 페이지의 형태 위에 사용자가 직접 제작한 CSS를 추가하면 다채로운 반응형 웹 페이지를 제작할 수 있습니다.</p>
                <a class="btn btn-default" href="#" role="button">더보기 &raquo;</a>
            </div>
        </div>
        <!-- // 그리드 시스템 -->
        <!-- 푸터 -->
        <footer>
            <hr>
            <address>
                Copyright&copy;2013. <a href="http://www.itpaper.co.kr">itpaper.co.kr</a>. All rights resurved
            </address>
        </footer>
        <!-- // 푸터 -->
    </div>
</body>
</html>