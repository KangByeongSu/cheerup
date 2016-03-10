package com.skplanet.project2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skplanet.project2.model.FeedResultDTO;
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
	
	
	

}
