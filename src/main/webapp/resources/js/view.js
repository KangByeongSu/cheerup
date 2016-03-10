$(document).ready(function() {	
	var feedLoad = function() {
			
	};
	$.ajax({
		url: "./feed/lists/1",
		success:function(resData) {
			console.log(resData.isSuccess);
			if(resData.isSuccess) {
				$.each(resData.feedList, function(i, v) {
					console.log("--",v.message);
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
										v.message +
										'<span class="hashtag">#스타벅스</span> <span class="hashtag">#STARBUCKS</span>  <span class="hashtag">#텀블러</span>  <span class="hashtag">#써니보틀</span>  <span class="hashtag">#물병</span>'+ 
									'</div>'+
									'<div class="comment">'+
										'<div class="commentList">'+
											'<p><span class="userId">akdung21</span> 우왕~~~😍😍</p>'+
											'<p><span class="userId">joao.marcos.mt</span> 😍😘😘</p>'+
										'</div>'+
									'</div>'+
								'</div>'+
								'<div class="commentAdd">'+
									'<div class="likeBtn">'+
										'<img src="./resources/img/like_.png" />'+
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
			} else {
				alert("알 수 없는 오류로 실패하였습니다.");
			}
		},
		error: function() {
			alert("알 수 없는 오류로 실패하였습니다.");
		}
	});
});