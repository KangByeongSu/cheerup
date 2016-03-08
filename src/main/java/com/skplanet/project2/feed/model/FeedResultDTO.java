package com.skplanet.project2.feed.model;

import java.util.List;

public class FeedResultDTO extends Result {

	
	private List<FeedDTO> feedList;

	public List<FeedDTO> getFeedList() {
		return feedList;
	}

	public void setFeedList(List<FeedDTO> feedList) {
		this.feedList = feedList;
	}
	
	
}
