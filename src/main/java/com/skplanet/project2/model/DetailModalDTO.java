package com.skplanet.project2.model;

import java.util.List;

public class DetailModalDTO extends Result{

	private DetailViewDTO detailPost;

	private List<CommentDTO> commentList;
	

	public DetailViewDTO getDetailPost() {
		return detailPost;
	}

	public void setDetailPost(DetailViewDTO detailPost) {
		this.detailPost = detailPost;
	}

	public List<CommentDTO> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<CommentDTO> commentList) {
		this.commentList = commentList;
	}
	
}
