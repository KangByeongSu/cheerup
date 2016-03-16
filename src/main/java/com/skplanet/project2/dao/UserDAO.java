package com.skplanet.project2.dao;

import java.util.List;

import com.skplanet.project2.model.CommentDTO;
import com.skplanet.project2.model.DetailViewDTO;
import com.skplanet.project2.model.ImageGridDTO;
import com.skplanet.project2.model.LikeDTO;
import com.skplanet.project2.model.UserDTO;

public interface UserDAO {
	public UserDTO checkUser(UserDTO userDTO);

	public List<ImageGridDTO> userImageGridURL(String userId);
	
	public int likeCount(int contentId);

	public int commentCount(int contentId);
	
	public DetailViewDTO extendModalContents(int contentId);
	public int extendModalLikeCount(int contentId);
	public int extendModalLikeClicked(LikeDTO likeInfo);
	
	public List<CommentDTO> extendModalComment(int contentId);
	public int editUser(UserDTO userDTO);

}
