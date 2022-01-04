package com.camflex.admin.login.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.camflex.client.login.vo.LoginVO;

@Repository
public class AdminLoginDAOImpl implements AdminLoginDAO {

	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.camflex.admin.login.dao.AdminLoginDAO";

	@Override
	public LoginVO loginCheck(LoginVO vo) throws Exception {
		
		return sqlSession.selectOne(namespace + ".loginCheck", vo);
	}
}
