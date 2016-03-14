package com.skplanet.project2.service;

import com.skplanet.project2.model.LikeDTO;

public interface UpDownService {

	public LikeDTO findUser(LikeDTO like);

/*	public int insertUp(LikeDTO like);

	public int insertDown(LikeDTO like);

	public int deleteUser(LikeDTO like);

	public int updateUp(LikeDTO like);

	public int updateDown(LikeDTO like);
	
	*/
	public int deleteLikeStatus(LikeDTO like);
	
	public int insertLikeStatus(LikeDTO like);
	
	public int updateLikeStatus(LikeDTO like);
}
