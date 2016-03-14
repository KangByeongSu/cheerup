package com.skplanet.project2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.skplanet.project2.HomeController;
import com.skplanet.project2.model.Result;
import com.skplanet.project2.model.UserDTO;
import com.skplanet.project2.service.UserService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.impl.crypto.MacProvider;
import java.security.Key;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



@Controller
@RequestMapping(value="/user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	UserService userService;

	@Autowired
	Result jsonResult;

	
	Key key = null;
	
	UserController() {
		key = MacProvider.generateKey();
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public @ResponseBody Result Login(HttpSession session, 
			@RequestBody UserDTO inputUserDTO) {

		
		UserDTO user = userService.loginProc(inputUserDTO);
		
		if(user.getCount() == 1) {
//			token = Jwts.builder().setId(inputUserDTO.getU_id()).setSubject(user.getU_nickname()).signWith(SignatureAlgorithm.HS512, key).compact();
			jsonResult.setIsSuccess(1);
			session.setAttribute("id",inputUserDTO.getuId());
		    session.setAttribute("nickname",user.getuNickname());
		    
		    logger.info("id:{}, nickname:{}", inputUserDTO.getuId(),user.getuNickname());
//			jsonResult.setMsg(token);
			
		} else {
			jsonResult.setIsSuccess(0);
		}
		
		return jsonResult;
	}
	
	@RequestMapping(value="/loginProc/{token:.+}",method=RequestMethod.GET)
	public ModelAndView loginProc(HttpServletRequest request, HttpSession session, Model model, @PathVariable(value="token") String token) {		
		ModelAndView mav = new ModelAndView();
		
		try {
		    Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
		    
		    session.setAttribute("id",claims.getId());
		    session.setAttribute("nickname",claims.getSubject());
		    session.setAttribute("token", token);
		    
		     mav.addObject("session", session);

		} catch (SignatureException e) {
			
			logger.info("Error!");
			
			mav.setViewName("redirect:/login");
			return mav;
		}
		
		mav.setViewName("redirect:/view");
		return mav;
	}
	
	
	

}
