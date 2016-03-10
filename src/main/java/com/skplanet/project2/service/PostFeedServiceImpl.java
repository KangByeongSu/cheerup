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
		System.out.println("content get hashtag"+content.getHashtag());
		
		int result = contentDAO.insertFeed(content);
		String hashtag = content.getHashtag();
		if(hashtag.equals("") || hashtag == null )
		{
			List<String> hashtags = tokenizeHashTag(content.getHashtag());
			int result2 = contentDAO.insertHashTagList(result, hashtags);
		}
		

		return result;
	}

	public List<String> tokenizeHashTag(String hashtags) {
		List<String> resultHash = new ArrayList<String>();
		if (hashtags==null || hashtags.equals("")) {
			resultHash.add("dd");
			System.out.println("null hashtag");
		} else {
			StringTokenizer tokenTemp = new StringTokenizer(hashtags, "-||-");
			while (tokenTemp.hasMoreTokens()) {
				System.out.println("insert hashtag");
				resultHash.add(tokenTemp.nextToken());
			}
		}
		System.out.println("token size : "+resultHash.size());
		
		return resultHash;
	}

}
