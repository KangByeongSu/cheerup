package com.skplanet.project2.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skplanet.project2.model.ImageGridDTO;
import com.skplanet.project2.model.PostFeedDTO;
import com.skplanet.project2.model.UserDTO;


@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public UserDTO checkUser(UserDTO userDTO) {
		UserDTO result=sqlSession.selectOne("UserMapper.checkUser", userDTO);
		
		return result;
	}

	@Override
	public List<ImageGridDTO> userImageGridURL(String userId) {
		
		List<ImageGridDTO> result=sqlSession.selectList("UserMapper.userImageGridURL", userId);
		
		return result;
	}

	@Override
	public int likeCount(int contentId) {
		int result = sqlSession.selectOne("UserMapper.likeCount",contentId);
		return result;
	}

	@Override
	public int commentCount(int contentId) {
		int result = sqlSession.selectOne("UserMapper.commentCount",contentId);
		return result;
	}

	@Override
	public PostFeedDTO extendModal(int contentId) {
		PostFeedDTO result = sqlSession.selectOne("UserMapper.extendModal",contentId);
		return result;
	}
	@Override
	public int editUser(UserDTO userDTO) {
		return sqlSession.update("UserMapper.updateUser",userDTO);
	}
	

}
