package com.skplanet.project2.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skplanet.project2.model.UserDTO;


@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public UserDTO checkUser(UserDTO userDTO) {
		UserDTO result=sqlSession.selectOne("UserMapper.checkUser", userDTO);
		
		return result;
	}

	@Override
	public int editUser(UserDTO userDTO) {
		return sqlSession.update("UserMapper.updateUser",userDTO);
	}
	

}
