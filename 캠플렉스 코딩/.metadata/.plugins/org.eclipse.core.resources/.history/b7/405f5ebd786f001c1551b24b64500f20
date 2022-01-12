package com.camflex.client.member.service;

import java.util.List;

import com.camflex.client.member.vo.MemberVO;
import com.camflex.common.vo.PageRequest;

public interface MemberService {

	// 회원가입 처리
	public void insertMember(MemberVO vo) throws Exception;
	
	// 예약 취소 리스트 구현
	public List<MemberVO> cancelList(PageRequest pageRequest) throws Exception;

	// 카운트
	public int count(PageRequest pageRequest) throws Exception;

	// 지난 예약 리스트 구현
	public List<MemberVO> pastList(PageRequest pageRequest) throws Exception;

}
