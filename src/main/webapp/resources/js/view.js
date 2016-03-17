$(document).ready(function() {	
	var userId = $("#wrap").attr("userId");
	
	$(".moreFeed").click(function() {
		var nextFeed = parseInt($(this).attr("nextFeed"));
		getFeed(nextFeed);
		
		$(this).attr("nextFeed", nextFeed+1);
		
	});
	
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
	
	var makeComment=function(comment){
		var tmpComment="";
		$.each(comment, function(comment_index, comment_value){
			
		
		tmpComment+="<p><span class='userId'>"+comment_value.userId+"</span> "+comment_value.message;
		
		
		if(comment_value.userId === userId) {
			tmpComment+= " <img style='width:14px' src='/resources/img/delete.png' />"
		}
		tmpComment+= "</p>";
			
		});
		return tmpComment;
	}
	
	
	var makeLikeBtn=function(upList){
		
		var likeBtn = "";
		
		if($.inArray(userId, upList) >= 0) {
			likeBtn = '<img  src="/resources/img/like.png" />'
		} else {
			likeBtn = '<img  src="/resources/img/like_.png" />'
		}
		
		return likeBtn;
	}
		

	
	var getFeed = function(pageNum) {
		$.ajax({
			url: "./feed/lists/"+pageNum,
			success:function(resData) {
				if(resData.isSuccess) {
					$(".likeBtn").off("click");
					$(".dislikeBtn").off("click");
					
					$.each(resData.feedList, function(feed_index, v) {
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
										jQuery.timeago(v.createTime)+ 
									'</div>'+
								'</div>'+
								'<div class="img">'+
									'<img src="'+ v.imgurl +'" />'+
								'</div>'+
								'<div class="mainData">'+
									'<div class="likeCount">'+
										'좋아요 <span id="likeNum'+v.feedId+'" class="likeNumData">'+ v.upUserList.length + '</span>'+
									'</div>'+
									'<div class="content">'+
										'<div class="text">'+
											'<span class="userId">'+v.userId+'</span>'+
											makeHashtag(v.message) + 
										'</div>'+
										'<div class="comment">'+
											'<div class="commentList">'+
											makeComment(v.commentList)+
											'</div>'+
										'</div>'+
									'</div>'+
									'<div class="commentAdd">'+
										'<div feedId="'+v.feedId+'" class="likeBtn">'+
											makeLikeBtn(v.upUserList)+
											//'<img  src="./resources/img/like_.png" />'+
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
										addPosition.append("<p><span class='userId'>"+$("#userId").text()+"</span> "+commentData.message+" <img style='width:14px' src='/resources/img/delete.png' /></p>");
										$(".commentInput").val("");
									},

									error : function() {
										
										alert("알 수 없는 오류로 실패하였습니다.");
									}
								});
						 }
						

						
					});
					
					$(".likeBtn").click(function(e) {
						var self=this;
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
					    			var elLikeNum = $(self).parent().parent().children(".likeCount").children(".likeNumData");
					    			var likeNum = parseInt(elLikeNum.html());
					    			
					    			if($(self).children().attr("src") === "/resources/img/like.png" ) {
						    			$(self).children().attr("src","/resources/img/like_.png");
						    			elLikeNum.html(likeNum-1);
						    		} else {
			 			    			$(self).children().attr("src","/resources/img/like.png");
			 			    			elLikeNum.html(likeNum+1);
						    		}
					    			
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
	}
	
	
	getFeed(1);
	
	
});



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

