package com.camflex.client.member.service;

import java.util.List;

import com.camflex.client.member.vo.MemberVO;
import com.camflex.client.reservation.vo.ReservationVO;
import com.camflex.common.vo.PageRequest;

public interface MemberService {

	// 회원가입 처리
	public void insertMember(MemberVO vo) throws Exception;

	// 내 정보 보기, 정보 수정 폼
	public MemberVO readMember(String m_id) throws Exception;

	// 내 정보 수정 처리
	public MemberVO MemberModify(MemberVO vo) throws Exception;

	// 비밀번호 인증
	public MemberVO PwCheck(MemberVO vo)throws Exception;

	// 예약 정보 폼
	public List<ReservationVO> ReserveList (PageRequest pageRequest) throws Exception;

	// 페이징 카운트
	public int count(PageRequest pageRequest);



}
