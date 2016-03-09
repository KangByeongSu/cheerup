package com.skplanet.project2.service;

import com.skplanet.project2.model.PostFeedDTO;


public interface PostFeedService {
	
	public void getFeedlists();
	
	public int postFeed(PostFeedDTO content);

}
