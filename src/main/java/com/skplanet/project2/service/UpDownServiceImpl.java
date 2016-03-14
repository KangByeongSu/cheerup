package com.skplanet.project2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skplanet.project2.dao.UpDownDAO;
import com.skplanet.project2.model.LikeDTO;

@Service
public class UpDownServiceImpl implements UpDownService {

	
	@Autowired
	private UpDownDAO upDownDAO;
	
	@Override
	public LikeDTO findUser(LikeDTO like) {
		LikeDTO find_user=upDownDAO.findUser(like);
		return find_user;
	}
	@Override
	public int deleteLikeStatus(LikeDTO like) {
		int result=upDownDAO.deleteLikeStatus(like);
		return result;
	}
	@Override
	public int insertLikeStatus(LikeDTO like) {
		
		int up_result=upDownDAO.insertLikeStatus(like);
		return up_result;
	}

	@Override
	public int updateLikeStatus(LikeDTO like) {
		int result=upDownDAO.updateLikeStatus(like);
		return result;
	}
	
}
