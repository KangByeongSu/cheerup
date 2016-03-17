package com.skplanet.project2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skplanet.project2.controller.PostFeedController;
import com.skplanet.project2.dao.PostFeedDAO;
import com.skplanet.project2.model.PostFeedDTO;

@Service
public class PostFeedServiceImpl implements PostFeedService {
	private static final Logger logger = LoggerFactory.getLogger(PostFeedServiceImpl.class);
	
	@Autowired
	PostFeedDAO contentDAO;

	@Override
	public int postFeed(PostFeedDTO content) {

		int ContentInsertResult;
		int hashtagInsertResult;
		String hashtag = content.getHashtag();

		ContentInsertResult = contentDAO.insertFeed(content);
		if (hashtag.equals("")) {
			logger.info("This Content has not hashtags.");

		} else {
			List<String> hashtags = tokenizeHashTag(content.getHashtag());
			hashtagInsertResult = contentDAO.insertHashTagList(ContentInsertResult, hashtags);
		}

		return ContentInsertResult;
	}

	public List<String> tokenizeHashTag(String hashtags) {
		List<String> resultHash = new ArrayList<String>();

		StringTokenizer tokenTemp = new StringTokenizer(hashtags, "-||-");
		while (tokenTemp.hasMoreTokens()) {
			resultHash.add(tokenTemp.nextToken());
		}

		return resultHash;
	}
}
