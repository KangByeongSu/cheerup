package com.skplanet.project2.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.skplanet.project2.model.ImageFile;
import com.skplanet.project2.model.PostFeedDTO;
import com.skplanet.project2.service.ImageUploadServiceImpl;
import com.skplanet.project2.service.PostFeedServiceImpl;

@Controller
public class PostFeedController {

	private static final Logger logger = LoggerFactory.getLogger(PostFeedController.class);
	@Autowired
	PostFeedServiceImpl feedservice;

	@Autowired
	ImageUploadServiceImpl imageService;

	@RequestMapping(value = "/feed/add", method = RequestMethod.GET)
	public String writeContent(Locale locale, Model model) {
		logger.info("Enter the /feed/add GET return writeContent");

		return "writeContent";
	}

	@RequestMapping(value = "/feed/add", method = RequestMethod.POST)
	public String addFeedPost(@RequestParam(value = "imageFile") MultipartFile file, PostFeedDTO feed, Model model) {
		logger.info("Enter the /feed/add POST return redirect:/view");
		int result;
		try {
			if (file.getSize() == 0) {

			} else {
				ImageFile fileInfo = imageService.save(file);

				if (feed.getComment() != null) {
				} else {
					feed.setComment(" ");
				}
				feed.setUserId("test1");
				feed.setImgUrl("url");
				result = feedservice.postFeed(feed);
			}
		} catch (Exception e) {
			logger.error("Error /feed/add POST");
		}
		return "redirect:/view";
	}
}
