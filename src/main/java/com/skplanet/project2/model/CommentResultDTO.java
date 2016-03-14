package com.skplanet.project2.model;

import java.util.List;

public class CommentResultDTO extends Result{

	private List<CommentDTO> commentList;

	public List<CommentDTO> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<CommentDTO> commentList) {
		this.commentList = commentList;
	}
	
}
