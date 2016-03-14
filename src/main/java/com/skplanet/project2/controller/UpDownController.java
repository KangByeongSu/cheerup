package com.skplanet.project2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skplanet.project2.model.LikeDTO;
import com.skplanet.project2.model.LikeResultDTO;
import com.skplanet.project2.model.Result;
import com.skplanet.project2.service.UpDownServiceImpl;

@Controller
public class UpDownController {
	private static final Logger logger = LoggerFactory.getLogger(UpDownController.class);
	
	@Autowired
	UpDownServiceImpl upDownService;

	@RequestMapping(value = "/feed/like", method = RequestMethod.POST)
	/* @RequestMapping(value = "/feed/like", method = RequestMethod.POST) */
	public @ResponseBody Result callLike(@RequestBody LikeDTO like, Model model) {
		logger.info("Enter in the UpDownController. ");
		
		logger.info("contentId:{}, up:{}", like.getContentId(), like.getUp());
		
		LikeResultDTO resultJson = new LikeResultDTO();
		int result = 0;
		like.setUserId("user");  //session
		like.setContentId(1);  
		like.setDown(0);      
		like.setUp(1);         

		try {
			// Select Like Table
			LikeDTO find_user = upDownService.findUser(like);
			if (find_user == null) {
				// If find_user is Null, insert new data.
				result = upDownService.insertLikeStatus(like);
				if (result == 1) {
					logger.info("Success Insert Count is {}" , result);
				}
			} else {
				if (find_user.getUp() == like.getUp() || find_user.getDown() == like.getDown()) {
					// If find_user is not null and user up number is 1, delete
					// user.
					result = upDownService.deleteLikeStatus(like);
					if (result == 1) {
						logger.info("Success Delete Count is {}" , result);
					}
				} else {
					// If find_user is not null and user down number is 1,
					// update
					// user data. l_down=0,l_up=1.
					result = upDownService.updateLikeStatus(like);
					if (result == 1) {
						logger.info("Success Update Count is {}" , result);
					}
				}
			}
		} catch (Exception e) {
			logger.error("Error Class is UpDownController");
			result = 0;
			e.printStackTrace();
		}

		if (result == 1) {
			resultJson.setIsSuccess(1);
			resultJson.setMsg("success");
		} else {
			resultJson.setIsSuccess(0);
			resultJson.setMsg("fail");
		}
		return resultJson;
	}
}
