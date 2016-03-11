package com.skplanet.project2.dao;

import java.util.List;

import com.skplanet.project2.model.CommentDTO;
import com.skplanet.project2.model.FeedDTO;

public interface FeedDAO {

	List<FeedDTO> selectFeedList(int pageNo);
	int insertComment(CommentDTO commentDTO);
	List<CommentDTO> selectCommentList(int feedId, int pageNo);
	int updateComment(int commentId);
	int deleteComment(int commentId);


}