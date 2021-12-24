package com.camflex.client.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.camflex.client.member.vo.MemberVO;

//DB 연결 구현
@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSession sqlSession;

	private static final String namespace = "com.camflex.client.member.dao.MemberDAO";

	// 회원가입 처리
	@Override
	public void insertMember(MemberVO vo) throws Exception {
		sqlSession.insert(namespace + ".insertMember", vo);
	}

}
