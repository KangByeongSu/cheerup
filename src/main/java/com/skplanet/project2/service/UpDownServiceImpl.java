package com.skplanet.project2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skplanet.project2.dao.UpDownDAO;
import com.skplanet.project2.model.LikeDTO;

@Service
public class UpDownServiceImpl implements UpDownService {

	
	@Autowired
	private UpDownDAO upDownDAO;

/*	@Override
	public int insertUp(LikeDTO like) {
		int up_result=upDownDAO.insertUp(like);
		return up_result;
	}

	@Override
	public int insertDown(LikeDTO like) {
		System.out.println("Insert Down Service");
		int down_result=upDownDAO.insertDown(like);
		return down_result;
	}

	@Override
	public int deleteUser(LikeDTO like) {
		int result=upDownDAO.deleteUser(like);
		return result;
	}

	@Override
	public int updateUp(LikeDTO like) {
		
		// Setting value
		like.setUp(1);
		like.setDown(0);
		
		int result=upDownDAO.updateUser(like);
		return result;
	}

	@Override
	public int updateDown(LikeDTO like) {
		
		// Setting value
		like.setUp(0);
		like.setDown(1);
		
		int result=upDownDAO.updateUser(like);
		return result;
	}
*/
	
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
