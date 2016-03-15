$(document).ready(function() {	
	var makeHashtag = function(message) {
		var tmpMessage = "";
		$.each(message.split(" "), function(i, v) {
			if(v.indexOf("#") == 0) {
				tmpMessage += '<span class="hashtag">'+v+'</span> '
			} else {
				tmpMessage += v+' ';
			} 
		});
		return tmpMessage;
// '<span class="hashtag">#스타벅스</span>' <span class="hashtag">#STARBUCKS</span>
// <span class="hashtag">#텀블러</span> <span class="hashtag">#써니보틀</span> <span
// class="hashtag">#물병</span>'+

	};
		
	$(".commentInput").keydown(function(key) {
		
		 if (key.keyCode == 13){
			 var commentData = {		
					  "feedId" : $(this).attr("feedId"),
					  "message" : $(this).val()
				};
			 
			 var addPosition=$(this).parent().parent().parent().children(".content").children(".comment").children(".commentList");
			 $.ajax({
					url : "./feed/comment",
					type : 'POST', // define the type of HTTP verb
									// we want to use (POST for our
									// form)
					data : JSON.stringify(commentData), // our data
														// object
					contentType : "application/json",
					charset : "utf-8",
					success : function(resData) {
						console.log(resData.msg)
						frontEndCommentAdd(addPosition);
					},

					error : function() {
						
						alert("알 수 없는 오류로 실패하였습니다.");
					}
				});
		 }
		

		
	});
	
	$.ajax({
		url: "./feed/lists/1",
		success:function(resData) {
			if(resData.isSuccess) {
				$(".likeBtn").off("click");
				$(".dislikeBtn").off("click");
				
				$.each(resData.feedList, function(i, v) {
					var temp =
						'<section>' +
							'<div class="nav">' +
								'<div class="userImg">' +
									'<img src="'+ v.imgurl +'" />' +
									 '<span class="userId">' +
									 	v.userId +
									 '</span>'+
								'</div>'+
								'<div class="updateTime">'+
									'1시간'+ 
								'</div>'+
							'</div>'+
							'<div class="img">'+
								'<img src="'+ v.imgurl +'" />'+
							'</div>'+
							'<div class="mainData">'+
								'<div class="likeCount">'+
									'좋아요 '+ v.upUserList.length +
								'</div>'+
								'<div class="content">'+
									'<div class="text">'+
										'<span class="userId">'+v.userId+'</span>'+
										makeHashtag(v.message) + 
									'</div>'+
									'<div class="comment">'+
										'<div class="commentList">'+
											'<p><span class="userId">akdung21</span> 우왕~~~😍😍</p>'+
											'<p><span class="userId">joao.marcos.mt</span> 😍😘😘</p>'+
										'</div>'+
									'</div>'+
								'</div>'+
								'<div class="commentAdd">'+
									'<div feedId="'+v.feedId+'" class="likeBtn">'+
										'<img  src="./resources/img/like_.png" />'+
									'</div>'+
									'<div feedId="'+v.feedId+'" class="dislikeBtn">'+
										'<img src="./resources/img/like_.png" />'+
									'</div>'+
									'<div>'+
										'<input feedId="'+v.feedId+'"class="commentInput" type="text" placeholder="댓글달기..." />'+
									'</div>'+
									'<div class="more">'+
										'<img src="./resources/img/moreBtn.png" />'+
									'</div>'+
								'</div>'+
							'</div>'+
						'</section>';
					
					$('.moreFeed').before(temp);
				});
				
				$(".likeBtn").click(function(e) {
					console.log("feedId : ", $(this).attr("feedId"));
					$.ajax({
				    	type:'post',
				    	contentType: "application/json",
				    	url: "./feed/like", 
				    	data : JSON.stringify({
				    		contentId: $(this).attr("feedId"),
				    		up:1,
				    		down:0
				    	}),
				    	dataType: 'json',
				    	success: function(result){
				    		if(result.isSuccess == 1) {
				    			alert("success")	
				    		} else {
				    			alert("fail");
				    		}
				    		
				    	}
				    });
				}) ;
				
				$(".dislikeBtn").click(function(e) {
					console.log("feedId : ", $(this).attr("feedId"));
					$.ajax({
				    	type:'post',
				    	contentType: "application/json",
				    	url: "./feed/like", 
				    	data : JSON.stringify({
				    		contentId: $(this).attr("feedId"),
				    		up:0,
				    		down:1
				    	}),
				    	dataType: 'json',
				    	success: function(result){
				    		if(result.isSuccess == 1) {
				    			alert("success")	
				    		} else {
				    			alert("fail");
				    		}
				    		
				    	}
				    });
				}) ;
			} else {
				alert("알 수 없는 오류로 실패하였습니다.");
			}
		},
		error: function() {
			alert("알 수 없는 오류로 실패하였습니다.");
		}
	});
});

function frontEndCommentAdd(addPosition){
	
	addPosition.append("<p><span class='userId'>"+$("#userId").text()+"</span>"+$(".commentInput").val()+"</p>");
	$(".commentInput").val("");
}

function commentPlusView(feedId,pageNo){
	 $.ajax({
			url : "./"+feedId+"/comment/"+pageNo,
			type : 'get', // define the type of HTTP verb
							// we want to use (POST for our
							// form)
			dataType : "application/json",
			charset : "utf-8",
			success : function(resData) {
				if(resData===1){
					return resData.commnetList;
				}
			},

			error : function() {
				
				alert("알 수 없는 오류로 실패하였습니다.");
			}
		});
}

function commentUpdate(commentId,msg){
	var commentData={
			"message"	: msg
	}
	
	 $.ajax({
			url : "./feed/comment/"+commentId,
			type : 'put', // define the type of HTTP verb
							// we want to use (POST for our
							// form)
			data : JSON.stringify(commentData), // our data
												// object
			contentType : "application/json",
			charset : "utf-8",
			success : function(resData) {
				console.log(resData.msg)
				frontendCommentEdit();//frontend edit
			},

			error : function() {
				
				alert("알 수 없는 오류로 실패하였습니다.");
			}
		});

}

function commentDelete(commentId){
	
	 $.ajax({
			url : "./feed/comment/"+commentId,
			type : 'delete', // define the type of HTTP verb
							// we want to use (POST for our
							// form)
			charset : "utf-8",
			success : function(resData) {
				console.log(resData.msg)
				frontendCommentDelete();//frontend edit
			},

			error : function() {
				
				alert("알 수 없는 오류로 실패하였습니다.");
			}
		});

}

