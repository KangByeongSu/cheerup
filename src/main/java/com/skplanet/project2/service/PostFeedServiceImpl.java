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
		// TODO hashtag token, file upload
		String hashtag = content.getHashtag();

		//String employee = "Smith,Katie,3014,,8.25,6.5,,,10.75,8.5";
		//String delims = "[,]";
		//String[] tokens = hashtag.split(delims);      
		
		int result = contentDAO.insertFeed(content);
		
		return result;
	}

	
	
}
