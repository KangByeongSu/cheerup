package com.skplanet.project2.feed.dao;

import java.util.List;

import com.skplanet.project2.feed.model.FeedDTO;

public interface FeedDAO {

	List<FeedDTO> selectFeedList(int pageNo);


}
