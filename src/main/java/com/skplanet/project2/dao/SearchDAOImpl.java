package com.skplanet.project2.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skplanet.project2.model.SearchDTO;

@Repository
public class SearchDAOImpl implements SearchDAO{

	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public List<SearchDTO> selectinterestList(String hashtag, int pageNum, String type) {
		List<SearchDTO> searchlist = new ArrayList<SearchDTO>();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("hashtag", hashtag);
		map.put("pageNum", pageNum);
		map.put("type", type);
		searchlist = sqlSession.selectList("search.selectInterestItem",map);
		
		return searchlist;
	}

	

}
