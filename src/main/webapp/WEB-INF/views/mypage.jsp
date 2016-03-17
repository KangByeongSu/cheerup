<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<meta id="viewport" name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, minimum-scale=1, maximum-scale=1">
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" href="<c:url value='/resources/css/mypage.css' />" type="text/css" />
</head>
<body>
	<div id="wrap">
		<nav class="navbar">
			<div class="content">
				<div class="logo">
					<a href="/view"> <img src="<c:url value='/resources/img/instagram.png' />" /></a>
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
						<span class="userId__"> ${pageUserId}</span>
						<c:if test="${mypage}">
							<a href="/modify">
								<div class="modifyBtn">
									프로필 편집 
								</div>
							</a>
							<a href="/feed/add">
								<div class="modifyBtn">
									글쓰기  
								</div>
							</a>
							
						</c:if>
					</div>
					<!-- <div class="userIntro">
						DongukKim
						<span class="hashtag">#SW_Developer</span> 
						<span class="hashtag">#SKplanet</span>
					</div> -->
					<div class="userHistory">
						<div>
							게시물 <span class="num">${fn:length(lists)}</span>개
						</div>
						<div>
							<!-- 팔로워 <span class="num">236</span>명 -->
						</div>
						<div>
							<!-- 팔로우 <span class="num">339</span>명 -->
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
						
						<img src="${item.imgUrl}">
						
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
							<span class="likeNum">좋아요 <span class="likeNumData">19</span>개</span>
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
						<div feedId="" class="likeBtn">
							<img src="<c:url value='/resources/img/like_.png' />" />
						</div>
						<div>
							<input feedId="" class="commentInput" type="text" placeholder="댓글달기..." />
						</div>
					</div>
				</div>
			</div>
		
		</div>
	</div>
	<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
	<script src="<c:url value='/resources/js/jquery.timeago.js' />"></script>
	<script src="<c:url value='/resources/js/jquery.timeago.ko.js' />"></script>
	<script >
	
		var makeHashtag = function(message) {
			var tmpMessage = "";
			$.each(message.split(" "), function(i, v) {
				
				if(v.indexOf("#") == 0) {
					tmpMessage += '<span class="hashtag"><a href="/search/interest?hashtag='+v.substring(1,v.length)+'">'+v+'</a></span> '
				} else {
					tmpMessage += v+' ';
				} 
			});
			console.log("tmpMessage : ", tmpMessage);
			return tmpMessage;
	
		};
		
		var frontEndCommentAdd = function(){
			
			$('.commentList').append("<div class='commentItem'><span class='userId'> <a href='/user/test/${sessionId}'>${sessionId}</a></span>"+makeHashtag($(".commentInput").val())+"</p>");
			$(".commentInput").val("");
		}
		
		$(".commentInput").keydown(function(key) {
			 if (key.keyCode == 13){
				 var commentData = {		
						  "feedId" : $(this).attr("feedId"),
						  "message" : $(this).val()
					};
				 
				 
				 $.ajax({
						url : "../../feed/comment",
						type : 'POST', // define the type of HTTP verb
										// we want to use (POST for our
										// form)
						data : JSON.stringify(commentData), // our data
															// object
						contentType : "application/json",
						charset : "utf-8",
						success : function(resData) {
							frontEndCommentAdd();
						},

						error : function() {
							
							alert("알 수 없는 오류로 실패하였습니다.");
						}
					});
			 }
		});
		
		$(".likeBtn").click(function(e) {
			var itemId = $(this).attr("itemId");
			var self = this;
			
			$.ajax({
		    	type:'post',
		    	contentType: "application/json",
		    	url: "../../feed/like", 
		    	data : JSON.stringify({
		    		contentId: $(this).attr("feedId"),
		    		up:1,
		    		down:0
		    	}),
		    	dataType: 'json',
		    	success: function(result){
		    		if(result.isSuccess == 1) {
		    			var likeNum = parseInt($(".likeNumData").html());
		    			if($(".likeBtn").children().attr("src") === "/resources/img/like.png" ) {
			    			$(".likeBtn").children().attr("src","/resources/img/like_.png");
			    			$(".likeNumData").html(likeNum-1);
			    		} else {
 			    			$(".likeBtn").children().attr("src","/resources/img/like.png");
 			    			$(".likeNumData").html(likeNum+1);
			    		}
		    		} else {
		    			alert("fail");
		    		}
		    		
		    	}
		    });
		});
		
		$(".imgItem").click(function() {
			var itemId = $(this).attr("itemId");
			
			$.ajax({
		    	type:'get',
		    	contentType: "application/json",
		    	url: "../modal/"+itemId, 
		    	success: function(result){
		    		
		    		$("#modal .imgSection img").attr("src",result.detailPost.imgUrl);
		    		$("#modal .contentBody").html(makeHashtag(result.detailPost.comment));
		    		$("#modal .date").html(jQuery.timeago(result.detailPost.time));
		    		$("#modal .likeBtn").attr("feedId", itemId );
		    		$("#modal .likeNumData").html(result.detailPost.likeCount);
		    		
		    		if(result.detailPost.likeClicked == 0) {
		    			$(".likeBtn").children().attr("src","/resources/img/like_.png");
		    		} else {
		    			$(".likeBtn").children().attr("src","/resources/img/like.png");
		    		}
		    		
		    		$(".commentInput").attr("feedId", itemId );
		    		$('.commentList').html("");
		    		
		    		
		    		$.each(result.commentList, function(i, v) {
		    			$('.commentList').append("<div class='commentItem'><span class='userId'> <a href='/user/test/"+v.userId+"'>"+v.userId+"</a></span>"+makeHashtag(v.message)+"</p>");
		    		});
		    		
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
