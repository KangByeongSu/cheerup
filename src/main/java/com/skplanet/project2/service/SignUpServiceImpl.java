package com.skplanet.project2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skplanet.project2.dao.SignUpDAO;
import com.skplanet.project2.model.UserDTO;

@Service
public class SignUpServiceImpl implements SignUpService{
	
	@Autowired
	SignUpDAO signupdao;

	@Override
	public int checkUserId(String userId) {
		int result = signupdao.selectUserId(userId);
		return result;
	}

	@Override
	public int signupUser(UserDTO user) {
		
		int result = signupdao.insertUser(user);
		return result;
	}

}
