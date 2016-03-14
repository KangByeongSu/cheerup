package com.skplanet.project2.model;

public class FeedIdAndPageNo{
	private int feedId,pageNo;
	
	public FeedIdAndPageNo(int feedId, int pageNo){
		this.feedId=feedId;
		this.pageNo=pageNo;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getFeedId() {
		return feedId;
	}

	public void setFeedId(int feedId) {
		this.feedId = feedId;
	}
}