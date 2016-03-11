package com.skplanet.project2.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skplanet.project2.model.CommentDTO;
import com.skplanet.project2.model.FeedDTO;

@Repository
public class FeedDAOImpl implements FeedDAO {

	
	private static final String MAPPER_PACKAGE="com.skplanet.project2.mapper";
	

	
	@Autowired
	private SqlSession sqlSession; 
	
	@Override
	public List<FeedDTO> selectFeedList(int pageNo) {
	
		
		List<FeedDTO> feedList=sqlSession.selectList(MAPPER_PACKAGE+".FeedMapper.selectFeed",(pageNo-1)*5);
		
		for (FeedDTO feedDTO : feedList) {
			List<String> upUserIdList=sqlSession.selectList(MAPPER_PACKAGE+".FeedMapper.getUpUserId", feedDTO.getFeedId());
			List<String> downUserIdList=sqlSession.selectList(MAPPER_PACKAGE+".FeedMapper.getDownUserId", feedDTO.getFeedId());
			
			feedDTO.setUpUserList(upUserIdList);
			feedDTO.setDownUserList(downUserIdList);
		}
	
		return feedList;
	}

	@Override
	public int insertComment(CommentDTO commentDTO) {
		
		return sqlSession.insert(MAPPER_PACKAGE+".FeedMapper.insertComment",commentDTO);
	}

}