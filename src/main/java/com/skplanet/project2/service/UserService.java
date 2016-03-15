package com.skplanet.project2.service;

import java.util.List;

import com.skplanet.project2.model.ImageGridDTO;
import com.skplanet.project2.model.UserDTO;

public interface UserService {
	
	public UserDTO loginProc(UserDTO userDTO);
	
	public List<ImageGridDTO> userImageGridURL(String userId);

}
