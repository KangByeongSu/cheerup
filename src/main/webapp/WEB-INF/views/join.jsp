<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% request.setCharacterEncoding("utf8");%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<meta id="viewport" name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, minimum-scale=1, maximum-scale=1">
	<link rel="stylesheet" href="<c:url value='/resources/css/common.css' />" type="text/css" />
</head>
<body>
	<div id="wrap">
		<div class="loginBox">
			<div class="logo">
				<img src="<c:url value='/resources/img/instagram.png' />" />
			</div>
			<div class="formBox">
				<div class="idInput">
					<input type="text" placeholder="사용자 이름" />
				</div>
				<div class="passInput">
					<input type="text" placeholder="비밀번호"/>
				</div>
				<div class="nickInput">
					<input type="text" placeholder="닉네임"/>
				</div>
				
				<div class="joinBtn">
					<input type="button" value="회원가입" />
				</div>
			</div>
		</div>
	</div>
	<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
	<%-- <script src="<c:url value='/resources/js/view.js' />"></script> --%>
</body>
</html>
