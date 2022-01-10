package com.camflex.client.login.service;

import com.camflex.client.login.vo.LoginVO;
import com.camflex.client.member.vo.MemberVO;

public interface LoginService {

	// 로그인 처리
	public LoginVO loginCheck(LoginVO vo) throws Exception;

	// 아이디 찾기
	public MemberVO findId(MemberVO vo) throws Exception;

	// 비밀번호 찾기 (이름,아이디)인증
	public MemberVO IdName(MemberVO vo) throws Exception;

	// 인증 처리 후 비밀번호 변경
	public void change_pw(MemberVO vo) throws Exception;

}
