package com.camflex.admin.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.camflex.client.login.vo.LoginVO;

@Repository
public class AdminMemberDAOImpl implements AdminMemberDAO {
	
	@Autowired
	private SqlSession sqlSession;

	// 회원 리스트
	@Override
	public List<LoginVO> memberList(LoginVO lvo) {
		
		return sqlSession.selectList("memberList");
	}
}
