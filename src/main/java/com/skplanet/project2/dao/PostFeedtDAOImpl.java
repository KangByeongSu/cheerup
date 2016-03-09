package com.skplanet.project2.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skplanet.project2.model.PostFeedDTO;

@Repository
public class PostFeedtDAOImpl implements PostFeedDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insertFeed(PostFeedDTO content) {
		// TODO Auto-generated method stub
		return sqlSession.insert("postfeed.insertFeed", content);	
	}
	 
}
