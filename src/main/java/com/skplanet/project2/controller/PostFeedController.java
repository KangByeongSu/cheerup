package com.skplanet.project2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.skplanet.project2.model.PostFeedDTO;
import com.skplanet.project2.model.Result;
import com.skplanet.project2.service.PostFeedServiceImpl;


@Controller
public class PostFeedController {
	
	@Autowired
	PostFeedServiceImpl feedservice;
	
	@Autowired
	Result jsonResult;
	
	@RequestMapping(value="/feed/add",method=RequestMethod.POST)
	public @ResponseBody Result addFeedPost(@RequestParam(value="imageFile") MultipartFile file,PostFeedDTO feed){
		
		
		System.out.println("file :" +file);
		System.out.println("feed :" +feed.getComment());
		feed.setImgUrl("url");
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
