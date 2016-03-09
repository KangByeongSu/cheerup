package com.skplanet.project2.model;

import java.util.List;

public class FeedDTO{

	private String message;
	private String imgurl;
	private String createTime;
	private int feedId;
	private int userId;
	private List<CommentDTO> commentList;
	private List<Integer> upUserList;
	private List<Integer> downUserList;
	
	
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public List<CommentDTO> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<CommentDTO> commentList) {
		this.commentList = commentList;
	}
	public List<Integer> getUpUserList() {
		return upUserList;
	}
	public void setUpUserList(List<Integer> upUserList) {
		this.upUserList = upUserList;
	}
	public List<Integer> getDownUserList() {
		return downUserList;
	}
	public void setDownUserList(List<Integer> downUserList) {
		this.downUserList = downUserList;
	}
	
	
	
}
