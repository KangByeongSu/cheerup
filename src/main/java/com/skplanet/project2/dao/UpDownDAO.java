package com.skplanet.project2.dao;

import com.skplanet.project2.model.LikeDTO;

public interface UpDownDAO {
	LikeDTO findUser(LikeDTO find);
	
	int insertLikeStatus(LikeDTO like);

	int deleteLikeStatus(LikeDTO like);

	int updateLikeStatus(LikeDTO like);

}
