package com.skplanet.project2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skplanet.project2.model.LikeDTO;
import com.skplanet.project2.model.LikeResultDTO;
import com.skplanet.project2.model.Result;
import com.skplanet.project2.service.UpDownServiceImpl;

@Controller
public class UpDownController {

	@Autowired
	UpDownServiceImpl upDownService;

	@RequestMapping(value = "/feed/like", method = RequestMethod.GET)
	/* @RequestMapping(value = "/feed/like", method = RequestMethod.POST) */
	public @ResponseBody Result callLike(LikeDTO like, Model model) {

		LikeResultDTO resultJson = new LikeResultDTO();
		int result = 0;
		like.setUserId("user");
		like.setContentId(1);
		like.setDown(0);
		like.setUp(1);

		try {
			// Select Like Table
			LikeDTO find_user = upDownService.findUser(like);
			if (find_user == null) {
				// If find_user is Null, insert new data.
				result=upDownService.insertLikeStatus(like);
				if (result == 1) {
					System.out.println("Success Insert Count = " + result);
				}
			} else {
				if (find_user.getUp() == like.getUp() || find_user.getDown() == like.getDown()) {
					// If find_user is not null and user up number is 1, delete
					// user.
					result = upDownService.deleteLikeStatus(like);
					if (result == 1) {
						System.out.println("Success Delete Count = " + result);
					}
				} else {
					// If find_user is not null and user down number is 1,
					// update
					// user data. l_down=0,l_up=1.
					result = upDownService.updateLikeStatus(like);
					if (result == 1) {
						System.out.println("Success Update Count = " + result);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Error");
			result = 0;
			e.printStackTrace();
		}

		if (result == 1) {
			resultJson.setIsSuccess(1);
			resultJson.setMsg("success");
		} else {
			resultJson.setIsSuccess(0);
			resultJson.setMsg("fail");
		}
		return resultJson;
	}

	/*
	 * @RequestMapping(value = "/feed/up", method = RequestMethod.GET)
	 * 
	 * @RequestMapping(value = "/feed/up", method = RequestMethod.POST) public
	 * String callUp(LikeDTO like, Model model) { int result = 1;
	 * like.setUserId("user"); like.setContentId(1); like.setDown(0);
	 * like.setUp(1);
	 * 
	 * // Select Like Table LikeDTO find_user = upDownService.findUser(like); if
	 * (find_user == null) { // If find_user is Null, insert new data.
	 * upDownService.insertUp(like); if (result == 1) { System.out.println(
	 * "Success Insert Count = " + result); } } else { if (find_user.getUp() ==
	 * 1) { // If find_user is not null and user up number is 1, delete // user.
	 * result = upDownService.deleteUser(like); if (result == 1) {
	 * System.out.println("Success Delete Count = " + result); } } else if
	 * (find_user.getDown() == 1) { // If find_user is not null and user down
	 * number is 1, update // user data. l_down=0,l_up=1. result =
	 * upDownService.updateUp(like); if (result == 1) { System.out.println(
	 * "Success Update Count = " + result); } } }
	 * 
	 * return "view"; }
	 * 
	 * @RequestMapping(value = "/feed/down", method = RequestMethod.GET)
	 * 
	 * @RequestMapping(value = "/feed/down", method = RequestMethod.POST) public
	 * String callDown(LikeDTO like, Model model) {
	 * 
	 * int result = 0; like.setUserId("user"); like.setContentId(1);
	 * like.setDown(1); like.setUp(0);
	 * 
	 * // Select Like Table LikeDTO find_user = upDownService.findUser(like); if
	 * (find_user == null) { // If find_user is Null, insert new data. result =
	 * upDownService.insertDown(like); if (result == 1) { System.out.println(
	 * "Success Insert Count = " + result); } } else { if (find_user.getDown()
	 * == 1) { // If find_user is not null and user down number is 1, delete //
	 * user. result = upDownService.deleteUser(like); if (result == 1) {
	 * System.out.println("Success Delete Count = " + result); } } else if
	 * (find_user.getUp() == 1) { // If find_user is not null and user up number
	 * is 1, update // user data. l_down=1,l_up=0. result =
	 * upDownService.updateDown(like); if (result == 1) { System.out.println(
	 * "Success Update Count = " + result); } }
	 * 
	 * } return "view"; }
	 */
}
