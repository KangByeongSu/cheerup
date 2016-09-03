package com.skplanet.project2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class HelloController {
	

	@RequestMapping(value="/",method=RequestMethod.GET)
	public String getFeedList() {

		return "hello";
	}
}