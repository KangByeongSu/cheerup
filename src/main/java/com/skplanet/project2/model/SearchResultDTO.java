package com.skplanet.project2.model;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class SearchResultDTO extends Result{
	
	private List<SearchDTO> searchList;

	public List<SearchDTO> getSearchList() {
		return searchList;
	}

	public void setSearchList(List<SearchDTO> searchList) {
		this.searchList = searchList;
	}
	
}
