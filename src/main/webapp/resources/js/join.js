$(document).ready(function() {
	var checkid = $("#checkid");
	var boolcheckid = 1;
	
	$("#checkid").focusout(_.debounce(checkId,500,true));
	
	$("#register-form").validate({
		 rules: {
			    /*uId: {
	                required: true,
	                minlength: 5,
	                remote: {
	                    url:  "./check",
	                    type: "GET",
	                    data: {
							"userId" : function(){
								return $("#checkid").val();
							}
						},
						success : function(resData) {
							//$("#checkidtext").html(resData.msg);
							resultText = resData.msg;
						    console.log(resultText);
						    
						}
	                  }
	            },*/
	            uPw: {
	                required: true,
	                minlength: 5
	            },
	            uNickname: "required"
	        },
	        messages: {
	        	/*uId: {
	                required: "아이디를 입력해줘",
	                minlength: "5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능해.",
	                remote : resultText
	            },*/
	        	uPw: {
	                required: "패스워드를 입력해줘",
	                minlength: "5자리 이상이야"
	            },
	            uNickname: "닉네임을 입력해줘"
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
						boolcheckid = resData.isSuccess;
					},
					error : function() {
					}
				});
		} else{
			$("#checkidtext").html("5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능해.");
			boolcheckid = 1;

		}
	}

});
