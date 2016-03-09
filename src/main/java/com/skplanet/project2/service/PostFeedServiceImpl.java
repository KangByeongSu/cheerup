package com.skplanet.project2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skplanet.project2.dao.PostFeedDAO;
import com.skplanet.project2.model.PostFeedDTO;

@Service
public class PostFeedServiceImpl implements PostFeedService {

	@Autowired
	PostFeedDAO contentDAO;
	
	@Override
	public void getFeedlists() {
		// TODO Auto-generated method stub
		System.out.println("hi");
		return;
		
	}

	@Override
	public int postFeed(PostFeedDTO content) {
		// TODO Auto-generated method stub
		int result = contentDAO.insertFeed(content);
		
		return result;
	}

	
	
}
