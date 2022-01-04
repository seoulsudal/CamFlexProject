package com.camflex.client.login.dao;

import java.util.Map;

import com.camflex.client.login.vo.LoginVO;
import com.camflex.client.member.vo.MemberVO;

public interface LoginDAO {

	// 로그인 처리
	public LoginVO loginCheck(LoginVO vo) throws Exception;

	// 아이디 찾기
	public MemberVO findId(MemberVO vo) throws Exception;

	// 비밀번호 찾기
	public MemberVO findPw(MemberVO vo) throws Exception;

	// 인증 후 비밀번호 변경
	public Object change_pw(Map<String, Object> map, MemberVO mvo) throws Exception;
}
