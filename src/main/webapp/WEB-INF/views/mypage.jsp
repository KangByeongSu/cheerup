<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% request.setCharacterEncoding("utf8");%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<meta id="viewport" name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, minimum-scale=1, maximum-scale=1">
	<link rel="stylesheet" href="<c:url value='/resources/css/mypage.css' />" type="text/css" />
</head>
<body>
	<div id="wrap">
		<nav class="navbar">
			<div class="content">
				<div class="logo">
					<img src="<c:url value='/resources/img/instagram.png' />" />
				</div>
				<div class="personInfo userId">
					로그아웃 
				</div>
			</div>
		</nav>
		
		<div class="mainContainer">
			<div class="navbar">
				<div class="userImg">
					<img src="https://igcdn-photos-h-a.akamaihd.net/hphotos-ak-xfp1/t51.2885-19/924632_1015723898456023_1603104456_a.jpg" />
				</div>
				<div class="userInfo">
					<div class="userId_">
						<span class="userId__"> akdung21</span>
						<c:if test="${mypage}">
							<div class="modifyBtn">
								프로필 편집 
							</div>
						</c:if>
					</div>
					<div class="userIntro">
						DongukKim
						<span class="hashtag">#SW_Developer</span> 
						<span class="hashtag">#SKplanet</span>
					</div>
					<div class="userHistory">
						<div>
							게시물 <span class="num">37</span>개
						</div>
						<div>
							팔로워 <span class="num">236</span>명
						</div>
						<div>
							팔로우 <span class="num">339</span>명
						</div>
					</div>
				</div>
				
			</div>
			<div class="img_list">
				<c:forEach var="item" items="${lists}">
					<div id="imgItem_${item.contentId}" itemId="${item.contentId}" class="imgItem">
						<div class="hover">
							<span class="hoverInfo">
								좋아요 ${item.likeCount}&nbsp;&nbsp;댓글 ${item.commentCount}
							</span>
						</div>
						<img src="https://scontent.cdninstagram.com/t51.2885-15/s640x640/sh0.08/e35/12748407_1123003344378522_2087727875_n.jpg?ig_cache_key=MTE4NzM5NjU3ODI5MTM4NzI0Nw%3D%3D.2">
						
					</div>
				</c:forEach>
			</div>
		</div>
		<div id="modal">
			<div class="backdrop"></div>
			<div class="content">
				<div class="imgSection">
					<img src="https://scontent.cdninstagram.com/t51.2885-15/s640x640/sh0.08/e35/12748407_1123003344378522_2087727875_n.jpg?ig_cache_key=MTE4NzM5NjU3ODI5MTM4NzI0Nw%3D%3D.2">
				</div>
				<div class="contentSection">
					<div class="navSection">
						<div class="userImg">
							<img src="https://igcdn-photos-h-a.akamaihd.net/hphotos-ak-xfp1/t51.2885-19/924632_1015723898456023_1603104456_a.jpg" />
						</div>
						<div class="userId">
							akdung21
						</div>
					</div>
					
					<div class="commentListSection">
						<div class="status">
							<span class="likeNum">좋아요 19개</span>
							<span class="date">3주</span>
						</div>
						<div class="contentBody">
							나란말싸미듕국에다라 
							<span class="hashtag">#졸업장</span>  
							<span class="hashtag">#4000만원짜리</span>
						</div>
						<div class="commentList">
						<div class="commentItem">
								<span class="userId">
									akdung21	
								</span>
								나란말싸미듕국에다라
							</div>
							
							<div class="commentItem">
								<span class="userId">
									akdung21	
								</span>
								나란말싸미듕국에다라
							</div>
							
							
						</div>
					</div>
					
					<div class="commentSection">
						<div class="likeBtn">
							<img src="<c:url value='/resources/img/like_.png' />" />
						</div>
						<div>
							<input class="commentInput" type="text" placeholder="댓글달기..." />
						</div>
					</div>
				</div>
			</div>
		
		</div>
	</div>
	<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
	<script >
	
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
	
		};
		$(".imgItem").click(function() {
			

			$.ajax({
		    	type:'get',
		    	contentType: "application/json",
		    	url: "../modal/"+$(this).attr("itemId"), 
		    	success: function(result){
		    		
		    		
		    		
		    		$("#modal .imgSection img").attr("src",result.imgUrl);
		    		$("#modal .contentBody").html(makeHashtag(result.comment));
		    		
		    		
		    		
		    		$("#modal").css('top', $(document).scrollTop()+'px');
	    			$("#modal").css('display', 'block');
	     			$("body").css("overflow-y","hidden");
	    			$("#modal .backdrop").click(function(e) {
	    				e.stopPropagation();
	    				$("#modal").css('display', 'none');
	    				$(document).off("keypress");
	    				$("#modal .backdrop").off("click");
	    				$("body").css("overflow-y","auto");	
	    			});
	    			$(document).keyup(function(e) {
	    				e.stopPropagation();
	    				if(e.keyCode == 27) {
	    					$("#modal").css('display', 'none');
	    					$(document).off("keypress");	
	    					$("#modal .backdrop").off("click");
	    					$("body").css("overflow-y","auto");
	    				}
	    			});	
		    		
		    	}
		    });
			
		});
	</script>
<%-- 	<script src="<c:url value='/resources/js/view.js' />"></script> --%>
</body>
</html>
