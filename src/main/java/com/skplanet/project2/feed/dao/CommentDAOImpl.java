package com.skplanet.project2.feed.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.skplanet.project2.feed.model.CommentDTO;

public class CommentDAOImpl implements CommentDAO {

	

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<CommentDTO> selectComment(String elephant_User_u_id) {
		return sqlSession.selectList("comment.getComment", elephant_User_u_id);
	}



}
