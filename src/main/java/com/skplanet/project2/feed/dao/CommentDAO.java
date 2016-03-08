package com.skplanet.project2.feed.dao;

import java.util.List;

import com.skplanet.project2.feed.model.CommentDTO;

public interface CommentDAO {
	
	List<CommentDTO> selectComment(String elephant_User_u_id);

}
