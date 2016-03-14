package com.skplanet.project2.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skplanet.project2.model.LikeDTO;

@Repository
public class UpDownDAOImpl implements UpDownDAO {

	@Autowired
	private SqlSession sqlSession;

/*	@Override
	public int insertUp(LikeDTO like) {

		int up_result = sqlSession.insert("up_down.insertUp", like);
		return up_result;
	}

	@Override
	public int insertDown(LikeDTO like) {
		int down_result = sqlSession.insert("up_down.insertDown", like);
		return down_result;
	}


	@Override
	public int deleteUser(LikeDTO like) {
		int result=sqlSession.delete("up_down.deleteUser",like);
		return result;
	}

	@Override
	public int updateUser(LikeDTO like) {
		int result=sqlSession.update("up_down.updateUser",like);
		return result;
	}
*/
	
	
	@Override
	public LikeDTO findUser(LikeDTO like) {
		LikeDTO find_user=sqlSession.selectOne("up_down.findUser",like);
		return find_user;
	}

	
	@Override
	public int insertLikeStatus(LikeDTO like) {
		int up_result = sqlSession.insert("up_down.insertLikeStatus", like);
		return up_result;
	}

	@Override
	public int deleteLikeStatus(LikeDTO like) {
		int result=sqlSession.delete("up_down.deleteLikeStatus",like);
		return result;
	}

	@Override
	public int updateLikeStatus(LikeDTO like) {
		int result=sqlSession.update("up_down.updateLikeStatus",like);
		return result;
	}

}
