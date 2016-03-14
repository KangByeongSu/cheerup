package com.skplanet.project2.dao;

import com.skplanet.project2.model.UserDTO;

public interface SignUpDAO {
	
	public int selectUserId(String userId);
	public int insertUser(UserDTO user);


}
