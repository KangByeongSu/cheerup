package com.skplanet.project2.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.skplanet.project2.model.DetailModalDTO;
import com.skplanet.project2.model.ImageGridDTO;
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
		
		List<ImageGridDTO> resultData = userService.userImageGridURL(userId);

		
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
	public @ResponseBody DetailModalDTO extendModal(HttpServletRequest request, @PathVariable(value="contentId") int contentId) {
		logger.info("enter the extendModal method");
		
		
		
		
		DetailModalDTO resultData = userService.extendModal(contentId, (String)request.getSession().getAttribute("id"));



		if(resultData == null)
		{
			logger.error("Extend Modal Null Pointer Exception - Databases Error");
			DetailModalDTO errorData = new DetailModalDTO();
			errorData.setIsSuccess(0);
			errorData.setMsg("Database I/O Error");
			return errorData;
		}
		else
		{
			logger.error("Success Extend Modal Select");
			resultData.setIsSuccess(1);
			resultData.setMsg("Detail Post is : "+resultData.getDetailPost() + ", Comment Size : "+resultData.getCommentList().size());
		}

		return resultData;
	}

}
