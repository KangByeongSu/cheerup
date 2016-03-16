<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<meta id="viewport" name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, minimum-scale=1, maximum-scale=1">
	<link rel="stylesheet" href="<c:url value='/resources/css/mypage.css' />" type="text/css" />
</head>
<body>

	<form>
		<input id="nickname" type="text">
		<input id="pw" type="text">
		<button id="btn">ë³ê²½</button>

	</form> 
	
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script>
$(document).ready(function(){


	$("#btn").click(function(){
		var nickname=$("#nickname").val();
		var pw=$("#pw").val();
		var userId="user";

		var userData={

			 "uNickname"	:    nickname,
     		 "uPw"          :    pw

		};

		$.ajax({
			url	: "./user/"+userId,
			type : "put",
			data : JSON.stringify(userData), // our data
												// object
			contentType : "application/json",
			charset : "utf-8",
			success : function(resData) {
				console.log(resData.msg)
				
			},

			error : function() {
				
				alert("ì ì ìë ì¤ë¥ë¡ ì¤í¨íììµëë¤.");
			}


		});
	});

});



</script>
</body>
</html>