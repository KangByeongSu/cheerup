package com.skplanet.project2.dao;

import java.util.List;

import com.skplanet.project2.model.SearchDTO;

public interface SearchDAO {
	
	List<SearchDTO> selectinterestList(String hashtag, int pageNum,String type);

}
