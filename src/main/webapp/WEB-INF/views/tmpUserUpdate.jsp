<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form>
		<input id="nickname" type="text">
		<input id="pw" type="text">
		<button id="btn">변경</button>

	</form> 
	
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/lodash.js/0.10.0/lodash.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
<script>
$(document).ready(function(){


	$("#btn").click(function(){
		var nickname=$("#nickname").text();
		var pw=$("#pw").text();
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
				
				alert("알 수 없는 오류로 실패하였습니다.");
			}


		});
	});

});



</script>
</body>
</html>