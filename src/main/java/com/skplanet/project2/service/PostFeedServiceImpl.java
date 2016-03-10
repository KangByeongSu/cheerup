package com.skplanet.project2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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

		int result = contentDAO.insertFeed(content);
		String hashtag = content.getHashtag();

		if (hashtag.equals("hash_null") || hashtag == null) {
			System.out.println("hash is null");
		} else {
			List<String> hashtags = tokenizeHashTag(content.getHashtag());
			int result2 = contentDAO.insertHashTagList(result, hashtags);
		}

		return result;
	}

	public List<String> tokenizeHashTag(String hashtags) {
		List<String> resultHash = new ArrayList<String>();

		StringTokenizer tokenTemp = new StringTokenizer(hashtags, "-||-");
		while (tokenTemp.hasMoreTokens()) {
			System.out.println("insert hashtag");
			resultHash.add(tokenTemp.nextToken());
		}

		return resultHash;
	}
}
