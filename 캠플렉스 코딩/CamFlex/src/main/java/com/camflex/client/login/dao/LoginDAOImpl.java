package com.camflex.client.login.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.camflex.client.login.vo.LoginVO;
import com.camflex.client.member.vo.MemberVO;

//DB 연결 구현
@Repository
public class LoginDAOImpl implements LoginDAO {

	@Autowired
	private SqlSession sqlSession;

	private static final String namespace = "com.camflex.client.login.dao.LoginDAO";

	// 로그인 처리
	@Override
	public LoginVO loginCheck(LoginVO vo) throws Exception {
		return sqlSession.selectOne(namespace + ".loginCheck", vo);
	}

	// 비밀번호 찾기 (이름,아이디)인증
	@Override
	public MemberVO IdName(MemberVO vo) throws Exception {
		return sqlSession.selectOne(namespace + ".IdName", vo);
	}

	// 아이디 찾기
	@Override
	public MemberVO findId(MemberVO vo) throws Exception {
		return sqlSession.selectOne(namespace + ".findId", vo);
	}

	// 인증 처리 후 비밀번호 변경
	@Override
	public void change_pw(MemberVO vo) throws Exception {
		sqlSession.update(namespace + ".change_pw", vo);
	}

}
