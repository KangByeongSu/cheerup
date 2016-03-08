<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% request.setCharacterEncoding("euc-kr");%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="<c:url value='/resources/css/common.css' />" type="text/css" />
	<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
</head>
<body>
	<div id="wrap">
		<nav class="navbar">
			<div class="content">
				<div class="logo">
					<img src="<c:url value='/resources/img/instagram.png' />" />
				</div>
				<div class="personInfo">
					akdung21
				</div>
			</div>
		</nav>
		
		<div class="mainContainer">
			<section>
				<div class="nav">
					<div class="userImg">
						 <img src="https://scontent.cdninstagram.com/t51.2885-19/s150x150/12797646_1586114025041720_1619955416_a.jpg" />
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
							<span class="userId">akdung21</span>
							아메리카노 사러갔다가 물병 필요해서<br>
							첨으로 스벅에서 사봤당ㅋㅋ<br>
							비싼데 이쁘긴하네~ 물 많이 마시자!!💦 <br>
							<span class="hashtag">#스타벅스</span> <span class="hashtag">#STARBUCKS</span>  <span class="hashtag">#텀블러</span>  <span class="hashtag">#써니보틀</span>  <span class="hashtag">#물병</span> 
						</div>
						<div class="comment">
						
						</div>
					</div>
				</div>
				
			</section>
		</div>
	</div>
</body>
</html>
