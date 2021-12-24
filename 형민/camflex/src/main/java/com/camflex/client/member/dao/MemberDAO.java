package com.camflex.client.member.dao;

import com.camflex.client.member.vo.MemberVO;

//DB 연결 구현
public interface MemberDAO {

	// 회원가입 처리
	public void insertMember(MemberVO vo) throws Exception;

}
