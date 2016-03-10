package com.skplanet.project2;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view(Locale locale, Model model) {

		
		return "view";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {

		
		return "login";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(Locale locale, Model model) {

		
		return "join";
	}
	
	
	/*@RequestMapping(value = "/feed/add", method = RequestMethod.POST)
	public String uploadText(@RequestParam(value = "imageFile")  MultipartFile imageFile,@RequestParam(value = "hashtag")  String hash,@RequestParam(value = "text")  String text, ModelMap modelMap) {
				
		System.out.println("before : upload Image To Server Method");
		
		System.out.println("image  : "+hash);
		System.out.println("image  : "+imageFile);
//		ImageFile fileInfo = imageService.save(imageFile);
		System.out.println("text : "+text);
			
		System.out.println("after : upload Image To Server Method");
	//	modelMap.put("imageFile", fileInfo);
		
		//이미지만 return 해야합니다.
		return "view";
	}*/
}