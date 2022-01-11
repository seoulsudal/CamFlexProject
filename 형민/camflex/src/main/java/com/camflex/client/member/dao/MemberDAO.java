package com.camflex.client.member.dao;

import java.util.List;

import com.camflex.client.member.vo.MemberVO;
import com.camflex.client.reservation.vo.ReservationVO;
import com.camflex.common.vo.PageRequest;

public interface MemberDAO {

	// 회원가입 처리
	public int insertMember(MemberVO mvo) throws Exception;

	// 내 정보 보기, 정보 수정 폼
	public MemberVO readMember(String m_id) throws Exception;

	// 내 정보 수정 처리
	public int MemberModify(MemberVO vo) throws Exception;

	// 내 예약 리스트 구현
	public List<MemberVO> reserveList(PageRequest pageRequest) throws Exception;

	// 비밀번호 체크
	public MemberVO PwCheck(MemberVO vo) throws Exception;

	// 예약 취소 폼
	public ReservationVO reserveCancel(int r_number) throws Exception;

	// 예약 취소 처리
	public int Cancel(ReservationVO vo) throws Exception;

	// 예약 취소 리스트 구현
	public List<MemberVO> cancelList(PageRequest pageRequest) throws Exception;

	// 카운트
	public int count(PageRequest pageRequest) throws Exception;

	// 지난 예약 리스트 구현
	public List<MemberVO> pastList(PageRequest pageRequest) throws Exception;

}
