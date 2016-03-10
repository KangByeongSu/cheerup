package com.skplanet.project2.dao;

import java.util.List;

import com.skplanet.project2.model.FeedDTO;

public interface FeedDAO {

	List<FeedDTO> selectFeedList(int pageNo);

}
