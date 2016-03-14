package com.skplanet.project2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skplanet.project2.model.CommentDTO;
import com.skplanet.project2.model.CommentResultDTO;
import com.skplanet.project2.model.FeedResultDTO;
import com.skplanet.project2.model.Result;
import com.skplanet.project2.service.FeedService;

@Controller
@RequestMapping(value="/feed")
public class FeedController {
	
	@Autowired
	FeedService feedService;
	
	
	@RequestMapping(value="/lists/{pageNo}",method=RequestMethod.GET)
	public @ResponseBody FeedResultDTO getFeedList(
			@PathVariable(value = "pageNo") int pageNo) {
		
		FeedResultDTO result=new FeedResultDTO();
		result.setIsSuccess(1);
		result.setMsg("success");
		try{
			result.setFeedList(feedService.getFeedlist(pageNo));
		}catch(Exception e){
		
			result.setIsSuccess(0);
			result.setMsg("fail, "+e.getMessage());
			return result;
		}
		return result;
	}
	
	
	@RequestMapping(value = "/comment", method = RequestMethod.POST,consumes="application/json")
	public @ResponseBody Result insertComment(HttpServletRequest request,@RequestBody CommentDTO commentDTO) {
		
		
		HttpSession session = request.getSession();
		commentDTO.setUserId((String)session.getAttribute("id"));
		int insertResult=feedService.insertComment(commentDTO);

		
		Result result = new Result();
		
		if(insertResult<0){
			result.setIsSuccess(0);
			result.setMsg("insert fail");
		}else{
			result.setIsSuccess(1);
			result.setMsg("success");

		}

				return result;
	}
	
	@RequestMapping(value = "/{feed_id}/comment/{page_no}", method = RequestMethod.GET)
	public @ResponseBody CommentResultDTO getCommentList(@PathVariable(value = "feed_id") int feedId,@PathVariable(value = "page_no") int pageNo) {
		

		CommentResultDTO result=new CommentResultDTO();
		result.setIsSuccess(1);
		result.setMsg("success");
		try{
			result.setCommentList(feedService.getCommentList(feedId,pageNo));
		}catch(Exception e){
		
			result.setIsSuccess(0);
			result.setMsg("fail, "+e.getMessage());
			return result;
		}
		return result;
	}
	
	@RequestMapping(value = "/comment/{comment_id}", method = RequestMethod.PUT)
	public @ResponseBody Result updateComment(@PathVariable(value = "comment_id") int commentId,@RequestBody CommentDTO commentDTO) {
		
	commentDTO.setCommentId(commentId);
	int insertResult=feedService.updateComment(commentDTO);

		
		Result result = new Result();
		
		if(insertResult<0){
			result.setIsSuccess(0);
			result.setMsg("update fail");
		}else{
			result.setIsSuccess(1);
			result.setMsg("success");

		}
		return result;
	}
	
	
	@RequestMapping(value = "/comment/{comment_id}", method = RequestMethod.DELETE)
	public @ResponseBody Result deleteComment(@PathVariable(value = "comment_id") int commentId) {
		

	int insertResult=feedService.deleteComment(commentId);

		
		Result result = new Result();
		
		if(insertResult<0){
			result.setIsSuccess(0);
			result.setMsg("delete fail");
		}else{
			result.setIsSuccess(1);
			result.setMsg("success");

		}
		return result;
	}

}