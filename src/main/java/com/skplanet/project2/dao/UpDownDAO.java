package com.skplanet.project2.dao;

import com.skplanet.project2.model.LikeDTO;

public interface UpDownDAO {
	LikeDTO findUser(LikeDTO find);

	int insertUp(LikeDTO like);

	int insertDown(LikeDTO like);

	int deleteUser(LikeDTO like);

	int updateUser(LikeDTO like);


}
