package com.skplanet.project2.service;

import java.util.List;

import com.skplanet.project2.model.SearchDTO;

public interface SearchService {
	
	public List<SearchDTO> searchInterestFeed(String hashtag, int pageNum,String type);
	
}
