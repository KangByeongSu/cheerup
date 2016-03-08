package com.skplanet.project2.feed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skplanet.project2.feed.service.FeedService;

@Controller
@RequestMapping("/feed")
public class FeedController {
	
	@Autowired
	FeedService feedservice;
	
	
	@RequestMapping(value="/lists")
	public String getFeedlists(){
		
		System.out.println("dd");
		feedservice.getFeedlists();
		return "view";
	}
	
	@RequestMapping(value="/add")
	public String addFeedPost(){
	
		return "view";
	}
	
	

}
