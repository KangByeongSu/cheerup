package com.skplanet.project2.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.skplanet.project2.model.ImageFile;
import com.skplanet.project2.model.PostFeedDTO;
import com.skplanet.project2.model.Result;
import com.skplanet.project2.service.ImageUploadServiceImpl;
import com.skplanet.project2.service.PostFeedServiceImpl;

@Controller
public class PostFeedController {

	@Autowired
	PostFeedServiceImpl feedservice;

	@Autowired
	Result jsonResult;

	@Autowired
	ImageUploadServiceImpl imageService;

	@RequestMapping(value = "/feed/add", method = RequestMethod.GET)
	public String writeContent(Locale locale, Model model) {

		return "writeContent";
	}

	@RequestMapping(value = "/feed/add", method = RequestMethod.POST)
	public String addFeedPost(@RequestParam(value = "imageFile") MultipartFile file, PostFeedDTO feed, Model model) {
		System.out.println("Post controller In");
		if (file.getSize() == 0) {
		} else {
			ImageFile fileInfo = imageService.save(file);

			if (feed.getComment() != null) {
				// System.out.println("feed :" + feed.getComment());
			} else {
				feed.setComment(" ");
			}
			feed.setUserId("test1");
			feed.setImgUrl("url");
			int result = feedservice.postFeed(feed);
		}
		return "redirect:/view";
	}
}
