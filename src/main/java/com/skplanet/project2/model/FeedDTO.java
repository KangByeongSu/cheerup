package com.skplanet.project2.model;

import java.util.List;

public class FeedDTO{

	private String message;
	private String imgurl;
	private String createTime;
	private int feedId;
	private String userId;
	private List<CommentDTO> commentList;
	private List<String> upUserList;
	private List<String> downUserList;
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public int getFeedId() {
		return feedId;
	}
	public void setFeedId(int feedId) {
		this.feedId = feedId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<CommentDTO> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<CommentDTO> commentList) {
		this.commentList = commentList;
	}
	public List<String> getUpUserList() {
		return upUserList;
	}
	public void setUpUserList(List<String> upUserList) {
		this.upUserList = upUserList;
	}
	public List<String> getDownUserList() {
		return downUserList;
	}
	public void setDownUserList(List<String> downUserList) {
		this.downUserList = downUserList;
	}
	
	
	
}
