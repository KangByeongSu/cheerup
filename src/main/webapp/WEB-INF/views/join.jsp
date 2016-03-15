<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<meta id="viewport" name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1, minimum-scale=1, maximum-scale=1">
<link rel="stylesheet"
	href="<c:url value='/resources/css/common.css' />" type="text/css" />
		<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>

</head>
<body>
	<div id="wrap">
		
		<div class="loginBox">
			<div class="logo">
				<img src="<c:url value='/resources/img/instagram.png' />" />
			</div>
			<form id="register-form" action="./add" method="post"> 
			<div class="formBox">
				<div class="idInput">
					<input id="checkid" name="uId" type="text" placeholder="id" />
					<div id="checkidtext"></div>
				</div>
				<div class="passInput">
					<input id="password" name="uPw" type="password" placeholder="password" />
				</div>
				<div class="passInput">
					<input id="password_again" name="password_again" type="password" placeholder="password" />
				</div>
				<div class="nickInput">
					<input id="nickname" name="uNickname" type="text" placeholder="nickname" />
				</div>
				<div class="joinBtn">
					<input id="singup" type="submit" value="가입하기" />
				</div>
			</div>
			</form>
		</div>
		
	</div>
	
	<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/lodash.js/0.10.0/lodash.min.js"></script>
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
	<script src="<c:url value='/resources/js/join.js' />"></script>
		
</body>
</html>
