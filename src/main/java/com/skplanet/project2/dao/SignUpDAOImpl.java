package com.skplanet.project2.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skplanet.project2.model.UserDTO;

@Repository
public class SignUpDAOImpl implements SignUpDAO {


	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int selectUserId(String userId) {
		// TODO Auto-generated method stub
		int cnt = sqlSession.selectOne("signup.selectUser", userId);
		return cnt;
	}

	@Override
	public int insertUser(UserDTO user) {
		int result = sqlSession.insert("signup.insertUser", user);	
		return result;
	}

}
