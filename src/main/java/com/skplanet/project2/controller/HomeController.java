package com.skplanet.project2.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		HttpSession session = request.getSession();
		String sessionId = (String)session.getAttribute("id");
		
		
		if (sessionId == null) {
			return "redirect:/login";
		} else {
			return "redirect:/view";
		}
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView view(HttpServletRequest request, HttpSession session, Locale locale, Model model) {

		ModelAndView mav = new ModelAndView();
		mav.addObject("userId", session.getAttribute("id"));
		mav.addObject("nickname", session.getAttribute("nickname"));
		mav.setViewName("view");

		return mav;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {

		return "login";
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(Locale locale, Model model) {

		return "join";
	}

	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String mypage(Locale locale, Model model) {

		return "mypage";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public ModelAndView tmpUserUpdate(HttpServletRequest request, HttpSession session, Locale locale, Model model) {

		ModelAndView mav = new ModelAndView();
		mav.addObject("userId", session.getAttribute("id"));
		mav.addObject("nickname", session.getAttribute("nickname"));
		mav.setViewName("modify");

		return mav;
	}

}
