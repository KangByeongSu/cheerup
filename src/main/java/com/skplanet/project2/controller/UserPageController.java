package com.skplanet.project2.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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


	/**
	 * @param userId
	 * @return json type { contentId : id, imgUrl : url } 
	 * @method select upload image of one user
	 */
	@RequestMapping(value = "/test/{userId}", method = RequestMethod.GET)
	public ModelAndView imageGridURL(HttpServletRequest request, @PathVariable(value="userId") String userId) {
		HttpSession session = request.getSession();
		ModelAndView model = new ModelAndView("mypage");
		
		Result jsonResult = new Result();
		
		
		
		UserImageGridDTO resultJson = new UserImageGridDTO();
		
//		String userId = "test1"; //dummy data
		
		List<ImageGridDTO> resultData = userService.userImageGridURL(userId);

/*		 test case
		
		for (int i = 0; i < resultData.size(); i++) {
			System.out.println(resultData.get(i).getContentId());
			System.out.println(resultData.get(i).getImgUrl());
			System.out.println(resultData.get(i).getLikeCount());
			System.out.println(resultData.get(i).getCommentCount());
		}
*/
		//add if success ??
//		resultJson.setIsSuccess(1);
//		resultJson.setMsg("success");
//		resultJson.setImageGridDTO(resultData);
		
		model.addObject("lists", resultData);
		
		model.addObject("pageUserId", userId);
		model.addObject("sessionId", session.getAttribute("id"));
		
		if(userId.equals((String)session.getAttribute("id"))) {
			model.addObject("mypage", true);
		} else {
			model.addObject("mypage", false);
		}

		
		return model;
	}
	
	/**
	 * @param contentId
	 * @return json type PostFeedDTO 
	 * @method select modal data
	 */
	@RequestMapping(value = "/modal/{contentId}", method = RequestMethod.GET)
	public @ResponseBody PostFeedDTO extendModal(HttpServletRequest request, @PathVariable(value="contentId") int contentId) {
		logger.info("enter the imageGridUrl method");
		
		
//		int contentId = 1; //dummy data
		
		PostFeedDTO resultData = userService.extendModal(contentId);
		
		
//		logger.info("", resultData);
		
		return resultData;
	}

}
