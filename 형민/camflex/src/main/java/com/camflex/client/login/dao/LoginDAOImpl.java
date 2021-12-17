package com.camflex.client.login.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import org.springframework.stereotype.Repository;

import com.camflex.client.login.vo.LoginVO;

@Repository
public class LoginDAOImpl implements LoginDAO {

	@Inject
	private SqlSession sqlSession;

	private static final String namespace = "com.camflex.client.login.dao.LoginDAO";

	// 회원가입 처리
	@Override
	public void insert(LoginVO vo) throws Exception {
		sqlSession.insert(namespace + ".insertMember", vo);
	}

	

}
