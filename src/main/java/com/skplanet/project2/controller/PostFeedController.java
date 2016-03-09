package com.skplanet.project2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skplanet.project2.model.PostFeedDTO;
import com.skplanet.project2.model.Result;
import com.skplanet.project2.service.PostFeedServiceImpl;


@Controller
@RequestMapping("/feed")
public class PostFeedController {
	
	@Autowired
	PostFeedServiceImpl feedservice;
	
	@Autowired
	Result jsonResult;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public @ResponseBody Result addFeedPost(PostFeedDTO feed){
		
		int result = feedservice.postFeed(feed);
		
		jsonResult.setIsSuccess(result);
		if(result == 1){
			jsonResult.setMsg("Success");	
		}
		else{
			jsonResult.setMsg("fail");
		}
		
		return jsonResult;
	}
	
	

}
