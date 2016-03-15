package com.skplanet.project2.dao;

import java.util.List;

import com.skplanet.project2.model.PostFeedDTO;

public interface PostFeedDAO {
	
	public int insertFeed(PostFeedDTO content);
	
	public int insertHashTagList(int cId, List<String> hashtags);



}
