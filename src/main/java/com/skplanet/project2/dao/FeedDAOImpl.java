package com.skplanet.project2.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skplanet.project2.model.CommentDTO;
import com.skplanet.project2.model.FeedDTO;
import com.skplanet.project2.model.FeedIdAndPageNo;

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

	@Override
	public List<CommentDTO> selectCommentList(int feedId, int pageNo) {
		FeedIdAndPageNo fp=new FeedIdAndPageNo(feedId,(pageNo-1)*5);
		return sqlSession.selectList(MAPPER_PACKAGE+".FeedMapper.selectComment",fp);
	}

	@Override
	public int updateComment(CommentDTO commentDTO) {
		return sqlSession.update(MAPPER_PACKAGE+".FeedMapper.updateComment", commentDTO);
	}

	@Override
	public int deleteComment(int commentId) {
		return sqlSession.delete(MAPPER_PACKAGE+".FeedMapper.deleteComment", commentId);
	}
	
	

}

