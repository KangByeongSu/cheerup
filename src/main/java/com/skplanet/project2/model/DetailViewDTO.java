package com.skplanet.project2.model;

public class DetailViewDTO extends PostFeedDTO {
	int likeCount;
	int likeClicked;
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public int getLikeClicked() {
		return likeClicked;
	}
	public void setLikeClicked(int likeClicked) {
		this.likeClicked = likeClicked;
	}
	
}
