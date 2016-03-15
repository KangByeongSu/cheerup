package com.skplanet.project2.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skplanet.project2.model.ImageGridDTO;
import com.skplanet.project2.model.PostFeedDTO;
import com.skplanet.project2.model.Result;
import com.skplanet.project2.model.UserImageGridDTO;
import com.skplanet.project2.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserPageController {

	private static final Logger logger = LoggerFactory.getLogger(UserPageController.class);

	@Autowired
	UserService userService;

	@Autowired
	Result jsonResult;

	/**
	 * @param userId
	 * @return json type { contentId : id, imgUrl : url } 
	 * @method select upload image of one user
	 */
	@RequestMapping(value = "/user/test", method = RequestMethod.GET)
	public @ResponseBody UserImageGridDTO imageGridURL(HttpSession session) {
		logger.info("enter the imageGridUrl method");
		
		UserImageGridDTO resultJson = new UserImageGridDTO();
		
		String userId = "test1"; //dummy data
		
		List<ImageGridDTO> resultData = userService.userImageGridURL(userId);

/*		
		
		for (int i = 0; i < resultData.size(); i++) {
			System.out.println(resultData.get(i).getContentId());
			System.out.println(resultData.get(i).getImgUrl());
			System.out.println(resultData.get(i).getLikeCount());
			System.out.println(resultData.get(i).getCommentCount());
		}
*/
		resultJson.setIsSuccess(1);
		resultJson.setMsg("success");
		resultJson.setImageGridDTO(resultData);
		
		return resultJson;
	}
	/*
	 * @RequestMapping(value="/user/{userId}",method=RequestMethod.POST)
	 * public @ResponseBody Result Login(HttpSession session,
	 * 
	 * @PathVariable(value="userId") String userId) {
	 * 
	 * 
	 * String userId="test1"; List<PostFeedDTO> user =
	 * userService.userImageGridURL(userId);
	 * 
	 * 
	 * 
	 * return null; }
	 */

}
