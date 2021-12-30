package com.camflex.client.login.service;

import java.util.Map;

import com.camflex.client.login.dao.LoginDAO;
import com.camflex.client.login.vo.LoginVO;
import com.camflex.client.member.vo.MemberVO;

public interface LoginService {

	// 로그인 처리
	public LoginVO loginCheck(LoginVO vo) throws Exception;

	// 아이디 찾기
	public MemberVO findId(MemberVO vo) throws Exception;

	// 인증 후 비밀번호 변경
	public void change_pw(Map<String, Object> map, MemberVO mvo) throws Exception;
}
