package com.skplanet.project2.model;

import java.util.List;

public class SearchDTO {
	
	private int hashId;
	private int contentId;
	private List<String> hashtag;
	
	public int getHashId() {
		return hashId;
	}
	public void setHashId(int hashId) {
		this.hashId = hashId;
	}
	public int getContentId() {
		return contentId;
	}
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	public List<String> getHashtag() {
		return hashtag;
	}
	public void setHashtag(List<String> hashtag) {
		this.hashtag = hashtag;
	}
	
	
	

}
