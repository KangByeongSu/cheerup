package com.skplanet.project2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skplanet.project2.dao.FeedDAO;
import com.skplanet.project2.model.CommentDTO;
import com.skplanet.project2.model.FeedDTO;

@Service
public class FeedServiceImpl implements FeedService {

	
	@Autowired
	private FeedDAO feedDAO;
	
	
	@Override
	public List<FeedDTO> getFeedlist(int pageNo) {

		return feedDAO.selectFeedList(pageNo);
		
	}


	@Override
	public int insertComment(CommentDTO commentDTO) {
		return feedDAO.insertComment(commentDTO);
	}


	@Override
	public List<CommentDTO> getCommentList(int feedId, int pageNo) {
		
		return feedDAO.selectCommentList(feedId,pageNo);
	}


	@Override
	public int updateComment(int commentId) {
		return feedDAO.updateComment(commentId);
	}


	@Override
	public int deleteComment(int commentId) {
		return feedDAO.deleteComment(commentId);
	}
	

	
}