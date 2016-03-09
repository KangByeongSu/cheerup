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
	public String addFeedPost(@RequestParam(value="imageFile") MultipartFile file,PostFeedDTO feed){
		
		
		//1. 파일을 save한다.  -내가한다.
		
		//2. 파일 저장 return을 url로 받아온다.  -내가한다.
		
		//3. db저장 소스에 url넣어서 보낸다. - 내가한다. return 컨텐트 아이디를 받아온다. 
		
		//4. 해시태그 자른다.  - 내가한다.
		
		//5. 자른 해시태그 해시태그 테이블에 insert한다.(for문 돌려야하나?) - 
		
		
		
		System.out.println("file :" +file);
		System.out.println("feed :" +feed.getComment());
		feed.setUserId("test1");
		feed.setImgUrl("url");
		int result = feedservice.postFeed(feed);
		
		jsonResult.setIsSuccess(result);
		if(result == 1){
			jsonResult.setMsg("Success");	
		}
		else{
			jsonResult.setMsg("fail");
		}
		
		return "view";
	}
}
