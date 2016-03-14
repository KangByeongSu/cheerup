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
//		'<span class="hashtag">#스타벅스</span>' <span class="hashtag">#STARBUCKS</span>  <span class="hashtag">#텀블러</span>  <span class="hashtag">#써니보틀</span>  <span class="hashtag">#물병</span>'+
	};
	
	
	$.ajax({
		url: "./feed/lists/1",
		success:function(resData) {
			if(resData.isSuccess) {
				$(".likeBtn").off("click");
				$.each(resData.feedList, function(i, v) {
					var temp =
						'<section>' +
							'<div class="nav">' +
								'<div class="userImg">' +
//									 '<img src="'+ v.imgurl +'" />' +
									 '<span class="userId">' +
									 	v.userId +
									 '</span>'+
								'</div>'+
								'<div class="updateTime">'+
									'1시간'+ 
								'</div>'+
							'</div>'+
							'<div class="img">'+
//								'<img src="'+ v.imgurl +'" />'+
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
									'<div>'+
										'<input class="commentInput" type="text" placeholder="댓글달기..." />'+
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
			} else {
				alert("알 수 없는 오류로 실패하였습니다.");
			}
		},
		error: function() {
			alert("알 수 없는 오류로 실패하였습니다.");
		}
	});
	
	
});