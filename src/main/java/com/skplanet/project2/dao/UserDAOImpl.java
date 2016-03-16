package com.skplanet.project2.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skplanet.project2.model.CommentDTO;
import com.skplanet.project2.model.DetailViewDTO;
import com.skplanet.project2.model.ImageGridDTO;
import com.skplanet.project2.model.LikeDTO;
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
	public int editUser(UserDTO userDTO) {
		return sqlSession.update("UserMapper.updateUser",userDTO);
	}

	@Override
	public DetailViewDTO extendModalContents(int contentId) {
		DetailViewDTO result = sqlSession.selectOne("UserMapper.extendModalContents",contentId);
		return result;
	}

	@Override
	public List<CommentDTO> extendModalComment(int contentId) {
		List<CommentDTO> result = sqlSession.selectList("UserMapper.extendModalComment",contentId);
		return result;
	}

	@Override
	public int extendModalLikeCount(int contentId) {
		int result = sqlSession.selectOne("UserMapper.extendModalLikeCount",contentId);
		return result;
	}
	@Override
	public int extendModalLikeClicked(LikeDTO likeInfo) {
		
		int result = sqlSession.selectOne("UserMapper.extendModalLikeClicked",likeInfo);
		return result;
	}
	
}
