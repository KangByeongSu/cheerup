package com.skplanet.project2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skplanet.project2.dao.FeedDAO;
import com.skplanet.project2.model.FeedDTO;

@Service
public class FeedServiceImpl implements FeedService {

	
	@Autowired
	FeedDAO feedDAO;
	
	
	@Override
	public List<FeedDTO> getFeedlists(int pageNo) {

		return feedDAO.selectFeedList(pageNo);
		
	}
	
}
