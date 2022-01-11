package com.camflex.admin.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.camflex.client.member.vo.MemberVO;
import com.camflex.common.vo.PageRequest;

@Repository
public class AdminMemberDAOImpl implements AdminMemberDAO {
	
	@Autowired
	private SqlSession sqlSession;

	// 회원 리스트
	@Override
	public List<MemberVO> memberList(PageRequest pageRequest) {
		
		return sqlSession.selectList("memberList");
	}

	@Override
	public int count(PageRequest pageRequest) {
		
		return sqlSession.selectOne("count");
	}
	
}
