package com.camflex.client.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.camflex.client.login.dao.LoginDAO;
import com.camflex.client.login.vo.LoginVO;
import com.camflex.client.member.vo.MemberVO;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDAO loginDAO;

	// 로그인 처리
	@Override
	public LoginVO loginCheck(LoginVO vo) throws Exception {
		return loginDAO.loginCheck(vo);
	}

	// 아이디 찾기
	@Override
	public MemberVO findId(MemberVO vo) throws Exception {
		return loginDAO.findId(vo);
	}

	// 비밀번호 찾기 (이름,아이디)인증
	@Override
	public MemberVO IdName(MemberVO vo) throws Exception {
		return loginDAO.findId(vo);
	}

	// 인증 처리 후 비밀번호 변경
	@Override
	public void change_pw(MemberVO vo) throws Exception {
		loginDAO.change_pw(vo);
	}

}
