package com.skplanet.project2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skplanet.project2.model.FeedResultDTO;
import com.skplanet.project2.service.FeedService;

@Controller
//@RequestMapping(value="/feed")
public class FeedController {
	
	@Autowired
	FeedService feedService;
	
//	
//	@RequestMapping(value="/lists",method=RequestMethod.GET)
//	public @ResponseBody FeedResultDTO getFeedLists(@RequestParam int pageNo){
//
//		
//		FeedResultDTO result=new FeedResultDTO();
//		result.setIsSuccess(1);
//		result.setMsg("success");
//		result.setFeedList(feedService.getFeedlists(pageNo));
//		return result;
//	}
	
	
	

}
