<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta id="viewport" name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, minimum-scale=1, maximum-scale=1">
	<link rel="stylesheet" href="<c:url value='/resources/css/common.css' />" type="text/css" />
</head>
<body>
	<div id="wrap">
		<nav class="navbar">
			<div class="content">
				<div class="logo">
					<a href="/view"> <img src="<c:url value='/resources/img/instagram.png' />" /></a>
				</div>
				<div class="search">
					<form method="get" action="./search/interest">
						<input id="txtSearch" placeholder="검색" type="text" name="hashtag" />
					</form>
				</div>
				<div class="personInfo userId">
					<a style="color: #125688;" href="./user/test/${userId}"><c:out value="${nickname}"/></a> 
					<span id="userId" style="visibility:hidden">${userId}</span>
				</div>
			</div>
		</nav>
		
		<div class="mainContainer">
			<%-- <section>
				<div class="nav">
					<div class="userImg">
						 <img src="https://igcdn-photos-g-a.akamaihd.net/hphotos-ak-xft1/t51.2885-19/s150x150/12552423_441484902713862_1832731177_a.jpg" />
						 <span class="userId">
						 	akdung21
						 </span>
					</div>
					<div class="updateTime">
						1시간 
					</div>
				</div>
				<div class="img">
					<img src="<c:url value='/resources/img/testimg.png' />" />
				</div>
				<div class="mainData">
					<div class="likeCount">
						좋아요 30
					</div>
					<div class="content">
						<div class="text">
							<span class="userId" id="userId">akdung21</span>
							아메리카노 사러갔다가 물병 필요해서<br>
							첨으로 스벅에서 사봤당ㅋㅋ<br>
							비싼데 이쁘긴하네~ 물 많이 마시자!!💦 <br>
							<span class="hashtag">#스타벅스</span> <span class="hashtag">#STARBUCKS</span>  <span class="hashtag">#텀블러</span>  <span class="hashtag">#써니보틀</span>  <span class="hashtag">#물병</span> 
						</div>
						<div class="comment">
							<div class="commentList">
								<p><span class="userId">akdung21</span> 우왕~~~😍😍</p>
								<p><span class="userId">joao.marcos.mt</span> 😍😘😘</p>
								
							</div>
							
						</div>
					</div>
					<div class="commentAdd">
						<div class="likeBtn">
							<img src="<c:url value='/resources/img/like_.png' />" />
						</div>
						<div class="dislikeBtn">
							<img src="<c:url value='/resources/img/like_.png' />" />
						</div>
						<div>
							<input class="commentInput" type="text" placeholder="댓글달기..." />
						</div>
						<div class="more">
							<img src="<c:url value='/resources/img/moreBtn.png' />" />
						</div>
					</div>
				</div>
			</section>
			 --%>
			
			
			
			<div class="moreFeed" nextFeed="2">
				<span class="moreText"> 더 읽어들이기 </span>
			</div>
		</div>
	</div>
	<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
	<script src="<c:url value='/resources/js/jquery.timeago.js' />"></script>
	<script src="<c:url value='/resources/js/jquery.timeago.ko.js' />"></script>
	<script src="<c:url value='/resources/js/view.js' />"></script>
</body>
</html>
