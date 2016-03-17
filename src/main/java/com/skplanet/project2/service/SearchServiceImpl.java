package com.skplanet.project2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skplanet.project2.dao.SearchDAO;
import com.skplanet.project2.model.SearchDTO;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	SearchDAO searchdao;
	
	@Override
	public List<SearchDTO> searchInterestFeed(String hashtag, int pageNum,String type) {
		return searchdao.selectinterestList(hashtag, pageNum,type);
	}
	

}
