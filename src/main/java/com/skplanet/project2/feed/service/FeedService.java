package com.skplanet.project2.feed.service;

import java.util.List;

import com.skplanet.project2.feed.model.FeedDTO;

public interface FeedService {
	
	public List<FeedDTO> getFeedlists(int pageNo);

}
