package com.skplanet.project2.service;

import java.util.List;

import com.skplanet.project2.model.CommentDTO;
import com.skplanet.project2.model.FeedDTO;

public interface FeedService {
	
	public List<FeedDTO> getFeedlist(int pageNo);
	public int insertComment(CommentDTO commentDTO);
	public List<CommentDTO> getCommentList(int feedId, int pageNo);
	public int updateComment(int commentId);
	public int deleteComment(int commentId);


}