package com.skplanet.project2.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skplanet.project2.dao.UserDAO;
import com.skplanet.project2.model.ImageGridDTO;
import com.skplanet.project2.model.PostFeedDTO;
import com.skplanet.project2.model.UserDTO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;


	@Override
	public UserDTO loginProc(UserDTO userDTO) {
		return userDAO.checkUser(userDTO); 
	}
	
	@Override
	public List<ImageGridDTO> userImageGridURL(String userId) {
		
		List<ImageGridDTO> result = userDAO.userImageGridURL(userId); 
		//카운트 뽑아야한다.
		
		for(int i=0; i<result.size();i++)
		{
			ImageGridDTO temp = result.get(i);
			int likeCount = userDAO.likeCount(temp.getContentId());
			temp.setLikeCount(likeCount);
			int commentCount = userDAO.commentCount(temp.getContentId());
			temp.setCommentCount(commentCount);
			//System.out.println("like COunt : " + likeCount + "Comment Count : "+ commentCount);
		}
		return result; 
	}

	@Override
	public PostFeedDTO extendModal(int contentId) {
		PostFeedDTO result = userDAO.extendModal(contentId); 
		return result;
	}
}
