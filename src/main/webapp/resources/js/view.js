$(document).ready(function() {	
	var feedLoad = function() {
			
	};
	$.ajax({
		url: "./feed/lists/1",
		success:function(resData) {
			if(reaData.isSuccess) {
				$.each(reaData.feedList, function(i, v) {
					
					
					
				});
				
			} else {
				
				var temp =
					'<section>' +
						'<div class="nav">' +
							'<div class="userImg">' +
								 '<img src="https://igcdn-photos-g-a.akamaihd.net/hphotos-ak-xft1/t51.2885-19/s150x150/12552423_441484902713862_1832731177_a.jpg" />' +
								 '<span class="userId">' +
								 	'akdug21'+
								 '</span>'+
							'</div>'+
							'<div class="updateTime">'+
								'1시간'+ 
							'</div>'+
						'</div>'+
						'<div class="img">'+
							'<img src="<c:url value=/resources/img/testimg.png />" />'+
						'</div>'+
						'<div class="mainData">'+
							'<div class="likeCount">'+
								'좋아요 30'+
							'</div>'+
							'<div class="content">'+
								'<div class="text">'+
									'<span class="userId">akdung21</span>'+
									'아메리카노 사러갔다가 물병 필요해서<br>'+
									'첨으로 스벅에서 사봤당ㅋㅋ<br>'+
									'비싼데 이쁘긴하네~ 물 많이 마시자!!💦 <br>'+
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
									'<img src="<c:url value=/resources/img/like_.png />" />'+
								'</div>'+
								'<div>'+
									'<input class="commentInput" type="text" placeholder="댓글달기..." />'+
								'</div>'+
								'<div class="more">'+
									'<img src="<c:url value=/resources/img/moreBtn.png />" />'+
								'</div>'+
							'</div>'+
						'</div>'+
					'</section>';
				alert("알 수 없는 오류로 실패하였습니다.")
				
				$('.moreFeed').before(temp);
			}
		},
		error: function() {
			var temp =
				'<section>' +
					'<div class="nav">' +
						'<div class="userImg">' +
							 '<img src="https://igcdn-photos-g-a.akamaihd.net/hphotos-ak-xft1/t51.2885-19/s150x150/12552423_441484902713862_1832731177_a.jpg" />' +
							 '<span class="userId">' +
							 	'akdug21'+
							 '</span>'+
						'</div>'+
						'<div class="updateTime">'+
							'1시간'+ 
						'</div>'+
					'</div>'+
					'<div class="img">'+
						'<img src="./resources/img/testimg.png" />'+
					'</div>'+
					'<div class="mainData">'+
						'<div class="likeCount">'+
							'좋아요 30'+
						'</div>'+
						'<div class="content">'+
							'<div class="text">'+
								'<span class="userId">akdung21</span>'+
								'아메리카노 사러갔다가 물병 필요해서<br>'+
								'첨으로 스벅에서 사봤당ㅋㅋ<br>'+
								'비싼데 이쁘긴하네~ 물 많이 마시자!!💦 <br>'+
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
			
			alert("알 수 없는 오류로 실패하였습니다.")
		}
	});
});