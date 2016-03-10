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
		System.out.println("���Դ�.");
		tokenizeHashTag(content.getHashtag());
		System.out.println("Tokenizing ����");
		int result = contentDAO.insertFeed(content);
		System.out.println("�����ͺ��̽� �Է� ����");
		// ����� c_no�� ���´�

		return result;
	}

	public List<String> tokenizeHashTag(String hashtags) {
		List<String> resultHash = new ArrayList<String>();
		if (hashtags==null || hashtags.equals("")) {
		} else {
			StringTokenizer tokenTemp = new StringTokenizer(hashtags, "-||-");
			while (tokenTemp.hasMoreTokens()) {
				resultHash.add(tokenTemp.nextToken());
			}
		}
		return resultHash;
	}

}
