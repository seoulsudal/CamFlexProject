package com.camflex.client.login.dao;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import org.springframework.stereotype.Repository;

import com.camflex.client.login.vo.LoginVO;

//DB 연결 구현
@Repository
public class LoginDAOImpl implements LoginDAO {

	@Inject
	private SqlSession sqlSession;

	private static final String namespace = "com.camflex.client.login.dao.LoginDAO";

	// 회원 정보 끌어오기(사용자 ID)
	@Override
	public LoginVO userIdSelect(String m_id) {
		System.out.println("6");
		LoginVO vo = sqlSession.selectOne(namespace + ".userIdSelect", m_id);
		System.out.println("7");
		return vo;
	}

	// 회원 정보 끌어오기(ID,PW)
	@Override
	public LoginVO loginSelect(String m_id, String m_pw) throws Exception {
		System.out.println("6");
		Map<String, String> paramMap = new HashMap<String, String>();
		System.out.println("7");
		paramMap.put("m_id", m_id);
		paramMap.put("m_pw", m_pw);
		System.out.println("8");
		return sqlSession.selectOne(namespace + ".readMemberIDPW", paramMap);
	}

}
