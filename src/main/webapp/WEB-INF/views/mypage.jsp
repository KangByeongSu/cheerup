<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% request.setCharacterEncoding("utf8");%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<meta id="viewport" name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, minimum-scale=1, maximum-scale=1">
	<link rel="stylesheet" href="<c:url value='/resources/css/mypage.css' />" type="text/css" />
</head>
<body>
	<div id="wrap">
		<nav class="navbar">
			<div class="content">
				<div class="logo">
					<img src="<c:url value='/resources/img/instagram.png' />" />
				</div>
				<div class="personInfo userId">
					로그아웃 
				</div>
			</div>
		</nav>
		
		<div class="mainContainer">
			<div class="navbar">
				<div class="userImg">
					<img src="https://igcdn-photos-h-a.akamaihd.net/hphotos-ak-xfp1/t51.2885-19/924632_1015723898456023_1603104456_a.jpg" />
				</div>
				<div class="userInfo">
					<div class="userId_">
						<span class="userId__"> akdung21</span>
						<div class="modifyBtn">
							프로필 편집 
						</div>
					</div>
					<div class="userIntro">
						DongukKim
						<span class="hashtag">#SW_Developer</span> 
						<span class="hashtag">#SKplanet</span>
					</div>
					<div class="userHistory">
						<div>
							게시물 <span class="num">37</span>개
						</div>
						<div>
							팔로워 <span class="num">236</span>명
						</div>
						<div>
							팔로우 <span class="num">339</span>명
						</div>
					</div>
				</div>
				
			</div>
			<div class="img_list">
				<div class="imgItem">
					<img src="https://scontent.cdninstagram.com/t51.2885-15/s640x640/sh0.08/e35/12748407_1123003344378522_2087727875_n.jpg?ig_cache_key=MTE4NzM5NjU3ODI5MTM4NzI0Nw%3D%3D.2">
				</div>
				<div class="imgItem">
					<img src="https://scontent.cdninstagram.com/t51.2885-15/s640x640/sh0.08/e35/12748407_1123003344378522_2087727875_n.jpg?ig_cache_key=MTE4NzM5NjU3ODI5MTM4NzI0Nw%3D%3D.2">
				</div>
				<div class="imgItem">
					<img src="https://scontent.cdninstagram.com/t51.2885-15/s640x640/sh0.08/e35/12748407_1123003344378522_2087727875_n.jpg?ig_cache_key=MTE4NzM5NjU3ODI5MTM4NzI0Nw%3D%3D.2">
				</div>
				<div class="imgItem">
					<img src="https://scontent.cdninstagram.com/t51.2885-15/s640x640/sh0.08/e35/12748407_1123003344378522_2087727875_n.jpg?ig_cache_key=MTE4NzM5NjU3ODI5MTM4NzI0Nw%3D%3D.2">
				</div>
				<div class="imgItem">
					<img src="https://scontent.cdninstagram.com/t51.2885-15/s640x640/sh0.08/e35/12748407_1123003344378522_2087727875_n.jpg?ig_cache_key=MTE4NzM5NjU3ODI5MTM4NzI0Nw%3D%3D.2">
				</div>
			</div>
		</div>
	</div>
	<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<%-- 	<script src="<c:url value='/resources/js/view.js' />"></script> --%>
</body>
</html>
