<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% request.setCharacterEncoding("utf8");%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<meta id="viewport" name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1, minimum-scale=1, maximum-scale=1">
<link rel="stylesheet"
	href="<c:url value='/resources/css/common.css' />" type="text/css" />
</head>
<body>
	<div id="wrap">
		<div class="loginBox">
			<div class="logo">
				<img src="<c:url value='/resources/img/instagram.png' />" />
			</div>
			<div class="formBox">
				<form id="userForm"> 
					<div class="idInput">
						<input id="u_id" name="u_id" type="text" placeholder="사용자 이름" />
					</div>
					<div class="passInput">
						<input id="u_pw" name="u_pw" type="text" placeholder="비밀번호" />
					</div>
					<div class="loginBtn">
						<input id="loginBtn" type="button" value="로그인" />
					</div>
					<div class="joinBtn">
						<input type="button" value="회원가입" />
					</div>
				</form>
			</div>
		</div>
	</div>
	<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
	<script>
		$("#loginBtn").click(function(){
			
		    $.ajax({
		    	type:'post',
		    	contentType: "application/json",
		    	url: "./user/login", 
		    	data : JSON.stringify({
		    		u_id:$("#u_id").val(),
		    		u_pw:$("#u_pw").val()
		    	}),
		    	dataType: 'json',
		    	success: function(result){
		    		if(result.isSuccess == 1) {
		    			location.href='./user/loginProc/'+result.msg;	
		    		} else {
		    			alert("로그인에 실패했습니다!");
		    		}
		    		
		    	}
		    });
		});
	</script>
	<%-- <script src="<c:url value='/resources/js/view.js' />"></script> --%>
</body>
</html>
