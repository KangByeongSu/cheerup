package com.skplanet.project2.service;

import com.skplanet.project2.model.UserDTO;

public interface SignUpService {
	
	public int checkUserId(String userId);
	public int signupUser(UserDTO user);

}
