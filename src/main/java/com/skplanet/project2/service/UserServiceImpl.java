package com.skplanet.project2.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skplanet.project2.dao.UserDAO;
import com.skplanet.project2.model.UserDTO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;


	@Override
	public UserDTO loginProc(UserDTO userDTO) {
		return userDAO.checkUser(userDTO); 
	}
}
