package com.skplanet.project2.feed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skplanet.project2.feed.model.FeedResultDTO;
import com.skplanet.project2.feed.service.FeedService;

@Controller
public class FeedController {
	
	@Autowired
	FeedService feedService;
	
	
	@RequestMapping(value="/lists")
	public @ResponseBody FeedResultDTO getFeedLists(@RequestParam int pageNo){
	
		FeedResultDTO result=new FeedResultDTO();
		result.setIsSuccess(1);
		result.setMsg("success");
		result.setFeedList(feedService.getFeedlists(pageNo));
		return result;
	}
	
	@RequestMapping(value="/add")
	public String addFeedPost(){
		return "view";
	}
	
	

}
