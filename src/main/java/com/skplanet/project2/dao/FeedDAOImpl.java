package com.skplanet.project2.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skplanet.project2.model.FeedDTO;

@Repository
public class FeedDAOImpl implements FeedDAO {

	
	@Autowired
	private SqlSession sqlSession; 
	
	@Override
	public List<FeedDTO> selectFeedList(int pageNo) {
	
		
		List<FeedDTO> feedList=sqlSession.selectList("com.skplanet.project2.mapper.FeedMapper.selectFeed",(pageNo-1)*5);
		
		for (FeedDTO feedDTO : feedList) {
			List<String> upUserIdList=sqlSession.selectList("com.skplanet.project2.mapper.FeedMapper.getUpUserId", feedDTO.getFeedId());
			List<String> downUserIdList=sqlSession.selectList("com.skplanet.project2.mapper.FeedMapper.getDownUserId", feedDTO.getFeedId());
			
			feedDTO.setUpUserList(upUserIdList);
			feedDTO.setDownUserList(downUserIdList);
		}
	
		return feedList;
	}

	
}
