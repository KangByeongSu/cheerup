package com.skplanet.project2.service;

import com.skplanet.project2.model.LikeDTO;

public interface UpDownService {

	public LikeDTO findUser(LikeDTO like);

	public int deleteLikeStatus(LikeDTO like);
	
	public int insertLikeStatus(LikeDTO like);
	
	public int updateLikeStatus(LikeDTO like);
}
