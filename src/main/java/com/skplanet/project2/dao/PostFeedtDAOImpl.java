package com.skplanet.project2.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skplanet.project2.model.PostFeedDTO;

@Repository
public class PostFeedtDAOImpl implements PostFeedDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insertFeed(PostFeedDTO content) {
		// TODO Auto-generated method stub
		int result = sqlSession.insert("postfeed.insertFeed", content);	
		System.out.println(content.getId());
		int c_id = content.getId();
		return c_id;
	}

	@Override
	public int insertHashTagList(int cId,List<String> hashlist) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("contentId", cId);
		map.put("list", hashlist);
		
		int result = sqlSession.insert("postfeed.inserthashtag", map);	
		return result;
	}
	
}
