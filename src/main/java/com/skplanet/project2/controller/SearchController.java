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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.skplanet.project2.model.ImageGridDTO;
import com.skplanet.project2.model.SearchDTO;
import com.skplanet.project2.model.SearchResultDTO;
import com.skplanet.project2.model.UserImageGridDTO;
import com.skplanet.project2.service.SearchService;

@Controller
public class SearchController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserPageController.class);
	
	@Autowired
	SearchService searchservice;
	
	@Autowired
	SearchResultDTO jsonResult;

	/*@RequestMapping(value = "/search/{type}/{hashtag}", method = RequestMethod.GET)
	public @ResponseBody SearchResultDTO getSearchList(@PathVariable(value = "type") String type,@PathVariable(value = "hashtag") String hashtag,@RequestParam(value = "pageNum", defaultValue="0") int pageNum){
			List<SearchDTO> list = searchservice.searchInterestFeed(hashtag, pageNum,type);
			if(list.isEmpty()){
				jsonResult.setIsSuccess(0);
				jsonResult.setMsg("null");
				jsonResult.setSearchList(null);
			}else{
				jsonResult.setIsSuccess(1);
				jsonResult.setMsg("Success");
				jsonResult.setSearchList(list);
			}
		return jsonResult;
	}*/
	
	
	@RequestMapping(value = "/search/{type}", method = RequestMethod.GET)
	public ModelAndView getSearchList(@PathVariable(value="type") String type, @RequestParam(value = "hashtag") String hashtag,@RequestParam(value = "pageNum", defaultValue="0") int pageNum) {

		ModelAndView model = new ModelAndView("search");
		List<SearchDTO> list = searchservice.searchInterestFeed(hashtag, pageNum,type);
		if(list.isEmpty()){
			jsonResult.setIsSuccess(0);
			jsonResult.setMsg("null");
			jsonResult.setSearchList(null);
		}else{
			jsonResult.setIsSuccess(1);
			jsonResult.setMsg("Success");
			jsonResult.setSearchList(list);
		}
		logger.info("{}", list);
		
		model.addObject("lists", list);
		return model;
	}

}
