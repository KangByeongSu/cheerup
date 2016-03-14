package com.skplanet.project2.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skplanet.project2.model.Result;
import com.skplanet.project2.model.UserDTO;
import com.skplanet.project2.service.SignUpService;


@Controller
public class SignupController {
	
	@Autowired
	SignUpService signupService;
	

	@Autowired
	Result jsonResult;
	
	String [] checkidText = {"멋진 아이디네요!","이미 사용중이거나 탈퇴한 아이디입니다."};
	
	
	@RequestMapping(value = "/user/check", method = RequestMethod.GET)
	public @ResponseBody Result checkUser(Locale locale, Model model,@RequestParam(value = "userId") String userId) {
		
		int result = signupService.checkUserId(userId);
		jsonResult.setIsSuccess(result);
		jsonResult.setMsg(checkidText[result]);
		return jsonResult;
	}
	
	@RequestMapping(value = "/user/add", method = RequestMethod.GET)
	public String join(Locale locale, Model model) {
		return "join";
	}
	
	
	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public String addjoin(Locale locale, Model model,UserDTO user) {
		
		int result = signupService.signupUser(user);
		
		return "redirect:/feed/lists/1";
	}

}
