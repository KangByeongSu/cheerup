package com.skplanet.project2.feed.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.skplanet.project2.feed.model.FeedDTO;

public class FeedDAOImpl implements FeedDAO {

	
	@Autowired
	private SqlSession sqlSession; 
	
	@Override
	public List<FeedDTO> selectFeedList(int pageNo) {
	
		int limitStart=(pageNo-1)*5;
		
		List<FeedDTO> feedList=sqlSession.selectList("feed.getFeed", limitStart);
		
		for (FeedDTO feedDTO : feedList) {
			List<Integer> upUserIdList=sqlSession.selectList("feed.getUpUserId", feedDTO.getFeedId());
			List<Integer> downUserIdList=sqlSession.selectList("feed.getDownUserId", feedDTO.getFeedId());
			
			feedDTO.setUpUserList(upUserIdList);
			feedDTO.setUpUserList(downUserIdList);
		}
	
		return feedList;
	}

	
}
