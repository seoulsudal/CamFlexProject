package com.camflex.client.member.service;

import com.camflex.client.member.vo.MemberVO;

public interface MemberService {

	// 회원가입 처리
	public void insertMember(MemberVO vo) throws Exception;

}
