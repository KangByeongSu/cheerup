$(document).ready(function() {
	var checkid = $("#checkid");
	
	$("#checkid").focusout(_.debounce(checkId,500,true));
	
	$("#register-form").validate({
		 rules: {
			    uId: {
	                required: true,
	                minlength: 5
	            },
	            uPw: {
	                required: true,
	                minlength: 5
	            },
	            uNickname: "required"
	        },
	        messages: {
	        	uId: {
	                required: "아이디를 입력해줘",
	                minlength: "5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능해."
	            },
	        	uPw: {
	                required: "패스워드를 입력해줘",
	                minlength: "5자리 이상이야"
	            },
	            uNickname: "닉네임을 입력해줘"
	        },
	        submitHandler: function(form) {
	            form.submit();
	        }
	 });
	
	function checkId() {
		var checkid = $("#checkid").val();
		if (checkid.length > 5) {
				$.ajax({
					url : "./check",
					data : {
						"userId" : checkid
					},
					method : "GET",
					success : function(resData) {
						$("#checkidtext").html(resData.msg);
					},
					error : function() {
					}
				});
		} else{
			$("#checkidtext").html();

		}
	}

});
