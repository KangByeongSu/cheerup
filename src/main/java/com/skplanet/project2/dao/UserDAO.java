package com.skplanet.project2.dao;

import java.util.List;

import com.skplanet.project2.model.CommentDTO;
import com.skplanet.project2.model.CommentResultDTO;
import com.skplanet.project2.model.ImageGridDTO;
import com.skplanet.project2.model.PostFeedDTO;
import com.skplanet.project2.model.UserDTO;

public interface UserDAO {
	public UserDTO checkUser(UserDTO userDTO);

	public List<ImageGridDTO> userImageGridURL(String userId);
	
	public int likeCount(int contentId);

	public int commentCount(int contentId);
	
	public PostFeedDTO extendModalContents(int contentId);
	public List<CommentDTO> extendModalComment(int contentId);
	public int editUser(UserDTO userDTO);

}
