package com.skplanet.project2.model;

import java.util.List;

public class DetailModalDTO extends Result{

	private PostFeedDTO detailPost;

	private List<CommentDTO> commentList;
	
	public PostFeedDTO getDetailPost() {
		return detailPost;
	}

	public void setDetailPost(PostFeedDTO detailPost) {
		this.detailPost = detailPost;
	}

	public List<CommentDTO> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<CommentDTO> commentList) {
		this.commentList = commentList;
	}
	
}
