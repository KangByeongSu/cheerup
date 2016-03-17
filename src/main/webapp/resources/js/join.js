$(document).ready(function() {
	var checkid = $("#checkid");
	var boolcheckid = 1;
	
	$("#checkid").focusout(_.debounce(checkId,500,true));
	
	$("#register-form").validate({
		 rules: {
			    
	            uPw: {
	                required: true,
	                minlength: 5
	            },
	            password_again: {
	            	required: true,
	            	minlength: 5,
	                equalTo: "#password"
	            },
	            uNickname: "required"
	        },
	        messages: {
	        	
	        	uPw: {
	                required: "패스워드를 입력해주세요",
	                minlength: "비밀번호는 5자리 이상입니다"
	            },
	            password_again:{
	            	required: "패스워드 확인해주세요",
	                minlength: "비밀번호는 5자리 이상입니다",
                    equalTo: "비밀번호가 서로 다릅니다"	
                },
	            uNickname: "닉네임을 입력해주세요"
	        },
	        submitHandler: function(form) {
	        	if(boolcheckid==0)
	            form.submit();
	        }
	 });
	
	function checkId() {
		var checkid = $("#checkid").val();
		if (checkid.length > 4) {
				$.ajax({
					url : "./check",
					data : {
						"userId" : checkid
					},
					method : "GET",
					success : function(resData) {
						$("#checkidtext").html(resData.msg);
						$("#checkidtext").show();
						boolcheckid = resData.isSuccess;
					},
					error : function() {
					}
				});
		} else{
			$("#checkidtext").html("5~20자의 영문 소문자, 숫자와 특수기호만 사용 가능합니다");
			$("#checkidtext").show();
			boolcheckid = 1;

		}
	}

});
