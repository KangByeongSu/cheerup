package com.skplanet.project2.service;

import java.util.List;

import com.skplanet.project2.model.FeedDTO;

public interface FeedService {
	
	public List<FeedDTO> getFeedlists(int pageNo);

}
