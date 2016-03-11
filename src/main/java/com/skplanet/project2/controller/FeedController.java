package com.skplanet.project2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skplanet.project2.model.CommentDTO;
import com.skplanet.project2.model.FeedResultDTO;
import com.skplanet.project2.model.Result;
import com.skplanet.project2.service.FeedService;

@Controller
@RequestMapping(value="/feed")
public class FeedController {
	
	@Autowired
	FeedService feedService;
	
	
	@RequestMapping(value="/lists/{pageNo}",method=RequestMethod.GET)
	public @ResponseBody FeedResultDTO getFeedLists(
			@PathVariable(value = "pageNo") int pageNo) {
		
		FeedResultDTO result=new FeedResultDTO();
		result.setIsSuccess(1);
		result.setMsg("success");
		try{
			result.setFeedList(feedService.getFeedlists(pageNo));
		}catch(Exception e){
		
			result.setIsSuccess(0);
			result.setMsg("fail, "+e.getMessage());
			return result;
		}
		return result;
	}
	
	
	@RequestMapping(value = "comment", method = RequestMethod.POST)
	public @ResponseBody Result insertComment(@RequestBody CommentDTO commentDTO) {
		
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
	

}